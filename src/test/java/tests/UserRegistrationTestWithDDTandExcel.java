package tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTandExcel extends TestBase {

	HomePage homeObject;
	UserRegistrationPage userRegObject;
	LoginPage loginPage;
	String firstname = LoadProperties.userdata.getProperty("firstname");
	String lastname = LoadProperties.userdata.getProperty("lastname");
	String email = LoadProperties.userdata.getProperty("email");
	String password = LoadProperties.userdata.getProperty("pass");
	
	
	@DataProvider(name = "excelData")
	public Object[][] userRegisterData() throws IOException{
		
		ExcelReader excel = new ExcelReader();
		
		return excel.getExcelData();
	}
	
	
	
	@Test(alwaysRun = true, dataProvider = "excelData")
	public void registerUserSuccessfully(String firstName, String lastName, String email, String password) {
		
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		
		userRegObject = new UserRegistrationPage(driver);
		userRegObject.userRegistration(firstName, lastName, email, password);
		
		assertTrue(userRegObject.confMessage.getText().equals("Your registration completed"));
		
		userRegObject.userLogOut();
		
		homeObject.openLoginPage();
		
		loginPage = new LoginPage(driver);
		loginPage.userLogin(email, password);
		
		assertTrue(userRegObject.logOutLink.isDisplayed());
		
		userRegObject.userLogOut();
	}
	
	
	
}
