package commons;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import factoryBrowser.BrowserList;
import factoryEnvironment.BrowserStackFactory;
import factoryEnvironment.EnvironmentList;
import factoryEnvironment.LambdaFactory;
import factoryEnvironment.LocalFactory;
import factoryEnvironment.SauceLabFactory;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	private WebDriver driver;
	protected Log log;

	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}

	public WebDriver getDriverInstance() {
		return this.driver;
	}

	@BeforeSuite
	public void initAllureReport() {
		deleteAllFileInFolder();
	}

	public WebDriver openMultipleBrowser(String browserName, String url) {
		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
		if (browser.equals(BrowserList.FIREFOX)) {
			FirefoxProfile profile = new FirefoxProfile();
			File translate = new File(GlobalConstances.getGlobalContances().getProjectPath() + "\\browserExtensions\\simple_translate-2.8.1.xpi");
			profile.addExtension(translate);
			FirefoxOptions options = new FirefoxOptions();
			options.setProfile(profile);
			driver = WebDriverManager.firefoxdriver().capabilities(options).create();

		} else if (browser.equals(BrowserList.H_FIREFOX)) {
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1920×1080");
			driver = WebDriverManager.firefoxdriver().capabilities(options).create();
		} else if (browser.equals(BrowserList.CHROME)) {
			WebDriverManager.chromedriver().setup();
			
			// Disable browser log in console
			 System.setProperty("webdriver.chrome.args", "--disable-loggin");
			 System.setProperty("webdriver.chrome.silentOutput", "true");

			// Add extensions
			 File file = new File(GlobalConstances.getGlobalContances().getProjectPath() + "\\browserExtensions\\extension_2_0_13_0.crx");
			ChromeOptions options = new ChromeOptions();
			 options.addExtensions(file);

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

			driver = new ChromeDriver(options);

		} else if (browser.equals(BrowserList.H_CHROME)) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1366x768");
			driver = WebDriverManager.chromedriver().capabilities(options).create();

		} else if (browser.equals(BrowserList.EDGE)) {
			driver = WebDriverManager.edgedriver().create();
		} else if (browser.equals(BrowserList.OPERA)) {
			driver = WebDriverManager.operadriver().create();
		} else if (browser.equals(BrowserList.COCCOC)) {
			WebDriverManager.chromedriver().driverVersion("113.0.5672.24").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
			driver = new ChromeDriver(options);
		} else if (browser.equals(BrowserList.BRAVE)) {
			WebDriverManager.chromedriver().driverVersion("114.0.5735.90").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
			driver = new ChromeDriver(options);
		} else {
			throw new RuntimeException("Open invalid browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(GlobalConstances.getGlobalContances().getLongTimeOut(), TimeUnit.SECONDS);
		driver.get(getEnvironment(url));
		// return driver để bên các class con hứng biến này và gắn vào driver ở class
		// đó. ==> Sau đó sử dụng tiếp tục
		return driver;
	}

	public WebDriver getBrowser(String envName, String serverName, String browserName, String osName, String osVersion) {
		EnvironmentList env = EnvironmentList.valueOf(envName.toUpperCase());
		switch (env) {
		case LOCAL:
			driver = new LocalFactory(browserName).createDriver();
			break;
		case BROWSERSTACK:
			driver = new BrowserStackFactory(browserName, osName, osVersion).createDriver();
			break;
		case SAUCELAB:
			driver = new SauceLabFactory(browserName, osName).createDriver();
			break;
		case LAMBDA:
			driver = new LambdaFactory(browserName, osName).createDriver();
			break;
		default:
			driver = new LocalFactory(browserName).createDriver();
			break;

		}
		driver.manage().timeouts().implicitlyWait(GlobalConstances.getGlobalContances().getLongTimeOut(), TimeUnit.SECONDS);
		driver.get(getEnvironment(serverName));
		return driver;
	}

	public int fakeNumber() {
		Random rand = new Random();
		return rand.nextInt(999999);
	}

	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true) {
				System.out.println(" -------------------------- PASSED -------------------------- ");
			} else {
				System.out.println(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {
			if (condition == false) {
				System.out.println(" -------------------------- PASSED -------------------------- ");
			} else {
				System.out.println(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			System.out.println(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			System.out.println(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	public void deleteAllFileInFolder() {
		try {
			String pathFolderDownload = GlobalConstances.getGlobalContances().getProjectPath() + "/allure-json";
			File file = new File(pathFolderDownload);
			File[] listOfFiles = file.listFiles();
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					System.out.println(listOfFiles[i].getName());
					new File(listOfFiles[i].toString()).delete();
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	protected void closeBrowserDriver() {
		String cmd = null;
		try {
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);

			String driverInstanceName = driver.toString().toLowerCase();
			log.info("Driver instance name = " + driverInstanceName);

			String browserDriverName = null;

			if (driverInstanceName.contains("chrome")) {
				browserDriverName = "chromedriver";
			} else if (driverInstanceName.contains("internetexplorer")) {
				browserDriverName = "IEDriverServer";
			} else if (driverInstanceName.contains("firefox")) {
				browserDriverName = "geckodriver";
			} else if (driverInstanceName.contains("edge")) {
				browserDriverName = "msedgedriver";
			} else if (driverInstanceName.contains("opera")) {
				browserDriverName = "operadriver";
			} else {
				browserDriverName = "safaridriver";
			}

			if (osName.contains("window")) {
				cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
			} else {
				cmd = "pkill " + browserDriverName;
			}

			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		} finally {
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	protected String getCurrentDay() {
		DateTime nowUTC = new DateTime();
		int day = nowUTC.getDayOfMonth();
		if (day < 10) {
			String dayValue = "0" + day;
			return dayValue;
		}
		return day + "";
	}

	protected String getCurrentMonth() {
		DateTime now = new DateTime();
		int month = now.getMonthOfYear();
		if (month < 10) {
			String monthValue = "0" + month;
			return monthValue;
		}
		return month + "";
	}

	protected String getCurrentYear() {
		DateTime now = new DateTime(DateTimeZone.UTC);
		return now.getYear() + "";
	}

	protected String getToday() {
		return getCurrentMonth() + "/" + getCurrentDay() + "/" + getCurrentYear();
	}
	
	private String getEnvironment(String serverName) {
		String url = null;
		switch (serverName) {
		case "dev":
			url = "https://demo.guru99.com/v4/index.php";
			break;
		case "testing":
			url = "https://tiki.vn/";
			break;
		case "staging":
			url = "https://www.nopcommerce.com/";
			break;
		default:
			System.out.println("Invalid environment");
		}

		return url;
	}
}

