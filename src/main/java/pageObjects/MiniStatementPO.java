package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.MiniStatementUI;

public class MiniStatementPO extends BasePage{
	private WebDriver driver;
	public MiniStatementPO (WebDriver driver) {
		this.driver = driver;
	}
	public void enterToAccountNumberTextBox(String string) {
		waitForElementVisible(driver, MiniStatementUI.ACCOUNT_NO_TEXT_BOX);
		sendKeyToElement(driver, MiniStatementUI.ACCOUNT_NO_TEXT_BOX, string);
	}
	public void pressTabToNavigateNextFieldAtAccountNumber() {
			moveToNextElementByTabKey(driver, MiniStatementUI.ACCOUNT_NO_TEXT_BOX);
	}
	public boolean isAccountNumberErrorMessageDisplayed(String string) {
		waitForElementVisible(driver, MiniStatementUI.ERROR_MESSAGE_ACCOUNT_NO, string);
		return isElementDisplayed(driver, MiniStatementUI.ERROR_MESSAGE_ACCOUNT_NO, string);
	}
}
