package de.demowebshop.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginRegisteredUserPositiveTest() {
        clickLoginLink();
        fillLoginForm();
        clickInputLoginButton();
        Assert.assertTrue(isElementPresent(By.cssSelector(".ico-logout")));
    }

    @Test
    public void loginWithIncorrectPasswordNegativeTest() {
        clickLoginLink();
        fillLoginForm(
                "stupachenko30@gmail.com",
                "IncorrectPassword123!"
        );

        clickInputLoginButton();

        Assert.assertTrue(
                validationSummaryError(),
                "Ошибка авторизации  появилась"
        );
    }
    @Test
    public void loginWithIncorrectEmailNegativeTest() {
        clickLoginLink();

        fillLoginForm(
                "stupachenko30gmail.com",
                "QWERTy123!"
        );

        clickInputLoginButton();

        Assert.assertTrue(
                isElementPresent(
                        By.cssSelector("span[data-valmsg-for='Email']")),
                "Ошибка авторизации  появилась"
        );
    }
    @Test
    public void loginWithUnregisteredEmailNegativeTest() {
        clickLoginLink();

        fillLoginForm(
                "unknown" + System.currentTimeMillis() + "@gmail.com",
                "Qwerty123!"
        );

        clickInputLoginButton();

        Assert.assertTrue(
                validationSummaryError(),
                "Ошибка для незарегистрированного пользователя не появилась"
        );
    }
    @Test
    public void registerWithEmptyEmailNegativeTest() {
        clickRegisterLink();
        selectGender("gender-male");

        fillLoginRegisterForm(
                "Yevhenii",
                "Stupachenko",
                "",
                "Qwerty123!",
                "Qwerty123!"
        );

        clickRegistrationButton();

        Assert.assertTrue(
                isElementPresent(By.cssSelector("span[data-valmsg-for='Email']")),
                "Ошибка обязательного поля Email  появилась"
        );
    }
}