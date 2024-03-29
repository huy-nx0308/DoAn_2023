package com.music.configuration;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {
	private Sheet excelWSheet;
	private Workbook excelWBook;
	private String path;
	private static ExcelUtils instace = null;

	private ExcelUtils(String path) {
		this.path = path;
		try {
			// Open the Excel file
			FileInputStream excelFile = new FileInputStream(path);
			excelWBook = WorkbookFactory.create(excelFile);
			Log.info("Excel file opened");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	public static ExcelUtils getInstace(String path) {
		if (instace == null) {
			instace = new ExcelUtils(path);
		}
		return instace;
	}

	public void openSheet(String sheetName) {
		excelWSheet = excelWBook.getSheet(sheetName);
		Log.info("Excel sheet" + sheetName + " was opened");

	}

	public String getCellData(int rowNum, int colNum) throws Exception {
		try {
			Cell cell = excelWSheet.getRow(rowNum).getCell(colNum);
			String cellData = cell.getStringCellValue();
			return cellData;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("getCellData: " + e.getMessage());
			return "";
		}
	}

	// Write in the Excel Cell
	public void setCellData(String result, int rowNum, int colNum) throws Exception {
		try {
			Row row = excelWSheet.getRow(rowNum);
			Cell cell = row.getCell(colNum);
			if (cell == null) {
				cell = row.createCell(colNum);
				cell.setCellValue(result);
			} else {
				cell.setCellValue(result);
			}
			// Constant variable Test Data path and Test Data file name
			FileOutputStream fileOut = new FileOutputStream(path);
			excelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			// TODO: handle exception
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

	public int getColumns() {
		try {
			Row row = excelWSheet.getRow(0);
			return row.getLastCellNum();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw (e);
		}
	}

	public int getLastRowNum() {
		return excelWSheet.getLastRowNum();
	}

	public int getPhysicalNumberOfRows() {
		return excelWSheet.getPhysicalNumberOfRows();
	}

	public Object[][] getSheetData(String sheetName) throws Exception {
		Object[][] data = null;
		openSheet(sheetName);
		try {

			int rows = getLastRowNum();
			int columns = getColumns();

			System.out.println("Row: " + rows + " - Column: " + columns);

			data = new Object[rows][1];
			Hashtable<String, String> table = null;
			for (int rIndex = 1; rIndex <= rows; rIndex++) {
				table = new Hashtable<>();
				for (int cIndex = 0; cIndex < columns; cIndex++) {
					table.put(getCellData(0, cIndex), getCellData(rIndex, cIndex));
				}
				data[rIndex - 1][0] = table;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return data;
	}
}