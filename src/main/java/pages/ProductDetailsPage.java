package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase{

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css ="strong.current-item")
	public WebElement product;
	
	@FindBy(id = "price-value-4")
	public WebElement priceValue;
	
	@FindBy(css = "button.button-2.add-to-compare-list-button")
	WebElement addToCompareBtn;
	
	@FindBy(linkText = "product comparison")
	public WebElement prodComparisonNotifLink;
	
	@FindBy(id = "add-to-cart-button-4")
	WebElement addToCartBtn;
	
	@FindBy(linkText = "shopping cart")
	public WebElement shoppingCartHyperLink;
	
	
	
	public void addProductToCompare() {
		
		clickBtn(addToCompareBtn);
	}
	
	public void addProductToCart() {
		
		clickBtn(addToCartBtn);
	}
	
	
}
