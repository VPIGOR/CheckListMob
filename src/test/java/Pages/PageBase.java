package Pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public abstract class PageBase {
    AppiumDriver driver;

    public PageBase(AppiumDriver driver) {
        this.driver = driver;
    }


    public PageBase fillField(WebElement element, String value) {
        element.clear();
        element.click();
        element.sendKeys(value);
        return this;
    }



}
