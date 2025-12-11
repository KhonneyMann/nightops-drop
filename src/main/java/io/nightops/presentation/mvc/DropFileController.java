package io.nightops.presentation.mvc;

import io.nightops.data.entity.DropFile;
import io.nightops.data.repository.DropFileRepository;
import io.nightops.utils.FileUploadUtils;
import jakarta.servlet.ServletContext;
import java.math.BigInteger;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/files")
public class DropFileController {

    private DropFileRepository dropFileRepo;
    private ServletContext servletContext;
    
    @Autowired
    public DropFileController(DropFileRepository dropFileRepo, ServletContext servletContext) {
        this.dropFileRepo = dropFileRepo;
        this.servletContext = servletContext;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/upload")
    public String uploadDropFile(@ModelAttribute("dropfile") DropFile dropFile,
            @RequestParam(value = "file") MultipartFile multiPartFile,
            RedirectAttributes redirectAttributes) {
        try {
            String shortCode = StringUtils.cleanPath(digestCreator(multiPartFile.getOriginalFilename() + dropFile.getId()));
            long fileSize = multiPartFile.getSize();

            // Dosya boyutu
            dropFile.setFileSize(fileSize);
            // Dosya kısa kodu
            dropFile.setShortCode(shortCode);
            // Dosyayı aktif et
            dropFile.setActive(true);
            // File Path oluşturma
            if (dropFile.getFilePath().contains(".")) {
                String[] newMyFilePath = dropFile.getFilePath().split("/");
                StringBuilder newPath = new StringBuilder();
                for (int i = 0; i < newMyFilePath.length - 1; i++) {
                    newPath.append(newMyFilePath[i]).append("/");
                }
                dropFile.setFilePath(newPath.toString());
            }
            this.dropFileRepo.save(dropFile);
            FileUploadUtils.saveFile(dropFile.getFilePath(), dropFile.getFileName(), multiPartFile);
            redirectAttributes.addFlashAttribute("success", true);
            redirectAttributes.addFlashAttribute("file", dropFile);
        } catch (NoSuchAlgorithmException ex) {
            System.getLogger(DropFileController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return "redirect:/home";

    }
    
    @RequestMapping(method=RequestMethod.GET,path="/d/{shortCode}")
    public ResponseEntity<Resource> downloadFile(@PathVariable("shortCode") String shortCode){
        DropFile dropFile = this.dropFileRepo.findDropFileByShortCode(shortCode);
        if (dropFile == null){
            return ResponseEntity.notFound().build();
        }
        
        if (!dropFile.isActive()){
            return ResponseEntity.notFound().build();
        }
        
        try{
            Path filePath = Paths.get(dropFile.getFilePath());
            Resource resource = new UrlResource(filePath.toUri()+"/"+dropFile.getFileName());
            if (resource.exists() || resource.isReadable()){
                String contentType = this.servletContext.getMimeType(filePath.toString()+"/"+dropFile.getFileName());
                String headerValue = "attachment; filename=\""+dropFile.getFileName()+"\"";
                if (dropFile.isOneTime()){
                    dropFile.setActive(false);
                }
                dropFile.setClickedCount(dropFile.getClickedCount()+1);
                this.dropFileRepo.save(dropFile);
                return ResponseEntity
                        .ok()
                        .contentType(MediaType.parseMediaType(contentType))
                        .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
                        .body(resource);
            }
        }catch(Exception ex){
            System.out.println("Dosya indirirken hata oluştu : "+ex.getMessage());
        }
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/passive/{id}")
    public String doFilePassive(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        DropFile dropFile = this.dropFileRepo.findById(id).get();
        dropFile.setActive(false);
        this.dropFileRepo.save(dropFile);
        redirectAttributes.addFlashAttribute("message", "Dosya : " + dropFile.getFileName() + " pasif yapıldı!");
        return "redirect:/home";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/delete/{id}")
    public String deleteDropFile(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        DropFile dropFile = this.dropFileRepo.findById(id).get();
        this.dropFileRepo.delete(dropFile);
        redirectAttributes.addFlashAttribute("message", "Dosya : " + dropFile.getFileName() + " silindi!");
        return "redirect:/home";
    }

    private String digestCreator(String fileName) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(fileName.getBytes());
        BigInteger no = new BigInteger(1, messageDigest);
        String hashText = no.toString(16);
        while (hashText.length() < 32) {
            hashText = "0" + hashText;
        }
        return hashText;
    }

}
