package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishListPage;

public class AddProduvtToWishListTest extends TestBase {

	SearchPage searchobject;
	ProductDetailsPage productdetailsobject;
	String productname = "Apple MacBook Pro 13-inch";
	WishListPage wishlistobject;

	@Test(priority=1)
	public void usercansearchwithautosuggest() throws InterruptedException {
		searchobject = new SearchPage(driver);
		productdetailsobject= new ProductDetailsPage(driver);
		searchobject.productautosearch("MacB");
		Assert.assertTrue(productdetailsobject.productnamebreadcrumb.getText().equalsIgnoreCase(productname));
	}
	@Test(priority=2)
	public void addtowishlist() {
		productdetailsobject.openaddtowishlistlink();
		driver.navigate().to("https://demo.nopcommerce.com/wishlist");
		wishlistobject = new WishListPage(driver);
		Assert.assertTrue(wishlistobject.productcell.getText().contains(productname));
	}
	@Test(priority=3)
	public void removeelementfromwishlist() {
		wishlistobject.removeelementfromwishlist();
		Assert.assertTrue(wishlistobject.wishlistemptymsg.getText().contains("The wishlist is empty!"));
	}
}
