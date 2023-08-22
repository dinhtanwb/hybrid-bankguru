package com.bankguru.account;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.customer.NewCustomer;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.HomePagePO;
import pageObjects.LoginPagePO;
import pageObjects.NewAccountPO;

public class NewAccount extends BaseTest{
	WebDriver driver;
	LoginPagePO loginPage;
	HomePagePO homePage;
	NewAccountPO newAccountPage;
	String userID = "mngr522589";
	String password = "epEhEgY";
	String customerID;
	String accountType = "Current";
	String initialDeposit = "500";
	public static String accountID;
	
	@Parameters({ "envName", "serverName", "browserName", "osName", "osVersion" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("dev") String serverName, @Optional("chrome") String browserName, @Optional("Windows") String osName, @Optional("10") String osVersion) {
		driver = getBrowser(envName, serverName, browserName, osName, osVersion);
		customerID = NewCustomer.customerID;
		
		log.info("Step 01 - Open URL 'https://demo.guru99.com/v4/'");
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
	
	@Test
	public void NA01_CustomerID_Cannot_Empty() {
		log.info("Step 01 - Open New Account Page");
		newAccountPage = homePage.openNewAccountPage(driver);
		
		
		log.info("Step 02 - Not enter value in Customer ID");
		newAccountPage.enterToCustomerID("");
		
		log.info("Step 03 - Press tab and move to next field");
		newAccountPage.pressTabToNavigateNextFieldAtCustomerID();
		
		log.info("Step 04 - Error Message displayed");
		Assert.assertTrue(newAccountPage.isCustomerIDErrorMessageDisplayed("Customer ID is required"));
		
		
	}
	@Test
	public void NA02_CustomerID_Must_Be_Numeric() {
		log.info("Step 01 - Reload the page");
		newAccountPage.refreshBrowser(driver);
		
		log.info("Step 02 - Enter character value in Customer ID '123ACCCC'");
		newAccountPage.enterToCustomerID("123ACCCC");
		
		log.info("Step 03 - Error Message displayed");
		Assert.assertTrue(newAccountPage.isCustomerIDErrorMessageDisplayed("Characters are not allowed"));
		
		
	}
	@Test
	public void NA03_CustomerID_Have_Special_Character() {
		log.info("Step 01 - Reload the page");
		newAccountPage.refreshBrowser(driver);
		
		log.info("Step 02 - Enter character value in Customer ID '123#####@!'");
		newAccountPage.enterToCustomerID("123#####@!");
		
		log.info("Step 03 - Error Message displayed");
		Assert.assertTrue(newAccountPage.isCustomerIDErrorMessageDisplayed("Special characters are not allowed"));
		
		
	}
	@Test
	public void NA04_CustomerID_Have_Blank_Space() {
		log.info("Step 01 - Reload the page");
		newAccountPage.refreshBrowser(driver);
		
		log.info("Step 02 - Enter character value in Customer ID '123 3442'");
		newAccountPage.enterToCustomerID("123 3442");
		
		log.info("Step 03 - Error Message displayed");
		Assert.assertTrue(newAccountPage.isCustomerIDErrorMessageDisplayed("Characters are not allowed"));
		
		
	}
	@Test
	public void NA05_CustomerID_Have_First_Blank_Space() {
		log.info("Step 01 - Reload the page");
		newAccountPage.refreshBrowser(driver);
		
		log.info("Step 02 - Enter character value in Customer ID ' qwe'");
		newAccountPage.enterToCustomerID(" qwe");
		
		log.info("Step 03 - Error Message displayed");
		Assert.assertTrue(newAccountPage.isCustomerIDErrorMessageDisplayed("First character can not have space"));
		
		
	}
	
	@Test
	public void NA06_Inital_Deposit_field_Empty() {
		log.info("Step 01 - Reload the page");
		newAccountPage.refreshBrowser(driver);
		
		
		log.info("Step 02 - Not enter value in Initial Deposit");
		newAccountPage.enterToInitialDeposit("");
		
		log.info("Step 03 - Press tab and move to next field");
		newAccountPage.pressTabToNavigateNextFieldAtInitialDeposit();
		
		log.info("Step 04 - Error Message displayed");
		Assert.assertTrue(newAccountPage.isInitialDepositErrorMessageDisplayed("Initial Deposit must not be blank"));
		
		
		
	}
	@Test
	public void NA07_Initial_Deposit_Must_Be_Numeric() {
		log.info("Step 01 - Reload the page");
		newAccountPage.refreshBrowser(driver);
		
		log.info("Step 02 - Enter character value in Initial_Deposit '123ACCCC'");
		newAccountPage.enterToInitialDeposit("123ACCCC");
		
		log.info("Step 03 - Error Message displayed");
		Assert.assertTrue(newAccountPage.isInitialDepositErrorMessageDisplayed("Characters are not allowed"));
		
		
	}
	@Test
	public void NA08_Initial_Deposit_Have_Special_Character() {
		log.info("Step 01 - Reload the page");
		newAccountPage.refreshBrowser(driver);
		
		log.info("Step 02 - Enter character value in Initial_Deposit '123#####@!'");
		newAccountPage.enterToInitialDeposit("123#####@!");
		
		log.info("Step 03 - Error Message displayed");
		Assert.assertTrue(newAccountPage.isInitialDepositErrorMessageDisplayed("Special characters are not allowed"));
		
		
	}
	@Test
	public void NA09_Initial_Deposit_Have_Blank_Space() {
		log.info("Step 01 - Reload the page");
		newAccountPage.refreshBrowser(driver);
		
		log.info("Step 02 - Enter character value in Initial_Deposit '123 3442'");
		newAccountPage.enterToInitialDeposit("123 3442");
		
		log.info("Step 03 - Error Message displayed");
		Assert.assertTrue(newAccountPage.isInitialDepositErrorMessageDisplayed("Characters are not allowed"));
		
		
	}
	@Test
	public void NA10_Initial_Deposit_Have_First_Blank_Space() {
		log.info("Step 01 - Reload the page");
		newAccountPage.refreshBrowser(driver);
		
		log.info("Step 02 - Enter character value in Initial_Deposit ' qwe'");
		newAccountPage.enterToInitialDeposit(" qwe");
		
		log.info("Step 03 - Error Message displayed");
		Assert.assertTrue(newAccountPage.isInitialDepositErrorMessageDisplayed("First character can not have space"));
		
	}
	@Test
	public void NA11_NewAccount_Success() {
		log.info("Step 01 - Reload the page");
		newAccountPage.refreshBrowser(driver);
		
		log.info("Step 02 - Enter to Customer ID value: '" + customerID + "'");
		newAccountPage.enterToCustomerID(customerID);
		
		log.info("Step 03 - Select Account Type value: '" + accountType + "'");
		newAccountPage.selectAccountTypeInDropDown(accountType);
		
		log.info("Step 04 - Enter to Initial Deposit value: '" + initialDeposit + "'");
		newAccountPage.enterToInitialDeposit(initialDeposit);
		
		log.info("Step 05 - Click to submit button");
		newAccountPage.clickToSubmitButton();
		
		log.info("Step 06 - Value Account ID is displayed");
		Assert.assertTrue(newAccountPage.isAccountIDDisplayed());
		
		accountID = newAccountPage.getAccountID();
		log.info("Step 07 - Value  Account ID is: '" + accountID + "'");
	}
	
	@Test
	public void NA12_Verify_NewAccount_Success() {
		log.info("Step 01 - Reload the page");
		newAccountPage.refreshBrowser(driver);
		
		log.info("Step 02 - Account Generated Successfully message displayed");
		Assert.assertTrue(newAccountPage.isSuccessMessageDisplayed());
		
		log.info("Step 03 - Current Amount is generated " + initialDeposit);
		Assert.assertEquals(newAccountPage.isInformationAccountDisplayed("Current Amount"), initialDeposit);
		
	}
	
	
	
	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
}
