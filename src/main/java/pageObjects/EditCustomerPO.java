package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.EditCustomerUI;
import pageUIs.NewCustomerUI;

public class EditCustomerPO extends BasePage {
	private WebDriver driver;

	public EditCustomerPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToCustomerIDTextBox(String string) {
		waitForElementVisible(driver, EditCustomerUI.CUSTOMER_ID_TEXTBOX);
		sendKeyToElement(driver, EditCustomerUI.CUSTOMER_ID_TEXTBOX, string);
	}

	public void pressTabToNavigateNextFieldAtCustomerID() {
		moveToNextElementByTabKey(driver, EditCustomerUI.CUSTOMER_ID_TEXTBOX);
		
	}

	public boolean isErrorMessageCustomerIdDisplayed(String errorMessage) {
		waitForElementVisible(driver, EditCustomerUI.ERROR_MESSAGE_CUSTOMER_ID, errorMessage);
		return isElementDisplayed(driver, EditCustomerUI.ERROR_MESSAGE_CUSTOMER_ID, errorMessage);
	}

	public void clickToSubmitButton() {
		waitForClickable(driver, EditCustomerUI.SUBMIT_BUTTON);
		clickToElement(driver, EditCustomerUI.SUBMIT_BUTTON);
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
}
