package de.demowebshop.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {


    @Test
            public void isHomeComponentPresentTest() {
        Assert.assertTrue(app.homePage.isHomeComponentPresent());//условие(элемент isHome...)=true

    }
            @Test
            public void logoutLinkIsNotPresentForGuestTest() {
                Assert.assertFalse(
                        app.homePage.isElementPresent(By.cssSelector(".ico-logout")),
                        "Кнопка Logout не отображается для неавторизованного пользователя");
            }
            @Test
            public void accountLinkIsNotPresentForGuestTest() {
                Assert.assertFalse(
                        app.homePage.isElementPresent(By.cssSelector(".header-links .account")),
                        "Ссылка аккаунта не отображается для неавторизованного пользователя");
            }
            @Test
            public void searchWithEmptyQueryNegativeTest() {
                app.user.clickSearchButton();
                Alert alert = app.driver.switchTo().alert();
                Assert.assertEquals(
                        alert.getText(),
                        "Please enter some search keyword");
                alert.accept();
            }

            @Test
            public void searchUnknownProductNegativeTest() {
                app.homePage.type(
                        By.id("small-searchterms"),
                        "UnknownProduct" + System.currentTimeMillis());
                app.user.clickSearchButton();
                Assert.assertTrue(app.homePage.isElementPresent(By.cssSelector(".result")),
                        "Сообщение об отсутствии товаров не появилось");
            }

}