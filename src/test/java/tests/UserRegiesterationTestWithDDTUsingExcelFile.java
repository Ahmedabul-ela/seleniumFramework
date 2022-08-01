package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegiesterationTestWithDDTUsingExcelFile extends TestBase {

	UserRegisterationPage registerationobject;
	HomePage Homeobject; 
	LoginPage Loginobject;

	@DataProvider(name = "ExcelData")
	public Object [][] usergetdata() throws IOException{
		ExcelReader er = new ExcelReader();
		return er.getexceldata();
	}
	@Test(priority=1,dataProvider = "ExcelData")
	public void usercanregistersuccessfully(String firstname, String lastname, String email, String password) {
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
	}
}