package org.examle;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlaywrightTest {
    static Playwright playwright;
    static Browser browser;

    BrowserContext context;
    Page page;

    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch();
    }

    @AfterAll
    static void closeBrowser() {
        playwright.close();
    }

    @BeforeEach
    void createPage() {
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterEach
    void closeContext() {
        context.close();
    }

    @Disabled
    @Test
    void shouldOpenPlaywrightWebsite(){
        page.navigate("https://playwright.dev");
        assertEquals("Fast and reliable end-to-end testing for modern web apps | Playwright", page.title());
    }

}