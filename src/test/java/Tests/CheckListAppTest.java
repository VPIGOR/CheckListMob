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
        int listCount = mainPage.getListCount();
        mainPage
                .clickAddList()
                .enterListName(listName)
                .pressOkCreationList();
        listPage
                .waitPlusVisable();
        String currentListName = listPage.getListName();
        listPage
                .returnToMainPage();
        String lastListName = mainPage.lastListName();

        Assert.assertEquals(listCount+1,mainPage.getListCount(),"no list");
        Assert.assertEquals(currentListName, lastListName, "somthing went wrong");
        Assert.assertTrue(mainPage.isCheclistTitle(listName));

    }

    @Test
    public void createAmptyListWithRotationTest() {
        int listCount = mainPage.getListCount();
        mainPage
                .clickAddList()
                .enterListName("TestForRotation")
                .pressOkCreationList();
        listPage
                .waitPlusVisable();
        String currentListName = listPage.getListName();
        listPage
                .returnToMainPage()
                .rotationScreenLandScape();

        String lastListName = mainPage.lastListName();

        Assert.assertEquals(listCount+1,mainPage.getListCount(),"no list");
        Assert.assertEquals(currentListName, lastListName, "somthing went wrong");


    }



    @Test
    public void createNotAmptyListTest(){
        int listCountBefore = mainPage.getListCount();
        mainPage
                .clickAddList()
                .enterListName("listName")
                .pressOkCreationList();
        listPage
                .waitPlusVisable()
                .createNewItem("ne item")
                .returnToMainPage();
        int listCountAfter =
        mainPage
                .waitPageLoad()
                .getListCount();

        Assert.assertEquals(listCountAfter-listCountBefore,1,"List didnt add");

    }

}
