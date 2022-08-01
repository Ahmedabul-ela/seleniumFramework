package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {

	protected WebDriver driver;  // only this package
	public JavascriptExecutor js ;
	public Select select;
	public Actions action;

	// Create Parameterized Constructor
	public PageBase(WebDriver driver) {
		PageFactory.initElements(driver, this);    // Elements in this page
	}
	protected static void clickbutton(WebElement button) {  // Protected for only this package(pages), static used for any page object w/o object
		button.click();
	}
	protected static void settext(WebElement textbox, String value) {
		textbox.sendKeys(value);
	}
	public void ScrollToButton() {
		js.executeScript("scrollBy(0,6000)");
	}
	protected static void clearelement(WebElement element) {
		element.clear();
	}
}