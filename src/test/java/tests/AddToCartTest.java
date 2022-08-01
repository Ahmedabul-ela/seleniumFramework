package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class AddToCartTest extends TestBase{

	String productname = "Apple MacBook Pro 13-inch";
	SearchPage searchobject;
	ProductDetailsPage productdetailsobject;
	ShoppingCartPage addtocartobject;

	@Test(priority=1)
	public void usercansearchforproducts() {
		searchobject = new SearchPage(driver);
		productdetailsobject = new ProductDetailsPage(driver);
		searchobject.productsearch(productname);
		searchobject.openproductdetails();
		Assert.assertEquals(productdetailsobject.productnamebreadcrumb.getText(), productname);
	}
	@Test(priority=2)
	public void usercanaddproducttocart() throws InterruptedException {
		productdetailsobject.openaddtocatrtlink();
		Thread.sleep(1000);
		driver.navigate().to("https://demo.nopcommerce.com/cart");
		addtocartobject = new ShoppingCartPage(driver);
		addtocartobject.updatecart();
		Assert.assertTrue(addtocartobject.totalamount.getText().contains("9,000"));
	}
	@Test(priority=3)
	public void removeelementfromcart() {
		addtocartobject.removeelementfromcart();
		Assert.assertTrue(addtocartobject.emptyshoppingcartmsg.getText().contains("Your Shopping Cart is empty!"));
	}
}	