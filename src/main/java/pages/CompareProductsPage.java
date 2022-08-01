package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompareProductsPage extends PageBase {

	public CompareProductsPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(css="a.clear-list")
	WebElement clearlistbtn;

	@FindBy(css="table.compare-products-table")
	WebElement comparetable;

	@FindBy(tagName = "tr")
	List<WebElement> allrows;

	@FindBy(tagName = "td")
	List<WebElement> allcolms;

	@FindBy(linkText="Apple MacBook Pro 13-inch")
	public WebElement product1name;

	@FindBy(linkText = "Asus N551JK-XO076H Laptop")
	public WebElement product2name;

	@FindBy(css="div.no-data")
	public WebElement clearcomparelistmsg;

	public void clearcomparelist() {
		clickbutton(clearlistbtn);
	}
	public void compareproducts() {
		System.out.println(allrows.size());
		for (WebElement row : allrows) {
			System.out.println(row.getText()+"\t");
			for (WebElement colm : allcolms) {
				System.out.println(colm.getText()+"\t");
			}
		}
	}
}