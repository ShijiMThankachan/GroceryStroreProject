package Utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public String[] readLoginCredentialsFromExcel() throws Exception {
		File file = new File(
				System.getProperty("user.dir") + "\\src\\main\\resources\\Excel Files\\GroceryStoreLoginData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("LoginCredentials");
		String username = sheet.getRow(1).getCell(0).getStringCellValue();
		String password = sheet.getRow(1).getCell(1).getStringCellValue();
		workbook.close();
		fis.close();
		return new String[] { username, password };
	}

//	public static void main(String[] args) throws Exception {
//		String[] loginData = readLoginCredentialsFromExcel();
//		System.out.println(loginData[0]);
//		System.out.println(loginData[1]);
//	}

}
