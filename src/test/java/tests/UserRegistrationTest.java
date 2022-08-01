package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegistrationTest extends TestBase {

	UserRegisterationPage registerationobject;
	HomePage Homeobject; 
	LoginPage Loginobject;

	@Test(priority=1,alwaysRun = true)
	public void usercanregistersuccessfully() {
		Homeobject = new HomePage(driver);
		registerationobject = new UserRegisterationPage(driver);
		Homeobject.openRegistrationPage();
		registerationobject.userregisteration("Ahmed","Mahmoud","Tes1@test.com", "12345678" );
		Assert.assertTrue(registerationobject.successmsg.getText().contains("Your registration completed"));
	}
	@Test(dependsOnMethods = "usercanregistersuccessfully")
	public void RegisteredUserCanLogOut() {
		registerationobject.usercanlogout();
	}
	@Test(dependsOnMethods = "RegisteredUserCanLogOut")
	public void RegisteredUserCanLogin() {
		Homeobject.openLoginPage();
		Loginobject = new LoginPage(driver);
		Loginobject.userlogin("Tes1@test.com", "12345678");
		Assert.assertTrue(registerationobject.logoutbutton.isDisplayed());
	}
}
