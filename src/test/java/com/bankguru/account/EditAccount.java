package com.bankguru.account;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.EditAccountPO;
import pageObjects.HomePagePO;
import pageObjects.LoginPagePO;

public class EditAccount extends BaseTest {
	WebDriver driver;
	LoginPagePO loginPage;
	HomePagePO homePage;
	EditAccountPO editAccountPage;
	String userID = "mngr522589";
	String password = "epEhEgY";
	String initialDeposit = "500";
	String accountID;

	@Parameters({ "envName", "serverName", "browserName", "osName", "osVersion" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("dev") String serverName,
			@Optional("chrome") String browserName, @Optional("Windows") String osName,
			@Optional("10") String osVersion) {
		driver = getBrowser(envName, serverName, browserName, osName, osVersion);
		accountID = NewAccount.accountID;
		
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
	public void EA01_Account_Number_Cannot_Empty() {
		log.info("Step 01 - Open Edit Accout Page");
		editAccountPage = homePage.openEditAccountPage(driver);

		log.info("Step 02 - Enter to Account Number value: ");
		editAccountPage.enterToAccountNumber("");

		log.info("Step 03 - Press Tab to navigate next field");
		editAccountPage.pressTabToNavigateNextFieldAtAccountNumber();

		log.info("Step 04 - Error Message displayed");
		Assert.assertTrue(editAccountPage.isAccountNumberErrorMessageDisplayed(""));

	}

	@Test
	public void EA02_Account_Number_Must_Be_Numeric() {
		log.info("Step 01 - Reload the page");
		editAccountPage.refreshBrowser(driver);

		log.info("Step 02 - Enter to Account Number value: Acc1234");
		editAccountPage.enterToAccountNumber("Acc1234");

		log.info("Step 03 - Error Message displayed");
		Assert.assertTrue(editAccountPage.isAccountNumberErrorMessageDisplayed("Characters are not allowed"));
	}
	@Test
	public void EA03_Account_Number_Have_Special_Character() {
		log.info("Step 01 - Reload the page");
		editAccountPage.refreshBrowser(driver);

		log.info("Step 02 - Enter to Account Number value: 123!@#$");
		editAccountPage.enterToAccountNumber("123!@#$");

		log.info("Step 03 - Error Message displayed");
		Assert.assertTrue(editAccountPage.isAccountNumberErrorMessageDisplayed("Special characters are not allowed"));
	}
	@Test
	public void EA04_Account_Number_Have_Blank_Space() {
		log.info("Step 01 - Reload the page");
		editAccountPage.refreshBrowser(driver);

		log.info("Step 02 - Enter to Account Number value: 123!@#$");
		editAccountPage.enterToAccountNumber("123!@#$");

		log.info("Step 03 - Error Message displayed");
		Assert.assertTrue(editAccountPage.isAccountNumberErrorMessageDisplayed("Characters are not allowed"));
	}
	@Test
	public void EA05_Account_Number_Valid() {
		log.info("Step 01 - Reload the page");
		editAccountPage.refreshBrowser(driver);

		log.info("Step 02 - Enter to Account Number value: '" + accountID + "'");
		editAccountPage.enterToAccountNumber(accountID);

		log.info("Step 03 - Click to submit button");
		editAccountPage.clickToSubmitButton();
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

}
