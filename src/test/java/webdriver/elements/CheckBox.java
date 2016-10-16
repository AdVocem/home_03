package webdriver.elements;

import org.openqa.selenium.By;

public class CheckBox extends BaseElement {

	/**
	 * Constructor
	 * @param locator locator
	 * @param name name
	 */
	public CheckBox(final By locator, final String name) {
		super(locator, name);
	}

	/**
	 * Constructor
	 * @param string locator
	 * @param name name
	 */
	public CheckBox(final String string, final String name) {
		super(string, name);
	}


	/**
	 * Constructor
	 * @param locator locator
	 */
	public CheckBox(final By locator) {
		super(locator);
	}

	public Boolean isChecked() {
		return element.isSelected();
	}

	public void check() {
		if (!isChecked()) {
			this.click();
		}
	}

	public void uncheck() {
		if (isChecked()) {
			this.click();
		}
	}

	protected String getElementType() {
		return getLoc("loc.checkbox");
	}

}
