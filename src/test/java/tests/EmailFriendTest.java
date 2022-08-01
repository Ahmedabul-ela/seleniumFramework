package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailFriendPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegisterationPage;

public class EmailFriendTest extends TestBase {

	String productname = "Apple MacBook Pro 13-inch";
	String email = "588a@test.com";
	UserRegisterationPage registerationobject;
	HomePage Homeobject;
	SearchPage searchobject;
	ProductDetailsPage productdetailsobject;
	EmailFriendPage emailfriendobject;

	@Test(priority=1,alwaysRun = true)
	public void usercanregistersuccessfully() {
		Homeobject = new HomePage(driver);
		registerationobject = new UserRegisterationPage(driver);
		Homeobject.openRegistrationPage();
		registerationobject.userregisteration("Ahmed","Mahmoud", email, "12345678" );
		Assert.assertTrue(registerationobject.successmsg.getText().contains("Your registration completed"));
	}
	@Test(priority = 2)
	public void usercansearchforproducts() {
		searchobject = new SearchPage(driver);
		productdetailsobject = new ProductDetailsPage(driver);
		searchobject.productsearch(productname);
		searchobject.openproductdetails();
		Assert.assertEquals(productdetailsobject.productnamebreadcrumb.getText(), productname);
		productdetailsobject.openemailfriend();
	}
	@Test(priority = 3)
	public void usercansendmailtofriend() {
		emailfriendobject = new EmailFriendPage(driver);
		emailfriendobject.sendmailtofriend("testhh@test.com", "Hello, you can show this product");
		Assert.assertTrue(emailfriendobject.sentmailconfirmmsg.getText().contains("Your message has been sent"));
	}
	@Test(priority=4)
	public void RegisteredUserCanLogOut() {
		registerationobject.usercanlogout();
	}
}

