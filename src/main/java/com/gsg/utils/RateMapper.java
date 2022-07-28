package com.gsg.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class RateMapper {

    private final static Properties mapper = new Properties();
    private final static String fileName = "rates.properties";

    static {
        try {
            InputStream stream = ClassLoader.getSystemResources(fileName).nextElement().openStream();
            mapper.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Properties getMapper() {return mapper;}

}
