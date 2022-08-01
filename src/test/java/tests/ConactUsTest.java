package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

public class ConactUsTest extends TestBase{

	HomePage homeobject;
	ContactUsPage contactusobject;
	String name = "Ahmed";
	String mail = "test@test.com";
	String enquiry = "Hello every body";

	@Test
	public void Usercancontactbycontactus() {
		homeobject = new HomePage(driver);
		contactusobject = new ContactUsPage(driver);
		homeobject.openContactUsPage();
		contactusobject.fillingcontactus(name, mail, enquiry);
		Assert.assertTrue(contactusobject.submitmessage.getText().contains("Your enquiry has been successfully sent to the store owner"));
	}
}
