package de.demowebshop.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

    @Test
    public void isHomeComponentPresentTest() {

        Assert.assertTrue(isHomeComponentPresent());//условие(элемент isHome...)=true

    }
    @Test
    public void logoutLinkIsNotPresentForGuestTest() {
        Assert.assertFalse(
                isElementPresent(By.cssSelector(".ico-logout")),
                "Кнопка Logout отображается для неавторизованного пользователя"
        );
    }
    @Test
    public void accountLinkIsNotPresentForGuestTest() {
        Assert.assertFalse(
                isElementPresent(By.cssSelector("span[data-valmsg-for='Password']")),
                "Ссылка аккаунта отображается для неавторизованного пользователя"
        );
    }
    @Test
    public void searchWithEmptyQueryNegativeTest() {

        click(By.cssSelector("span[data-valmsg-for='Password']"));

        Assert.assertTrue(
                isElementPresent(By.cssSelector("dialog-notifications-error"))
        );
    }
    @Test
    public void searchUnknownProductNegativeTest() {
        type(
                By.id("small-searchterms"),
                "UnknownProduct" + System.currentTimeMillis()
        );

        click(By.cssSelector("input.search-box-button"));

        Assert.assertTrue(                isElementPresent(By.cssSelector(".no-result")),
                "Сообщение об отсутствии товаров не появилось"
        );
    }
}