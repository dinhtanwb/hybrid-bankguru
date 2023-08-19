package pageUIs;

public class NewCustomerUI {
	public static final String CUSTOMER_NAME = "xpath=//tbody//input[@name = 'name']";
	public static final String ERROR_MESSAGE_CUSTOMER_NAME = "xpath=//tbody//label[@id = 'message' and text()='%s']";
	public static final String ADDRESS = "xpath=//tbody//textarea";
	public static final String ERROR_MESSAGE_ADDRESS = "xpath=//tbody//textarea/following-sibling::label[text()='%s']";
	public static final String CITY = "xpath=//tbody//input[@name = 'city']";
	public static final String ERROR_MESSAGE_CITY = "xpath=//tbody//input/following-sibling::label[text()='%s']";
	public static final String STATE = "xpath=//tbody//input[@name = 'state']";
	public static final String ERROR_MESSAGE_STATE = "xpath=//tbody//input/following-sibling::label[@id='message5' and text()='%s']";
	public static final String PIN = "xpath=//tbody//input[@name = 'pinno']";
	public static final String ERROR_MESSAGE_PIN = "xpath=//tbody//input/following-sibling::label[@id='message6' and text()='%s']";
	public static final String TELEPHONE = "xpath=//tbody//input[@name = 'telephoneno']";
	public static final String ERROR_MESSAGE_TELEPHONE = "xpath=//tbody//input/following-sibling::label[@id='message7' and text()='%s']";
	public static final String EMAIL = "xpath=//tbody//input[@name = 'emailid']";
	public static final String ERROR_MESSAGE_EMAIL = "xpath=//tbody//input/following-sibling::label[@id='message9' and text()='%s']";
	public static final String RESET_BUTTON = "xpath=//input[@type='reset']";
	public static final String SUBMIT_BUTTON = "xpath=//input[@type='submit']";
}
