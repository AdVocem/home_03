package tests.forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.TextBox;
import webdriver.elements.Label;

public class OnlinerMainForm extends BaseForm {
    private TextBox txbSearchBar = new TextBox(By.id("fast-search"),"Search bar");
    private Label lbForum = new Label(By.className("b-main-page-blocks-footer-3"),"Forum Section");

    public void assertForum(){
        assert(lbForum.isPresent());
    }

    public OnlinerMainForm() {
        super(By.id("fast-search"), "Onliner's main page");
    }

    public void searchFor(String text) {
        txbSearchBar.type(text);
        txbSearchBar.submit();
        browser.waitForPageToLoad();

    }

    public Label getMenuItem(String itemName){
        String rawXPath = String.format("//span[@class='b-main-navigation__text' and contains(text(), \"%s\")]", itemName);
        Label lbMenuItem = new Label(By.xpath(rawXPath),"Menu Item");
        return lbMenuItem;
    }
}
