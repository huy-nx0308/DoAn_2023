package com.clinic.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.clinic.configuration.DataProviderFactory;
import com.clinic.configuration.Log;

import com.clinic.core.BaseTest;
import com.clinic.pageelement.Common;
import com.clinic.pageelement.HomePage;
import com.clinic.pageelement.SignInPage;

public class TestCase_SignIn extends BaseTest {
	SignInPage signInPage;
	HomePage homePage;
	Common common;

	public TestCase_SignIn() {
		super();
	}

	@Test(priority = 1, dataProvider = "dp_login", dataProviderClass = DataProviderFactory.class)
	public void signIn_TC1(Hashtable<String, String> data) throws Exception {
		Common common = Common.getInstant();
		try {

			String userName = data.get("UserName");
			String password = data.get("PassWord");
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
			common.setDataToExcel("Pass", Integer.parseInt(data.get("STT")), 4);

		} catch (Exception e) {
			common.setDataToExcel("Fail", Integer.parseInt(data.get("STT")), 4);
			Log.error(e.getMessage());
			throw (e);
		}

	}

}
