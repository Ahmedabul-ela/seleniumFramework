package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPage extends PageBase {

	public EmailFriendPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="FriendEmail")
	WebElement friendemailtextbox;

	@FindBy(id="PersonalMessage")
	WebElement personalmsgtextbox;

	@FindBy(css="button.button-1.send-email-a-friend-button")
	WebElement sendmailbtn;

	@FindBy(css="div.result")
	public WebElement sentmailconfirmmsg;

	public void sendmailtofriend(String friendmail, String personalmsg) {
		settext(friendemailtextbox, friendmail);
		settext(personalmsgtextbox, personalmsg);
		clickbutton(sendmailbtn);
	}
}
