package factoryEnvironment;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import commons.GlobalConstances;

public class LambdaFactory implements EnvironmentFactory {
	private WebDriver driver;
	private String browserName, osName;

	public LambdaFactory(String browserName, String osName) {
		this.browserName = browserName;
		this.osName = osName;
	}

	@Override
	public WebDriver createDriver() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platform", osName);
		capabilities.setCapability("browserName", browserName);
		capabilities.setCapability("version", "latest");
		capabilities.setCapability("video", true);
		capabilities.setCapability("visual", true);
		if(osName.contains("Windows")) {
			capabilities.setCapability("screenResolution", "1920x1080");
		} else {
			capabilities.setCapability("screenResolution", "2560x1440");
		}
		
		
		
		capabilities.setCapability("name", "Run on " + osName  + "|"+ browserName);
		
		try {
			driver = new RemoteWebDriver(new URL(GlobalConstances.getGlobalContances().getLambdaURL()), capabilities); 
				
			}catch(MalformedURLException e) {
				e.printStackTrace();
			}
		return driver;
	}
}
