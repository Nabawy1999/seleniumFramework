package tests;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductTest extends TestBase {

	String productName = "Apple MacBook Pro";
	String subProductName = "Mac";
	SearchPage searchObject;
	ProductDetailsPage productObject;

	@Test(enabled = true, priority = 2)
	public void userCanSearchProductTest() {

		searchObject = new SearchPage(driver);
		searchObject.searchBoxSearchBtn(productName);
		searchObject.openProductDetailsPage();

		productObject = new ProductDetailsPage(driver);	
		assertTrue(productObject.product.isDisplayed());
	}
	
	@Test(enabled = true, priority = 1)
	public void userCanSearchProductAutoSuggestTest() {
		
		searchObject = new SearchPage(driver);
		searchObject.searchBoxAutoSuggest(subProductName);

		productObject = new ProductDetailsPage(driver);	
		assertTrue(productObject.product.isDisplayed());
	}
	
	
}
