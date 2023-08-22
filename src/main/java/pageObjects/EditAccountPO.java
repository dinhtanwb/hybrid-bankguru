package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.EditAccountUI;

public class EditAccountPO extends BasePage {
	private WebDriver driver;

	public EditAccountPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToAccountNumber(String string) {
		waitForElementVisible(driver, EditAccountUI.ACCOUNT_NO_TEXTBOX);
		sendKeyToElement(driver, EditAccountUI.ACCOUNT_NO_TEXTBOX, string);
	}

	public void pressTabToNavigateNextFieldAtAccountNumber() {
		moveToNextElementByTabKey(driver, EditAccountUI.ACCOUNT_NO_TEXTBOX);
	}

	public boolean isAccountNumberErrorMessageDisplayed(String string) {
		waitForElementVisible(driver, EditAccountUI.ERROR_MESSAGE_ACCOUNT_NO);
		return isElementDisplayed(driver, EditAccountUI.ERROR_MESSAGE_ACCOUNT_NO);
	}

	public void clickToSubmitButton() {
		waitForClickable(driver, EditAccountUI.SUBMIT_BUTTON);
		clickToElement(driver, EditAccountUI.SUBMIT_BUTTON);
	}
}
