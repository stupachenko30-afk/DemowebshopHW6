package de.demowebshop.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginRegisteredUserPositiveTest() {

        click(By.cssSelector(".ico-login"));

        type(By.id("Email"), "stupachenko30@gmail.com");
        type(By.id("Password"), "Qwerty123!");

        click(By.cssSelector("input.login-button"));

        Assert.assertTrue(isElementPresent(By.cssSelector(".ico-logout")));
    }
}