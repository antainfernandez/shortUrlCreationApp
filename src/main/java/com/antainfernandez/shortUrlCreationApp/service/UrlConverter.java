package com.antainfernandez.shortUrlCreationApp.service;

/**
 * can be use for convert the id of the url entity to a a string ,
 * only useful if id is so long
 */
public interface UrlConverter {

    long decode(String shortUrl);

    String encode(long id);
}
