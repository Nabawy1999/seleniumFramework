package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver;
		action = new Actions(driver);
	}
	
	
	@FindBy(linkText = "Register")
	WebElement registrationLink;
	
	@FindBy(className = "ico-login")
	WebElement loginLink;
	
	@FindBy(linkText = "Contact us")
	WebElement contactUsLink;
	
	@FindBy(id = "customerCurrency")
	WebElement currencyDropDown;
	
	@FindBy(linkText = "Computers" )
	WebElement computerMenu;
	
	@FindBy(linkText = "Notebooks" )
	WebElement notebooksLink;
	
	public void openRegistrationPage() {
		
		clickBtn(registrationLink);
		
	}
	
	public void openLoginPage() {
		
		clickBtn(loginLink);
		
	}
	
	public void openContactUsPage() {
		
		scrollToBottom();
		clickBtn(contactUsLink);
		
	}
	
	public void changeCurrency() {
		
		select = new Select(currencyDropDown);
		//select.selectByIndex(1);
		select.selectByVisibleText("Euro");
	}
	
	public void selectNotebooksMenu() {
		
		//this is to hover over computers menu first then move to the notebooks option then click
		//action.moveToElement(computerMenu).moveToElement(notebooksMenu).click().build().perform();
		
			// Hover over the main "Computers" menu
			action.moveToElement(computerMenu).perform();
			
			// Wait for the "Notebooks" link to be visible before clicking
			WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(20));
			explicitWait.until(ExpectedConditions.visibilityOf(notebooksLink));
			
			// Click on the "Notebooks" link
			clickBtn(notebooksLink);
		
	}
	
	
	

}
