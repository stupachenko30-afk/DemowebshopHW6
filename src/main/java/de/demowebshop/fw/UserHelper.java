package de.demowebshop.fw;

import de.demowebshop.data.UserData;
import de.demowebshop.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends de.demowebshop.core.BaseHelper {

    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void selectGender(String Gender) {
        click(By.id(Gender));
    }

    public void clickRegisterLink() {
        click(By.cssSelector(".ico-register"));
    }

    public void clickRegistrationButton() {
        click(By.id("register-button"));
    }

    public void clickInputLoginButton() {
        click(By.cssSelector("input.login-button"));
    }

    public void fillLoginForm() {
        type(By.id("Email"), UserData.EMAIL);
        type(By.id("Password"), UserData.PASSWORD);
    }

    public void fillLoginForm(String email, String password){
type(By.id("Email"),email);
type (By.id("Password"),password);
    }

    public void clickLoginLink() {
        click(By.cssSelector(".ico-login"));
    }

    public String generateEmail() {
      return "stupachenko30" + System.currentTimeMillis() + "@gmail.com";
    }

    public void clickSearchButton() {
        click(By.cssSelector("input.search-box-button"));
    }
    public void fillLoginRegisterForm(User user) {
        type(By.id("FirstName"), user.getName());
        type(By.id("LastName"), user.getLastName());
        fillLoginForm(user.getEmail(), user.getPassword());
        type(By.id("ConfirmPassword"), user.getConfirmPassword());
    }

    public boolean validationSummaryError() {
        return isElementPresent(By.cssSelector(".validation-summary-errors"));
    }

}
