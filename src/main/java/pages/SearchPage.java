package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase {

	public SearchPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "small-searchterms")
	WebElement searchTextBox;
	
	@FindBy(css = "button.button-1.search-box-button")
	WebElement searchButton;
	
	//
	@FindBy(id = "ui-id-1")
	List<WebElement> ProductList;
	
	//the macbook product that appears after you hit search for macbook
	@FindBy(linkText = "Apple MacBook Pro")
	WebElement productTitle;
	
	public void searchBoxSearchBtn(String productName) {
	
		textBoxSetText(searchTextBox, productName);
		clickBtn(searchButton);
		
	}
	
	public void openProductDetailsPage() {
		
		clickBtn(productTitle);
		
	}
	
	public void searchBoxAutoSuggest(String productName) {
		
		textBoxSetText(searchTextBox, productName);
		clickBtn(ProductList.get(0));
		
	}
	
	
	
}
