package de.demowebshop.core;

import de.demowebshop.fw.HomePageHelper;
import de.demowebshop.fw.UserHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
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

    public UserHelper getUser() {
        return user;
    }

    public HomePageHelper getHomePage() {
        return homePage;
    }

    public WebDriver getDriver() {return driver;
    }
}
