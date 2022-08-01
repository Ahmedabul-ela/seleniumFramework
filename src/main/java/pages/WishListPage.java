package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends PageBase {

	public WishListPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(css="h1")
	WebElement wishlistheader;

	@FindBy(id="updatecart")
	WebElement updatewishlistbtn;

	@FindBy(css="button.remove-btn")
	public WebElement removefromwishlist;

	@FindBy(css="td.product")
	public WebElement productcell;

	@FindBy(css="div.no-data")
	public WebElement wishlistemptymsg;

	public void removeelementfromwishlist() {
		clickbutton(removefromwishlist);
	}
}
