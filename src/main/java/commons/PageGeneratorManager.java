package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.DeleteAccountPO;
import pageObjects.DeleteCustomerPO;
import pageObjects.EditAccountPO;
import pageObjects.EditCustomerPO;
import pageObjects.HomePagePO;
import pageObjects.LoginPagePO;
import pageObjects.MiniStatementPO;
import pageObjects.NewAccountPO;
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
	
	public static EditCustomerPO getEditCustomer(WebDriver driver) {
		return new EditCustomerPO(driver);
	}
	public static DeleteCustomerPO getDeleteCustomer(WebDriver driver) {
		return new DeleteCustomerPO(driver);
	}
	public static NewAccountPO getNewAccount(WebDriver driver) {
		return new NewAccountPO(driver);
	}
	
	public static EditAccountPO getEditAccount(WebDriver driver) {
		return new EditAccountPO(driver);
	}
	public static DeleteAccountPO getDeleteAccount(WebDriver driver) {
		return new DeleteAccountPO(driver);
	}
	public static MiniStatementPO getMiniStatement(WebDriver driver) {
		return new MiniStatementPO(driver);
	}
}
