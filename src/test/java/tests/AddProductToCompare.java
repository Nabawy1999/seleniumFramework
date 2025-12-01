package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.ComparePage;
import pages.PageBase;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddProductToCompare extends TestBase{
	
	String firstProductName = "Asus Laptop";
	String secondProductName = "Apple MacBook Pro";
	
	ProductDetailsPage productDetails;
	ComparePage comparePage;
	SearchPage searchObject;
	//HomePage homePage;
	
	@Test(enabled = true, priority = 1)
	public void userCanCompareProductTest()  {
		
		searchObject = new SearchPage(driver);
		searchObject.searchBoxAutoSuggest(firstProductName);
		productDetails = new ProductDetailsPage(driver);
		comparePage = new ComparePage(driver);
		
		assertTrue(productDetails.product.isDisplayed());
		productDetails.addProductToCompare();
		
		searchObject.searchBoxAutoSuggest(secondProductName);
		assertTrue(productDetails.product.isDisplayed());
		productDetails.addProductToCompare();
		PageBase.clickBtn(productDetails.prodComparisonNotifLink);
		
		comparePage.CompareProducts();
		
		
	}
	
	@Test(enabled = true, priority = 2)
	public void userCanClearCompareList() {
		
		comparePage = new ComparePage(driver);
		comparePage.clearCompareTable();
		
	}
	
	

	
	
	
}
