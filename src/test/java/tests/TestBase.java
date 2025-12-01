package tests;

import java.io.IOException;
import java.time.Duration;

import java.util.HashMap;

import java.util.Map;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utilities.Helper;




public class TestBase extends AbstractTestNGCucumberTests{
	
	public static WebDriver driver;
	
	@BeforeSuite
	@Parameters({"browser"})
	//browserName value will be passed from the @Parameters({"browser"}) coming from the testng.xml file
	//@Optional ("chrome") means that just in case @Parameters({"browser"}) is equal null, take the value chrome
	//why would it be null? if you run from a test case class not from the testng.xml
	public void startDriver(@Optional ("chrome") String browserName) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, IOException {
		
		
		if(browserName.equalsIgnoreCase("chrome")) {
	        // Create ChromeOptions object
	        ChromeOptions options = new ChromeOptions();

	        // Create a Map to hold preferences
	        Map<String, Object> prefs = new HashMap<>();
	        prefs.put("autofill.profile_enabled", false); // Disable "Save address?" popup

	        // Set the experimental option with the preferences
	        options.setExperimentalOption("prefs", prefs);
	       // options.addArguments("--headless=new"); // For Chrome versions 109+
	        
	        

	        // Initialize ChromeDriver with the configured options
	        driver = new ChromeDriver(options);	

			
		}else if(browserName.equalsIgnoreCase("firefox")) {
			
			driver = new FirefoxDriver();
			
		} else if (browserName.equalsIgnoreCase("edge")) {
			
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.navigate().to("https://demo.nopcommerce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
	//AfterSuite so when the whole test suite is finished the driver quits not after one test case in the test suite 
	//if you have multiple test cases running in your test suite
	@AfterSuite
	public void stopDriver() {

		driver.quit();

	}
	
	@AfterMethod
	public void screenshotOnFailure(ITestResult result) {
		
		if (result.getStatus() == ITestResult.FAILURE) {
			
			System.out.println("Test failed");
			System.out.println("Taking Screenshot");
			Helper.captureScreenshot(driver, result.getName());
		}
		
	}
	
}
