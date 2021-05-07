package Tests;

import Pages.CurrentListPageHelper;
import Pages.MainPageHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class TastBase {
    public AppiumDriver driver;
    MainPageHelper mainPage;
    CurrentListPageHelper listPage;

    @BeforeMethod(alwaysRun = true)
    public void init() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("appPackage", "com.flt.checklist");
        capabilities.setCapability("appActivity", "com.flt.checklist.MainActivity");
        capabilities.setCapability("automationName", "Uiautomator2");
        capabilities.setCapability("app", "C:/Users/Igor/IdeaProjects/checkListMob/apk/com.flt.checklist_1_apps.evozi.com.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainPage = new MainPageHelper(driver);
        listPage = new CurrentListPageHelper(driver);

//        mainPage = PageFactory.initElements(driver,MainPageHelper.class);
//        listPage = PageFactory.initElements(driver, CurrentListPageHelper.class);


    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

}
