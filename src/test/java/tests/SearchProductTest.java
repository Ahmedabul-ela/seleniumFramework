package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductTest extends TestBase {

	String productname = "Apple MacBook Pro 13-inch";
	SearchPage searchobject;
	ProductDetailsPage productdetailsobject;
@Test
	public void usercansearchforproducts() {
		searchobject = new SearchPage(driver);
		productdetailsobject = new ProductDetailsPage(driver);
		searchobject.productsearch(productname);
		searchobject.openproductdetails();
		Assert.assertEquals(productdetailsobject.productnamebreadcrumb.getText(), productname);
	}
}
