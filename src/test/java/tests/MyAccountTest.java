package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase {
	
	HomePage homeObject;
	UserRegistrationPage userRegObject;
	LoginPage loginPage;
	MyAccountPage myAccountPage;
	String oldPass = "Nabosa";
	String newPass = "Naboobs";
	String firstName = "Youssef";
	String lastName = "ElNabawy";
	String email = "test16.email@gmail.com";
	
	@Test(priority = 1, alwaysRun = true)
	public void registerUserSuccessfully() {
		
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		
		userRegObject = new UserRegistrationPage(driver);
		userRegObject.userRegistration(firstName, lastName, email, oldPass);
		
		assertTrue(userRegObject.confMessage.getText().equals("Your registration completed"));
		
	}

	
	@Test(dependsOnMethods = {"registerUserSuccessfully"})
	public void registeredUserCanChangePass() {
		
		userRegObject.openMyAccountPage();
		myAccountPage = new MyAccountPage(driver);
		myAccountPage.openChangePassPage();
		myAccountPage.changePassword(oldPass, newPass);
		assertTrue(myAccountPage.changeSuccessful.isDisplayed());
		myAccountPage.closeSuccessNotification();
	}
	
	@Test(dependsOnMethods = {"registeredUserCanChangePass()"} )
	public void registeredUserCanLogOut() {
		
		userRegObject.userLogOut();
		
	}
	
	@Test(dependsOnMethods = {"registeredUserCanLogOut"})
	public void registeredUserCanlogin() {
		
		homeObject.openLoginPage();
		
		loginPage = new LoginPage(driver);
		loginPage.userLogin(email, newPass);
		
		assertTrue(userRegObject.logOutLink.isDisplayed());
		
	}
	
	


}
