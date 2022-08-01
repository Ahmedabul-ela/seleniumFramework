package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckOutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import pages.UserRegisterationPage;

public class CheckOutAndOrderDetailsTest extends TestBase {

	UserRegisterationPage registerationobject;
	HomePage Homeobject; 
	LoginPage Loginobject;
	SearchPage searchobject;
	ProductDetailsPage productdetailsobject;
	String productname = "Apple MacBook Pro 13-inch";
	ShoppingCartPage addtocartobject;
	CheckOutPage checkoutobject;
	OrderDetailsPage orderdetailsobject;

	@Test(priority=1,alwaysRun = true)
	public void usercanregistersuccessfully() {
		Homeobject = new HomePage(driver);
		registerationobject = new UserRegisterationPage(driver);
		Homeobject.openRegistrationPage();
		registerationobject.userregisteration("Ahmed","Mahmoud","asde5@me.com", "12345678" );
		Assert.assertTrue(registerationobject.successmsg.getText().contains("Your registration completed"));
	}
	@Test(priority = 2)
	public void usercansearchwithautosuggest() throws InterruptedException {
		searchobject = new SearchPage(driver);
		productdetailsobject= new ProductDetailsPage(driver);
		searchobject.productautosearch("MacB");
		Assert.assertTrue(productdetailsobject.productnamebreadcrumb.getText().equalsIgnoreCase(productname));
	}
	@Test(priority=3)
	public void usercanaddproducttocart() throws InterruptedException {
		productdetailsobject.openaddtocatrtlink();
		Thread.sleep(1000);
		driver.navigate().to("https://demo.nopcommerce.com/cart");
		addtocartobject = new ShoppingCartPage(driver);
		addtocartobject.updatecart();
		Assert.assertTrue(addtocartobject.totalamount.getText().contains("9,000"));
		addtocartobject.checkout();
	}
	@Test(priority=4)
	public void usercancheckout() throws InterruptedException {
		checkoutobject = new CheckOutPage(driver);
		orderdetailsobject = new OrderDetailsPage(driver);
		checkoutobject.shippingdetails("cairo", "01015493215", "140", "5 zoghbi st., dokki");
		Assert.assertTrue(checkoutobject.successlbl.isDisplayed());
		orderdetailsobject.printinvoice();
		}
	@Test(priority = 5)
	public void RegisteredUserCanLogOut() {
		registerationobject.usercanlogout();
	}
}
