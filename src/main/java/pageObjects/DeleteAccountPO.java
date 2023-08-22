package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.DeleteAccountUI;

public class DeleteAccountPO extends BasePage {
	private WebDriver driver;

	public DeleteAccountPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToAccountNo(String string) {
		waitForElementVisible(driver, DeleteAccountUI.ACCOUNT_NO_TEXT_BOX);
		sendKeyToElement(driver, DeleteAccountUI.ACCOUNT_NO_TEXT_BOX, string);
	}

	public void pressTabToNavigateNextFieldAtAccountNo() {
		moveToNextElementByTabKey(driver, DeleteAccountUI.ACCOUNT_NO_TEXT_BOX);
	}

	public boolean isAccountNoErrorMessageDisplayed(String string) {
		waitForElementVisible(driver, DeleteAccountUI.ERROR_MESSAGE_ACCOUNT_NO, string);
		return isElementDisplayed(driver, DeleteAccountUI.ERROR_MESSAGE_ACCOUNT_NO, string);
	}
}
