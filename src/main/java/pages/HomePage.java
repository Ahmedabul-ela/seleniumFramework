package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
		js = (JavascriptExecutor)driver; // will run here
		action = new Actions(driver);
	}

	@FindBy(linkText="Register")
	WebElement registerLink;

	@FindBy(linkText="Log in")
	WebElement loginLink;

	@FindBy(linkText="Contact us")
	WebElement Contactuslink;

	@FindBy(id="customerCurrency")
	WebElement changecurrency;

	@FindBy(linkText="Computers")
	WebElement computersmenue;

	@FindBy(linkText="Notebooks")
	WebElement notebooksmenue;

	public void openRegistrationPage() {
		clickbutton(registerLink);		
	}
	public void openLoginPage() {
		clickbutton(loginLink);
	}
	public void openContactUsPage() {
		ScrollToButton();
		clickbutton(Contactuslink);
	}
	public void changecurrency() {
		select = new Select(changecurrency);
		select.selectByIndex(1);
	}
	public void opennotebookmenue() {
		action.moveToElement(computersmenue).click().build().perform();
		action.moveToElement(notebooksmenue).click().build().perform();
		
	}
}