package Pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public abstract class PageBase {
    WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }


    public PageBase fillField(WebElement element, String value) {
        element.clear();
        element.click();
        element.sendKeys(value);
        return this;
    }
    public PageBase waitUntilElementIsVisable(WebElement element, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }
    public PageBase implicitlyWait(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return this;
    }
    public PageBase waitUntilElementIsClickabl(WebElement element, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }
    public void rotationScreenLandScape(){
        AppiumDriver appiumDriver = (AppiumDriver)driver;
        appiumDriver.rotate(ScreenOrientation.LANDSCAPE);
    }
    public void rotationScreenPortrate(){
        AppiumDriver appiumDriver = (AppiumDriver)driver;
        appiumDriver.rotate(ScreenOrientation.PORTRAIT);
    }



}
