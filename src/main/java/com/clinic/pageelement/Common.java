package com.clinic.pageelement;

import com.clinic.configuration.ExcelUtils;
import com.clinic.configuration.PropertiesFile;
import com.clinic.core.BasePage;
import com.clinic.core.KeyWordWeb;

public class Common extends BasePage {
	private PropertiesFile props;
	private ExcelUtils excel;
	private static Common instant = null;

	public static Common getInstant() {
		if (instant == null) {
			instant = new Common();

		}
		return instant;
	}

	private Common() {
		super();
		props = new PropertiesFile("Common");
		excel = ExcelUtils.getInstace(props.getPropValue("EXCEL_PATH"));
	}

	private Common(KeyWordWeb keyword) {
		super(keyword);
	}

	public PropertiesFile getProps() {
		return props;
	}

	public void verifyPageDisplay(String page) {
		keyword.verifyElementPresent(props.getPropValue("H1_PAGE_TITLE"));
	}

	public String getDataFromExcel(int row, int col) throws Exception {
		return excel.getCellData(row, col);
	}

	public void setDataToExcel(String value, int row, int col) throws Exception {
		excel.setCellData(value, row, col);
	}

	public Object[][] getDataInSheet(String sheetName) throws Exception {
		return excel.getSheetData(sheetName);
	}
}
