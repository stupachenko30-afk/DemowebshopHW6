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

}