package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailsPage extends PageBase {

	public OrderDetailsPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(linkText = "Click here for order details.")
	WebElement moredetails;

	@FindBy(css="a.button-2.pdf-invoice-button")
	WebElement pdfinvoicebtn;

	@FindBy(css="a.button-2.print-order-button")
	WebElement printbtn;

	public void pdf() {
		clickbutton(moredetails);
		clickbutton(pdfinvoicebtn);
	}
	public void printinvoice() throws InterruptedException {
		clickbutton(moredetails);
		clickbutton(printbtn);
		Thread.sleep(2000);
	}
} 