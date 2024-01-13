package com.music.core;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.music.configuration.Log;
import com.music.pageobject.Common;

import java.lang.reflect.Method;

public class BaseTest {
    protected KeyWordWeb keyword;
    Common common;

    public BaseTest() {
        System.out.println("Base Test");
        keyword = new KeyWordWeb();
        common = Common.getInstant();
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("beforeSuite");
    }

    @BeforeTest
    public void beforeTest(final ITestContext testContext) {
        String testname = testContext.getName();
        System.out.println("beforeTest: " + testname);

        if (!testname.equals("Sign_In")) {
            keyword.openBrowser(common.getProps().getPropValue("BROWSER_NAME"), common.getProps().getPropValue("BASE_URL"));
        }
        keyword.maximizeWindow();
        DOMConfigurator.configure("log4j.xml");
        Log.startTestCase(testContext.getName());

    }

    @AfterTest
    public void afterTest( ITestContext testContext) {
        String testname = testContext.getName();

        if (!testname.equals("Sign_In")) {
            keyword.closeBrowser();
        }

    }


}
