package de.demowebshop.tests;

import de.demowebshop.core.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {



    @Test
    public void loginWithIncorrectPasswordNegativeTest() {
        app.getUser().clickLoginLink();
        app.getUser().fillLoginForm(
                "stupachenko30@gmail.com",
                "IncorrectPassword123!");
        app.getUser().clickInputLoginButton();
        Assert.assertTrue(
                app.getUser().validationSummaryError(),
                "Ошибка авторизации не появилась");
    }
    @Test
    public void loginWithIncorrectEmailNegativeTest() {
        app.getUser().clickLoginLink();
        app.getUser().fillLoginForm(
                "stupachenko30gmail.com",
                "QWERTy123!");
        app.getUser().clickInputLoginButton();
        Assert.assertTrue(
                app.getUser().isElementPresent(By.cssSelector("span[data-valmsg-for='Email']")),
                "Ошибка авторизации не появилась");
    }
    @Test
    public void loginRegisteredUserPositiveTest() {
        app.getUser().clickLoginLink();
        app.getUser().fillLoginForm();
        app.getUser().clickInputLoginButton();
        Assert.assertTrue(app.getUser().isElementPresent(By.cssSelector(".ico-logout")));
    }
    @Test
    public void loginWithUnregisteredEmailNegativeTest() {
        app.getUser().clickLoginLink();
        app.getUser().fillLoginForm(
                "unknown" + System.currentTimeMillis() + "@gmail.com",
                "Qwerty123!");
        app.getUser().clickInputLoginButton();
        Assert.assertTrue(
                app.getUser().validationSummaryError(),
                "Ошибка для незарегистрированного пользователя не появилась");
    }

}