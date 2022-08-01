package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(linkText = "Change password")
	WebElement changepasswordlink;

	@FindBy(id = "OldPassword")
	WebElement oldpasswordtextbox;

	@FindBy(id = "NewPassword")
	WebElement newpasswordtextbox;

	@FindBy(id = "ConfirmNewPassword")
	WebElement confirmnewpasswordtextbox;

	@FindBy(css = "button.button-1.change-password-button")
	WebElement changepasswordbutton;

	@FindBy(css="p.content")
	public WebElement passwordchangesmsg;

	@FindBy(css = "span.close")
	WebElement closemsg;
	
	public void OpenChangePassword() {
		clickbutton(changepasswordlink);
	}
	public void closepasswordchangedmsg() {
		clickbutton(closemsg);
	}
	public void ChangePassword(String oldpassword, String newpassword) {
		settext(oldpasswordtextbox, oldpassword);
		settext(newpasswordtextbox, newpassword);
		settext(confirmnewpasswordtextbox, newpassword);
		clickbutton(changepasswordbutton);
	}
}