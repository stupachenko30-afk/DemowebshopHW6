package de.demowebshop.tests;

import de.demowebshop.core.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {


    @Test
            public void isHomeComponentPresentTest() {
        Assert.assertTrue(app.getHomePage().isHomeComponentPresent());//условие(элемент isHome...)=true

    }
            @Test
            public void logoutLinkIsNotPresentForGuestTest() {
                Assert.assertFalse(
                        app.getHomePage().isElementPresent(By.cssSelector(".ico-logout")),
                        "Кнопка Logout не отображается для неавторизованного пользователя");
            }
            @Test
            public void accountLinkIsNotPresentForGuestTest() {
                Assert.assertFalse(
                        app.getHomePage().isElementPresent(By.cssSelector(".header-links .account")),
                        "Ссылка аккаунта не отображается для неавторизованного пользователя");
            }
            @Test
            public void searchWithEmptyQueryNegativeTest() {
                app.getUser().clickSearchButton();
                Alert alert = app.getDriver().switchTo().alert();
                Assert.assertEquals(
                        alert.getText(),
                        "Please enter some search keyword");
                alert.accept();
            }

            @Test
            public void searchUnknownProductNegativeTest() {
                app.getHomePage().type(
                        By.id("small-searchterms"),
                        "UnknownProduct" + System.currentTimeMillis());
                app.getUser().clickSearchButton();
                Assert.assertTrue(app.getHomePage().isElementPresent(By.cssSelector(".result")),
                        "Сообщение об отсутствии товаров не появилось");
            }

}