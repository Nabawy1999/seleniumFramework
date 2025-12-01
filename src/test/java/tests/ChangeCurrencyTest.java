package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase {
	
	HomePage homePage;
	ProductDetailsPage productDetails;
	SearchPage searchObject;
	String subProductName = "MacB";
	
	@Test(enabled = true, priority = 1)
	public void userCanChangeCurrency() {
		
		homePage = new HomePage(driver);
		homePage.changeCurrency();
	}
	
	@Test(enabled = true, priority = 2)
	public void userCanSearchProductAutoSuggestTest() {
		
		searchObject = new SearchPage(driver);
		searchObject.searchBoxAutoSuggest(subProductName);

		productDetails = new ProductDetailsPage(driver);	
		assertTrue(productDetails.product.isDisplayed());
		assertTrue(productDetails.priceValue.getText().contains("€"));
	}


}
