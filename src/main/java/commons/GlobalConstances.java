package commons;

import java.io.File;

import lombok.Getter;
@Getter
public class GlobalConstances {
	//Private static variable
	private static GlobalConstances globalConstances;
	
	//Private constructor
	private GlobalConstances() {
		
	}
	public static synchronized GlobalConstances getGlobalContances() {
//		if (globalConstances == null) {
//			return new GlobalConstances();
//		}
//		return globalConstances;
		
		return (globalConstances == null) ? new GlobalConstances() : globalConstances;
	}
	
	
	
	public String getProtalDevURL() {
		return protalDevURL;
	}
	public String getAdminDevURL() {
		return adminDevURL;
	}
	public String getProtalTestingURL() {
		return protalTestingURL;
	}
	public String getAdminTestingURL() {
		return adminTestingURL;
	}
	public String getProjectPath() {
		return projectPath;
	}
	public String getOsName() {
		return osName;
	}
	public String getUploadFile() {
		return uploadFile;
	}
	public String getDownloadFile() {
		return downloadFile;
	}
	public String getBrowserLog() {
		return browserLog;
	}
	public String getDragDropHTML5() {
		return dragDropHTML5;
	}
	public String getAutoITScript() {
		return autoITScript;
	}
	public String getReportingImage() {
		return reportingImage;
	}
	public String getExtendReport() {
		return extendReport;
	}
	public String getJavaVersion() {
		return javaVersion;
	}
	public String getDbDevURL() {
		return dbDevURL;
	}
	public String getDbDevUserName() {
		return dbDevUserName;
	}
	public String getDbDevPass() {
		return dbDevPass;
	}
	public String getDbTestURL() {
		return dbTestURL;
	}
	public String getDbTestUserName() {
		return dbTestUserName;
	}
	public String getDbTestPass() {
		return dbTestPass;
	}
	public long getShortTimeOut() {
		return shortTimeOut;
	}
	public long getLongTimeOut() {
		return longTimeOut;
	}
	public long getRetryTestFail() {
		return retryTestFail;
	}
	public String getJqueryDataTable() {
		return jqueryDataTable;
	}
	public String getJqueryDataTable2() {
		return jqueryDataTable2;
	}
	public String getJqueryUploadFile() {
		return jqueryUploadFile;
	}
	public String getFacebookLogin() {
		return facebookLogin;
	}
	public String getBrowserUserName() {
		return browserUserName;
	}
	public String getBrowserKey() {
		return browserKey;
	}
	public String getBrowserURL() {
		return browserURL;
	}
	public String getSauceUserName() {
		return sauceUserName;
	}
	public String getSauceKey() {
		return sauceKey;
	}
	public String getSauceURL() {
		return sauceURL;
	}
	public String getLambdaUserName() {
		return lambdaUserName;
	}
	public String getLambdaKey() {
		return lambdaKey;
	}
	public String getLambdaURL() {
		return lambdaURL;
	}



	private final  String protalDevURL = "https://demo.nopcommerce.com/";
	private final  String adminDevURL = "https://admin-demo.nopcommerce.com";
	private final  String protalTestingURL = "https://demo.nopcommerce.com/";
	private final  String adminTestingURL = "https://admin-demo.nopcommerce.com";
	private final  String projectPath = System.getProperty("user.dir");
	private final  String osName = System.getProperty("os.name");
	private final  String uploadFile = projectPath + File.separator +"uploadFiles" + File.separator;
	private final  String downloadFile = projectPath + File.separator +"downloadFiles";
	private final  String browserLog = projectPath + File.separator + "browserLogs";
	private final  String dragDropHTML5 = projectPath + File.separator + "dragDropHTML5";
	private final  String autoITScript = projectPath + File.separator + "autoIT";
	private final  String reportingImage = projectPath + File.separator + "reportNG_image" + File.separator ;
	private final  String extendReport = projectPath + File.separator + "extentReportV2" + File.separator;
	private final  String javaVersion = System.getProperty("java.version");
	private final  String dbDevURL = "32.18.195.40:9860";
	private final  String dbDevUserName = "automationfc";
	private final  String dbDevPass = "Pass@w0rrld111/";
	private final  String dbTestURL = "32.18.195.23:9860";
	private final  String dbTestUserName = "automationfc";
	private final  String dbTestPass = "Pass@w0rrld111/";
	private final  long shortTimeOut = 5;
	private final  long longTimeOut = 30;
	private final  long retryTestFail = 3;
	private final  String jqueryDataTable = "https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/";
	private final  String jqueryDataTable2 = "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/";
	private final  String jqueryUploadFile = "https://blueimp.github.io/jQuery-File-Upload/";
	private final  String facebookLogin = "https://www.facebook.com/";
	
	private final  String browserUserName = "tantran_H1BVh2";
	private final  String browserKey = "gYMHNpnJmEDiRMQrAUdU";
	private final  String browserURL = "https://" + browserUserName + ":" + browserKey + "@hub-cloud.browserstack.com/wd/hub";
	
	private final  String sauceUserName = "oauth-dinhtan.wb-e10b1";
	private final  String sauceKey = "fb90098f-e080-4498-9180-3db50afb979b";
	private final  String sauceURL = "https://" + sauceUserName + ":" + sauceKey + "@ondemand.us-west-1.saucelabs.com:443/wd/hub";
	
	private final  String lambdaUserName = "dinhtan.wb";
	private final  String lambdaKey = "vQDRcicBLq0qmohwJWeYQxauVxaXh2R8AKpNorSyLH7bASi8p7";
	private final  String lambdaURL = "https://" + lambdaUserName + ":" + lambdaKey + "@hub.lambdatest.com/wd/hub";
	
}
