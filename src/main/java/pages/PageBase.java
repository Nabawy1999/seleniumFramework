package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class PageBase {
	
	protected WebDriver driver;
	public JavascriptExecutor jse;
	public Select select;
	public Actions action;
	
	//create constructor
	public PageBase(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	public static void clickBtn(WebElement element) {
		
		element.click();
		
	}
	
	public static void textBoxSetText(WebElement element, String value) {
		
		element.sendKeys(value);
		
	}
	
	public void scrollToBottom() {
		
//		Long height= (Long) jse.executeScript("var scrollHeight = document.body.scrollHeight; return scrollHeight");
//		System.out.println(height);
		jse.executeScript("scrollBy(0,2500)");
		
	}
	
	public static void clearText(WebElement element) {

		element.clear();

	}
	 
	

}
