package Steps;

import static org.testng.Assert.assertTrue;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;
import tests.TestBase;

public class UserRegisteration extends TestBase {
	UserRegisterationPage registerationobject;
	HomePage Homeobject; 
	LoginPage Loginobject;

	@Given("^User at Home page$")
	public void User_at_Home_page() {
		Homeobject = new HomePage(driver);
	}
	@when("^I Click on Register Link$")
	public void I_Click_on_Register_Link() {
		registerationobject = new UserRegisterationPage(driver);
		Homeobject.openRegistrationPage();
		assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}
	@when("^I entered \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\"$")
	public void I_entered(String firstname , String lastname , String email , String password) {
		registerationobject = new UserRegisterationPage(driver);
		registerationobject.userregisteration(firstname , lastname , email , password );
	}
	@then("^The Regiseration page is Displayed Successfully")
	public void The_Regiseration_page_is_Displayed_Successfully() {
		registerationobject.usercanlogout();
	}
}