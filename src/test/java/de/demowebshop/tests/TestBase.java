package de.demowebshop.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {

     WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {//атрибут id=email
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    public boolean isElementPresent(By locator) {

        return driver.findElements(locator).size() > 0;
    }

    public boolean isHomeComponentPresent() {

        return isElementPresent(By.cssSelector(".header-logo"));
    }

    public void fillLoginRegisterForm(String Name,
                                      String LastName,
                                      String email,
                                      String Password,
                                      String ConfirmPassword) {
        type(By.id("FirstName"), Name);
        type(By.id("LastName"), LastName);
        type(By.id("Email"), email);
        type(By.id("Password"), Password);
        type(By.id("ConfirmPassword"), ConfirmPassword);
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
        type(By.id("Email"), "stupachenko30@gmail.com");
        type(By.id("Password"), "Qwerty123!");
    }
    public void fillLoginForm(String email, String password){
type(By.id("Email"),email);
type (By.id("Password"),password);
    }

    public void clickLoginLink() {
        click(By.cssSelector(".ico-login"));
    }

    public boolean validationSummaryError() {
        return isElementPresent(By.cssSelector(".validation-summary-errors"));
    }
      public String generateEmail() {
      return "stupachenko30" + System.currentTimeMillis() + "@gmail.com";
    }

    public void clickSearchButton() {
        click(By.cssSelector("input.search-box-button"));
    }

}

