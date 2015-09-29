package com.franconnect.baseutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.google.common.collect.Iterators;
import com.thoughtworks.selenium.webdriven.commands.FireEvent;

public class ExcelMethods {	
	
	public static String createTestCaseFormat() throws IOException{
		HSSFWorkbook workbook=new HSSFWorkbook();
		String filename;
		filename="C://FC905Project/WorkSpace001/FranConnect905/TestResults/Result.xls";
		//System.out.println("createTestCaseFormat"+filename);
	    FileOutputStream fileOut = new FileOutputStream(filename);
		HSSFSheet firstsheet=workbook.createSheet("Result");
		Row row;
		Cell cell;
		
		HSSFCellStyle style=workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		
		String tcformat[]={"TC_ID","Test Summary","Test Description","Test Steps","Test Data","Expected Result","Actual Result","Status","Screenshot","Remarks"};
		//System.out.println("Length of Array : "+tcformat.length);
		for(int rownum=0;rownum<1;rownum++){
			row = firstsheet.createRow(rownum);
			for(int cellnum=0;cellnum<tcformat.length;cellnum++){
				cell=row.createCell(cellnum);
				cell.setCellType(0);
				cell.setCellValue(tcformat[cellnum]);
				//firstsheet.autoSizeColumn(cellnum);
				firstsheet.setColumnWidth(cellnum, 6000);
				row.getCell(cellnum).setCellStyle(style); 
			}
		}
		firstsheet.setColumnWidth(0, 3000);
		firstsheet.setColumnWidth(4, 3000);
		firstsheet.setColumnWidth(7, 3000);
		firstsheet.setColumnWidth(8, 3000);
	    workbook.write(fileOut);
	    fileOut.close();
		return filename;
	}
	
	public static Row createExcelRow(HSSFWorkbook workbook,Sheet sheetname) throws IOException{
		FileOutputStream fileout = new FileOutputStream("F://MTFC805/Workspaces/WS2/FranConnect/TestResults/Result.xls");
		Row row= sheetname.createRow(0);
		workbook.write(fileout);
		fileout.close();
		return row;
		
	}
	public static void createExcelCell(HSSFWorkbook workbook,Sheet sheetname, Row row) throws IOException{
		FileOutputStream fileout = new FileOutputStream("F://MTFC805/Workspaces/WS2/FranConnect/TestResults/Result.xls");
		Cell cell= row.createCell(0);
		cell.setCellType(0);
		cell.setCellValue(0);
		workbook.write(fileout);
		fileout.close();
	}
	public static HSSFWorkbook createExcelWorkBook() throws IOException{
		HSSFWorkbook workbook=new HSSFWorkbook();
		FileOutputStream fileout=new FileOutputStream("F://MTFC805/Workspaces/WS2/FranConnect/workbook.xls");
		workbook.write(fileout);
		fileout.close();
		return workbook;
	}
	public static Sheet createExcelWorkSheet(HSSFWorkbook workbook,String sheetname) throws IOException{
		FileOutputStream fileout = new FileOutputStream("F://MTFC805/Workspaces/WS2/FranConnect/workbook.xls");		
		Sheet sheet=workbook.createSheet(sheetname);
		workbook.write(fileout);
		fileout.close();
		return sheet;
	}
	
	//without blank values
	public static <E> void readExcelSheet() throws IOException{
		
		File file =  new File("F://MTFC805/Workspaces/WS2/FranConnect/TestCases/Users.xls");
		FileInputStream filein=new FileInputStream(file);
		Workbook workbook = new HSSFWorkbook(filein);
		
		Sheet sheetname = workbook.getSheet("Test Data");
		Row row=sheetname.getRow(1);
		Iterator<Cell> cells=row.cellIterator();
		int x=0;
		while (cells.hasNext()){
			//System.out.println(cells.next());
			x++;
		}
		//System.out.println(x);
		int sizeofiterator;
		
	}
	
