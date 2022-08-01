package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegisterationPage extends PageBase {

	public UserRegisterationPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="gender-male")
	WebElement genderBtn;

	@FindBy(id="FirstName")
	WebElement FirstNameTxtBox;

	@FindBy(id="LastName")
	WebElement LastNameTxtBox;

	@FindBy(id="Email")
	WebElement EmailTxtBox;

	@FindBy(id="Password")
	WebElement PasswordTxtBox;

	@FindBy(id="ConfirmPassword")
	WebElement ConfirmPasswordTxtBox;

	@FindBy(id="register-button")
	WebElement registerbtn;

	@FindBy(css="div.result")
	public WebElement successmsg; // Public to appear in test case

	@FindBy(css = "a.ico-logout")
	public WebElement logoutbutton;

	@FindBy(css="a.ico-account")
	WebElement MyAccountLink;

	public void userregisteration(String firstname,String lastname,String email, String password ) {
		clickbutton(genderBtn);
		settext(FirstNameTxtBox,firstname);
		settext(LastNameTxtBox, lastname);
		settext(EmailTxtBox, email);
		settext(PasswordTxtBox, password);
		settext(ConfirmPasswordTxtBox, password);
		clickbutton(registerbtn);
	}
	public void usercanlogout() {
		clickbutton(logoutbutton);
	}
	public void usercanopenmyaccount() {
		clickbutton(MyAccountLink);
	}
}