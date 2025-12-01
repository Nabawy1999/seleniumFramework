package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase{

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name = "updatecart")
	WebElement removeBtn ;
	
	@FindBy(css = "span.product-subtotal")
	WebElement total;
	
	@FindBy(className = "qty-input")
	WebElement quantityTxt;
	
	@FindBy(id = "checkout")
	WebElement checkOutBtn;
	
	@FindBy(id = "termsofservice")
	WebElement agreeTermsCheckBox;
	
	
	public void removeProductFromCart() {
		
		clickBtn(removeBtn);	
	}
	
	public void updateProductQuantity(String quantity) {
		
		clearText(quantityTxt);
		textBoxSetText(quantityTxt, quantity);
		quantityTxt.submit();
	}
	
	
	public void openCheckOutPage() {
		
		clickBtn(agreeTermsCheckBox);
		clickBtn(checkOutBtn);
		
	}
	
	
}
