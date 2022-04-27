package Utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	public static File file;
	public static FileInputStream fis;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	ExcelRead erObj;

	public void setExcelPath() throws Exception {
		this.file = new File(
				System.getProperty("user.dir") + "\\src\\main\\resources\\Excel Files\\GroceryStoreLoginData.xlsx");
		this.fis = new FileInputStream(file);
		this.workbook = new XSSFWorkbook(fis);
		this.sheet = workbook.getSheet("LoginCredentials");

	}

	public String[] readLoginCredentialsFromExcel() throws Exception {
		erObj = new ExcelRead();
		erObj.setExcelPath();
		String username = sheet.getRow(1).getCell(0).getStringCellValue();
		String password = sheet.getRow(1).getCell(1).getStringCellValue();
		workbook.close();
		fis.close();
		return new String[] { username, password };
	}

	/*
	 * public String[] readInvalidLoginCredentialsFrExcel() throws Exception {
	 * 
	 * String username = sheet.getRow(2).getCell(0).getStringCellValue(); String
	 * password = sheet.getRow(2).getCell(1).getStringCellValue(); workbook.close();
	 * fis.close(); return new String[] { username, password }; }
	 */

}
