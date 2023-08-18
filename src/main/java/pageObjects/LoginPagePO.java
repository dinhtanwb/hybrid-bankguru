package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.LoginPageUI;

public class LoginPagePO extends BasePage {
	private WebDriver driver;

	public LoginPagePO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToUserIDTextBox(String string) {
		waitForElementVisible(driver, LoginPageUI.USER_ID_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.USER_ID_TEXTBOX, string);
	}

	public void enterToPasswordTextBox(String string) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, string);

	}

	public void moveToPasswordTextBox() {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		moveToNextElementByTabKey(driver, LoginPageUI.USER_ID_TEXTBOX);
		
	}

	public boolean isErrorMessageUserBlankDisplayed(String text) {
		waitForElementVisible(driver, LoginPageUI.ERROR_MESSAGE_USER_ID, text);
		return isElementDisplayed(driver, LoginPageUI.ERROR_MESSAGE_USER_ID, text);
	}

	public HomePagePO clickToLoginButton() {
		waitForClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}

}
