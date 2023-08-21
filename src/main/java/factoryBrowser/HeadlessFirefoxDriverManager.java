package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessFirefoxDriverManager implements BrowserFactory{

	@Override
	public WebDriver getBrowserDriver() {
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("headless");
		options.addArguments("window-size=1920×1080");
		return WebDriverManager.firefoxdriver().capabilities(options).create();
		
		
		
	}

}
