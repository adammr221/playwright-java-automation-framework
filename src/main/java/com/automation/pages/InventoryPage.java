package com.automation.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;

public class InventoryPage extends BasePage {

    private final Locator pageTitle;
    private final Locator inventoryItems;
    private final Locator shoppingCart;

    public InventoryPage(Page page) {
        super(page);

        pageTitle = page.locator(".title");
        inventoryItems = page.locator(".inventory_item");
        shoppingCart = page.locator(".shopping_cart_link");
    }

    public String getInventoryTitle() {
        return getText(pageTitle);
    }

    public int getProductCount() {
        return inventoryItems.count();
    }

    public void addProductToCart(String productName) {
        Locator product = page.locator(".inventory_item")
                .filter(new Locator.FilterOptions().setHasText(productName));

        product.locator("button").click();
    }

    public CartPage openCart() {
        click(shoppingCart);
        return new CartPage(page);
    }
}