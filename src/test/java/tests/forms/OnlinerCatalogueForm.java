package tests.forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Label;
import webdriver.elements.TextBox;

public class OnlinerCatalogueForm extends BaseForm {
    private TextBox txbSearchBar = new TextBox(By.id("fast-search"),"Search bar");
    private Label lbCatalogue = new Label(By.className("catalog-navigation"),"Catalogue's Navigation Bar");

    public void assertCatalogue(){
        assert(lbCatalogue.isPresent());
    }

    public OnlinerCatalogueForm() {
        super(By.id("fast-search"), "Onliner's catalogue page");
    }

    public Label getCatalogueItem(String itemName){
        String rawXPath = String
                .format("//div[@class='catalog-navigation']//span[contains(text(), \"%s\")]", itemName);
        Label lbCatalogueItem = new Label(By.xpath(rawXPath),"Catalogue Item");
        return lbCatalogueItem;
    }

    public Label getCatalogueSection(String sectionName){
        String rawXPath = String
                .format("//div[@class='catalog-navigation']//a[contains(text(),  \"%s\")]", sectionName);
        Label lbCatalogueItem = new Label(By.xpath(rawXPath),"Catalogue Section");
        return lbCatalogueItem;
    }

    public void searchFor(String text) {
        txbSearchBar.type(text);
        txbSearchBar.submit();
        browser.waitForPageToLoad();

    }

}
