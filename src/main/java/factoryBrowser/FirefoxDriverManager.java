package factoryBrowser;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import commons.GlobalConstances;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxDriverManager implements BrowserFactory{

	@Override
	public WebDriver getBrowserDriver() {
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions options = new FirefoxOptions();
		
		FirefoxProfile profile = new FirefoxProfile();
		File translate = new File(GlobalConstances.PROJECT_PATH + "\\browserExtensions\\simple_translate-2.8.1.xpi");
		profile.addExtension(translate);
		options.setProfile(profile);
		return new FirefoxDriver(options);
	}

}
