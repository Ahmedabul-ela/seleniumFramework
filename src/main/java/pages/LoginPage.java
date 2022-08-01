package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="Email")
	WebElement emailtxtbox;
	
	@FindBy(id="Password")
	WebElement Passwordtxtbox;
	
	@FindBy(css = "button.button-1.login-button")
	WebElement loginbutton;

	public void userlogin(String email,String passward) {
		settext(emailtxtbox, email);
		settext(Passwordtxtbox, passward);
		clickbutton(loginbutton);
	}
}