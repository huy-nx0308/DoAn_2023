package com.clinic.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.clinic.configuration.DataProviderFactory;
import com.clinic.configuration.Log;

import com.clinic.core.BaseTest;
import com.clinic.pageelement.Common;
import com.clinic.pageelement.HomePage;
import com.clinic.pageelement.MainPage;
import com.clinic.pageelement.SignInPage;

public class TestCase_SignIn extends BaseTest {
	SignInPage signInPage;
	HomePage homePage;
	Common common;
	MainPage mainPage;

	public TestCase_SignIn() {
		super();
	}

	@Test(priority = 1, dataProvider = "dp_login", dataProviderClass = DataProviderFactory.class)
	public void signIn_TC1(Hashtable<String, String> data) throws Exception {
		Common common = Common.getInstant();
		try {
			Log.info(data.get("TestCaseName"));
			String userName = data.get("UserName");
			String password = data.get("PassWord");
			homePage = new HomePage();
			homePage.goToPage("Log in");

			signInPage = new SignInPage();
			Thread.sleep(2000);
			signInPage.inputToTheTextBox("username", userName);
			signInPage.inputToTheTextBox("password", password);
			signInPage.clickOnButton("Log In");
			Thread.sleep(3000);
//
//			mainPage = new MainPage();
//			if(mainPage.visibleInstallBtn()) {
//				System.out.println("Log in thanh cong");
//				common.setDataToExcel("Pass", Integer.parseInt(data.get("STT")), 4);
//			} else {
//				common.setDataToExcel("Fail", Integer.parseInt(data.get("STT")), 4);
//			}
			System.out.println(keyword.getTitle());
			System.out.println(data.get("Expectation key").toString());
			keyword.webDriverWaitForElementPresent(data.get("Expectation key").toString(), 4);
			if(keyword.verifyElementVisible(data.get("Expectation key").toString())) {
				common.setDataToExcel("Pass", Integer.parseInt(data.get("STT")), 4);
			}
		} catch (Exception e) {
			common.setDataToExcel("Fail", Integer.parseInt(data.get("STT")), 4);
			Log.error(e.getMessage());
			throw (e);
		}

	}

}
