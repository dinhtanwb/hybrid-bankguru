package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.DeleteCustomerUI;

public class DeleteCustomerPO extends BasePage {
	private WebDriver driver;

	public DeleteCustomerPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToCustomerIdTextBox(String string) {
		waitForElementVisible(driver, DeleteCustomerUI.CUSTOMER_ID_FIELD);
		sendKeyToElement(driver, DeleteCustomerUI.CUSTOMER_ID_FIELD, string);
	}

	public void pressTabToNavigateNextFieldAtCustomerId() {
		moveToNextElementByTabKey(driver, DeleteCustomerUI.CUSTOMER_ID_FIELD);
	}

	public boolean isCustomerIDErrorMessageDisplayed(String string) {
		waitForElementVisible(driver, DeleteCustomerUI.ERROR_MESSAGE_CUSTOMER_ID, string);
		return isElementDisplayed(driver, DeleteCustomerUI.ERROR_MESSAGE_CUSTOMER_ID, string);
	}

}
