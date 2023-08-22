package pageUIs;

public class NewAccountUI {
	public static final String CUSTOMER_ID_TEXTBOX = "xpath=//input[@type='text' and @name='cusid']";
	public static final String ERROR_MESSAGE_CUSTOMER_ID = "xpath=//label[@id='message14' and text()='%s']";
	public static final String INITIAL_DEPOSIT_TEXTBOX = "xpath=//input[@type='text' and @name='inideposit']";
	public static final String ERROR_MESSAGE_INITIAL_DEPOSIT = "xpath=//label[@id='message19' and text()='%s']";
	public static final String ACCOUT_TYPE_DROPDOWN = "xpath=//select[@name='selaccount']";
	public static final String SUBMIT_BUTTON = "xpath=//input[@type='submit']";
	public static final String ACCOUNT_ID = "xpath=//table[@id='account']/tbody//td[text()='Account ID']/following-sibling::td";
	public static final String SUCCESS_REGISTERED_MESSAGE = "xpath=//table[@id='account']/tbody//p[text()='Account Generated Successfully!!!']";
	public static final String INFORMATION_ACCOUNT = "xpath=//table[@id='account']/tbody//td[text()='%s']/following-sibling::td";
}
