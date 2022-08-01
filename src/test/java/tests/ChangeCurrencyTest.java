package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase {

	String productname = "Apple MacBook Pro 13-inch";
	SearchPage searchobject;
	ProductDetailsPage productdetailsobject;
	HomePage homeobject;

	@Test(priority=1)
	public void changecurrecncy(){
		homeobject = new HomePage(driver);
		homeobject.changecurrency();
	}
	@Test(priority=2)
	public void usercansearchforproducts() {

		searchobject = new SearchPage(driver);
		productdetailsobject = new ProductDetailsPage(driver);
		searchobject.productsearch(productname);
		searchobject.openproductdetails();
		Assert.assertEquals(productdetailsobject.productnamebreadcrumb.getText(), productname);
		Assert.assertTrue(productdetailsobject.productpricelabel.getText().contains("€"));
	}
}
