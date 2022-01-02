package com.example.carabos.repository;

import com.example.carabos.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    @Bean
    CommandLineRunner initDatabase(UserRepository repository,
                                   OrderRepository orderRepository,
                                   ProductRepository productRepository){
        List<Product> products = new ArrayList<>();
        return args -> {
            User andrey = new User("Andrey", "pepega", "0000", Role.ADMINISTRATOR, "kek@mail.com");
            log.info("Preloading" + repository.save(andrey));
            User vovan = new User("Vovan", "boba", "1111", Role.PREMIUM_USER, "boba@gmail.com");
            log.info("Preloading" + repository.save(vovan));
            User lex = new User("Lex", "dyck", "2222", Role.DEFAULT_USER, "lala@email.com");
            log.info("Preloading" + repository.save(lex));

            Product iPhone11 = new Product("IPhone11", 100000f);
            productRepository.save(iPhone11);
            Product iPhone12 = new Product("IPhone12", 120000f);
            productRepository.save(iPhone12);

            log.info("Preloaded " + orderRepository.save(new Order(andrey, new Date(), Status.COMPLETED)));
            log.info("Preloaded " + orderRepository.save(new Order(vovan, new Date(), Status.CANCELED)));
            log.info("Preloaded " + orderRepository.save(new Order(andrey, new Date(), Status.IN_PROGRESS)));



        };
    }
}
