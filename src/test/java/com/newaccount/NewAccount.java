package com.newaccount;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.HomePagePO;
import pageObjects.LoginPagePO;

public class NewAccount extends BaseTest {
	WebDriver driver;
	LoginPagePO loginPage;
	HomePagePO homePage;
	String userID= "mngr522589";
	String password = "epEhEgY";
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browser, String url) {
		log.info("Step 01 - Open URL 'https://demo.guru99.com/v4/'");
		driver = openMultipleBrowser(browser, url);
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
	public void NA1() {
		log.info("NA1 01: Open New Customer Page");
		

	}
	
	@Test
	public void NA2() {
	
	}
	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

}
