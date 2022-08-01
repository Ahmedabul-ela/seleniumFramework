package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase{

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(css="strong.current-item")
	public WebElement productnamebreadcrumb;

	@FindBy(css="button.button-2.email-a-friend-button")
	WebElement emailafriendbtn;

	@FindBy(id="price-value-4")
	public WebElement productpricelabel;

	@FindBy(linkText="Add your review")
	WebElement addreviewbtn;

	@FindBy(id="add-to-wishlist-button-4")
	WebElement addtowishlistbtn;

	@FindBy(id="add-to-cart-button-4")
	WebElement addtocartbtn;

	@FindBy(css="button.button-2.add-to-compare-list-button")
	WebElement addtocomparebtn;

	public void openemailfriend() {
		clickbutton(emailafriendbtn);
	}
	public void openaddreviewlink() {
		clickbutton(addreviewbtn);
	}
	public void openaddtowishlistlink() {
		clickbutton(addtowishlistbtn);
	}
	public void openaddtocatrtlink() {
		clickbutton(addtocartbtn);
	}
	public void openaddtocomparelink() {
		clickbutton(addtocomparebtn);
	}
}