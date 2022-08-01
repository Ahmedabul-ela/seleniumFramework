package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegiesterationTestWithDDTJavaFaker extends TestBase {

	UserRegisterationPage registerationobject;
	HomePage Homeobject; 
	LoginPage Loginobject;

	Faker fakedata = new Faker();
	String firstname = fakedata.name().firstName();
	String lastname = fakedata.name().lastName();
	String email = fakedata.internet().emailAddress();
	String password = fakedata.number().digits(8).toString();
	
	@Test(priority=1)
	public void usercanregistersuccessfully() {
		
		Homeobject = new HomePage(driver);
		registerationobject = new UserRegisterationPage(driver);
		Homeobject.openRegistrationPage();
		registerationobject.userregisteration( firstname, lastname, email, password );
		Assert.assertTrue(registerationobject.successmsg.getText().contains("Your registration completed"));

		registerationobject.usercanlogout();

		Homeobject.openLoginPage();
		Loginobject = new LoginPage(driver);
		Loginobject.userlogin(email, password);
		Assert.assertTrue(registerationobject.logoutbutton.isDisplayed());
		registerationobject.usercanlogout();
	}
}
