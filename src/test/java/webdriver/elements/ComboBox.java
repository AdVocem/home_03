package webdriver.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class ComboBox extends BaseElement {

	/**
	 * Constructor
	 * @param locator locator
	 * @param name name
	 */
	public ComboBox(final By locator, final String name) {
		super(locator, name);
	}

	/**
	 * Constructor
	 * @param string locator
	 * @param name name
	 */
	public ComboBox(final String string, final String name) {
		super(string, name);
	}


	/**
	 * Constructor
	 * @param locator locator
	 */
	public ComboBox(final By locator) {
		super(locator);
	}

	/**
	 * Enter the text in the box
	 * @param value text
	 */
	public void select(final String value) {
		waitForIsElementPresent();
		info(String.format(getLoc("loc.text.typing") + " '%1$s'", value));
		if (browser.getDriver() instanceof JavascriptExecutor) {
			((JavascriptExecutor)browser.getDriver()).executeScript("arguments[0].style.border='3px solid red'", element);
		}
		element.sendKeys(value);
	}

	protected String getElementType() {
		return getLoc("loc.combobox");
	}

}
