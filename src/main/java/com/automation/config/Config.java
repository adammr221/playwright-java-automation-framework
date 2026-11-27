package com.automation.config;

import io.github.cdimascio.dotenv.Dotenv;

public class Config {

    private static final Dotenv dotenv = Dotenv.load();

    public static String getBrowser() {
        return System.getProperty("browser", "chromium");
    }

    public static boolean isHeadless() {
        return Boolean.parseBoolean(
                System.getProperty("headless", "true")
        );
    }

    public static String getBaseUrl() {
        return System.getProperty(
                "baseUrl",
                "https://www.saucedemo.com"
        );
    }

    public static String getUsername() {
        return dotenv.get("USERNAME");
    }

    public static String getPassword() {
        return dotenv.get("PASSWORD");
    }
}