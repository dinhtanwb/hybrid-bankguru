package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HomePageUI;

public class HomePagePO extends BasePage{
	private WebDriver driver;
	
	public HomePagePO (WebDriver driver) {
		this.driver = driver;
	}

	public boolean isLoginSuccessDisplayed() {
		waitForElementVisible(driver, HomePageUI.LOGIN_SUCCESS);
		return isElementDisplayed(driver, HomePageUI.LOGIN_SUCCESS);
	}

	public void openNewCustomerPage() {
		// TODO Auto-generated method stub
		
	}
}
