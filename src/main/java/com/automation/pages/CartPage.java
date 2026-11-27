package com.automation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CartPage extends BasePage {

    private final Locator cartItems;
    private final Locator checkoutButton;
    private final Locator continueShoppingButton;

    public CartPage(Page page) {
        super(page);

        cartItems = page.locator(".cart_item");
        checkoutButton = page.locator("#checkout");
        continueShoppingButton = page.locator("#continue-shopping");
    }
    
    public Locator getCartItems() {
        return page.locator("[data-test='inventory-item']");
    }

    public int getCartItemCount() {
        return cartItems.count();
    }

    public boolean containsProduct(String productName) {
        return cartItems.filter(
                new Locator.FilterOptions().setHasText(productName)
        ).count() > 0;
    }

    public CheckoutPage proceedToCheckout() {
        click(checkoutButton);
        return new CheckoutPage(page);
    }

    public void continueShopping() {
        click(continueShoppingButton);
    }
}
