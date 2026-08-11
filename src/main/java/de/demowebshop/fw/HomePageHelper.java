package de.demowebshop.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageHelper extends de.demowebshop.core.BaseHelper {
    public HomePageHelper(WebDriver driver) {
        super(driver);
    }
    public boolean isHomeComponentPresent() {

        return isElementPresent(By.cssSelector(".header-logo"));
    }
}
