package de.demowebshop.tests;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
public class CreateAccountTests extends TestBase {

    @Test
    public void newUserRegisterPositiveTest() {
        String email = "stupachenko30" + System.currentTimeMillis() + "@gmail.com";
        clickRegisterLink();
        selectGender("gender-male");
        fillLoginRegisterForm("Yevhenii", "Stupachenko", email, "Qwerty123!", "Qwerty123!");
        clickRegistrationButton();
        Assert.assertTrue(isElementPresent(By.cssSelector(".result")));//проверка регистрации
    }
    @Test
    public void newUserRegisterExistingEmailNegativeTest() {
        clickRegisterLink();
        selectGender("gender-male");
        fillLoginRegisterForm("Yevhenii", "Stupachenko", "stupachenko30@gmail.com", "Qwerty123!", "Qwerty123!");
        clickRegistrationButton();
        Assert.assertTrue(validationSummaryError());
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
    @Test
    public void registerWithDifferentPasswordsNegativeTest() {
        String email = "stupachenko30"
                + System.currentTimeMillis()
                + "@gmail.com";

        clickRegisterLink();
        selectGender("gender-male");

        fillLoginRegisterForm(
                "Yevhenii",
                "Stupachenko",
                email,
                "Qwerty123!",
                "Qwerty456!"
        );

        clickRegistrationButton();

        Assert.assertTrue(
                isElementPresent(By.cssSelector("span[data-valmsg-for='Email']")),
                "Ошибка несовпадения паролей появилась"
        );
    }
    @Test
    public void registerWithInvalidEmailNegativeTest() {
        clickRegisterLink();
        selectGender("gender-male");

        fillLoginRegisterForm(
                "Yevhenii",
                "Stupachenko",
                "incorrect-email",
                "Qwerty123!",
                "Qwerty123!"
        );

        clickRegistrationButton();

        Assert.assertTrue(
                isElementPresent(By.cssSelector("span[data-valmsg-for='Email']")),
                "Ошибка некорректного email не появилась"
        );
    }
    @Test
    public void registerWithShortPasswordNegativeTest() {
        String email = "stupachenko30"
                + System.currentTimeMillis()
                + "@gmail.com";

        clickRegisterLink();
        selectGender("gender-male");

        fillLoginRegisterForm(
                "Yevhenii",
                "Stupachenko",
                email,
                "123",
                "123"
        );

        clickRegistrationButton();

        Assert.assertTrue(
                isElementPresent(By.cssSelector("span[data-valmsg-for='Password']")),
                "Ошибка короткого пароля не появилась"
        );
    }
}
