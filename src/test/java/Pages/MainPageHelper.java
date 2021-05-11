package Pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPageHelper extends PageBase {

    public MainPageHelper(WebDriver driver) {super(driver); }

    @AndroidFindBy(className = "android.widget.TextView")
    WebElement title;
    @FindBy(id = "com.flt.checklist:id/add_shopping_list")
    WebElement addListButton;
    @FindBy(xpath = "//*[@resource-id='android:id/custom']/*")
    WebElement listNameField;
    @FindBy(id = "android:id/button1")
    WebElement createListButton;
    @FindBy(id = "com.flt.checklist:id/list_title")
    WebElement lastList;
    @FindBy(id = "com.flt.checklist:id/list_title")
    List<WebElement> listsName;


//

    public int getListCount(){
      return  listsName.size();
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
    public MainPageHelper waitPageLoad(){
        waitUntilElementIsClickabl(addListButton,2);
        return this;
    }
}
