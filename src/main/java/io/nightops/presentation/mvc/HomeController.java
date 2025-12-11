package io.nightops.presentation.mvc;

import io.nightops.data.entity.Config;
import io.nightops.data.entity.DropFile;
import io.nightops.data.repository.ConfigRepository;
import io.nightops.data.repository.DropFileRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {
    
    private ConfigRepository configRepo;
    private DropFileRepository dropFileRepo;
    
    @Autowired
    public HomeController(ConfigRepository configRepo, DropFileRepository dropFileRepo) {
        this.configRepo = configRepo;
        this.dropFileRepo = dropFileRepo;
    }
    
    @RequestMapping(method=RequestMethod.GET,path="/login")
    public String loginPage(){
        return "login-page";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/access-denied")
    public String accessDenied() {
        return "access-denied";
    }
    
    
    @RequestMapping(method = RequestMethod.GET, path = "/home")
    public String showHomePage(Model theModel) {
        theModel.addAttribute("dropfile", new DropFile());
        
        List<DropFile> allDropFiles = this.dropFileRepo.findAll();
        theModel.addAttribute("files", allDropFiles);
        
        Long clickedCount = this.dropFileRepo.sumClickedCount();
        theModel.addAttribute("clickedCount", (clickedCount == null ? 0 : clickedCount));
        
        Long countPassiveDropFile = this.dropFileRepo.countPassiveDropFile();
        theModel.addAttribute("countPassiveDropFile", (countPassiveDropFile == null ? 0 : countPassiveDropFile));
        
        
        Config config = this.configRepo.findById(1L).get();
        theModel.addAttribute("config", config);
        return "home-page";
    }

}
