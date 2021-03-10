package com.antainfernandez.shortUrlCreationApp.service;


import com.antainfernandez.shortUrlCreationApp.entities.Url;
import com.antainfernandez.shortUrlCreationApp.repositories.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;


@Service
public class UrlService {

    @Autowired
    private  UrlRepository urlRepository;

    @Autowired
    private UrlConverter urlConverter;


    public String convertToShortUrl(Url originalUrl) {
        Url url = new Url();
        url.setOriginalUrl(originalUrl.getOriginalUrl());
        Url entity = urlRepository.save(url);

        return urlConverter.encode(entity.getId());
    }

    public String getOriginalUrl(String shortUrl) {
        long id = urlConverter.decode(shortUrl);
        Url entity = urlRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("There is no entity with " + shortUrl));
        return entity.getOriginalUrl();
    }

}
