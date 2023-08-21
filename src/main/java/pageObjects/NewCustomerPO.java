package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import pageUIs.NewCustomerUI;



public class NewCustomerPO extends BasePage{
private WebDriver driver;
	
	public NewCustomerPO (WebDriver driver) {
		this.driver = driver;
	}

	public void enterToCustomerName(String text) {
		waitForElementVisible(driver, NewCustomerUI.CUSTOMER_NAME);
		sendKeyToElement(driver, NewCustomerUI.CUSTOMER_NAME, text);
	}

	public void pressTabToNavigateNextFieldAtCustomerName() {
		moveToNextElementByTabKey(driver, NewCustomerUI.CUSTOMER_NAME);
	}

	public boolean isCustomerNameErrorMessageDisplayed(String text) {
		waitForElementVisible(driver, NewCustomerUI.ERROR_MESSAGE_CUSTOMER_NAME, text);
		return isElementDisplayed(driver, NewCustomerUI.ERROR_MESSAGE_CUSTOMER_NAME, text);
	}

	public void enterToAddress(String text) {
		waitForElementVisible(driver, NewCustomerUI.ADDRESS);
		sendKeyToElement(driver, NewCustomerUI.ADDRESS, text);
		
	}

	public boolean isAddressErrorMessageDisplayed(String text) {
		waitForElementVisible(driver, NewCustomerUI.ERROR_MESSAGE_ADDRESS, text);
		return isElementDisplayed(driver, NewCustomerUI.ERROR_MESSAGE_ADDRESS, text);
	}

	public void pressTabToNavigateNextFieldAtAddress() {
		moveToNextElementByTabKey(driver, NewCustomerUI.ADDRESS);
	}

	public void enterToCity(String text) {
		waitForElementVisible(driver, NewCustomerUI.CITY);
		sendKeyToElement(driver, NewCustomerUI.CITY, text);
		
	}

	public void pressTabToNavigateNextFieldAtCity() {
		moveToNextElementByTabKey(driver, NewCustomerUI.CITY);
		
	}

	public boolean isCityErrorMessageDisplayed(String text) {
		waitForElementVisible(driver, NewCustomerUI.ERROR_MESSAGE_CITY, text);
		return isElementDisplayed(driver, NewCustomerUI.ERROR_MESSAGE_CITY, text);
	}

	public void enterToState(String text) {
		waitForElementVisible(driver, NewCustomerUI.STATE);
		sendKeyToElement(driver, NewCustomerUI.STATE, text);
		
	}

	public boolean isStateErrorMessageDisplayed(String text) {
		waitForElementVisible(driver, NewCustomerUI.ERROR_MESSAGE_STATE, text);
		return isElementDisplayed(driver, NewCustomerUI.ERROR_MESSAGE_STATE, text);
	}

	public void pressTabToNavigateNextFieldAtState() {
		moveToNextElementByTabKey(driver, NewCustomerUI.STATE);
		
	}

	public void enterToPIN(String string) {
		waitForElementVisible(driver, NewCustomerUI.PIN);
		sendKeyToElement(driver, NewCustomerUI.PIN, string);
		
	}

	public boolean isPINErrorMessageDisplayed(String text) {
		waitForElementVisible(driver, NewCustomerUI.ERROR_MESSAGE_PIN, text);
		return isElementDisplayed(driver, NewCustomerUI.ERROR_MESSAGE_PIN, text);
	}

	public void pressTabToNavigateNextFieldAtPIN() {
		moveToNextElementByTabKey(driver, NewCustomerUI.PIN);
		
	}

	public void enterToTelephone(String text) {
		waitForElementVisible(driver, NewCustomerUI.TELEPHONE);
		sendKeyToElement(driver, NewCustomerUI.TELEPHONE, text);
		
	}

	public boolean isTelephoneErrorMessageDisplayed(String text) {
		waitForElementVisible(driver, NewCustomerUI.ERROR_MESSAGE_TELEPHONE, text);
		return isElementDisplayed(driver, NewCustomerUI.ERROR_MESSAGE_TELEPHONE, text);
	}

	public void pressTabToNavigateNextFieldAtTelephone() {
		moveToNextElementByTabKey(driver, NewCustomerUI.TELEPHONE);
		
	}

	public void enterToEmail(String string) {
		waitForElementVisible(driver, NewCustomerUI.EMAIL);
		sendKeyToElement(driver, NewCustomerUI.EMAIL, string);
		
	}

	public boolean isEmailErrorMessageDisplayed(String text) {
		waitForElementVisible(driver, NewCustomerUI.ERROR_MESSAGE_EMAIL, text);
		return isElementDisplayed(driver, NewCustomerUI.ERROR_MESSAGE_EMAIL, text);
	}

	public void pressTabToNavigateNextFieldAtEmail() {
		moveToNextElementByTabKey(driver, NewCustomerUI.EMAIL);
		
	}

	public void clickToResetButton() {
		waitForClickable(driver, NewCustomerUI.RESET_BUTTON);
		clickToElement(driver, NewCustomerUI.RESET_BUTTON);
	}

	public void clickToSubmitButton() {
		waitForClickable(driver, NewCustomerUI.SUBMIT_BUTTON);
		clickToElement(driver, NewCustomerUI.SUBMIT_BUTTON);
		
	}

	public String getErrorMessageAllFieldRequired() {
		return getTextAlert(driver);
	}

	public void selectGenderRadio(String textGender) {
		waitForClickable(driver, NewCustomerUI.GENDER_RADIO, textGender);
		clickToElement(driver, NewCustomerUI.GENDER_RADIO, textGender);
		
	}

	public void selectDateOfBirdByClickDay(String attribute, String text) {
		waitForClickable(driver, NewCustomerUI.DATE_OF_BIRD_BUTTON);
		removeAttributeInDOM(driver, NewCustomerUI.DATE_OF_BIRD_BUTTON, attribute);
		sendKeyToElement(driver, NewCustomerUI.DATE_OF_BIRD_BUTTON, text);
		
	}

	public void enterToPasswordCustomer(String passwordCustomer) {
		waitForElementVisible(driver, NewCustomerUI.PASSWORD);
		sendKeyToElement(driver, NewCustomerUI.PASSWORD, passwordCustomer);
	}

	public String getCustomerID() {
		waitForElementVisible(driver, NewCustomerUI.VERIFY_CUSTOMER_ID);
		return getElementText(driver, NewCustomerUI.VERIFY_CUSTOMER_ID);
	}

	

	
}
