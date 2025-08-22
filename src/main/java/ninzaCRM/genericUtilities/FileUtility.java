package ninzaCRM.genericUtilities;

import java.util.List;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

/**
 * This class consists of genric methods related to 
 * File operation like property file ,excel File
 * @author Bandi Saiteja
 */
public class FileUtility {
	/**
	 * 
	 * @param key
	 * @return value
	 * @throws IOException
	 */
	public String ReadDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
	}
	/**
	 * this method will read data from excel file and return
	 * @param sheetName
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String ReadDataFromExcelFile(String sheetName,int rownum,int cellnum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		return wb.getSheet(sheetName).getRow(rownum).getCell(cellnum).toString();
	}
	public double ReadDataFromExcelFileInInt(String sheetName,int rownum,int cellnum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		return wb.getSheet(sheetName).getRow(rownum).getCell(cellnum).getNumericCellValue();
	}
	public List ReadDataFromExcelFile(String sheetName,int rownum,int ...cellnum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		List<String> list= new ArrayList<>();
		for (int i = 0; i < cellnum.length; i++) {
			list.add(wb.getSheet(sheetName).getRow(rownum).getCell(i).toString());		
			}
		return list;
	}
	public Object[][] readDataForDataProvider() throws EncryptedDocumentException, IOException{
		Object[][] data = new Object[4][2];
		FileInputStream file = new FileInputStream("C:\\Users\\User\\eclipse-workspace\\FireFlink.NinzaCRM.AutomationFrameWork\\src\\test\\resources\\Sample.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		Sheet sheet = wb.getSheet("Sheet1");
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			Row r = sheet.getRow(i);
			for (int j = 0; j < r.getLastCellNum(); j++) {
				String value = r.getCell(j).toString();
				data[i][j]=value;
			}
		}
		return data;
		}
}
