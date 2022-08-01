package tests;

import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegiesterationTestWithDDTCSV extends TestBase {

	UserRegisterationPage registerationobject;
	HomePage Homeobject; 
	LoginPage Loginobject;
	CSVReader reader;

	@Test(priority=1)
	public void usercanregistersuccessfully() throws Exception, IOException {
		String csvfilepath = System.getProperty("user.dir"+"\\src\\test\\java\\data\\UserData.csv");
		reader = new CSVReader((new FileReader(csvfilepath)));
		String [] CSVCell;
		while((CSVCell = reader.readNext()) != null) {
			String fname = CSVCell[0];
			String lname = CSVCell[1];
			String email = CSVCell[2];
			String password = CSVCell[3];
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
}