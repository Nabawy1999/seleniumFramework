package data;

import java.io.FileInputStream;           // Used to read bytes from a file (the properties file)
import java.io.FileNotFoundException;     // Exception thrown if the file specified by path doesn't exist
import java.io.IOException;               // General exception for input/output operations
import java.util.Properties;              // Class used to load and manage key-value pairs from the properties file

// Class responsible for loading configuration data from a properties file
public class LoadProperties {

	// load the properties file from the folder and store its contents
	public static Properties userdata = loadProperties(
			
			// Construct the full path to the 'userdata.properties' file
			System.getProperty("user.dir") + ("\\src\\main\\java\\properties\\userdata.properties")
			
			);


	// Private method to handle the actual loading of the properties file
	private static Properties loadProperties(String path) {
		Properties pro = new Properties(); // Create a new Properties object to hold the data
		
		try {
			// Create a stream to read data from the file specified by 'path'
			FileInputStream stream = new FileInputStream(path); 
			// Load the key-value pairs from the stream into the Properties object
			pro.load(stream); 
		} catch (FileNotFoundException e) {
			// Catch and print an error if the file is not found
			System.out.println("Error message: " + e.getMessage());
			
		} catch (IOException e) {
			// Catch and print an error for any general IO issues (e.g., failed read/write)
			System.out.println("Error message: " + e.getMessage());
			
		} catch (NullPointerException e) {
			System.out.println("Error message: " + e.getMessage());
			
		}
		
		
		return pro; // Return the populated Properties object
	}
	
	
	
}