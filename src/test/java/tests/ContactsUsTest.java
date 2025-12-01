package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactsUsTest extends TestBase{

	HomePage homePage;
	ContactUsPage contactUsPage;
	
	String name = "youssef nabawy";
	String email = "nab@nabawy.com";
	String enquiry = "elhamdulellah";
	
	@Test
	public void contactUsPageTest() {
		
		homePage = new HomePage(driver);
		homePage.openContactUsPage();

		contactUsPage = new ContactUsPage(driver);
		
		contactUsPage.sendEnquiry(name, email, enquiry);
		assertTrue(contactUsPage.successMessage.getText().contains("Your enquiry has been successfully sent to the store owner."));
		
	}
	
}
