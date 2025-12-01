package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;

public class ProductHoverMenuTest extends TestBase {
	
	HomePage homePage;
	
	@Test
	public void productHoverMenuTest() {
		
		homePage = new HomePage(driver);
		homePage.selectNotebooksMenu();
		assertTrue(driver.getCurrentUrl().contains("notebooks"));
		
	}

}
