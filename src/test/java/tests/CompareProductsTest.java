package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CompareProductsPage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class CompareProductsTest extends TestBase {

	String product1name = "Apple MacBook Pro 13-inch"; 
	String product2name = "Asus N551JK-XO076H Laptop";
	SearchPage searchobject;
	ProductDetailsPage productdetailsobject;
	CompareProductsPage compareobject;

	@Test(priority=1)
	public void usercansearchforproduct1() throws Exception {

		searchobject = new SearchPage(driver);
		productdetailsobject = new ProductDetailsPage(driver);
		compareobject = new CompareProductsPage(driver);
		searchobject.productsearch(product1name);
		searchobject.openproductdetails();
		Assert.assertEquals(productdetailsobject.productnamebreadcrumb.getText(), product1name);
		productdetailsobject.openaddtocomparelink();
		Thread.sleep(1000);
	}
	@Test(priority=2)
	public void usercansearchforproduct2() throws Exception {

		searchobject.productsearch(product2name);
		searchobject.openproductdetails();
		Assert.assertEquals(productdetailsobject.productnamebreadcrumb.getText(), product2name);
		productdetailsobject.openaddtocomparelink();
		Thread.sleep(1000);
	}
	@Test(priority=3)
	public void compareproducts() {

		driver.navigate().to("https://demo.nopcommerce.com/compareproducts");
		Assert.assertTrue(compareobject.product1name.getText().contains(product1name));
		Assert.assertTrue(compareobject.product2name.getText().contains(product2name));
		compareobject.compareproducts();
	}
	@Test(priority=4)
	public void usercanclearcompareproductslist() {

		compareobject.clearcomparelist();
		Assert.assertTrue(compareobject.clearcomparelistmsg.getText().contains("You have no items to compare"));
	}
}
