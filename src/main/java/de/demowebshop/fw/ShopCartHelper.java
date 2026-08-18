package de.demowebshop.fw;

import de.demowebshop.core.BaseHelper;
import org.openqa.selenium.WebDriver;

public class ShopCartHelper extends BaseHelper {
    public ShopCartHelper(WebDriver driver) {
        super(driver);
    }
    public void clickOnCategoryBooks(){
        clickOnCategory("books");
    }
}
