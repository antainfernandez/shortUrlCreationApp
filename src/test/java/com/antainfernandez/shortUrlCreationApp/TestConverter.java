package com.antainfernandez.shortUrlCreationApp;

import com.antainfernandez.shortUrlCreationApp.service.Base26AlphabetOnlyConverter;
import com.antainfernandez.shortUrlCreationApp.service.UrlConverter;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestConverter {

    private static final Logger log = LoggerFactory.getLogger(TestConverter.class);
    private UrlConverter base26AlphabetOnlyConverter =new Base26AlphabetOnlyConverter();


    @Test
    public void base26AlphabetOnlyConverterTest() {

        assertEquals("A", base26AlphabetOnlyConverter.encode(0));
        assertEquals("Z", base26AlphabetOnlyConverter.encode(25));
        assertEquals("BA", base26AlphabetOnlyConverter.encode(26));

        assertEquals(0, base26AlphabetOnlyConverter.decode("A"));
    }


}