package com.automation.factory;
import com.microsoft.playwright.*;
//This class will be responsible for initializing Playwright and launching the browser.

public class PlaywrightFactory {
    private Playwright playwright;
    private Browser browser;

    public Browser createBrowser(String browserName, boolean headless) {
        playwright = Playwright.create();
        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions().setHeadless(headless);

        switch (browserName.toLowerCase()) {
            case "chromium" -> browser = playwright.chromium().launch(options);
            case "firefox" -> browser = playwright.firefox().launch(options);
            case "webkit" -> browser = playwright.webkit().launch(options);
        }
        return browser;

    }

    public void closeBrowser() {
        if(browser != null) {
            browser.close();
        }

        if (playwright != null) {
            playwright.close();
        }
    }
}
