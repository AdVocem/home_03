package tests;

import webdriver.BaseTest;
import tests.forms.*;

public class OnlinerTVSearch extends BaseTest {


    public void runTest() {

        logger.step(1);
        OnlinerMainForm pageMain = new OnlinerMainForm();
        pageMain.assertForum();
        pageMain.getMenuItem("Каталог").click();

        logger.step(2);
        OnlinerCatalogueForm pageCatalogue = new OnlinerCatalogueForm();
        pageCatalogue.assertCatalogue();
        pageCatalogue.getCatalogueItem("Электроника").click();
        pageCatalogue.getCatalogueSection("Телевизоры").click();

        logger.step(3);
        OnlinerTVForm pageTV = new OnlinerTVForm();
        pageTV.assertFilter();
        pageTV.setBrend("Samsung");
        pageTV.setPriceTo(1000);
        pageTV.setDateFrom(2013);

        pageTV.setSizeFrom("39\"");
        pageTV.setSizeTo("42\"");
        pageTV.assertResults();
    }
}


