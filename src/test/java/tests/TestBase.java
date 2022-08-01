package tests;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utilities.helper;

public class TestBase extends AbstractTestNGCucumberTests{

	public static WebDriver driver;
	public static String downloadspath = System.getProperty("user.dir"+"\\Downloads");

	public static FirefoxOptions firefoxoption() {
		FirefoxOptions option = new FirefoxOptions();
		option.addPreference("Browser.download.folderList", 2); // 0 is default
		option.addPreference("Browser.download.dir", downloadspath);
		option.addPreference("Browser.helperApps.neverAsk.saveToDisk","Aplication/octet_stream");
		option.addPreference("Browser.download.manager.showWhenStarting", false);
		return option;
	}
		public static ChromeOptions chromeoption() {
			ChromeOptions option = new ChromeOptions();
			HashMap<String, Object> chromeprefs = new HashMap<String, Object>();
			chromeprefs.put("Profile.default.content_settings.popups", 0); //default
			chromeprefs.put("download.default_directory", downloadspath);
			option.setExperimentalOption("prefs", chromeprefs);
			option.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
			return option;
		}
	@BeforeSuite
	@Parameters({"browser"})
	public void startDriver(@Optional("chrome") String browsername) {     // chrome by default

		if (browsername.equalsIgnoreCase("chrome")) {                     // ignore capital or small
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver(chromeoption());

		}else if (browsername.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir"+"\\Drivers\\geckodriver.exe"));
			driver = new FirefoxDriver(firefoxoption());

		}else if (browsername.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir"+"\\Drivers\\IEDriverServer.exe"));
			driver = new InternetExplorerDriver();


		}else if (browsername.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();

		}
		driver.manage().window().maximize();
		driver.navigate().to("https://demo.nopcommerce.com/");
	}

	@AfterSuite
	public void stopDriver() {
		driver.quit();
	}
	
	@AfterMethod
	public void ScreenShotOnFalliure(ITestResult result) {
		
		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("FAILED!");
			System.out.println("Taking Screenshot....");
			helper.CaptureScreenShot(driver, result.getName());
		}
	}
}
