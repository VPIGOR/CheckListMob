package Tests;

import Pages.CurrentListPageHelper;
import Pages.MainPageHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public abstract class TastBase {
    AppiumDriver driver;
    MainPageHelper mainPage;
    CurrentListPageHelper listPage;

    @BeforeMethod(alwaysRun = true)
    public void init() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "8.0.0");
        capabilities.setCapability("appPackage", "com.flt.checklist");
        capabilities.setCapability("appActivity", "com.flt.checklist.MainActivity");
        capabilities.setCapability("automationName", "Appium");
//        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability("app", "C:/Users/Igor/IdeaProjects/checkListMob/apk/com.flt.checklist_1_apps.evozi.com.apk");




        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainPage = PageFactory.initElements(driver,MainPageHelper.class);
        listPage = PageFactory.initElements(driver,CurrentListPageHelper.class);


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        listPage.rotationScreenPortrate();

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }



}
