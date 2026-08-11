package de.demowebshop.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ApplicationManager{

    WebDriver driver;
    UserHelper user;
    HomePageHelper homePage;


    public void init() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        user = new UserHelper(driver);
        homePage = new HomePageHelper(driver);
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
        }
    }
}
