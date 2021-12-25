package com.example.carabos.repository;

import com.example.carabos.entity.Role;
import com.example.carabos.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    @Bean
    CommandLineRunner initDatabase(UserRepository repository){
        return args -> {
            log.info("Preloading" + repository.save(new User("Andrey", "pepega","0000", Role.ADMINISTRATOR,"kek@mail.com")));
            log.info("Preloading" + repository.save(new User("Vovan", "boba","1111", Role.PREMIUM_USER,"boba@gmail.com")));
            log.info("Preloading" + repository.save(new User("Lex", "dyck","2222", Role.DEFAULT_USER,"lala@email.com")));
        };
    }
}
