package com.automation.pages;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;

public class BasePage {
    protected final Page page;

    protected BasePage(Page page) {
        this.page = page;
    }

    protected void click(Locator locator) {
        locator.click();
    }

    protected void fill(Locator locator, String value) {
        locator.fill(value);
    }

    protected String getText(Locator locator) {
        return locator.innerText();
    }

    protected boolean isVisible(Locator locator) {
        return locator.isVisible();
    }

    protected void navigate(String url) {
        page.navigate(url);
    }

    public String getPageTitle() {
        return page.title();
    }






}
