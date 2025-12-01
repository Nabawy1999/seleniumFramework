package tests;

import static org.testng.Assert.assertTrue;

import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTandOpenCSV extends TestBase {

	HomePage homeObject;
	UserRegistrationPage userRegObject;
	LoginPage loginPage;
	String firstname;
	String lastname;
	String email;
	String password;
	
	CSVReader reader;
	
	@Test(priority = 1, alwaysRun = true)
	public void registerUserSuccessfully() throws IOException, CsvValidationException {
		
		String csvFile = System.getProperty("user.dir") + "\\src\\test\\java\\data\\CSV_UserData.csv" ;
		reader = new CSVReader(new FileReader(csvFile));
		
		String[] csvCell;
		
		while((csvCell = reader.readNext()) != null ) {
			
			firstname = csvCell[0];
			lastname = csvCell[1];
			email = csvCell[2];
			password = csvCell[3];
			
			homeObject = new HomePage(driver);
			homeObject.openRegistrationPage();
			
			userRegObject = new UserRegistrationPage(driver);
			userRegObject.userRegistration(firstname, lastname, email, password);
			
			assertTrue(userRegObject.confMessage.getText().equals("Your registration completed"));
			
			userRegObject.userLogOut();
			
			homeObject.openLoginPage();
			
			loginPage = new LoginPage(driver);
			loginPage.userLogin(email, password);
			
			assertTrue(userRegObject.logOutLink.isDisplayed());
			
			userRegObject.userLogOut();

			
		}
		
	}
	
}
