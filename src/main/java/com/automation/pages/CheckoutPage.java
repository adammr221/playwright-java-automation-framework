package com.automation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CheckoutPage extends BasePage {

    private final Locator firstName;
    private final Locator lastName;
    private final Locator postalCode;
    private final Locator continueButton;
    private final Locator finishButton;
    private final Locator confirmationMessage;

    public CheckoutPage(Page page) {
        super(page);

        firstName = page.locator("#first-name");
        lastName = page.locator("#last-name");
        postalCode = page.locator("#postal-code");
        continueButton = page.locator("#continue");
        finishButton = page.locator("#finish");
        confirmationMessage = page.locator(".complete-header");
    }

    public CheckoutPage enterCustomerInformation(
            String firstNameValue,
            String lastNameValue,
            String postalCodeValue) {

        fill(firstName, firstNameValue);
        fill(lastName, lastNameValue);
        fill(postalCode, postalCodeValue);

        click(continueButton);

        return this;
    }

    public CheckoutPage finishOrder() {
        click(finishButton);
        return this;
    }

    public String getConfirmationMessage() {
        return getText(confirmationMessage);
    }
}