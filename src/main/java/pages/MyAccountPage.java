package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase{	
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(linkText = "Change password")
	WebElement changePassLink;
	
	@FindBy(id = "OldPassword")
	WebElement oldPassLink;
	
	@FindBy(id = "NewPassword")
	WebElement newPassLink;
	
	@FindBy(id = "ConfirmNewPassword")
	WebElement confNewPassLink;
	
	@FindBy(css = "button.button-1.change-password-button")
	WebElement changePassBtn;
	
	@FindBy(css = "p.content")
	public WebElement changeSuccessful;
	
	@FindBy(css = "span.close")
	WebElement closeSuccess;
	
	public void openChangePassPage() {
		
		clickBtn(changePassLink);
	}
	
	public void changePassword(String oldPass, String newPass) {
		
		textBoxSetText(oldPassLink, oldPass);
		textBoxSetText(newPassLink, newPass);
		textBoxSetText(confNewPassLink, newPass);
		clickBtn(changePassBtn);
		
		
	}
	
	public void closeSuccessNotification() {
		
		clickBtn(closeSuccess);
		
	}
	
	
	
}
