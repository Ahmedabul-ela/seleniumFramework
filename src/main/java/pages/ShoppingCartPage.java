package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css="a.product-name")
	public WebElement productname;

	@FindBy(css="td.remove-from-cart")
	WebElement removeelement;

	@FindBy(id="updatecart")
	WebElement updateshoppingcart;

	@FindBy(css="input.qty-input")
	public WebElement qty;

	@FindBy(css="div.no-data")
	public WebElement emptyshoppingcartmsg;

	@FindBy(css="td.subtotal")
	public WebElement totalamount;

	@FindBy(id="termsofservice")
	WebElement agreeterms;

	@FindBy(id="checkout")
	WebElement checkoutbtn;

	public void removeelementfromcart() {
		clickbutton(removeelement);
	}
	public void updatecart() {
		clearelement(qty);
		settext(qty, "5");
		clickbutton(updateshoppingcart);
	}
	public void checkout() {
		clickbutton(agreeterms);
		clickbutton(checkoutbtn);
	}
}