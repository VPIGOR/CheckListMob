package Pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPageHelper extends PageBase {

    @FindBy(className = "android.widget.TextView")
    WebElement title;
    @FindBy(id = "com.flt.checklist:id/add_shopping_list")
    WebElement addListButton;
    @FindBy(xpath = "//*[@resource-id='android:id/custom']/*")
    WebElement listNameField;
    @FindBy(id = "android:id/button1")
    WebElement createListButton;
    @FindBy(id = "com.flt.checklist:id/list_title")
    WebElement lastList;


    public MainPageHelper(AppiumDriver driver) {
        super(driver);
    }


    public String mainPageTitle() {
        return title.getText();
    }

    public String receiveAtributBy(String by) {
        return addListButton.getAttribute(by);
    }

    public MainPageHelper clickAddList() {
        addListButton.click();
        return this;
    }

    public MainPageHelper enterListName(String name) {
        fillField(listNameField, name);
        return this;
    }

    public MainPageHelper pressOkCreationList() {
        createListButton.click();
        return this;
    }

    public String lastListName() {
        return lastList.getText();
    }
}