	public static String[] readTestData(String excelwbpath, String excelwbname, String excelsheetname) throws IOException{
		
		File file =  new File(excelwbpath+excelwbname);
		FileInputStream filein=new FileInputStream(file);
		System.out.println(file.getAbsolutePath());
		Workbook workbook = new HSSFWorkbook(filein);
		Sheet sheetname = workbook.getSheet(excelsheetname);
		Row row=sheetname.getRow(0);
		int sizeofcells= row.getLastCellNum();
		row=sheetname.getRow(1);
		String[] arr=new String[sizeofcells];
		for (int x=0;x<sizeofcells;x++){
			Cell cell=row.getCell(x,Row.CREATE_NULL_AS_BLANK);
			//System.out.println(cell.toString());
			arr[x]=cell.toString();
		}
		for (int y=0;y<arr.length;y++){
			if(arr[y].isEmpty()){
				//System.out.println("No Value Found!");
			}
			else{
				//System.out.println(arr[y]);
			}
		}
		return arr;
	}
	
public static String[] readTestData1(String workbookpath, String workbookname, String sheetname2) throws IOException{
		
		workbookpath="F://MTFC805/Workspaces/WS2/FranConnect/TestCases/";
		workbookname="Users.xls";
		String wb = workbookpath+workbookname;
		//"F://MTFC805/Workspaces/WS2/FranConnect/TestCases/Users.xls"
		System.out.println(wb);
		File file =  new File(wb);
		FileInputStream filein=new FileInputStream(file);
		Workbook workbook = new HSSFWorkbook(filein);
		Sheet sheetname = workbook.getSheet("Test Data");
		Row row=sheetname.getRow(0);
		int sizeofcells= row.getLastCellNum();
		row=sheetname.getRow(1);
		String[] arr=new String[sizeofcells];
		for (int x=0;x<sizeofcells;x++){
			Cell cell=row.getCell(x,Row.CREATE_NULL_AS_BLANK);
			//System.out.println(cell.toString());
			arr[x]=cell.toString();
		}
		for (int y=0;y<arr.length;y++){
			if(arr[y].isEmpty()){
				//System.out.println("No Value Found!");
			}
			else{
				//System.out.println(arr[y]);
			}
		}
		return arr;
	}
	
	public static String[] readTestCases() throws IOException{
		
		File file =  new File("C://FC905Project/WorkSpace001/FranConnect905/TestCases/Users.xls");
		FileInputStream filein=new FileInputStream(file);
		Workbook workbook = new HSSFWorkbook(filein);
		Sheet sheetname = workbook.getSheet("Test Cases");
		//System.out.println("Reading Test Cases sheet!");
		Row row=sheetname.getRow(0);
		int sizeofcells= row.getLastCellNum();
		row=sheetname.getRow(1);
		String[] arr=new String[sizeofcells];
		for (int x=0;x<sizeofcells;x++){
			Cell cell=row.getCell(x,Row.CREATE_NULL_AS_BLANK);
			//System.out.println(cell.toString());
			arr[x]=cell.toString();
			//System.out.println("value of arr : "+arr[x]);
		}
		for (int y=0;y<arr.length;y++){
			if(arr[y].isEmpty()){
				//System.out.println("No Value Found!");
			}
			else{
				//System.out.println(arr[y]);
			}
		}
		return arr;
	}
	
	@Test
	public static void printTestResult() throws IOException{
		String filename=createTestCaseFormat();
		
		FileInputStream fis=new FileInputStream(filename);
		HSSFWorkbook wb=new HSSFWorkbook(fis);
		HSSFSheet sheet=wb.getSheet("Result");
		Row row=sheet.getRow(0);
		
		Cell cell=null;
		
		int rowid=sheet.getLastRowNum();
		
		int cellcount=row.getLastCellNum();
		
		row = sheet.createRow(rowid+1);
		
		String[] testcase=readTestCases();
		int testcasecellcount = testcase.length;
		
//		String[] testcasevariable=TestCaseValidation.validateTestCase();
//		
//		for (int x=0;x<testcasecellcount-4;x++){
//			System.out.println(x);
//			cell=row.createCell(x);
//			cell.setCellType(0);
//			cell.setCellValue(testcase[x]);
//			
//			System.out.println("---------------------------"+testcase[x]);
//		}
//		
//
//		for (int x=6;x<10;x++){
//			cell=row.createCell(x);
//			cell.setCellType(0);
//			cell.setCellValue(testcasevariable[x-6]);
//			
//			//System.out.println("---------------------------"+testcasevariable[x-testcasecellcount]);
//		}
				
		fis.close();
		FileOutputStream fout=new FileOutputStream(filename);
		wb.write(fout);
		fout.close();
	}
	public static void updateExcelSheet(){
		
	}
}