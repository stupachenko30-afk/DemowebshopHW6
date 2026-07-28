package de.demowebshop.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void newUserRegisterPositiveTest() {

        click(By.cssSelector(".ico-register"));

        click(By.id("gender-male"));

        type(By.id("FirstName"), "Yevhenii");
        type(By.id("LastName"), "Stupachenko");
        String email = "stupachenko30" + System.currentTimeMillis() + "@gmail.com";
        type(By.id("Email"), email);
        type(By.id("Password"), "Qwerty123!");
        type(By.id("ConfirmPassword"), "Qwerty123!");

        click(By.id("register-button"));

        Assert.assertTrue(isElementPresent(By.cssSelector(".result")));
    }
}
