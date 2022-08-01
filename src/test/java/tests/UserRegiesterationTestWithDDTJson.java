package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.JsonDataReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegiesterationTestWithDDTJson extends TestBase {

	UserRegisterationPage registerationobject;
	HomePage Homeobject; 
	LoginPage Loginobject;

	@Test(priority=1)
	public void usercanregistersuccessfully() throws FileNotFoundException, IOException, ParseException {

		JsonDataReader jsonreader = new JsonDataReader();
		jsonreader.JsonReader();
		Homeobject = new HomePage(driver);
		registerationobject = new UserRegisterationPage(driver);
		Homeobject.openRegistrationPage();
		registerationobject.userregisteration( jsonreader.firstname, jsonreader.lastname, jsonreader.email, jsonreader.password );
		Assert.assertTrue(registerationobject.successmsg.getText().contains("Your registration completed"));

		registerationobject.usercanlogout();

		Homeobject.openLoginPage();
		Loginobject = new LoginPage(driver);
		Loginobject.userlogin(jsonreader.email, jsonreader.password);
		Assert.assertTrue(registerationobject.logoutbutton.isDisplayed());
		registerationobject.usercanlogout();
	}
}