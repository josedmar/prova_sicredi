package pageobjects;

import org.openqa.selenium.By;

public class HomePage extends CommonMethods {

	By versionSelect = By.id("switch-version-select");
	By addButton = By.xpath("//a[@href='/demo/bootstrap_theme_v4/add']");

	public void selectBootstrap() {
		waitElement(versionSelect, 20);
		select(getElement(versionSelect), "Bootstrap V4 Theme");
	}

	public void clickAddCustomer() {
		waitElement(addButton, 20);
		clickJs(addButton);
	}
}
