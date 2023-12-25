package com.clinic.configuration;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelUtils {
	private Sheet excelWSheet;
	private Workbook excelWBook;
	private Cell cell;
	private Row row;
	//private static MissingCellPolicy Row;
	
	public ExcelUtils(String path, String sheetName) {
		// TODO Auto-generated method stub
		try {
			// Open the Excel file
			FileInputStream excelFile = new FileInputStream(path);
			// Access the required test data sheet
//			excelWBook = new XSSFWorkbook(excelFile);
			excelWBook = WorkbookFactory.create(excelFile);
			excelWSheet = excelWBook.getSheet(sheetName);
			Log.info("Excel sheet opened");
			//excelWBook.setMissingCellPolicy(Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public void setExcelFile(String path, String sheetName) throws Exception {
		try {
			// Open the Excel file
			FileInputStream excelFile = new FileInputStream(path);
			// Access the required test data sheet
//			excelWBook = new XSSFWorkbook(excelFile);
			excelWBook = WorkbookFactory.create(excelFile);
			excelWSheet = excelWBook.getSheet(sheetName);
			Log.info("Excel sheet opened");
			//excelWBook.setMissingCellPolicy(Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
		} catch (Exception e) {
			System.err.println("setExcelFile: "+e.getMessage());
			throw (e);
		}
	}

	public String getCellData(int rowNum, int colNum) throws Exception {
		try {
			cell = excelWSheet.getRow(rowNum).getCell(colNum);
			String cellData = cell.getStringCellValue();
			return cellData;
		} catch (Exception e) {
			System.err.println("getCellData: "+e.getMessage());
			return "";
		}
	}

	// This method is to write in the Excel cell, Row num and Col num are the
	// parameters
	@SuppressWarnings("static-access")
	public void setCellData(String result, int rowNum, int colNum) throws Exception {
		try {
			row = excelWSheet.getRow(rowNum);
			cell = row.getCell(colNum,Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
			if (cell == null) {
				cell = row.createCell(colNum);
				cell.setCellValue(result);
			} else {
				cell.setCellValue(result);
			}
			// Constant variables Test Data path and Test Data file name
			FileOutputStream fileOut = new FileOutputStream(Constant.pathTestData + Constant.fileTestData);
			excelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			throw (e);
		}
	}

	public int getRowContains(String sTestCaseName, int colNum) throws Exception {
		int i;
		try {
			int rowCount = getRowUsed();
			for (i = 0; i < rowCount; i++) {
				if (getCellData(i, colNum).equalsIgnoreCase(sTestCaseName)) {
					break;
				}
			}
			return i;
		} catch (Exception e) {
			Log.error("Class ExcelUtil | Method getRowContains | Exception desc : " + e.getMessage());
			throw (e);
		}
	}

	public int getRowUsed() throws Exception {
		try {
			int RowCount = excelWSheet.getLastRowNum();
			Log.info("Total number of Row used return as < " + RowCount + " >.");
			return RowCount;
		} catch (Exception e) {
			Log.error("Class ExcelUtil | Method getRowUsed | Exception desc : " + e.getMessage());
			System.out.println(e.getMessage());
			throw (e);
		}

	}
}