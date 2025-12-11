package io.nightops.utils;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtils {

    public static void saveFile(String uploadDir, String fileName, MultipartFile multiPartFile) {
        try {
            Path uploadPath = Paths.get(uploadDir);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
                File uploadDirAsDropFile = uploadPath.toFile();
                uploadDirAsDropFile.setReadable(true);
                uploadDirAsDropFile.setExecutable(true);
                uploadDirAsDropFile.setWritable(true, true);
            }
            
            InputStream inputStream = multiPartFile.getInputStream();
            Path filePath = uploadPath.resolve(fileName); 
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
            
            File newFile = filePath.toFile();
            newFile.setReadable(true,false);
            newFile.setWritable(true,false);
        } catch (Exception ex) {
            System.out.println("[INFO] FileUploadUtils.java dosyasında hata oluştu : "+ex.getMessage());
        }

    }

}
