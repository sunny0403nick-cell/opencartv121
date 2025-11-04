package utilities;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

	//DataProvider 1
	
//	@DataProvider(name="LoginData")
//	public String [][] getData() throws IOException
//	{
//		String path=".\\testData\\Opencart_LoginData.xlsx";//taking xl file from testData
//		
//		ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
//		
//		int totalrows=xlutil.getRowCount("Sheet1");	
//		int totalcols=xlutil.getCellCount("Sheet1",1);
//				
//		String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
//		
//		for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
//		{		
//			for(int j=0;j<totalcols;j++)  //0    i is rows j is col
//			{
//				logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
//			}
//		}
//	return logindata;//returning two dimension array
	@DataProvider(name = "TestData")
	public Object[][] logindetails() throws IOException{
		
		String path=".\\testData\\Opencart_LoginData1.xlsx";
		
		FileInputStream file =new FileInputStream(path);
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheetAt(0);
		int rows_count=sheet.getPhysicalNumberOfRows();
		XSSFRow row=sheet.getRow(0);
		int cols_count=row.getPhysicalNumberOfCells();
		Object[][] data=new Object[rows_count-1][cols_count];
		for(int i =1;i<rows_count;i++) {
			XSSFRow row1=sheet.getRow(i);
			if(row1==null) {
				continue;
			}

			for(int j=0;j<cols_count;j++) {
				 XSSFCell cell=row1.getCell(j);
	             String cellvalue=cell.getStringCellValue();
	             data[i-1][j]=cellvalue;

			}
		}
		file.close();
		workbook.close();
		return data;
		
		
	}
	
	

	}
	
	
