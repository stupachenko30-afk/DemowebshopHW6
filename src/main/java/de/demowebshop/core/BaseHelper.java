package de.demowebshop.core;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseHelper {
    protected WebDriver driver;

    public BaseHelper(WebDriver driver) {
        this.driver = driver;
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
    public String takeScreenshot(){
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);  //временный файл
        File screen = new File("screenshots/screen-" + System.currentTimeMillis() + ".png"); //постоянный

        try {
            Files.copy(tmp,screen);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return screen.getAbsolutePath();
    }
    public void waitForText(By locator, String text) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.textToBe(locator, text));
    }
    public void waitForNotificationToDisappear() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.invisibilityOfElementLocated(
                        By.id("bar-notification")));
    }
    public void closeNotificationIfPresent() {
        try {
            By closeButton = By.cssSelector("#bar-notification .close");

            new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.elementToBeClickable(closeButton))
                    .click();

        } catch (TimeoutException e) {
            // notification не появилась — продолжаем тест
        }
    }

    public void clickOnCategory(String category) {
        String cssLocator = String.format("[href='/%s']",category);
        click(By.cssSelector(cssLocator));
    }
    public void acceptAlertIfPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());

            System.out.println("ALERT TEXT: " + alert.getText());
            alert.accept();

        } catch (TimeoutException e) {
            // alert не появился — продолжаем тест
        }

    }

    public void clickOnAdd(String cart) {
        String cssLocator = String.format("input[value='%s']", cart);
        click(By.cssSelector(cssLocator));
    }

    public void clickOnIcoCart() {
        click(By.cssSelector(".ico-cart"));
    }
}
