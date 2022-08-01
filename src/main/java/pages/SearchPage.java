package pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends PageBase {

	public SearchPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="small-searchterms")
	WebElement searchtextbox;

	@FindBy(css="button.button-1.search-box-button")
	WebElement searchbutton;

	@FindBy(id="ui-id-1")
	List<WebElement> productlist;

	@FindBy(css="h2.product-title")
	WebElement producttitle;

	public void productsearch(String productname) {
		settext(searchtextbox, productname);
		clickbutton(searchbutton);
	}
	public void openproductdetails() {
		clickbutton(producttitle);
	}
	public void productautosearch(String productname) throws InterruptedException {
		settext(searchtextbox, productname);
			Thread.sleep(3000);
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			//wait.until(ExpectedConditions.visibilityOfAllElements(productlist));
			productlist.get(0).click();
		}
	}