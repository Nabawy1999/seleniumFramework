package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {

	//method to take screenshot when test case fail
	
	public static void captureScreenshot(WebDriver driver, String screenshotName) {
		
		try {
			// Construct the file path for the screenshot
			// It will be saved in a 'Screenshots' folder in the project directory
			Path dest = Paths.get("./screenshots", screenshotName + ".png");

			// Create the 'Screenshots' directory if it doesn't already exist
			Files.createDirectories(dest.getParent());

			// Create a file output stream to write the screenshot data
			FileOutputStream out = new FileOutputStream(dest.toFile());

			// We cast the WebDriver to TakesScreenshot to access the screenshot method
			//.getScreenshotAs(OutputType.BYTES): captures a screenshot of the browser and returns it as a byte array.
			//out.write(...): This writes the byte array of the screenshot to the file output stream, effectively saving the image file.
			out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));

			// Close the output stream to ensure the file is saved
			out.close();

		} catch (IOException e) {
			// Print an exception message to the console if something goes wrong
			System.out.println("Exception while taking screenshot: " + e.getMessage());
		}
		
	}
	
}
