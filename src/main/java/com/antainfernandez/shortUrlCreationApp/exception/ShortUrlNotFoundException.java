package com.antainfernandez.shortUrlCreationApp.exception;

public class ShortUrlNotFoundException extends RuntimeException {

    ShortUrlNotFoundException(Long id) {
        super("Could not find short url " + id);
    }
}