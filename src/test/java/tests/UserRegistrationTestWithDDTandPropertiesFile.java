package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTandPropertiesFile extends TestBase {

	HomePage homeObject;
	UserRegistrationPage userRegObject;
	LoginPage loginPage;
	String firstname = LoadProperties.userdata.getProperty("firstname");
	String lastname = LoadProperties.userdata.getProperty("lastname");
	String email = LoadProperties.userdata.getProperty("email");
	String password = LoadProperties.userdata.getProperty("pass");
	
	@Test(priority = 1, alwaysRun = true)
	public void registerUserSuccessfully() {
		
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		
		userRegObject = new UserRegistrationPage(driver);
		userRegObject.userRegistration(firstname, lastname, email, password);
		
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
		loginPage.userLogin(email, password);
		
		assertTrue(userRegObject.logOutLink.isDisplayed());
		
	}
	
}
