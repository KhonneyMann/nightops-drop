package io.nightops.presentation.mvc;

import io.nightops.data.entity.Config;
import io.nightops.data.repository.ConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/config")
public class ConfigController {
    
    private ConfigRepository configRepo;

    @Autowired
    public ConfigController(ConfigRepository configRepo) {
        this.configRepo = configRepo;
    }
    
    @RequestMapping(method=RequestMethod.POST,path="/save")
    public String updateConfig(@ModelAttribute("config") Config config, RedirectAttributes redirectAttributes){
        
        String domainName = config.getDomainName().toLowerCase().strip();
        if (domainName.contains("http://")){
            domainName = domainName.replace("http://", "https://");
        }else if (!domainName.contains("https://")){
            domainName = "https://"+domainName;
        }
        
        Config updatedConfig = this.configRepo.findById(config.getId()).get(); // 1L
        updatedConfig.setDomainName(domainName);
        this.configRepo.save(updatedConfig);
        redirectAttributes.addFlashAttribute("successConfig", true);
        return "redirect:/home";
    }
    
    
    
    
}
