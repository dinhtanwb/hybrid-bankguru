package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.HomePagePO;
import pageObjects.LoginPagePO;
import pageObjects.NewCustomerPO;

public class PageGeneratorManager {
	public static LoginPagePO getLoginPage(WebDriver driver) {
		return new LoginPagePO(driver);
	}
	
	public static HomePagePO getHomePage(WebDriver driver) {
		return new HomePagePO(driver);
	}
	
	public static NewCustomerPO getNewCustomer(WebDriver driver) {
		return new NewCustomerPO(driver);
	}
}
