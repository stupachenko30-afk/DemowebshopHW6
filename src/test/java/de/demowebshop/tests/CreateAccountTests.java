package de.demowebshop.tests;
import de.demowebshop.core.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
public class CreateAccountTests extends TestBase {

    @Test(enabled = true)
    public void newUserRegisterPositiveTest() {
        String email = app.getUser().generateEmail();
        app.getUser().clickRegisterLink();
        app.getUser().selectGender("gender-male");
        app.getUser().fillLoginRegisterForm(
                new de.demowebshop.model.User().setName("Yevhenii").setLastName("Stupachenko")
                .setEmail(email). setPassword("Qwerty123!").setConfirmPassword("Qwerty123!"));
        app.getUser().clickRegistrationButton();
        Assert.assertTrue(app.getUser().isElementPresent(By.cssSelector(".result")));//проверка регистрации
    }

    @Test
    public void newUserRegisterExistingEmailNegativeTest() {
        app.getUser().clickRegisterLink();
        app.getUser().selectGender("gender-male");
        app.getUser().fillLoginRegisterForm(
                new de.demowebshop.model.User().setName("Yevhenii").setLastName("Stupachenko")
                        .setEmail("stupachenko30@gmail.com").setPassword("Qwerty123!").setConfirmPassword("Qwerty123!"));
        app.getUser().clickRegistrationButton();
        Assert.assertTrue(app.getUser().validationSummaryError());
    }
    @Test
    public void registerWithEmptyEmailNegativeTest() {
        app.getUser().clickRegisterLink();
        app.getUser().selectGender("gender-male");
        app.getUser().fillLoginRegisterForm(
                new de.demowebshop.model.User().setName("Yevhenii").setLastName("Stupachenko")
                        .setEmail("").setPassword("Qwerty123!").setConfirmPassword("Qwerty123!"));
        app.getUser().clickRegistrationButton();
        Assert.assertTrue(
                app.getUser().isElementPresent(By.cssSelector("span[data-valmsg-for='Email']")),
                "Ошибка обязательного поля Email не появилась");
    }

    @Test
    public void registerWithDifferentPasswordsNegativeTest() {
        String email = app.getUser().generateEmail();
        app.getUser().clickRegisterLink();
        app.getUser().selectGender("gender-male");
        app.getUser().fillLoginRegisterForm(
                new de.demowebshop.model.User().setName("Yevhenii").setLastName("Stupachenko")
                        .setEmail(email).setPassword("Qwerty123!").setConfirmPassword("Qwerty456!"));
        app.getUser().clickRegistrationButton();
        Assert.assertTrue(
                app.getUser().isElementPresent(By.cssSelector("span[data-valmsg-for='ConfirmPassword']")),
                "Ошибка несовпадения паролей не появилась");
    }

    @Test
    public void registerWithInvalidEmailNegativeTest() {
        app.getUser().clickRegisterLink();
        app.getUser().selectGender("gender-male");
        app.getUser().fillLoginRegisterForm(
                new de.demowebshop.model.User().setName("Yevhenii").setLastName("Stupachenko")
                        .setEmail("incorrect-email"). setPassword("Qwerty123!").setConfirmPassword("Qwerty123!"));
        app.getUser().clickRegistrationButton();
        Assert.assertTrue(
                app.getUser().isElementPresent(By.cssSelector("span[data-valmsg-for='Email']")),
                "Ошибка некорректного email не появилась");
    }
    @Test
    public void registerWithShortPasswordNegativeTest() {
        String email = app.getUser().generateEmail();
        app.getUser().clickRegisterLink();
        app.getUser().selectGender("gender-male");
        app.getUser().fillLoginRegisterForm(
                new de.demowebshop.model.User().setName("Yevhenii").setLastName("Stupachenko")
                        .setEmail(email).setPassword("123").setConfirmPassword("123"));
        app.getUser().clickRegistrationButton();
        Assert.assertTrue(
                app.getUser().isElementPresent(By.cssSelector("span[data-valmsg-for='Password']")),
                "Ошибка короткого пароля не появилась");
    }
}
