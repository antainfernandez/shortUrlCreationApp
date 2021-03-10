package com.antainfernandez.shortUrlCreationApp.controller;

import com.antainfernandez.shortUrlCreationApp.entities.Url;
import com.antainfernandez.shortUrlCreationApp.service.UrlService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.URI;

/*
Controller for the REST API
 */
@RestController
@RequestMapping("/api/v1")
public class UrlController {

    @Autowired
    private UrlService urlService;

    @ApiOperation(value = "create short url", notes = "Converts long url to short url")
    @PostMapping("/createShortUrl")
    public String convertToShortUrl(@RequestBody Url originalUrl) {
        return urlService.convertToShortUrl(originalUrl);
    }

    @ApiOperation(value = "Redirect", notes = "Finds original url from short url and redirects")
    @GetMapping(value = "/goToShortUrl/{shortUrl}")
    public ResponseEntity<Void> getAndRedirect(@PathVariable String shortUrl) {
        String url = urlService.getOriginalUrl(shortUrl);
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(url))
                .build();
    }

    @GetMapping("/shortToOriginalUrl/{shortUrl}")
    String getOriginalUrl(@PathVariable String shortUrl) {
        String originalUrl = urlService.getOriginalUrl(shortUrl);
        if (originalUrl != null) {
            return originalUrl;
        }
        return "url not found";
    }


    /**
     * More service methods ,....
     */
}