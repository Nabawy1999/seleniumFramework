package tests;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import data.JsonDataReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTandJSON extends TestBase {

	HomePage homeObject;
	UserRegistrationPage userRegObject;
	LoginPage loginPage;
	
	@Test(priority = 1, alwaysRun = true)
	public void registerUserSuccessfully() throws FileNotFoundException, IOException, ParseException {
		
		JsonDataReader jsonReader = new JsonDataReader();
		jsonReader.jsonReader();
		
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		
		userRegObject = new UserRegistrationPage(driver);
		userRegObject.userRegistration(jsonReader.firstname, jsonReader.lastname, jsonReader.email, jsonReader.password);
		
		assertTrue(userRegObject.confMessage.getText().equals("Your registration completed"));
		
		userRegObject.userLogOut();
		
		homeObject.openLoginPage();
		
		loginPage = new LoginPage(driver);
		loginPage.userLogin(jsonReader.email, jsonReader.password);
		
		assertTrue(userRegObject.logOutLink.isDisplayed());
	
		userRegObject.userLogOut();
	}



}
