package readDataExcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData2 {

	public static void main(String[] args) throws Exception {
		
		
		FileInputStream fis = new FileInputStream("./testdata\\RegisterStudent.xls");
		
		
		//XLSX
		
		HSSFWorkbook workbook = new HSSFWorkbook(fis);
		
		HSSFSheet sheet = workbook.getSheet("smokeTest");
		//XSSFSheet sheet = workbook.getSheet("Student");
		//workbook.getSheetAt(0);
		
		//get no of records in sheet
		
		int rowsCount = sheet.getLastRowNum();
		int columnsCount = sheet.getRow(0).getLastCellNum();
		
		
		System.out.println("No of Rows: " + rowsCount);
		System.out.println("No of Columns: " + columnsCount);
		
		
		
		for (int i = 1; i <= rowsCount; i++) {
			
			
				HSSFRow currentRow = sheet.getRow(i);
			
//					for (int j = 0; j < columnsCount; j++) {
//						
//						String firstName = currentRow.getCell(j).toString();
//						
//						System.out.println("FirstName: " + firstName);
//						
//					}
				
				
				String fName = currentRow.getCell(0).toString();
				String lName = currentRow.getCell(1).toString();
				String email = currentRow.getCell(2).toString();
				String phone = currentRow.getCell(3).toString();
				String address = currentRow.getCell(4).toString();
				
				
				System.out.println("FirstName: " + fName);
				System.out.println("Address : " + address);
				System.out.println("==========================================");
			
		}
		
		
		

	}

}
