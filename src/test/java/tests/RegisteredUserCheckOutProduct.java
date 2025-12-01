package tests;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pages.CheckOutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import pages.UserRegistrationPage;


public class RegisteredUserCheckOutProduct extends TestBase {
	
//	1- register user
//	2- search for product
//	3- add to cart
//	4- check out
//	5- logout
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	String productNameString = "MacBook";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ShoppingCartPage cartPage;
	CheckOutPage checkoutObject;
	
	@Test(priority = 1, alwaysRun = true)
	public void registerUserSuccessfully() {
		
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration("Youssef", "ElNabawy", "testy28.email@gmail.com", "Nabosa");
		
		assertTrue(registerObject.confMessage.getText().equals("Your registration completed"));
		
	}
	
	@Test(enabled = true, priority = 2)
	public void userCanSearchProductAutoSuggestTest() {
		
		searchObject = new SearchPage(driver);
		searchObject.searchBoxAutoSuggest(productNameString);

		detailsObject = new ProductDetailsPage(driver);	
		assertTrue(detailsObject.product.isDisplayed());
	}
	
	@Test(enabled = true, priority =3)
	public void userCanAddProductToCart() {
		
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.addProductToCart();
		
		
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(20));
		explicitWait.until(ExpectedConditions.elementToBeClickable(detailsObject.shoppingCartHyperLink));
		
		//using the class name directly because clickBtn method is static
		ProductDetailsPage.clickBtn(detailsObject.shoppingCartHyperLink);	
		
	}
	@Test(enabled = true, priority =4)
	public void userCanCheckOutProduct() throws InterruptedException {
		
		cartPage = new ShoppingCartPage(driver);
		cartPage.openCheckOutPage();
		
		checkoutObject = new CheckOutPage(driver);
		checkoutObject.registeredUserCheckOutProccess("Egypt", "Cairo", "Cairo", "rehab", "11035", "0101010", productNameString);
		assertTrue(checkoutObject.productName.isDisplayed());
		assertTrue(checkoutObject.productName.getText().contains(productNameString));
		checkoutObject.confirmOrder();
		assertTrue(checkoutObject.thankYouMessage.isDisplayed());
		
	}
	
	@Test(enabled = true, priority =5)
	public void registeredUserCanLogOut() {
		
		registerObject.userLogOut();
		
	}


}
