package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static FileInputStream fiS = null;
	
	public FileInputStream getFileInputStream() {
		
		String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\data\\UserData.xlsx";
		File srcFile = new File(filePath);
		
		try {
			fiS = new FileInputStream(srcFile);
		} catch (FileNotFoundException e) {
			
			System.out.println("excel file not found: " + e.getMessage());
			System.exit(0);
		}
		return fiS;
	}
	
	public Object[][] getExcelData() throws IOException{
		
		fiS = getFileInputStream();
		XSSFWorkbook wb = new XSSFWorkbook(fiS);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		int totalNumOfRows = sheet.getLastRowNum()+1;
		int totalNumOfColumns = 4;
		
		String[][] arrayExcelData = new String[totalNumOfRows][totalNumOfColumns];
		
		for(int i=0; i< totalNumOfRows; i++) {
			
			for(int j=0; j< totalNumOfColumns; j++) {
				
				XSSFRow row = sheet.getRow(i);
				arrayExcelData[i][j] = row.getCell(j).toString();
			}
		
		}
		
		wb.close();
		return arrayExcelData;
		
	}
	
}
