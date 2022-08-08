package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utilities.helper;

public class TestBase2 {

	public static String BaseURL = "https://demo.nopcommerce.com/";
	protected ThreadLocal<RemoteWebDriver> driver = null; // save memory location

	@BeforeClass
	@Parameters({"Browser"})
	public void setDrive(@Optional("chrome") String Browser) throws MalformedURLException {

		driver = new ThreadLocal<>();
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("BrowserName", Browser);
		driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps));
		getDriver().navigate().to(BaseURL);
	}
	public RemoteWebDriver getDriver() {
		return driver.get();	
	}
	@AfterClass
	public void stopDriver() {
		getDriver().quit();
		driver.remove(); // remove thread
	}
	@AfterMethod
	public void ScreenShotOnFalliure(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("FAILED!");
			System.out.println("Taking Screenshot....");
			helper.CaptureScreenShot(getDriver(), result.getName());
		}
	}