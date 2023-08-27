package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessChromeDriverManager implements BrowserFactory{

	@Override
	public WebDriver getBrowserDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("window-size=1920×1080");
		return WebDriverManager.chromedriver().capabilities(options).create();
		
//	
	}

}
