package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase {

	public ProductReviewPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="AddProductReview_Title")
	WebElement reviewtitletextbox;

	@FindBy(id="AddProductReview_ReviewText")
	WebElement reviewtexttextbox;

	@FindBy(id="addproductrating_4")
	WebElement rating4btn;

	@FindBy(css="button.button-1.write-product-review-button")
	WebElement submitreviewbtn;

	@FindBy(css="div.text-body")
	public WebElement userreview;

	public void Registeredusercanaddreview(String title, String reviewtext) {
		settext(reviewtitletextbox, title);
		settext(reviewtexttextbox, reviewtext);
		clickbutton(rating4btn);
		clickbutton(submitreviewbtn);
	}
}
