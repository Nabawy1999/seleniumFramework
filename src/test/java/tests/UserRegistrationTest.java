package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase {

	HomePage homeObject;
	UserRegistrationPage userRegObject;
	LoginPage loginPage;
	
	@Test(priority = 1, alwaysRun = true)
	public void registerUserSuccessfully() {
		
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		
		userRegObject = new UserRegistrationPage(driver);
		userRegObject.userRegistration("Youssef", "ElNabawy", "testz9.email@gmail.com", "Nabosa");
		
		assertTrue(userRegObject.confMessage.getText().equals("Your registration completed"));
		
	}
	
	@Test(dependsOnMethods = {"registerUserSuccessfully"} )
	public void registeredUserCanLogOut() {
		
		userRegObject.userLogOut();
		
	}
	
	@Test(dependsOnMethods = {"registeredUserCanLogOut"})
	public void registeredUserCanlogin() {
		
		homeObject.openLoginPage();
		
		loginPage = new LoginPage(driver);
		loginPage.userLogin("testz9.email@gmail.com", "Nabosa");
		
		assertTrue(userRegObject.logOutLink.isDisplayed());
		
	}
	


}
