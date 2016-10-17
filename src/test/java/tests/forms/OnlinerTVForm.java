package tests.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import webdriver.BaseForm;
import webdriver.elements.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class OnlinerTVForm extends BaseForm {
    private TextBox txbSearchBar = new TextBox(By.id("fast-search"),"Search bar");
    private Label lbFilter = new Label(By.id("schema-filter"), "Products Filter");
    private TextBox txbPriceFrom = new TextBox(By.xpath("//input[@placeholder=\"от\"]"), "Price From");
    private TextBox txbPriceTo = new TextBox(By.xpath("//input[@placeholder=\"до\"]"), "Price To");
    private TextBox txbDateFrom = new TextBox(By.xpath("//input[@placeholder=\"2010\"]"), "Date From");
    private TextBox txbDateTo = new TextBox(By.xpath("//input[@placeholder=\"2016\"]"), "Date To");
    private ComboBox cbSizeFrom = new ComboBox(By.xpath("//select[@class='schema-filter-control__item' and contains(@data-bind, \"facet.value.from\")]"), "Size From");
    private ComboBox cbSizeTo = new ComboBox(By.xpath("//select[@class='schema-filter-control__item' and contains(@data-bind, \"facet.value.to\")]"), "Size To");

    public void assertFilter(){
        assert(lbFilter.isPresent());
    }

    public OnlinerTVForm() {
        super(By.id("fast-search"), "Onliner's catalogue page");
    }

    public void searchFor(String text) {
        txbSearchBar.type(text);
        txbSearchBar.submit();
        browser.waitForPageToLoad();

    }

    public void setBrend(String text) {
        CheckBox cbBrand = getBrand(text);
        cbBrand.isPresent();
        cbBrand.check();
    }

    public void setPriceFrom(Integer price) {
        txbPriceFrom.type(price.toString());
    }

    public void setPriceTo(Integer price) {
        txbPriceTo.type(price.toString());
    }

    public void setDateFrom(Integer date) {
        txbDateFrom.type(date.toString());
    }

    public void setDateTo(Integer date) {
        txbDateTo.type(date.toString());
    }

    public void setSizeFrom(String value) {
        cbSizeFrom.select(value);
    }

    public void setSizeTo(String value) {
        cbSizeTo.select(value);
    }

    private CheckBox getBrand(String text) {
        String rawXPath = String.format("//div[@id='schema-filter']//span[@class='schema-filter__checkbox-text' and contains(text(), \"%s\")]", text);
        CheckBox cbBrand = new CheckBox(By.xpath(rawXPath),"Brand's Name");
        return cbBrand;
    }

    public void assertResults(){
        List<WebElement> elements = browser.getDriver().findElements(By.xpath("//div[@class='schema-product']"));
        System.out.println(elements.size());
        Assert.assertTrue(elements.size() > 0);
    }

}
