package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import util.DataProviders;


public class CheckListAppTest extends TastBase {




    @Test
    public void simpleTest() {
        System.out.println(mainPage.mainPageTitle());
        System.out.println(mainPage.receiveAtributBy("class"));
    }


    @Test(dataProviderClass = DataProviders.class, dataProvider = "names")
    public void createAmptyListTest(String listName) {

        mainPage
                .clickAddList()
                .enterListName(listName)
                .pressOkCreationList();

        String currentListName = listPage.getListName();

        listPage
                .returnToMainPage();

        String lastListName = mainPage.lastListName();


        Assert.assertEquals(currentListName, lastListName, "somthing went wrong");

    }

}
