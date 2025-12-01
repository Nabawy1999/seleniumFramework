package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase{

	public UserRegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id ="gender-male")
	WebElement genderRdoBtn;
	
	@FindBy(id ="FirstName")
	WebElement fnTxtBox;
	
	@FindBy(id ="LastName")
	WebElement lnTxtBox;
	
	@FindBy(id ="Email")
	WebElement emailTxtBox;

	@FindBy(id ="Password")
	WebElement passwordTxtBox;

	@FindBy(id ="ConfirmPassword")
	WebElement confirmPasswordTxtBox;
	
	@FindBy(id ="register-button")
	WebElement registerBtn;
	
	@FindBy(css = "div.result")
	public WebElement confMessage;
	
	//can do by linkText because its an <a href element
	@FindBy(linkText = "Log out")
	public WebElement logOutLink;
	
	@FindBy(linkText = "My account")
	public WebElement MyAccountLink;
	
	
	
	public void userRegistration(String firstname, String lastname, String email, String password) {
		
		clickBtn(genderRdoBtn);
		textBoxSetText(fnTxtBox, firstname);
		textBoxSetText(lnTxtBox, lastname);
		textBoxSetText(emailTxtBox, email);
		textBoxSetText(passwordTxtBox, password);		
		textBoxSetText(confirmPasswordTxtBox, password);		
		clickBtn(registerBtn);
		
	}

	public void userLogOut() {
		
		clickBtn(logOutLink);
	}
	
	public void openMyAccountPage() {
		
		clickBtn(MyAccountLink);
	}
	

}
