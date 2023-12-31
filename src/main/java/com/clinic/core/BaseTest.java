package com.clinic.core;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.clinic.configuration.Log;
import com.clinic.pageelement.Common;

public class BaseTest {
	protected KeyWordWeb keyword;
	Common common;

	public BaseTest() {
		keyword = new KeyWordWeb();
	}

	@BeforeSuite
	public void beforeSuite() {

	}

	@BeforeTest
	public void beforeTest(final ITestContext testContext) {
		System.out.println("beforeTest: " + testContext.getName());
		common = Common.getInstant();
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase(testContext.getName());

	}

	@AfterTest
	public void afterTest() {
		keyword.closeBrowser();
	}

	@BeforeMethod
	public void beforeMethod() {
		common = Common.getInstant();
		keyword.openBrowser(common.getProps().getPropValue("BROWSER_NAME"), common.getProps().getPropValue("BASE_URL"));
	}

	@AfterMethod
	public void afterMethod() {
		keyword.closeBrowser();
	}
}
