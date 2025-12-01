package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTandDataProvider extends TestBase {

	HomePage homeObject;
	UserRegistrationPage userRegObject;
	LoginPage loginPage;
	
	@DataProvider(name = "testData")
	public static Object [][] userData(){
		
		return new Object [][] {
			
			{
				"Youssef", "ElNabawy", "testN2.email@gmail.com", "Nabawy"
			},
			{
				"Youssef", "ElSabbagh", "testS2.email@gmail.com", "Sabbagh"
			}
		};
	}
	
	@Test(priority = 1, alwaysRun = true, dataProvider = "testData")
	public void registerUserSuccessfully(String fname, String lname, String email, String pass) {
		
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		
		userRegObject = new UserRegistrationPage(driver);
		userRegObject.userRegistration(fname, lname, email, pass);
		
		assertTrue(userRegObject.confMessage.getText().equals("Your registration completed"));
		
		userRegObject.userLogOut();
		
		homeObject.openLoginPage();
		
		loginPage = new LoginPage(driver);
		loginPage.userLogin(email, pass);
		
		assertTrue(userRegObject.logOutLink.isDisplayed());
		
		userRegObject.userLogOut();
		
		
	}
	
//	@Test(dependsOnMethods = {"registerUserSuccessfully"} )
//	public void registeredUserCanLogOut() {
//		
//		userRegObject.userLogOut();
//		
//	}
//	
//	@Test(dependsOnMethods = {"registeredUserCanLogOut"})
//	public void registeredUserCanlogin() {
//		
//		homeObject.openLoginPage();
//		
//		loginPage = new LoginPage(driver);
//		loginPage.userLogin("testz9.email@gmail.com", "Nabosa");
//		
//		assertTrue(userRegObject.logOutLink.isDisplayed());
//		
//	}
//	
}
