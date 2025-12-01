package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class UserRegistration extends TestBase{
	
	HomePage home;
	UserRegistrationPage registerObject;

	@Given("the user is in home page")
	public void the_user_is_in_home_page() throws InterruptedException {
		Thread.sleep(5000);
		home = new HomePage(driver);
		home.openRegistrationPage();
		
		Thread.sleep(5000); 
	}
	
	
	@When("i click on register link")
	public void i_click_on_register_link() throws InterruptedException {
	   Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	   Thread.sleep(5000); 
	}
	
	@When("i enetered user data")
	public void i_enetered_user_data() throws InterruptedException {
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration("youssef", "elnabawy", "youssef.elsabbagh@gmail.com", "xxxx");
		Thread.sleep(5000); 
	}
	@Then("the registration is successful")
	public void the_registration_is_successful() {
	   registerObject.userLogOut();
	}
	
}
