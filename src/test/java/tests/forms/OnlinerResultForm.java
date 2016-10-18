package tests.forms;


import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Label;

public class OnlinerResultForm extends BaseForm {
    private Label lbFilter = new Label(By.id("schema-filter"), "Products Filter");
    private Label lbYear   = new Label(By.xpath("//span[@class='value__text' and contains(text(), \"г.\")]"), "Product's Manufacture Date");
    private Label lbTitle  = new Label(By.className("catalog-masthead__title"), "Product's Title");
    private Label lbSize   = new Label(By.xpath("//div[@id='specs']//td[contains(text(), \"Диагональ экрана\")]/following::td/span"), "Product's Size");
    private Label lbPrice  = new Label(By.xpath("//a[contains(@class, 'b-offers-desc__info-price-value_primary')]"), "Product's Price");

    public void assertFilter(){
        assert(lbFilter.isPresent());
    }

    public OnlinerResultForm() {
        super(By.id("fast-search"), "Onliner's result page");
    }

    public Integer getYear(){
        lbYear.isPresent();
        String [] result = lbYear.getText()
                                 .split(" ");
        return Integer.parseInt(result[0]);

    }

    public Integer getSize(){
        lbSize.isPresent();
        String [] result = lbSize.getText()
                                 .split("\"");
        return Integer.parseInt(result[0]);

    }

    public Float getPrice(){
        lbPrice.isPresent();
        String [] result = lbPrice.getText()
                                  .split(" ");
        return Float.parseFloat(result[0].replaceAll(",", "."));

    }

    public Boolean isBrand(String brandName){
        lbTitle.isPresent();
        return lbTitle.getText()
                      .contains(brandName);

    }

    public void navigate(String url) {
        browser.getDriver().get(url);
    }

}
