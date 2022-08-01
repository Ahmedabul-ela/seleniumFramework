package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.SearchPage;
import pages.UserRegisterationPage;

public class ProductReviewTest extends TestBase {

	ProductReviewPage productreviewobject;
	UserRegisterationPage registerationobject;
	HomePage Homeobject; 
	LoginPage Loginobject;
	SearchPage searchobject;
	ProductDetailsPage productdetailsobject;
	String productname = "Apple MacBook Pro 13-inch";
	String title = "My Review";
	String reviewtext = "This labtop is very good";

	@Test(priority=1,alwaysRun = true)
	public void usercanregistersuccessfully() {
		Homeobject = new HomePage(driver);
		registerationobject = new UserRegisterationPage(driver);
		Homeobject.openRegistrationPage();
		registerationobject.userregisteration("Ahmed","Mahmoud","87954@test.com", "12345678" );
		Assert.assertTrue(registerationobject.successmsg.getText().contains("Your registration completed"));
	}
	@Test(priority=2)
	public void usercansearchforproducts() {
		searchobject = new SearchPage(driver);
		productdetailsobject = new ProductDetailsPage(driver);
		searchobject.productsearch(productname);
		searchobject.openproductdetails();
		Assert.assertEquals(productdetailsobject.productnamebreadcrumb.getText(), productname);
		productdetailsobject.openaddreviewlink();
	}
	@Test(priority=3)
	public void usercanreviewproduct() {
		productreviewobject = new ProductReviewPage(driver);
		productreviewobject.Registeredusercanaddreview(title, reviewtext);
		Assert.assertTrue(productreviewobject.userreview.getText().contains(reviewtext));
	}
	@Test(priority=4)
	public void RegisteredUserCanLogOut() {
		registerationobject.usercanlogout();
	}
}