package com.automation.ui;

import com.automation.base.BaseTest;
import com.automation.config.Config;
import com.automation.pages.LoginPage;
import com.automation.pages.InventoryPage;
import com.automation.pages.CartPage;
import com.automation.pages.CheckoutPage;
import org.junit.jupiter.api.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

public class CheckoutTest extends BaseTest {

    @Test
    void shouldCompleteCheckoutSuccessfully() {
        LoginPage loginPage = new LoginPage(page);
        InventoryPage inventoryPage = loginPage
                .navigateToLoginPage()
                .login(Config.getUsername(), Config.getPassword());
        assertEquals("Products", inventoryPage.getInventoryTitle());
        assertEquals(6, inventoryPage.getProductCount());
        inventoryPage.addProductToCart("Sauce Labs Backpack");
        CartPage cartPage = inventoryPage.openCart();
        //page.waitForTimeout(3_000); // Debug
        assertThat(cartPage.getCartItems()).hasCount(1);
        assertTrue(cartPage.containsProduct("Sauce Labs Backpack"));
        CheckoutPage checkoutPage = cartPage.proceedToCheckout();
        checkoutPage.enterCustomerInformation(
                "Adam",
                "Test",
                "12345"
        );
        checkoutPage.finishOrder();
        assertEquals(
                "Thank you for your order!",
                checkoutPage.getConfirmationMessage()
        );
    }
}
