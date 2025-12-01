package tests;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class AddProductToShoppingCart extends TestBase{


	SearchPage search;
	ProductDetailsPage productPage;
	ShoppingCartPage shoppingCartPage;
	String subProductName = "MacB";

	@Test(enabled = true, priority = 1)
	public void userCanSearchProductAutoSuggestTest() {

		search = new SearchPage(driver);
		search.searchBoxAutoSuggest(subProductName);

		productPage = new ProductDetailsPage(driver);	
		assertTrue(productPage.product.isDisplayed());
	}
	
	@Test(enabled = true, priority =2)
	public void userCanAddProductToCart() {
		
		productPage = new ProductDetailsPage(driver);
		productPage.addProductToCart();
		
		
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(20));
		explicitWait.until(ExpectedConditions.elementToBeClickable(productPage.shoppingCartHyperLink));
		
		//using the class name directly because clickBtn meythod is static
		ProductDetailsPage.clickBtn(productPage.shoppingCartHyperLink);	
		
	}
	
	@Test(enabled = true, priority =3)
	public void userCanRemoveProductFromCart() throws InterruptedException {
		
		shoppingCartPage = new ShoppingCartPage(driver);
		
		
		shoppingCartPage.updateProductQuantity("4");

		shoppingCartPage.removeProductFromCart();
		
	}




}
