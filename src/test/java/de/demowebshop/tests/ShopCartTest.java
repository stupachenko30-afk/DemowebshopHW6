package de.demowebshop.tests;

import de.demowebshop.core.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ShopCartTest extends TestBase {
    @Test
    public void addProductToShoppingCartPositiveTest() {
        app.getShopCart().clickOnCategoryBooks();
        app.getShopCart().clickOnAddToCart();
        app.getHomePage().waitForNotificationToDisappear();
        app.getHomePage().acceptAlertIfPresent();
        app.getHomePage().closeNotificationIfPresent();
        app.getShopCart().clickOnIcoCart();
        Assert.assertTrue(
                app.getHomePage().isElementPresent(By.cssSelector(".product-name")),
                "Товар не появился в корзине"
        );
    }
    @Test
    public void removeProductFromShoppingCartPositiveTest() {

        app.getShopCart().clickOnCategoryBooks();
        app.getShopCart().clickOnAddToCart();
        app.getHomePage().waitForNotificationToDisappear();
        app.getHomePage().acceptAlertIfPresent();
        app.getHomePage().closeNotificationIfPresent();
        app.getShopCart().clickOnIcoCart();
        app.getHomePage().click(By.name("removefromcart"));
        app.getHomePage().click(By.name("updatecart"));
        Assert.assertFalse(app.getHomePage().isElementPresent(By.cssSelector(".product-name")),
                "Товар остался в корзине");
    }
    @Test
    public void updateProductQuantityPositiveTest() {
        app.getShopCart().clickOnCategoryBooks();

        app.getShopCart().clickOnAddToCart();
        app.getHomePage().waitForNotificationToDisappear();
        app.getHomePage().acceptAlertIfPresent();
        app.getHomePage().closeNotificationIfPresent();
        app.getShopCart().clickOnIcoCart();
        app.getHomePage().type(By.cssSelector(".qty-input"), "2");
        app.getHomePage().click(By.name("updatecart"));
        String quantity = app.getDriver()
                .findElement(By.cssSelector(".qty-input"))
                .getAttribute("value");
        Assert.assertEquals(quantity, "2");
    }
    @Test
    public void addTwoProductsToShoppingCartPositiveTest() {
        app.getShopCart().clickOnCategoryBooks();
        app.getShopCart().clickOnAddToCart();
        app.getHomePage().acceptAlertIfPresent();
        app.getHomePage().waitForText(By.cssSelector(".cart-qty"), "(1)");
        app.getShopCart().clickOnAddToCart();
        app.getHomePage().waitForText(By.cssSelector(".cart-qty"), "(2)");
        String cartQuantity = app.getDriver()
                .findElement(By.cssSelector(".cart-qty"))
                .getText();
        Assert.assertEquals(cartQuantity, "(2)");
    }}