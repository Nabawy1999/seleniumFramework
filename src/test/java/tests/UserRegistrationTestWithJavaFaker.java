package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithJavaFaker extends TestBase {

	HomePage homeObject;
	UserRegistrationPage userRegObject;
	LoginPage loginPage;
	Faker fakeData = new Faker();
	String firstname = fakeData.name().firstName();
	String lastname = fakeData.name().lastName();
	String email = fakeData.internet().emailAddress();
	String password = fakeData.number().digits(8).toString();
	
	@Test(priority = 1, alwaysRun = true)
	public void registerUserSuccessfully() {
		
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		
		userRegObject = new UserRegistrationPage(driver);
		userRegObject.userRegistration(firstname, lastname, email, password);
		
		System.out.println("user details: " + firstname + " " + lastname + " " + email + " " + password);
		
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
		loginPage.userLogin(email,password);
		
		assertTrue(userRegObject.logOutLink.isDisplayed());
		
	}
	


}
