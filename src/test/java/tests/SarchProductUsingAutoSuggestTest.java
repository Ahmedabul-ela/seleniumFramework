package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class SarchProductUsingAutoSuggestTest extends TestBase {

	SearchPage searchobject;
	ProductDetailsPage productdetailsobject;
	String productname = "Apple MacBook Pro 13-inch";

	@Test
	public void usercansearchwithautosuggest() throws InterruptedException {

		searchobject = new SearchPage(driver);
		productdetailsobject= new ProductDetailsPage(driver);
		searchobject.productautosearch("MacB");
		Assert.assertTrue(productdetailsobject.productnamebreadcrumb.getText().equalsIgnoreCase(productname));
	}
}
