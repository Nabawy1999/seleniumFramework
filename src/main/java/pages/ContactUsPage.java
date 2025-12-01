package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase {

	public ContactUsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id = "FullName")
	WebElement nameTextBox;
	
	@FindBy(id = "Email")
	WebElement emailTextBox;
	
	@FindBy(id = "Enquiry")
	WebElement enquiryTextBox;
	
	@FindBy(name = "send-email")
	WebElement submitBtn;
	
	@FindBy(css = "div.result")
	public WebElement successMessage;
	
	public void sendEnquiry(String name, String email, String enquiry) {
		
		textBoxSetText(nameTextBox, name);
		textBoxSetText(emailTextBox, email);
		textBoxSetText(enquiryTextBox, enquiry);
		clickBtn(submitBtn);
		
	}
}
