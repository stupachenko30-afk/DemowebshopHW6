package de.demowebshop.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
}
