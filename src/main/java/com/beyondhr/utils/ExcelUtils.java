package com.beyondhr.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	@SuppressWarnings("null")
	public static Object[][] getTestcaseAllData(String testCaseName, String sheetName, String filePath) {
		Object[][] testCasedata = null;
		try {
			FileInputStream excelFile = new FileInputStream(filePath);
			@SuppressWarnings("resource")
			Workbook myWorkbook = new XSSFWorkbook(excelFile);
			Sheet mySheet = myWorkbook.getSheet(sheetName);
			for (int rowIteration = 1; rowIteration < mySheet.getPhysicalNumberOfRows(); rowIteration++) {
				Row row = mySheet.getRow(rowIteration);
				if (row.getCell(0).getStringCellValue().equals(testCaseName)) { // Getting the row where testCase Name Matches
					testCasedata = new Object[1][getNumberOfColumns(row)];
					for (int cellIteration = 1; cellIteration < row.getLastCellNum(); cellIteration++)
						testCasedata[0][cellIteration-1] = row.getCell(cellIteration).getStringCellValue();
				}
					
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return testCasedata;
	}
	
	private static int getNumberOfColumns(Row excelRow) {		
		return excelRow.getPhysicalNumberOfCells()-1;
	}

	public static String getCellData(String testCaseName, String cellName, String sheetName, String filePath) {
		int requiredcellNumber = 0;
		String cellValue = null;
		try {
			FileInputStream excelFile = new FileInputStream(filePath);
			@SuppressWarnings("resource")
			Workbook myWorkbook = new XSSFWorkbook(excelFile);
			Sheet mySheet = myWorkbook.getSheet(sheetName);
			for (int cellIterate = 0; cellIterate < mySheet.getRow(0).getLastCellNum(); cellIterate++) {
				if (mySheet.getRow(0).getCell(cellIterate).getStringCellValue().equals(cellName))
					requiredcellNumber = cellIterate;
			}
			for (int rowIteration = 0; rowIteration < mySheet.getLastRowNum(); rowIteration++) {
				Row row = mySheet.getRow(rowIteration);
				if (row.getCell(0).getStringCellValue().equals(testCaseName)) {// Getting the row where testCase Name Matches
					cellValue = row.getCell(requiredcellNumber).getStringCellValue();
					break;
				}					
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cellValue;
	}

}