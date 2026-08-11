package de.demowebshop.tests;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
public class CreateAccountTests extends TestBase {

    @Test
    public void newUserRegisterPositiveTest() {
        String email = app.user.generateEmail();
        app.user.clickRegisterLink();
        app.user.selectGender("gender-male");
        app.user.fillLoginRegisterForm(
                new User().setName("Yevhenii").setLastName("Stupachenko")
                .setEmail(email). setPassword("Qwerty123!").setConfirmPassword("Qwerty123!"));
        app.user.clickRegistrationButton();
        Assert.assertTrue(app.user.isElementPresent(By.cssSelector(".result")));//проверка регистрации
    }

    @Test
    public void newUserRegisterExistingEmailNegativeTest() {
        app.user.clickRegisterLink();
        app.user.selectGender("gender-male");
        app.user.fillLoginRegisterForm(
                new User().setName("Yevhenii").setLastName("Stupachenko")
                        .setEmail("stupachenko30@gmail.com").setPassword("Qwerty123!").setConfirmPassword("Qwerty123!"));
        app.user.clickRegistrationButton();
        Assert.assertTrue(app.user.validationSummaryError());
    }
    @Test
    public void registerWithEmptyEmailNegativeTest() {
        app.user.clickRegisterLink();
        app.user.selectGender("gender-male");
        app.user.fillLoginRegisterForm(
                new User().setName("Yevhenii").setLastName("Stupachenko")
                        .setEmail("").setPassword("Qwerty123!").setConfirmPassword("Qwerty123!"));
        app.user.clickRegistrationButton();
        Assert.assertTrue(
                app.user.isElementPresent(By.cssSelector("span[data-valmsg-for='Email']")),
                "Ошибка обязательного поля Email не появилась");
    }

    @Test
    public void registerWithDifferentPasswordsNegativeTest() {
        String email = app.user.generateEmail();
        app.user.clickRegisterLink();
        app.user.selectGender("gender-male");
        app.user.fillLoginRegisterForm(
                new User().setName("Yevhenii").setLastName("Stupachenko")
                        .setEmail(email).setPassword("Qwerty123!").setConfirmPassword("Qwerty456!"));
        app.user.clickRegistrationButton();
        Assert.assertTrue(
                app.user.isElementPresent(By.cssSelector("span[data-valmsg-for='ConfirmPassword']")),
                "Ошибка несовпадения паролей не появилась");
    }

    @Test
    public void registerWithInvalidEmailNegativeTest() {
        app.user.clickRegisterLink();
        app.user.selectGender("gender-male");
        app.user.fillLoginRegisterForm(
                new User().setName("Yevhenii").setLastName("Stupachenko")
                        .setEmail("incorrect-email"). setPassword("Qwerty123!").setConfirmPassword("Qwerty123!"));
        app.user.clickRegistrationButton();
        Assert.assertTrue(
                app.user.isElementPresent(By.cssSelector("span[data-valmsg-for='Email']")),
                "Ошибка некорректного email не появилась");
    }
    @Test
    public void registerWithShortPasswordNegativeTest() {
        String email = app.user.generateEmail();
        app.user.clickRegisterLink();
        app.user.selectGender("gender-male");
        app.user.fillLoginRegisterForm(
                new User().setName("Yevhenii").setLastName("Stupachenko")
                        .setEmail(email).setPassword("123").setConfirmPassword("123"));
        app.user.clickRegistrationButton();
        Assert.assertTrue(
                app.user.isElementPresent(By.cssSelector("span[data-valmsg-for='Password']")),
                "Ошибка короткого пароля не появилась");
    }
}
