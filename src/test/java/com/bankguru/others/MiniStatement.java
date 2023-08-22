package com.bankguru.others;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.HomePagePO;
import pageObjects.LoginPagePO;
import pageObjects.MiniStatementPO;

public class MiniStatement extends BaseTest{
	LoginPagePO loginPage;
	HomePagePO homePage;
	WebDriver driver;
	MiniStatementPO miniStatementPage;
	String userID= "mngr522589";
	String password = "epEhEgY";
	
	
	@Parameters({ "envName", "serverName", "browserName", "osName", "osVersion" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("dev") String serverName, @Optional("chrome") String browserName, @Optional("Windows") String osName, @Optional("10") String osVersion) {
		driver = getBrowser(envName, serverName, browserName, osName, osVersion);
		log.info("Step 01 - Open URL 'https://demo.guru99.com/v4/'");
		
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
	public void DC01_Account_Number_CannotBe_Empty() {
		log.info("Open MiniStatement page");
		miniStatementPage = homePage.openMiniStatementPage(driver);
		
		log.info("Step 01 - Enter to Account Number value: ''");
		miniStatementPage.enterToAccountNumberTextBox("");
		
		log.info("Step 02 - Press tab to navigate next field");
		miniStatementPage.pressTabToNavigateNextFieldAtAccountNumber();
		
		log.info("Step 03 - Verify error message displayed");
		verifyTrue(miniStatementPage.isAccountNumberErrorMessageDisplayed("Account Number must not be blank"));
		
	}
	@Test
	public void DC02_Account_Number_Must_Be_Numeric() {
		
		log.info("Step 01 - Enter to Account Number value: 'Acc12344'");
		miniStatementPage.enterToAccountNumberTextBox("Acc12344");
		
		log.info("Step 02 - Verify error message displayed");
		verifyTrue(miniStatementPage.isAccountNumberErrorMessageDisplayed("Characters are not allowed"));
		
	}
	
	@Test
	public void DC03_Account_Number_Have_Character_Special() {
		
		log.info("Step 01 - Enter to Account Number value: '!@#$$$$'");
		miniStatementPage.enterToAccountNumberTextBox("!@#$$$$");
		
		log.info("Step 02 - Verify error message displayed");
		verifyTrue(miniStatementPage.isAccountNumberErrorMessageDisplayed("Special characters are not allowed"));
		
	}
	
	@Test
	public void DC04_Account_Number_Have_Blank_Space() {
		
		log.info("Step 01 - Enter to Account Number value: '123 2323'");
		miniStatementPage.enterToAccountNumberTextBox("123 2323");
		
		log.info("Step 02 - Verify error message displayed");
		verifyTrue(miniStatementPage.isAccountNumberErrorMessageDisplayed("Characters are not allowed"));
		
	}
	

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

}
