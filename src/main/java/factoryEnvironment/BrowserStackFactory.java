package factoryEnvironment;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import commons.GlobalConstances;

public class BrowserStackFactory implements EnvironmentFactory{
	private WebDriver driver;
	private String browserName,osName, osVersion;
	
	
	public BrowserStackFactory(String browserName, String osName, String osVersion) {
		this.browserName = browserName;
		this.osName = osName;
		this.osVersion = osVersion;
	}


	@Override
	public WebDriver createDriver() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("os", osName);
		capabilities.setCapability("os_version", osVersion);
		capabilities.setCapability("browser", browserName);
		capabilities.setCapability("browser_version", "latest");
		capabilities.setCapability("browserstack.debug", "true");
		capabilities.setCapability("project", "NopCommerce");
		
		
		capabilities.setCapability("name", "Run on " + osName + "|" + osVersion + "|"+ browserName);
		if(osName.contains("Windows")) {
			capabilities.setCapability("resolusion", "1920x1080");
		} else {
			capabilities.setCapability("resolusion", "1920x1440");
		}
		try {
			driver = new RemoteWebDriver(new URL(GlobalConstances.getGlobalContances().getBrowserURL()), capabilities); 
				
			}catch(MalformedURLException e) {
				e.printStackTrace();
			}
		return driver;
		
	}

}
