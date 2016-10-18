package tests;

import org.junit.Assert;
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
        pageTV.sortBy("Дорогие");
        String [] links = pageTV.getResults();

        logger.step(4);
        for (String link : links) {
            OnlinerResultForm pageResult = new OnlinerResultForm();
            pageResult.navigate(link);
            Assert.assertTrue(pageResult.getPrice() < 1000 &&
                              pageResult.getSize() >= 39  &&
                              pageResult.getSize() <= 42 &&
                              pageResult.isBrand("Samsung") &&
                              pageResult.getYear() >= 2013);

        }


    }
}


