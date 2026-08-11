package de.demowebshop.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {



    @Test
    public void loginWithIncorrectPasswordNegativeTest() {
        app.user.clickLoginLink();
        app.user.fillLoginForm(
                "stupachenko30@gmail.com",
                "IncorrectPassword123!");
        app.user.clickInputLoginButton();
        Assert.assertTrue(
                app.user.validationSummaryError(),
                "Ошибка авторизации  появилась");
    }
    @Test
    public void loginWithIncorrectEmailNegativeTest() {
        app.user.clickLoginLink();
        app.user.fillLoginForm(
                "stupachenko30gmail.com",
                "QWERTy123!");
        app.user.clickInputLoginButton();
        Assert.assertTrue(
                app.user.isElementPresent(By.cssSelector("span[data-valmsg-for='Email']")),
                "Ошибка авторизации  появилась");
    }
    @Test
    public void loginRegisteredUserPositiveTest() {
        app.user.clickLoginLink();
        app.user.fillLoginForm();
        app.user.clickInputLoginButton();
        Assert.assertTrue(app.user.isElementPresent(By.cssSelector(".ico-logout")));
    }
    @Test
    public void loginWithUnregisteredEmailNegativeTest() {
        app.user.clickLoginLink();
        app.user.fillLoginForm(
                "unknown" + System.currentTimeMillis() + "@gmail.com",
                "Qwerty123!");
        app.user.clickInputLoginButton();
        Assert.assertTrue(
                app.user.validationSummaryError(),
                "Ошибка для незарегистрированного пользователя не появилась");
    }

}