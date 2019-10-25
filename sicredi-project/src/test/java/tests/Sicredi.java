package tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageobjects.AddCustomerPage;
import pageobjects.CommonMethods;
import pageobjects.HomePage;
import pageobjects.SearchCustomer;

public class Sicredi {

	public static WebDriver driver;
	HomePage homePage;
	AddCustomerPage addCustomerPage;
	SearchCustomer searchCustomer;
	CommonMethods commonMethods;

	@Before
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.grocerycrud.com/demo/bootstrap_theme");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		commonMethods.setDriver(driver);
		homePage = new HomePage();
		addCustomerPage = new AddCustomerPage();
		searchCustomer = new SearchCustomer();
	}

	@After
	public void closeDriver() {
		driver.quit();
	}

	@Test
	public void desafio1Test() throws Exception {

		homePage.selectBootstrap();
		homePage.clickAddCustomer();
		addCustomerPage.crudCustomer();

		assert (addCustomerPage.msgValidation().contains("Your data has been successfully stored into the database."));
	}

	@Test
	public void desafio2Test() throws Exception {

		homePage.selectBootstrap();
		homePage.clickAddCustomer();
		addCustomerPage.crudCustomer();

		assert (addCustomerPage.msgValidation().contains("Your data has been successfully stored into the database."));

		addCustomerPage.clickGoBack();

		searchCustomer.clickSearchButton();
		searchCustomer.sendKeySearchName();
		searchCustomer.clickCheckActions();
		searchCustomer.clickDelete();

		assert (searchCustomer.msgQuestionValidation().contains("Are you sure that you want to delete this 1 item?"));

		searchCustomer.clickDeleteModal();

		assert (searchCustomer.msgDeleteValidation().contains("Your data has been successfully deleted from the database."));
	}
}
