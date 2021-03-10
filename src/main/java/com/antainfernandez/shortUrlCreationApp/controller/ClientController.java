package com.antainfernandez.shortUrlCreationApp.controller;

import com.antainfernandez.shortUrlCreationApp.dto.UrlDto;
import com.antainfernandez.shortUrlCreationApp.entities.Url;
import com.antainfernandez.shortUrlCreationApp.repositories.UrlRepository;
import com.antainfernandez.shortUrlCreationApp.service.UrlConverter;
import com.antainfernandez.shortUrlCreationApp.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import java.net.URISyntaxException;


/**
 * Controller for web base app, to consume and test API if not use CURL, postman, ..
 */
@Controller
public class ClientController {

    @Autowired
    private UrlConverter urlConverter;
    @Autowired
    private UrlService urlService;
    @Autowired
    private UrlRepository urlRepository;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/convert")
    public String convertOriginalUrlToShortUrl(Model model) {
        model.addAttribute("urlDto", new UrlDto());
        return "convert";
    }

    /**
     * For testing the API, create a form to consume the API create a short Url and store in db
     */
    @PostMapping("/convert")
    public String convertOriginalUrlToShortUrl(@ModelAttribute UrlDto urlDto, Model model) {
        Url originalUrl = new Url(urlDto.getUrl());

        //consuming API create short Url with POST
        String uri = "http://localhost:8081/api/v1/createShortUrl";
        String shortUrl = restTemplate.postForObject(uri, originalUrl, String.class);

        model.addAttribute("url", originalUrl);
        model.addAttribute("shortUrl", shortUrl);
        return "result";
    }

    /**
     * For test API , redirect to original url from short url
     */
    @GetMapping("/go2/{shortUrl}")
    public String go2(@PathVariable String shortUrl) throws URISyntaxException {
        String redirectUrl = "http://localhost:8081/api/v1/goToShortUrl/" + shortUrl;
        return "redirect:" + redirectUrl;
    }

    /**
     * An example of what to expect from the API
     */
    @GetMapping("/example")
    public String index(Model model) {
        Url originalUrl = urlRepository.findById((long) 1).get();
        String shortUrl = urlConverter.encode(originalUrl.getId());
        model.addAttribute("shortUrl", shortUrl);
        model.addAttribute("originalUrl", originalUrl);
        return "example";
    }

}