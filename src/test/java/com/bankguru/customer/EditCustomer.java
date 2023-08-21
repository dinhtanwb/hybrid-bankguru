package com.bankguru.customer;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.EditCustomerPO;
import pageObjects.HomePagePO;
import pageObjects.LoginPagePO;

public class EditCustomer extends BaseTest{
	WebDriver driver;
	LoginPagePO loginPage;
	HomePagePO homePage;
	EditCustomerPO editCustomerPage;
	
	String userID= "mngr522589";
	String password = "epEhEgY";
	String customerID;
	
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browser, String url) {
		log.info("Step 01 - Open URL 'https://demo.guru99.com/v4/'");
		driver = openMultipleBrowser(browser, url);
		customerID = NewCustomer.customerID;
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		log.info("Step 02 - Input to USERID value " + userID);
		loginPage.enterToUserIDTextBox(userID);
		
		log.info("Step 03 - Input to Password value " + password);
		loginPage.enterToPasswordTextBox(password);
		
		log.info("Step 04 - Click to login button");
		homePage = loginPage.clickToLoginButton();
		
		log.info("Verify Login successfully");
		Assert.assertTrue(homePage.isLoginSuccessDisplayed());
		
	}
	
	@Test(description = "Customer ID Cannot be empty")
	public void EC_01_CustomerID_Cannot_Empty() {
		log.info("Step 01 - Open Edit Customer Page");
		editCustomerPage = homePage.openEditCustomerPage(driver);
		
		log.info("Step 02 -Send key to Customer ID field value: ''");
		editCustomerPage.enterToCustomerIDTextBox("");
		
		log.info("Step 03 -Press tab to navigate next field");
		editCustomerPage.pressTabToNavigateNextFieldAtCustomerID();
		
		log.info("Step 04 -Verify error message Customer ID field");
		verifyTrue(editCustomerPage.isErrorMessageCustomerIdDisplayed("Customer ID is required"));
		
	}
	@Test(description = "Customer ID must be numeric")
	public void EC_02_Must_Be_Numeric()  {
		
		log.info("Step 01 - Send key to Customer ID field value: '123ASD'");
		editCustomerPage.enterToCustomerIDTextBox("123ASD");
		
		log.info("Step 02 - Verify Error Message Displayed");
		verifyTrue(editCustomerPage.isErrorMessageCustomerIdDisplayed("Characters are not allowed"));
		
	}
	
	@Test(description = "Customer ID is special character")
	public void EC_03_Customer_ID_Have_Special_Character()  {
		
		log.info("Step 01 - Send key to Customer ID field value: '123$$$$$'");
		editCustomerPage.enterToCustomerIDTextBox("123$$$$$");
		
		log.info("Step 02 - Verify Error Message Displayed");
		verifyTrue(editCustomerPage.isErrorMessageCustomerIdDisplayed("Special characters are not allowed"));
		
	}
	@Test(description = "Customer ID is special character")
	public void EC_04_Customer_ID_Valid()  {
		
		log.info("Step 01 - Send key to Customer ID field value: '" + customerID + "'");
		editCustomerPage.enterToCustomerIDTextBox(customerID);
		
		log.info("Step 02 - Click to submit button");
		editCustomerPage.clickToSubmitButton();
		
	}
	
	@Test
	public void EC_05_Address_Cannot_Be_Empty()  {
		
		log.info("Step 01 - Send key to Customer ID field value: '" + customerID + "'");
		editCustomerPage.enterToAddress("");
		
		log.info("Step 02 - Press Tab to navigate next field at Address Field");
		editCustomerPage.pressTabToNavigateNextFieldAtAddress();
		
		log.info("Step 03 - Verify Error Message Address displayed");
		editCustomerPage.isAddressErrorMessageDisplayed("Address Field must not be blank");
		
	}
	
	@Test
	public void EC_06_City_Cannot_Be_Empty()  {
		
		log.info("Step 01 - Send key to City field value: ");
		editCustomerPage.enterToCity("");
		
		log.info("Step 02 - Press Tab to navigate next field at City Field");
		editCustomerPage.pressTabToNavigateNextFieldAtCity();
		
		log.info("Step 03 - Verify Error Message City displayed");
		editCustomerPage.isCityErrorMessageDisplayed("City Field must not be blank");
		
	}
	@Test
	public void EC_07_City_Cannot_Be_Numeric()  {
		
		log.info("Step 01 - Send key to City field value: 1234");
		editCustomerPage.enterToCity("1234");
		
		log.info("Step 02 - Verify Error Message City displayed");
		editCustomerPage.isCityErrorMessageDisplayed("Numbers are not allowed");
		
	}
	
	@Test
	public void EC_08_City_Cannot_Be_Special_Character()  {
		
		log.info("Step 01 - Send key to City field value: !@#$$$@!");
		editCustomerPage.enterToCity("!@#$$$@!");
		
		log.info("Step 02 - Verify Error Message City displayed");
		editCustomerPage.isCityErrorMessageDisplayed("Special characters are not allowed");
		
	}
	
	@Test
	public void EC_09_State_Cannot_Be_Empty()  {
		
		log.info("Step 01 - Send key to State field value: ");
		editCustomerPage.enterToState("");
		
		log.info("Step 02 - Press Tab to navigate next field at State Field");
		editCustomerPage.pressTabToNavigateNextFieldAtState();
		
		log.info("Step 03 - Verify Error Message State displayed");
		editCustomerPage.isStateErrorMessageDisplayed("State must not be blank");
		
	}
	@Test(priority = 2)
	public void EC_10_State_Cannot_Be_Numeric()  {
		
		log.info("Step 01 - Send key to State field value: 1234");
		editCustomerPage.enterToState("1234");
		
		log.info("Step 02 - Verify Error Message State displayed");
		editCustomerPage.isStateErrorMessageDisplayed("Numbers are not allowed");
		
	}
	
	@Test(priority = 2)
	public void EC_11_State_Cannot_Be_Special_Character()  {
		
		log.info("Step 01 - Send key to State field value: !@#$$$@!");
		editCustomerPage.enterToState("!@#$$$@!");
		
		log.info("Step 02 - Verify Error Message State displayed");
		editCustomerPage.isStateErrorMessageDisplayed("Special characters are not allowed");
		
	}
	
	@Test(priority = 2)
	public void EC_12_PIN_Cannot_Be_Empty()  {
		
		log.info("Step 01 - Send key to PIN field value: ");
		editCustomerPage.enterToPIN("");
		
		log.info("Step 02 - Press Tab to navigate next field at State Field");
		editCustomerPage.pressTabToNavigateNextFieldAtPIN();
		
		log.info("Step 03 - Verify Error Message PIN displayed");
		editCustomerPage.isPINErrorMessageDisplayed("PIN Code must not be blank");
		
	}
	@Test(priority = 2)
	public void EC_13_PIN_Must_Be_Numeric()  {
		
		log.info("Step 01 - Send key to PIN field value: 1234AB");
		editCustomerPage.enterToPIN("1234AB");
		
		log.info("Step 02 - Verify Error Message PIN displayed");
		editCustomerPage.isPINErrorMessageDisplayed("Characters are not allowed");
		
	}
	
	@Test(priority = 2)
	public void EC_14_PIN_Cannot_Be_Special_Character()  {
		
		log.info("Step 01 - Send key to PIN field value: !@#$$$@!");
		editCustomerPage.enterToPIN("!@#$$$@!");
		
		log.info("Step 02 - Verify Error Message PIN displayed");
		editCustomerPage.isPINErrorMessageDisplayed("Special characters are not allowed");
		
	}
	@Test(priority = 2)
	public void EC_15_PIN_Must_Have_6_Digits()  {
		
		log.info("Step 01 - Send key to PIN field value: 1234");
		editCustomerPage.enterToPIN("1234");
		
		log.info("Step 02 - Verify Error Message PIN displayed");
		editCustomerPage.isPINErrorMessageDisplayed("PIN Code must have 6 Digits");
		
	}
	
	@Test(priority = 2)
	public void EC_16_TelePhone_Cannot_Be_Special_Character()  {
		
		log.info("Step 01 - Send key to TelePhone field value: !@#$$$@!");
		editCustomerPage.enterToTelephone("!@#$$$@!");
		
		log.info("Step 02 - Verify Error Message TelePhone displayed");
		editCustomerPage.isTelephoneErrorMessageDisplayed("Special characters are not allowed");
		
	}
	@Test(priority = 2)
	public void EC_17_TelePhone_Cannot_Be_Empty()  {
		
		log.info("Step 01 - Send key to TelePhone field value: ''");
		editCustomerPage.enterToTelephone("");
		
		log.info("Step 02 - Verify Error Message TelePhone displayed");
		editCustomerPage.isTelephoneErrorMessageDisplayed("Mobile no must not be blank");
		
	}
	@Test(priority = 2)
	public void EC_18_Email_Not_Be_Empty()  {
		
		log.info("Step 01 - Send key to Email field value: ''");
		editCustomerPage.enterToEmail("");
		
		log.info("Step 02 - Verify Error Message PIN displayed");
		editCustomerPage.isEmailErrorMessageDisplayed("Email-ID must not be blank");
		
	}
	
	@Test(priority = 2)
	public void EC_19_Email_invalid_format()  {
		
		log.info("Step 01 - Send key to TelePhone field value: guru99@gmail");
		editCustomerPage.enterToEmail("guru99@gmail");
		
		log.info("Step 02 - Verify Error Message Email displayed");
		editCustomerPage.isEmailErrorMessageDisplayed("Email-ID is not valid");
		
	}
	
	
	
	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
}
