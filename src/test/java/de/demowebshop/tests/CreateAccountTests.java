package de.demowebshop.tests;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
public class CreateAccountTests extends TestBase {

    @Test
    public void newUserRegisterPositiveTest() {
        clickRegisterLink();
        selectGender();
        fillLoginRegisterForm();
        clickRegistrationButton();
        Assert.assertTrue(isElementPresent(By.cssSelector(".result")));//проверка регистрации
    }
    @Test
    public void newUserRegisterNegativeTest() {
        clickRegisterLink();
        selectGender();
        fillLoginRegisterForm();
        clickRegistrationButton();
        Assert.assertTrue(validationSummaryError());
    }

}
