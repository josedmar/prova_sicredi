package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class SearchCustomer extends CommonMethods {

	By searchButton = By.xpath("//input[@name='search']/..");
	By searchInput = By.name("search");
	By actionsCheck = By.className("select-all-none");
	By deleteButton = By.xpath("//span[text()='Delete']/..");
	By questionModalLabel = By.className("alert-delete-multiple");
	By deleteModalButton = By.xpath("//button[@data-target='/demo/bootstrap_theme_v4/delete_multiple']");
	By msgDeleted = By.xpath("//div[@class='alert alert-success growl-animated animated bounceInDown']//span/p");

	public void clickSearchButton() {
		clickJs(searchButton);
	}

	public void sendKeySearchName() {
		waitElement(searchInput, 15);
		sendKey(searchInput, "Teste Sicredi");
	}

	public void clickCheckActions() {
		clickJs(actionsCheck);
	}

	public void clickDelete() {
		waitElement(deleteButton, 10);
		clickJs(deleteButton);
	}

	public void clickDeleteModal() {
		waitElement(deleteModalButton, 10);
		new Actions(driver).moveToElement(getElement(deleteModalButton)).click().perform();
		clickJs(deleteModalButton);
	}

	public String msgQuestionValidation() {
		waitElement(questionModalLabel, 7);
		return getElement(questionModalLabel).getText().toString();
	}

	public String msgDeleteValidation() {
		waitElement(msgDeleted, 12);
		return getElement(msgDeleted).getText().toString();
	}
}
