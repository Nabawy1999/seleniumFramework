package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id = "Email")
	WebElement emailTextBox;
	
	@FindBy(id = "Password")
	WebElement passwordTextBox;
	
	@FindBy(css = "button.button-1.login-button")
	WebElement loginBtn;
	
	public void userLogin(String email , String password) {
		
		emailTextBox.sendKeys(email);
		passwordTextBox.sendKeys(password);
		clickBtn(loginBtn);
		
	}
	


	
	
}
