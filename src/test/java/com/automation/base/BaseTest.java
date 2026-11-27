package com.automation.base;

import com.automation.config.Config;
import com.automation.factory.PlaywrightFactory;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

public abstract class BaseTest {

    protected static PlaywrightFactory playwrightFactory;
    protected static Browser browser;

    protected BrowserContext context;
    protected Page page;

    @BeforeAll
    static void setupBrowser() {
        playwrightFactory = new PlaywrightFactory();

        browser = playwrightFactory.createBrowser(
                Config.getBrowser(),
                Config.isHeadless()
        );
    }

    @BeforeEach
    void setupTest() {
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterEach
    void teardownTest() {
        if (context != null) {
            context.close();
        }
    }

    @AfterAll
    static void teardownBrowser() {
        if (playwrightFactory != null) {
            playwrightFactory.closeBrowser();
        }
    }
}