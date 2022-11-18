package com.kasirgui.helpers;

import java.io.IOException;
import java.util.Properties;

public class PropertiesConfig {
    private static Properties config = new Properties();

    /**
     * 
     */
    private PropertiesConfig() {
        // hide contruct
    }

    public static Properties getConfig(String nameOfPropertiesFile) {
        try {
            PropertiesConfig.class.getClassLoader();
            config.load(ClassLoader.getSystemResourceAsStream(nameOfPropertiesFile + ".properties"));
        } catch (IOException e) {
            System.out.println(e.getMessage() + "ada yang salah dengan properties");
        }
        return config;
    }
}