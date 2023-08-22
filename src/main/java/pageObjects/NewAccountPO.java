package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.NewAccountUI;

public class NewAccountPO extends BasePage{
	private WebDriver driver;
	
	public NewAccountPO (WebDriver driver) {
		this.driver = driver;
	}

	public void enterToCustomerID(String string) {
		waitForElementVisible(driver, NewAccountUI.CUSTOMER_ID_TEXTBOX);
		sendKeyToElement(driver, NewAccountUI.CUSTOMER_ID_TEXTBOX, string);
	}

	public void pressTabToNavigateNextFieldAtCustomerID() {
			moveToNextElementByTabKey(driver, NewAccountUI.CUSTOMER_ID_TEXTBOX);
	}	

	public boolean isCustomerIDErrorMessageDisplayed(String string) {
		waitForElementVisible(driver, NewAccountUI.ERROR_MESSAGE_CUSTOMER_ID, string);
		return isElementDisplayed(driver, NewAccountUI.ERROR_MESSAGE_CUSTOMER_ID, string);
	}

	public void enterToInitialDeposit(String string) {
		waitForElementVisible(driver, NewAccountUI.INITIAL_DEPOSIT_TEXTBOX);
		sendKeyToElement(driver, NewAccountUI.INITIAL_DEPOSIT_TEXTBOX, string);
	}

	public void pressTabToNavigateNextFieldAtInitialDeposit() {
		moveToNextElementByTabKey(driver, NewAccountUI.INITIAL_DEPOSIT_TEXTBOX);		
	}

	public boolean isInitialDepositErrorMessageDisplayed(String string) {
		waitForElementVisible(driver, NewAccountUI.ERROR_MESSAGE_INITIAL_DEPOSIT, string);
		return isElementDisplayed(driver, NewAccountUI.ERROR_MESSAGE_INITIAL_DEPOSIT, string);
	}

	public void selectAccountTypeInDropDown(String string) {
		waitForClickable(driver, NewAccountUI.ACCOUT_TYPE_DROPDOWN);
		selectItemInDefaultDropdown(driver, NewAccountUI.ACCOUT_TYPE_DROPDOWN, string);
	}

	public void clickToSubmitButton() {
		waitForClickable(driver, NewAccountUI.SUBMIT_BUTTON);
		clickToElement(driver, NewAccountUI.SUBMIT_BUTTON);
	}

	public boolean isAccountIDDisplayed() {
		waitForElementVisible(driver, NewAccountUI.ACCOUNT_ID);
		return isElementDisplayed(driver, NewAccountUI.ACCOUNT_ID);
	}

	public String getAccountID() {
		waitForElementVisible(driver, NewAccountUI.ACCOUNT_ID);
		return getElementText(driver, NewAccountUI.ACCOUNT_ID);
	}

	public boolean isSuccessMessageDisplayed() {
		waitForElementVisible(driver, NewAccountUI.SUCCESS_REGISTERED_MESSAGE);
		return isElementDisplayed(driver, NewAccountUI.SUCCESS_REGISTERED_MESSAGE);
	}

	public String isInformationAccountDisplayed(String string) {
		waitForElementVisible(driver, NewAccountUI.INFORMATION_ACCOUNT, string);
		return getElementText(driver, NewAccountUI.INFORMATION_ACCOUNT, string);
	}
	
}
