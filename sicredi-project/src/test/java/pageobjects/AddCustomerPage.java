package pageobjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AddCustomerPage extends CommonMethods {

	By nameInput = By.id("field-customerName");
	By lastNameInput = By.id("field-contactLastName");
	By contactFisrtNameInput = By.id("field-contactFirstName");
	By phoneInpu = By.id("field-phone");
	By addressLine1Input = By.id("field-addressLine1");
	By addressLine2Input = By.id("field-addressLine2");
	By cityInput = By.id("field-city");
	By stateInput = By.id("field-state");
	By postalCodeInput = By.id("field-postalCode");
	By countryInput = By.id("field-country");
	By fromEmployeerChosen = By.xpath("//div[@id='field_salesRepEmployeeNumber_chosen']");
	By fromEmployeerOptions = By.xpath("//*[@id='field_salesRepEmployeeNumber_chosen']/div/ul/li");
	By creditLimitInput = By.id("field-creditLimit");
	By saveButton = By.id("form-button-save");
	By msg = By.id("report-success");
	By goBackLink = By.xpath("//a[text()='Go back to list']");

	public void sendKeyName() {
		waitElement(nameInput, 25);
		sendKey(nameInput, "Teste Sicredi");
	}

	public void sendKeyLastName() {
		sendKey(lastNameInput, "Teste");
	}

	public void sendKeyContactFisrtInput() {
		sendKey(contactFisrtNameInput, "José");
	}

	public void sendKeyPhone() {
		sendKey(phoneInpu, "51 9999-9999");
	}

	public void sendKeyAddressLine1() {
		sendKey(addressLine1Input, "Av Assis Brasil, 3970");
	}

	public void sendKeyAddressLine2() {
		sendKey(addressLine2Input, "Torre D");
	}

	public void sendKeyCity() {
		sendKey(cityInput, "Porto Alegre");
	}

	public void sendKeyState() {
		sendKey(stateInput, "RS");
	}

	public void sendKeyPostalCode() {
		sendKey(postalCodeInput, "91000-000");
	}

	public void sendKeyCountry() {
		sendKey(countryInput, "Brasil");
	}

	public void selectFromEmployeer() {
		waitElement(fromEmployeerChosen, 5);
		WebElement elemChosen = getElement(fromEmployeerChosen);
		new Actions(driver).moveToElement(elemChosen).click().perform();

		List<WebElement> options = getElements(fromEmployeerOptions);
		for (WebElement webElement : options) {
			if (webElement.getText().equals("Fixter")) {
				new Actions(driver).moveToElement(webElement).click().perform();
			}
		}
	}

	public void sendKeyCreditLimit() {
		sendKey(creditLimitInput, "200");
	}

	public void clickSave() {
		clickJs(saveButton);
	}

	public void clickGoBack() {
		clickJs(goBackLink);
	}

	public void crudCustomer() {

		sendKeyName();
		sendKeyLastName();
		sendKeyContactFisrtInput();
		sendKeyPhone();
		sendKeyAddressLine1();
		sendKeyAddressLine2();
		sendKeyCity();
		sendKeyState();
		sendKeyPostalCode();
		sendKeyCountry();
		selectFromEmployeer();
		sendKeyCreditLimit();
		clickSave();
	}

	public String msgValidation() {
		waitElement(msg, 20);
		return getElement(msg).getText().toString();
	}
}
