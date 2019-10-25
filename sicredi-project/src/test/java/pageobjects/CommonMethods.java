package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods {

	public static WebDriver driver;

	public static void setDriver(WebDriver driver) {
		CommonMethods.driver = driver;
	}

	public void click(By locator) {
		System.out.println("Click on the locator: " + locator.toString());
		driver.findElement(locator);
	}

	public void sendKey(By locator, String value) {
		System.out.println("SendKey the value: " + value);
		driver.findElement(locator).sendKeys(value);
	}

	public void select(WebElement element, String text) {
		System.out.println("Select the text : " + text);
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public WebElement getElement(By locator) {
		System.out.println("Get the locator: " + locator.toString());
		return driver.findElement(locator);
	}

	public List<WebElement> getElements(By locator) {
		System.out.println("Get the locator: " + locator.toString());
		return driver.findElements(locator);
	}

	public void waitElement(By locator, int timeOut) {
		System.out.println("Wait for the locator: " + locator.toString());
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void clickJs(By locator) {
		WebElement element = getElement(locator);
		System.out.println("Click on the element with Javascript");
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
}
