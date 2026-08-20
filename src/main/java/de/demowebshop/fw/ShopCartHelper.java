package de.demowebshop.fw;

import de.demowebshop.core.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShopCartHelper extends BaseHelper {
    public ShopCartHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnCategoryBooks(){
        clickOnCategory("books");
    }
    public void clickOnAddToCart() {
        clickOnAdd("Add to cart");
    }
    public void clickOnIcoCart(){
        click(By.cssSelector(".ico-cart"));
    }
}
