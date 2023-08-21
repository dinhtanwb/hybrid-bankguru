package factoryEnvironment;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import commons.GlobalConstances;

public class SauceLabFactory implements EnvironmentFactory{
	private WebDriver driver;
	private String browserName,osName;
	
	
	public SauceLabFactory(String browserName, String osName) {
		this.browserName = browserName;
		this.osName = osName;
	}
	
	
	@Override
	public WebDriver createDriver() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", osName);
		capabilities.setCapability("browserName", browserName);
		capabilities.setCapability("browserVersion", "latest");
		
		Map<String, Object> sauceOptions = new HashMap<>();
		sauceOptions.put("screenResolution", "1920x1080");
		capabilities.setCapability("sauce:options", sauceOptions);	
		capabilities.setCapability("name", "Run on " + osName  + "|"+ browserName);
		
		try {
			driver = new RemoteWebDriver(new URL(GlobalConstances.getGlobalContances().getSauceURL()), capabilities); 
				
			}catch(MalformedURLException e) {
				e.printStackTrace();
			}
		return driver;
	}

}
