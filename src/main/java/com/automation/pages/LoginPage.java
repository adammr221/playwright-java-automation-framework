package com.automation.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;
import com.automation.config.Config;

public class LoginPage extends BasePage {

    private final Locator usernameInput;
    private final Locator passwordInput;
    private final Locator loginButton;
    private final Locator errorMessage;

    public LoginPage(Page page) {
        super(page);

        usernameInput = page.locator("#user-name");
        passwordInput = page.locator("#password");
        loginButton = page.locator("#login-button");
        errorMessage = page.locator("[data-test='error']");
    }

    public LoginPage navigateToLoginPage() {
        navigate(Config.getBaseUrl());
        return this;
    }

    public InventoryPage login(String username, String password) {
        fill(usernameInput, username);
        fill(passwordInput, password);
        click(loginButton);
        return new InventoryPage(page);
    }

    public void loginExpectingFailure(String username, String password) {
        fill(usernameInput, username);
        fill(passwordInput, password);
        click(loginButton);
    }

    public String getErrorMessage() {
        return getText(errorMessage);
    }
}
