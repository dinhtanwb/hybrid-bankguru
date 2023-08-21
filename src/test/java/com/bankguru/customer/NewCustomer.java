package com.bankguru.customer;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageObjects.HomePagePO;
import pageObjects.LoginPagePO;
import pageObjects.NewCustomerPO;
import utilities.DataHelper;

public class NewCustomer extends BaseTest {
	WebDriver driver;
	DataHelper dataHelper;
	LoginPagePO loginPage;
	HomePagePO homePage;
	NewCustomerPO newCustomerPage;
	String customerName, gender, dateOfBirth, address, city, state, mobileNumber, email, passwordCustomer;
	public static String customerID;
	int PIN = fakeNumber();
	String userID= "mngr522589";
	String password = "epEhEgY";
	
	
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browser, String url) {
		log.info("Step 01 - Open URL 'https://demo.guru99.com/v4/'");
		driver = openMultipleBrowser(browser, url);
		dataHelper = DataHelper.getData();
		customerName = dataHelper.getCustomerName();
		address = dataHelper.getAddress();
		city = dataHelper.getCity();
		state = dataHelper.getState();
		mobileNumber = dataHelper.getPhoneNumber();
		email = dataHelper.getEmail();
		passwordCustomer = dataHelper.getPassword();
		
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
	
	@Test(description = "CustomerName_Is_Blank")
	public void NC1_CustomerName_Is_Blank() {
		log.info("NC1 01: Open New Customer Page");
		newCustomerPage = homePage.openNewCustomerPage(driver);
		
		log.info("NC1 02: Enter to Customer Name ''");
		newCustomerPage.enterToCustomerName("");
		
		log.info("NC1 03: Press TAB to navigate next field");
		newCustomerPage.pressTabToNavigateNextFieldAtCustomerName();
		
		log.info("NC1 04: Verify error message is displayed");
		Assert.assertTrue(newCustomerPage.isCustomerNameErrorMessageDisplayed("Customer name must not be blank"));
	}
	
	@Test(description = "CustomerName_Is_Number")
	public void NC2_CustomerName_Is_Number() {
		log.info("NC2 01: Enter to Customer Name value 'Acc1234'");
		newCustomerPage.enterToCustomerName("Acc1234");
		
		log.info("NC2 02: Verify error message is displayed");
		Assert.assertTrue(newCustomerPage.isCustomerNameErrorMessageDisplayed("Numbers are not allowed"));
	
	}
	
	@Test(description = "CustomerName_Is_Character")
	public void NC3_CustomerName_Is_Character() {
		log.info("NC3 01: Enter to Customer Name value '123123@##!'");
		newCustomerPage.enterToCustomerName("123123@");
		
		log.info("NC3 02: Verify error message is displayed");
		Assert.assertTrue(newCustomerPage.isCustomerNameErrorMessageDisplayed("Special characters are not allowed"));
	
	}
	
	@Test(description = "CustomerName_Is_Character")
	public void NC4_CustomerName_Is_First_Blank_Space() {
		log.info("N4 01: Enter to Customer Name value ' dsdsdsdsdsd'");
		newCustomerPage.enterToCustomerName(" sdasdasdasdasd");
		
		log.info("N4 02: Verify error message is displayed");
		Assert.assertTrue(newCustomerPage.isCustomerNameErrorMessageDisplayed("First character can not have space"));
	
	}
	@Test(description = "CustomerName_Is_Character")
	public void NC5_Address_Is_Blank_Space() {
		log.info("N5 01: Enter to Address value ''");
		newCustomerPage.enterToAddress("");
		
		log.info("N5 02: Press tab key to next field");
		newCustomerPage.pressTabToNavigateNextFieldAtAddress();
		
		log.info("N5 03: Verify error message is displayed");
		Assert.assertTrue(newCustomerPage.isAddressErrorMessageDisplayed("Address Field must not be blank"));
	
	}
	@Test(description = "Address_Is_First_Blank_Space")
	public void NC6_Address_Is_First_Blank_Space() {
		log.info("N6 01: Enter to Customer Name value ' dsdsdsdsdsd'");
		newCustomerPage.enterToAddress(" sdasdasdasdasd");
		
		log.info("N6 02: Verify error message is displayed");
		Assert.assertTrue(newCustomerPage.isAddressErrorMessageDisplayed("First character can not have space"));
	
	}
	@Test(description = "City_Is_First_Blank_Space")
	public void NC8_City_Is_First_Blank_Space() {
		log.info("N8 01: Enter to City value ''");
		newCustomerPage.enterToCity("");
		
		log.info("N8 02: Press tab to navigate next field");
		newCustomerPage.pressTabToNavigateNextFieldAtCity();
		
		log.info("N8 03: Verify error message is displayed");
		Assert.assertTrue(newCustomerPage.isCityErrorMessageDisplayed("City Field must not be blank"));
	
	}
	@Test(description = "City_Is_Numeric")
	public void NC9_City_Is_Numeric() {
		log.info("N9 01: Enter to City value '213123123'");
		newCustomerPage.enterToCity("213123123");
		
		log.info("N9 02: Verify error message is displayed");
		Assert.assertTrue(newCustomerPage.isCityErrorMessageDisplayed("Numbers are not allowed"));
	
	}
	@Test(description = "City_Is_Special_Character", priority = 2)
	public void NC10_City_Is_Special_Character() {
		log.info("N10 01: Enter to City value '!@#@#!#@!#@#!@!#'");
		newCustomerPage.enterToCity("!@#@#!#@!#@#!@!#");
		
		log.info("N10 02: Verify error message is displayed");
		Assert.assertTrue(newCustomerPage.isCityErrorMessageDisplayed("Special characters are not allowed"));
	
	}
	@Test(description = "City_Is_First_Blank_Space", priority = 2)
	public void NC11_City_Is_First_Blank_Space() {
		log.info("N11 01: Enter to City value ' dsdsdsdsdsd'");
		newCustomerPage.enterToCity(" sdasdasdasdasd");
		
		log.info("N11 02: Verify error message is displayed");
		Assert.assertTrue(newCustomerPage.isCityErrorMessageDisplayed("First character can not have space"));
	
	}
	
	@Test(description = "State_Is_Empty", priority = 2)
	public void NC12_State_Is_Empty() {
		log.info("N12 01: Enter to State value ''");
		newCustomerPage.enterToState("");
		
		log.info("N12 02: Press tab to navigate next field");
		newCustomerPage.pressTabToNavigateNextFieldAtState();
		
		log.info("N12 03: Verify error message is displayed");
		Assert.assertTrue(newCustomerPage.isStateErrorMessageDisplayed("State must not be blank"));
	
	}
	@Test(description = "State_Is_Numeric", priority = 2)
	public void NC13_State_Is_Numeric() {
		log.info("N13 01: Enter to State value '123123123123'");
		newCustomerPage.enterToState("123123123123");
		
		log.info("N13 02: Verify error message is displayed");
		Assert.assertTrue(newCustomerPage.isStateErrorMessageDisplayed("Numbers are not allowed"));
	
	}
	@Test(description = "State_Is_Special", priority = 2)
	public void NC14_State_Is_Special() {
		log.info("N14 01: Enter to State value '@&*!#^&*@!#^&'");
		newCustomerPage.enterToState("@&*!#^&*@!#^&");
		
		log.info("N14 02: Verify error message is displayed");
		Assert.assertTrue(newCustomerPage.isStateErrorMessageDisplayed("Special characters are not allowed"));
	
	}
	@Test(description = "State_Is_First_Blank_Space", priority = 2)
	public void NC15_City_Is_First_Blank_Space() {
		log.info("N15 01: Enter to State value ' dsdsdsdsdsd'");
		newCustomerPage.enterToState(" dsdsdsdsdsd");
		
		log.info("N15 02: Verify error message is displayed");
		Assert.assertTrue(newCustomerPage.isStateErrorMessageDisplayed("First character can not have space"));
	
	}
	@Test(description = "Pin_Is_Empty", priority = 2)
	public void NC16_Pin_Is_Empty() {
		log.info("N16 01: Enter to PIN value ''");
		newCustomerPage.enterToPIN("");
		
		log.info("N16 02: Press Tab to navigate next field");
		newCustomerPage.pressTabToNavigateNextFieldAtPIN();
		
		log.info("N16 02: Verify error message is displayed");
		Assert.assertTrue(newCustomerPage.isPINErrorMessageDisplayed("PIN Code must not be blank"));
	
	}
	@Test(description = "Pin_Is_Numeric", priority = 2)
	public void NC17_Pin_Is_Numeric() {
		log.info("N17 01: Enter to PIN value '123PIN'");
		newCustomerPage.enterToPIN("123PIN");
		
		log.info("N17 02: Verify error message is displayed");
		Assert.assertTrue(newCustomerPage.isPINErrorMessageDisplayed("Characters are not allowed"));
	
	}
	@Test(description = "PIN_Must_Have_6_Digits", priority = 2)
	public void NC18_PIN_Must_Have_6_Digits() {
		log.info("N18 01: Enter to PIN value '12345'");
		newCustomerPage.enterToPIN("12345");
		
		
		log.info("N18 02: Verify error message is displayed");
		Assert.assertTrue(newCustomerPage.isPINErrorMessageDisplayed("PIN Code must have 6 Digits"));
	
	}
	@Test(description = "PIN_Cannot_Have_Special", priority = 2)
	public void NC19_PIN_Cannot_Have_Special() {
		log.info("N19 01: Enter to PIN value '123$$$$'");
		newCustomerPage.enterToPIN("123$$$$");
		
		
		log.info("N19 02: Verify error message is displayed");
		Assert.assertTrue(newCustomerPage.isPINErrorMessageDisplayed("Special characters are not allowed"));
	
	}
	@Test(description = "Pin_Have_First_Blank_Space", priority = 2)
	public void NC20_Pin_Have_First_Blank_Space() {
		log.info("NC20 01: Enter to PIN value ' sadsadsad'");
		newCustomerPage.enterToPIN(" sadsadsad");
		
		
		log.info("NC20 02: Verify error message is displayed");
		Assert.assertTrue(newCustomerPage.isPINErrorMessageDisplayed("First character can not have space"));
	
	}
	@Test(description = "Pin_Have_Blank_Space", priority = 2)
	public void NC21_Pin_Have_Blank_Space() {
		log.info("NC21 01: Enter to PIN value '23 454'");
		newCustomerPage.enterToPIN("23 454");
		
		
		log.info("NC21 02: Verify error message is displayed");
		Assert.assertTrue(newCustomerPage.isPINErrorMessageDisplayed("Characters are not allowed"));
	
	}
	
	@Test(description = "Telephone_is_empty", priority = 2)
	public void NC22_Telephone_Is_Empty() {
		log.info("NC22 01: Enter to Telephone value ''");
		newCustomerPage.enterToTelephone("");
		
		log.info("NC22 02: Press Tab to navigate next field");
		newCustomerPage.pressTabToNavigateNextFieldAtTelephone();
		
		log.info("NC22 03: Verify error message is displayed");
		Assert.assertTrue(newCustomerPage.isTelephoneErrorMessageDisplayed("Mobile no must not be blank"));
	
	}
	@Test(description = "Telephone_first_character_is_blank", priority = 2)
	public void NC23_Telephone_first_character_is_blank() {
		log.info("NC23 01: Enter to PIN value ' sadsfsdfsdfsdf'");
		newCustomerPage.enterToTelephone(" sadsfsdfsdfsdf");
		
		
		log.info("NC23 02: Verify error message is displayed");
		Assert.assertTrue(newCustomerPage.isTelephoneErrorMessageDisplayed("First character can not have space"));
	
	}
	@Test(description = "Telephone_is_include_blank_space", priority = 2)
	public void NC24_Telephone_is_include_blank_space() {
		log.info("NC24 01: Enter to Telephone value '12312 34435'");
		newCustomerPage.enterToTelephone("12312 34435");
		
		
		log.info("NC24 02: Verify error message is displayed");
		Assert.assertTrue(newCustomerPage.isTelephoneErrorMessageDisplayed("Characters are not allowed"));
	
	}
	@Test(description = "Telephone_is_special_character", priority = 2)
	public void NC25_Telephone_is_special_character() {
		log.info("NC25 01: Enter to Telephone value '13123@##'");
		newCustomerPage.enterToTelephone("13123@##");
		
		
		log.info("NC25 02: Verify error message is displayed");
		Assert.assertTrue(newCustomerPage.isTelephoneErrorMessageDisplayed("Special characters are not allowed"));
	
	}
	
	@Test(description = "Email_Is_Empty", priority = 2)
	public void NC26_Email_is_Empty() {
		log.info("NC26 01: Enter to Email value ''");
		newCustomerPage.enterToEmail("");
		
		log.info("NC26 01: Press Tab to navigate next field");
		newCustomerPage.pressTabToNavigateNextFieldAtEmail();
		
		log.info("NC26 03: Verify error message is displayed");
		Assert.assertTrue(newCustomerPage.isEmailErrorMessageDisplayed("Email-ID must not be blank"));
	
	}
	@Test(description = "Email_Is_Incorrect_Format", priority = 2)
	public void NC27_Email_Is_Incorrect_Format() {
		log.info("NC27 01: Enter to Email value '13123@##'");
		newCustomerPage.enterToEmail("13123@##");
		
		log.info("NC27 02: Verify error message is displayed");
		Assert.assertTrue(newCustomerPage.isEmailErrorMessageDisplayed("Email-ID is not valid"));
	
	}
	@Test(description = "Email_Have_Space", priority = 2)
	public void NC29_Email_Have_Space() {
		log.info("NC29 01: Enter to Email value ' asdasdasdasd'");
		newCustomerPage.enterToEmail(" asdasdasdasd");
		
		log.info("NC29 02: Verify error message is displayed");
		Assert.assertTrue(newCustomerPage.isEmailErrorMessageDisplayed("First character can not have space"));
	
	}
	@Test(description = "Verify all field in New Customer", priority = 2)
	public void NC30_Verify_All_Field_Required() {
		log.info("NC30 01: Click to Reset Button to clear all field");
		newCustomerPage.clickToResetButton();
		
		log.info("NC30 02: Click to Submit Button");
		newCustomerPage.clickToSubmitButton();
		
		log.info("NC30 03: Verify all field is required");
		Assert.assertEquals(newCustomerPage.getErrorMessageAllFieldRequired(), "please fill all fields");
		
		
		log.info("NC30 04: Accept Alert");
		newCustomerPage.acceptAlert(driver);
		
		
	}
	
	@Test(description = "Add New Customer", priority = 2)
	public void NC_31_Add_New_Customer() {
		log.info("NC31 01: Enter to Customer Name value is: '" + customerName + "'");
		newCustomerPage.enterToCustomerName(customerName);
		
		log.info("NC31 02: Select to Gender value is: 'Female'");
		newCustomerPage.selectGenderRadio("f");
		
		log.info("NC31 23: Enter to Date of birth value is: 08");
		newCustomerPage.selectDateOfBirdByClickDay("type", "2023-08-21");
		
		log.info("NC31 04: Enter to Address value is: '" + address+ "'");
		newCustomerPage.enterToAddress(address);
		
		log.info("NC31 05: Enter to City value is: '" + city + "'");
		newCustomerPage.enterToCity(city);
		
		log.info("NC31 06: Enter to State value is: '" + state + "'");
		newCustomerPage.enterToState(state);
		
		log.info("NC31 07: Enter to PIN value is: 123456");
		newCustomerPage.enterToPIN("123456");
		
		log.info("NC31 08: Enter to Mobile Phone Number value is: '" + mobileNumber + "'");
		newCustomerPage.enterToTelephone(mobileNumber);
		
		log.info("NC31 09: Enter to Email value is: '" + email + "'");
		newCustomerPage.enterToEmail(email);
		
		log.info("NC31 10: Enter to Email value is: '" + passwordCustomer + "'");
		newCustomerPage.enterToPasswordCustomer(passwordCustomer);
		
		log.info("NC31 11: Click to submit button");
		newCustomerPage.clickToSubmitButton();
		
		log.info("NC31 12: Get Customer ID");
		customerID = newCustomerPage.getCustomerID();
		
		log.info("NC31 13: Customer ID value is: " + customerID);
	}
	
	
	
	
	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

}
