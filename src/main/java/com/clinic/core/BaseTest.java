package com.clinic.core;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.clinic.configuration.ExcelUtils;
import com.clinic.configuration.Log;
import com.clinic.configuration.PropertiesFile;
import com.clinic.pageelement.Common;

public class BaseTest {
	protected KeyWordWeb keyword;
	String path = "src/main/resources/Test_Data.xlsx";
	protected ExcelUtils excel = ExcelUtils.getInstace(path);

	public BaseTest() {
		keyword = new KeyWordWeb();
	}

	@BeforeSuite
	public void beforeSuite() {

	}

	@BeforeTest
	public void beforeTest(final ITestContext testContext) {
		Common common = Common.getInstant();
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase(testContext.getName());
		excel.openSheet(testContext.getName());
		keyword.openBrowser(common.getProps().getPropValue("BROWSER_NAME"), common.getProps().getPropValue("BASE_URL"));
	}

	@AfterTest
	public void afterTest() {
		keyword.closeBrowser();
	}
}
