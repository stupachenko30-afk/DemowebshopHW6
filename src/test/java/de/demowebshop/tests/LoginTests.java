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
                "Ошибка авторизации не появилась"
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
                "Ошибка авторизации не появилась"
        );
    }
}