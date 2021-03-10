package com.antainfernandez.shortUrlCreationApp.config;

import com.antainfernandez.shortUrlCreationApp.entities.Url;
import com.antainfernandez.shortUrlCreationApp.repositories.UrlRepository;
import com.antainfernandez.shortUrlCreationApp.service.UrlConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDataBase {

    private static final Logger log = LoggerFactory.getLogger(LoadDataBase.class);

    @Bean
    CommandLineRunner initDatabase(UrlRepository repository, UrlConverter converter) {

        return args -> {
            Url url = new Url();
            url.setOriginalUrl("https://www.google.com/");
            log.info("Preloading " + repository.save(url));
            log.info("short url is  : " + converter.encode(url.getId()));

        };
    }
}