package pages;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparePage extends PageBase{

	public ComparePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText = "CLEAR LIST")
	WebElement clearListBtn;
	
	@FindBy(css = "table.compare-products-table")
	WebElement compareTable;
	
	@FindBy(css = "div.no-data")
	WebElement noData;
	
	@FindBy(tagName = "tr")
	List<WebElement> allRows;
	
	@FindBy(tagName = "td")
	List<WebElement> allColumns;
	
	public void clearCompareTable() {
		
		clickBtn(clearListBtn);
	}
	
	public void CompareProducts() {
		
		System.out.println(allRows.size());
		for (WebElement row  : allRows) 
		{
			System.out.println(row.getText() + "\t");
//			for(WebElement col : allColumns) 
//			{
//				System.out.println(col.getText() + "\t");
//			}
		}
	}
	
}
