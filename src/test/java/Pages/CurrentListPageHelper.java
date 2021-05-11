package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CurrentListPageHelper extends PageBase{

    @FindBy(xpath = "//*[@content-desc = 'Navigate up']")
    WebElement exitFromListButton;
    @FindBy(className = "android.widget.TextView")
    WebElement listName;
    @FindBy(id = "com.flt.checklist:id/add_item")
    WebElement addItemButton;
    @FindBy(id = "com.flt.checklist:id/add_item_edit")
    WebElement itemNameField;

    public CurrentListPageHelper(WebDriver driver) {
        super(driver);
    }

    public CurrentListPageHelper returnToMainPage() {
        exitFromListButton.click();
        return this;
    }

    public CurrentListPageHelper createNewItem(String itemName){
        fillField(itemNameField,itemName);
        addItemButton.click();
        return this;
    }

    public String getListName() {
        return listName.getText();
    }
    public CurrentListPageHelper waitPlusVisable(){
        waitUntilElementIsClickabl(addItemButton,2);
        return this;
    }
}
