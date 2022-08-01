package tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegiesterationTestWithDDTDataProvider extends TestBase {

	UserRegisterationPage registerationobject;
	HomePage Homeobject; 
	LoginPage Loginobject;

	@DataProvider(name="testdata")
	public static Object[][] UserData(){

		return new Object [][] {
			{"ahmed","ali","hg55@df.com","123456789"},
			{"ali","aki","ak01i@tre.com","123456789"}
		};
	}
	@Test(priority=1,dataProvider = "testdata")
	public void usercanregistersuccessfully(String fname,String lname,String email, String password ) {

		Homeobject = new HomePage(driver);
		registerationobject = new UserRegisterationPage(driver);
		Homeobject.openRegistrationPage();
		registerationobject.userregisteration( fname, lname, email,  password );
		Assert.assertTrue(registerationobject.successmsg.getText().contains("Your registration completed"));

		registerationobject.usercanlogout();

		Homeobject.openLoginPage();
		Loginobject = new LoginPage(driver);
		Loginobject.userlogin(email, password);
		Assert.assertTrue(registerationobject.logoutbutton.isDisplayed());
		registerationobject.usercanlogout();
	}
}
