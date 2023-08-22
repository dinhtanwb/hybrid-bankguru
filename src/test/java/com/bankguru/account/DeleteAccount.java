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
import pageObjects.DeleteAccountPO;
import pageObjects.HomePagePO;
import pageObjects.LoginPagePO;

public class DeleteAccount extends BaseTest{
	WebDriver driver;
	LoginPagePO loginPage;
	HomePagePO homePage;
	DeleteAccountPO deleteAccountPage;
	
	String userID = "mngr522589";
	String password = "epEhEgY";
	String customerID;
	
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

		log.info("Step 05 - Verify Login successfully");
		Assert.assertTrue(homePage.isLoginSuccessDisplayed());

	}
	
	@Test
	public void DA_01_Account_Number_Empty() {
		log.info("Step 01 - Open Delete Account page");
		deleteAccountPage = homePage.openDeleteAccountPage(driver);
		
		
		log.info("Step 02 - Enter Account Number field value: ");
		deleteAccountPage.enterToAccountNo("");
		
		
		log.info("Step 03 - Press tab to navigate next field");
		deleteAccountPage.pressTabToNavigateNextFieldAtAccountNo();
		
		
		log.info("Step 04 - Error message is displayed");
		Assert.assertTrue(deleteAccountPage.isAccountNoErrorMessageDisplayed("Account Number must not be blank"));
		
		
	}
	@Test
	public void DA_02_Account_Number_Must_Be_Numeric() {
		log.info("Step 01 - Reload the page");
		deleteAccountPage.refreshBrowser(driver);
		
		
		log.info("Step 02 - Enter Account Number field value: 'Acc1234'");
		deleteAccountPage.enterToAccountNo("Acc1234");
		
		
		log.info("Step 03 - Error message is displayed");
		Assert.assertTrue(deleteAccountPage.isAccountNoErrorMessageDisplayed("Characters are not allowed"));
		
		
	}
	@Test
	public void DA_03_Account_Number_Have_Special_Character() {
		log.info("Step 01 - Reload the page");
		deleteAccountPage.refreshBrowser(driver);
		
		
		log.info("Step 02 - Enter Account Number field value: '123#####'");
		deleteAccountPage.enterToAccountNo("123#####");
		
		
		log.info("Step 03 - Error message is displayed");
		Assert.assertTrue(deleteAccountPage.isAccountNoErrorMessageDisplayed("Special characters are not allowed"));
		
		
	}
	@Test
	public void DA_04_Account_Number_Have_Blank_Space() {
		log.info("Step 01 - Reload the page");
		deleteAccountPage.refreshBrowser(driver);
		
		
		log.info("Step 02 - Enter Account Number field value: '123 321'");
		deleteAccountPage.enterToAccountNo("123 321");
		
		
		log.info("Step 03 - Error message is displayed");
		Assert.assertTrue(deleteAccountPage.isAccountNoErrorMessageDisplayed("Characters are not allowed"));
		
		
	}
	
	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
}
