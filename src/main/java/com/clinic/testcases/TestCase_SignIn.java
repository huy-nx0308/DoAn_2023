package com.clinic.testcases;

import java.time.Duration;

import org.apache.log4j.xml.DOMConfigurator;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.clinic.configuration.Constant;
import com.clinic.configuration.ExcelUtils;
import com.clinic.configuration.Log;

import com.clinic.core.BaseTest;
import com.clinic.pageelement.Common;
import com.clinic.pageelement.HomePage;
import com.clinic.pageelement.SignInPage;

public class TestCase_SignIn extends BaseTest {
	public WebDriver driver;
	SignInPage signInPage;
	HomePage homePage;
	Common common;

	public TestCase_SignIn() {
		super();
	}

	@Test(priority = 1)
	public void signIn_TC1() throws Exception {
		Common common = Common.getInstant();
		try {
			
			String userName = common.getDataFromExcel(1, 2);
			String password = common.getDataFromExcel(1, 3);
			System.out.println(userName);
			homePage = new HomePage();
			homePage.goToPage("Log in");
			System.out.println("goToPage ");
			Thread.sleep(5000);
			signInPage = new SignInPage(this.keyword);
			Thread.sleep(5000);
			signInPage.inputToTheTextBox("username", userName);

			signInPage.inputToTheTextBox("password", password);

			signInPage.clickOnButton("Log In");
			Thread.sleep(2000);
			System.out.println("Log in thanh cong");
			common.setDataToExcel("Pass", 1, 4);

		} catch (Exception e) {
			common.setDataToExcel("Fail", 1, 4);
			Log.error(e.getMessage());
			throw (e);
		}

	}

}
