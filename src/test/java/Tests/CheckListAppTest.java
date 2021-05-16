package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import util.DataProviders;


public class CheckListAppTest extends TastBase {

    @Test
    public void HwBackGround() {
        mainPage
                .clickAddList()
                .enterListName("listName")
                .pressOkCreationList();
        listPage
                .waitPlusVisable()
                .createNewItem("ne item")
                .runBackGround(5);
        listPage.waitPlusVisable();

        Assert.assertTrue(listPage.isItemWasAdd());
    }

    @Test
    public void simpleTest() {
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

        Assert.assertEquals(listCount + 1, mainPage.getListCount(), "no list");
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

        Assert.assertEquals(listCount + 1, mainPage.getListCount(), "no list");
        Assert.assertEquals(currentListName, lastListName, "somthing went wrong");


    }


    @Test
    public void createNotAmptyListTest() {
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

        Assert.assertEquals(listCountAfter - listCountBefore, 1, "List didnt add");

    }

    @Test
    public void goToBackGroundTest() {

        mainPage
                .clickAddList()
                .enterListName("list for test background")
                .pressOkCreationList();
        listPage
                .waitPlusVisable()
                .runBackGround(5);
    }

    @Test
    public void createManyChecklistsAndSwipeThem() {

        for (int j = 0; j < 39; j++) {
            String listName = "list # " + j;
            mainPage
                    .clickAddList()
                    .enterListName(listName)
                    .pressOkCreationList();
            listPage
                    .waitPlusVisable()
                    .returnToMainPage();
            mainPage.waitPageLoad();
        }
        mainPage.swipeUp();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainPage.swipeDown();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainPage.swipeToLastElement();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
