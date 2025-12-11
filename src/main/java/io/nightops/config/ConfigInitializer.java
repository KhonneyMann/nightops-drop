package io.nightops.config;

import io.nightops.data.entity.Config;
import io.nightops.data.repository.ConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConfigInitializer implements CommandLineRunner{
    
    private ConfigRepository configRepo;

    @Autowired
    public ConfigInitializer(ConfigRepository configRepo) {
        this.configRepo = configRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        Config config = new Config();
        config.setId(1L);
        config.setDomainName("nightops.io");
        this.configRepo.save(config);
    }
    
    
    
    
}
