package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class CheckOutPage extends PageBase {

	public CheckOutPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="BillingNewAddress_CountryId")
	WebElement countrylist;

	@FindBy(id="BillingNewAddress_City")
	WebElement citytextbox;

	@FindBy(id="BillingNewAddress_Address1")
	WebElement address1textbox;

	@FindBy(id="BillingNewAddress_ZipPostalCode")
	WebElement zipcodetextbox;

	@FindBy(id="BillingNewAddress_PhoneNumber")
	WebElement phonenumber;

	@FindBy(css="button.button-1.new-address-next-step-button")
	WebElement continuebtn;

	@FindBy(css="button.button-1.shipping-method-next-step-button")
	WebElement shippingcontinuebtn;

	@FindBy(css="button.button-1.payment-method-next-step-button")
	WebElement paymentcontinuebtn;

	@FindBy(css="button.button-1.payment-info-next-step-button")
	WebElement paymentnextstepcontinuebtn;

	@FindBy(css="button.button-1.confirm-order-next-step-button")
	WebElement confirmbtn;

	@FindBy(css="h1")
	public WebElement successlbl;

	@FindBy(css="div.details-link")
	WebElement moredetails;

	@FindBy(css="button.button-1.order-completed-continue-button")
	WebElement completedcontinuebtn;


	public void shippingdetails(String city, String number, String zipcode, String address) throws InterruptedException {

		select = new Select(countrylist);
		select.selectByVisibleText("Egypt");	
		settext(citytextbox, city);
		settext(address1textbox, address);
		settext(zipcodetextbox, zipcode);
		settext(phonenumber, number);
		clickbutton(continuebtn);
		Thread.sleep(2000);
		clickbutton(shippingcontinuebtn);
		Thread.sleep(2000);
		clickbutton(paymentcontinuebtn);
		Thread.sleep(2000);
		clickbutton(paymentnextstepcontinuebtn);
		Thread.sleep(2000);
		clickbutton(confirmbtn);
	}
	public void completeshipping() {
		clickbutton(completedcontinuebtn);
	}
	
}
