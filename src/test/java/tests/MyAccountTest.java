package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegisterationPage;

public class MyAccountTest extends TestBase {

	HomePage Homeobject;
	UserRegisterationPage registerationobject;
	LoginPage Loginobject;
	MyAccountPage MyAccountobject;

	String firstname = "Ahmed";
	String lastname = "Mahmoud";
	String email = "ana@test.com";
	String oldpassword = "12345678";
	String newpassword = "0123456789";

	@Test(priority=1)
	public void usercanregistersuccessfully() {
		Homeobject = new HomePage(driver);
		registerationobject = new UserRegisterationPage(driver);
		Homeobject.openRegistrationPage();
		registerationobject.userregisteration(firstname,lastname,email, oldpassword );
		Assert.assertTrue(registerationobject.successmsg.getText().contains("Your registration completed"));
	}
	@Test(priority=2)
	public void registeredusercanopenmyaccountpage() {
		registerationobject.usercanopenmyaccount();
	}
	@Test(priority=3)
	public void registeredusercanchangepassword() {
		MyAccountobject = new MyAccountPage(driver);
		MyAccountobject.OpenChangePassword();
		MyAccountobject.ChangePassword(oldpassword, newpassword);
		Assert.assertTrue(MyAccountobject.passwordchangesmsg.getText().contains("Password was changed"));
	}
	@Test(priority=4)
	public void userclosemsg() {
		MyAccountobject.closepasswordchangedmsg();
	}
	@Test(priority=5,dependsOnMethods ="userclosemsg")
	public void RegisteredUserCanLogOut() {
		registerationobject.usercanlogout();
	}
	@Test(priority=6,dependsOnMethods ="RegisteredUserCanLogOut")
	public void RegisteredUserCanLogin() {
		Homeobject.openLoginPage();
		Loginobject = new LoginPage(driver);
		Loginobject.userlogin(email, newpassword);
		Assert.assertTrue(registerationobject.logoutbutton.isDisplayed());
	}
}