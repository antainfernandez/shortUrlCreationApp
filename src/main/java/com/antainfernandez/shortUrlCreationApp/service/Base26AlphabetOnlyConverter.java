package com.antainfernandez.shortUrlCreationApp.service;

/**
 * https://en.wikipedia.org/w/index.php?title=Hexavigesimal&oldid=578218059#Bijective_base-26
 *
 * will do A,B,C, ....,Z,BA,BB, ....
 *         0,1, ...
 */
public class Base26AlphabetOnlyConverter implements UrlConverter{

    @Override
    public long decode(String shortUrl) {
            int s = 0;
            if (shortUrl != null && shortUrl.length() > 0) {
                s = (shortUrl.charAt(0) - 'A');
                for (int i = 1; i < shortUrl.length(); i++) {
                    s *= 26;
                    s += (shortUrl.charAt(i) - 'A');
                }
            }
            return s;
    }

    @Override
    public String encode(long id) {
        int number = (int) id;
        number = Math.abs(number);
        String converted = "";
        // Repeatedly divide the number by 26 and convert the
        // remainder into the appropriate letter.
        do
        {
            int remainder = number % 26;
            converted = (char)(remainder + 'A') + converted;
            number = (number - remainder) / 26;
        } while (number > 0);

        return converted;
    }
}
