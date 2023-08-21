package com.bankguru.customer;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.DeleteCustomerPO;
import pageObjects.HomePagePO;
import pageObjects.LoginPagePO;

public class DeleteCustomer extends BaseTest{
	LoginPagePO loginPage;
	HomePagePO homePage;
	WebDriver driver;
	DeleteCustomerPO deleteCustomerPage;
	String userID= "mngr522589";
	String password = "epEhEgY";
	
	
	@Parameters({ "envName", "serverName", "browserName", "osName", "osVersion" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("dev") String serverName, @Optional("chrome") String browserName, @Optional("Windows") String osName, @Optional("10") String osVersion) {
		log.info("Step 01 - Open URL 'https://demo.guru99.com/v4/'");
		driver = getBrowser(envName, serverName, browserName, osName, osVersion);
		
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		log.info("Step 02 - Input to USERID value " + userID);
		loginPage.enterToUserIDTextBox(userID);
		
		log.info("Step 03 - Input to Password value " + password);
		loginPage.enterToPasswordTextBox(password);
		
		log.info("Step 04 - Click to login button");
		homePage = loginPage.clickToLoginButton();
		
		log.info("Step 05 - Verify Login successfully");
		verifyTrue(homePage.isLoginSuccessDisplayed());
		
		
		
	}
	
	@Test
	public void DC01_CustomerID_CannotBe_Empty() {
		log.info("Open Delete customer page");
		deleteCustomerPage = homePage.openDeleteCustomerPage(driver);
		
		log.info("Step 01 - Enter to customer ID value: ''");
		deleteCustomerPage.enterToCustomerIdTextBox("");
		
		log.info("Step 02 - Press tab to navigate next field");
		deleteCustomerPage.pressTabToNavigateNextFieldAtCustomerId();
		
		log.info("Step 03 - Verify error message displayed");
		verifyTrue(deleteCustomerPage.isCustomerIDErrorMessageDisplayed("Customer ID is required"));
		
	}
	@Test
	public void DC02_CustomerID_Must_Be_Numeric() {
		
		log.info("Step 01 - Enter to customer ID value: 'Acc12344'");
		deleteCustomerPage.enterToCustomerIdTextBox("Acc12344");
		
		log.info("Step 02 - Verify error message displayed");
		verifyTrue(deleteCustomerPage.isCustomerIDErrorMessageDisplayed("Characters are not allowed"));
		
	}
	
	@Test
	public void DC03_CustomerID_Have_Character_Special() {
		
		log.info("Step 01 - Enter to customer ID value: '!@#$$$$'");
		deleteCustomerPage.enterToCustomerIdTextBox("!@#$$$$");
		
		log.info("Step 02 - Verify error message displayed");
		verifyTrue(deleteCustomerPage.isCustomerIDErrorMessageDisplayed("Special characters are not allowed"));
		
	}
	
	@Test
	public void DC04_CustomerID_Have_Blank_Space() {
		
		log.info("Step 01 - Enter to customer ID value: '123 2323'");
		deleteCustomerPage.enterToCustomerIdTextBox("123 2323");
		
		log.info("Step 02 - Verify error message displayed");
		verifyTrue(deleteCustomerPage.isCustomerIDErrorMessageDisplayed("Characters are not allowed"));
		
	}
	
	@Test
	public void DC05_CustomerID_First_Character_Not_Have_Blank_Space() {
		
		log.info("Step 01 - Enter to customer ID value: ' '");
		deleteCustomerPage.enterToCustomerIdTextBox(" ");
		
		log.info("Step 02 - Verify error message displayed");
		verifyTrue(deleteCustomerPage.isCustomerIDErrorMessageDisplayed("First character can not have space"));
		
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

}
