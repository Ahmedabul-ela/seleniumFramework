package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase {

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="FullName")
	WebElement yournametextbox;

	@FindBy(id="Email")
	WebElement yourmailtextbox;

	@FindBy(id="Enquiry")
	WebElement enquirytextbox;

	@FindBy(css="button.button-1.contact-us-button")
	WebElement submitbutton;
	
	@FindBy(css="div.result")
	public WebElement submitmessage;

	public void fillingcontactus(String name, String mail, String enquiry) {
		settext(yournametextbox, name);	
		settext(yourmailtextbox, mail);
		settext(enquirytextbox, enquiry);
		clickbutton(submitbutton);
	}
}