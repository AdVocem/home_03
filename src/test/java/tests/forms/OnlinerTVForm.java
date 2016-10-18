package tests.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import webdriver.BaseForm;
import webdriver.elements.*;


import java.util.List;

public class OnlinerTVForm extends BaseForm {
    private TextBox txbSearchBar = new TextBox(By.id("fast-search"),"Search bar");
    private Label   lbFilter     = new Label(By.id("schema-filter"), "Products Filter");
    private Label   lbSortMenu   = new Label(By.xpath("//div[@id='schema-order']/a/span"), "Sort By Menu");
    private TextBox txbPriceFrom = new TextBox(By.xpath("//input[@placeholder=\"от\"]"), "Price From");
    private TextBox txbPriceTo   = new TextBox(By.xpath("//input[@placeholder=\"до\"]"), "Price To");
    private TextBox txbDateFrom  = new TextBox(By.xpath("//input[@placeholder=\"2010\"]"), "Date From");
    private TextBox txbDateTo    = new TextBox(By.xpath("//input[@placeholder=\"2016\"]"), "Date To");
    private ComboBox cbSizeFrom  = new ComboBox(By
            .xpath("//select[@class='schema-filter-control__item' and contains(@data-bind, \"facet.value.from\")]"), "Size From");
    private ComboBox cbSizeTo    = new ComboBox(By
            .xpath("//select[@class='schema-filter-control__item' and contains(@data-bind, \"facet.value.to\")]"), "Size To");


    private CheckBox getBrand(String text) {
        String rawXPath = String
                .format("//div[@id='schema-filter']//span[@class='schema-filter__checkbox-text' and contains(text(), \"%s\")]", text);
        return new CheckBox(By.xpath(rawXPath),"Brand's Name");
    }

    private void waitPageLoad() throws InterruptedException {
        Thread.sleep(5000); // Other working solutions have not found
    }

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
        txbPriceFrom.isPresent();
        txbPriceFrom.type(price.toString());
    }

    public void setPriceTo(Integer price) {
        txbPriceTo.isPresent();
        txbPriceTo.type(price.toString());
    }

    public void setDateFrom(Integer date) {
        txbDateFrom.isPresent();
        txbDateFrom.type(date.toString());
    }

    public void setDateTo(Integer date) {
        txbPriceTo.isPresent();
        txbDateTo.type(date.toString());
    }

    public void setSizeFrom(String value) {
        cbSizeFrom.isPresent();
        cbSizeFrom.select(value);
    }

    public void setSizeTo(String value) {
        cbSizeTo.isPresent();
        cbSizeTo.select(value);
    }

    public void sortBy(String value) {
        lbSortMenu.isPresent();
        lbSortMenu.click();

        String rawXPath = String
                .format("//div[@class='schema-order__item']/span[contains(text(), \"%s\")]", value);
        Label lbSortOrderItem = new Label(By.xpath(rawXPath),"Sort By Order");
        lbSortOrderItem.click();
    }

    public String [] getResults(){
        try {
            waitPageLoad();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> elements = Label.browser.getDriver().findElements(By
                .xpath("//div[@class='schema-product__title']/a"));

        Assert.assertTrue(elements.size() > 0);

        String [] links = new String[elements.size()];
        Integer i = 0;
        for (WebElement element: elements) {
            links[i++] = element.getAttribute("href");
        }
        return links;

    }

}
