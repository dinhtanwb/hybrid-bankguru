package factoryBrowser;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import commons.GlobalConstances;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverManager implements BrowserFactory{

	@Override
	public WebDriver getBrowserDriver() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		
		// Disable browser log in console
		System.setProperty("webdriver.chrome.args", "--disable-loggin");
		System.setProperty("webdriver.chrome.silentOutput", "true");

		// Add extensions
		File file = new File(GlobalConstances.getGlobalContances().getProjectPath() + "\\browserExtensions\\extension_2_0_13_0.crx");
		File adBlock = new File(GlobalConstances.getGlobalContances().getProjectPath() + "\\browserExtensions\\extension_5_9_0_0.crx");
		File uBlock = new File(GlobalConstances.getGlobalContances().getProjectPath() + "\\browserExtensions\\extension_1_51_0_0.crx");
		options.addExtensions(file);
		options.addExtensions(adBlock);
		options.addExtensions(uBlock);
		// Change language browser
		options.addArguments("--lang=vi");

		// Notification popup
		options.addArguments("--disable-notifications");

		// Location popup
		options.addArguments("--disable-geolocation");

		// automation infor bar
		options.setExperimentalOption("useAutomationExtension", false);
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

		// disable save password popup
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		options.setExperimentalOption("prefs", prefs);

		// Auto save/download
		Map<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", GlobalConstances.getGlobalContances().getProjectPath() + "\\downloadFiles");
		options.setExperimentalOption("prefs", chromePrefs);

		// Open InCognito
		options.addArguments("--incognito");
		
		
		return new ChromeDriver(options);
	}

}
