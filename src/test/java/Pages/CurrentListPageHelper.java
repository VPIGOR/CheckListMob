package Pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CurrentListPageHelper extends PageBase{

    @FindBy(xpath = "//*[@content-desc = 'Navigate up']")
    WebElement exitFromListButton;
    @FindBy(className = "android.widget.TextView")
    WebElement listName;

    public CurrentListPageHelper(AppiumDriver driver) {
        super(driver);
    }

    public CurrentListPageHelper returnToMainPage() {
        exitFromListButton.click();
        return this;
    }

    public String getListName() {
        return listName.getText();
    }
}
