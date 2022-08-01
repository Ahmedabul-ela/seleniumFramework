package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.LoadProperities;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegiesterationTestWithDDTUdingProperitiesFile extends TestBase{

	UserRegisterationPage registerationobject;
	HomePage Homeobject; 
	LoginPage Loginobject;

	String firstname = LoadProperities.userdata.getProperty("firstname");
	String lastname = LoadProperities.userdata.getProperty("lastname");
	String email = LoadProperities.userdata.getProperty("email");
	String password = LoadProperities.userdata.getProperty("password");

	@Test(priority=1,alwaysRun = true)
	public void usercanregistersuccessfully() {
		Homeobject = new HomePage(driver);
		registerationobject = new UserRegisterationPage(driver);
		Homeobject.openRegistrationPage();
		registerationobject.userregisteration(firstname,lastname,email,password);
		Assert.assertTrue(registerationobject.successmsg.getText().contains("Your registration completed"));

		registerationobject.usercanlogout();

		Homeobject.openLoginPage();
		Loginobject = new LoginPage(driver);
		Loginobject.userlogin(email,password);
		Assert.assertTrue(registerationobject.logoutbutton.isDisplayed());

		registerationobject.usercanlogout();
	}
}
