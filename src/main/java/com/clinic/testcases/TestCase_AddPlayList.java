package com.clinic.testcases;

import java.util.Hashtable;

import com.clinic.core.BaseTest;
import org.testng.annotations.Test;

import com.clinic.configuration.DataProviderFactory;
import com.clinic.core.BasePage;
import com.clinic.pageelement.AddPlayListPage;
import com.clinic.pageelement.Common;
import com.clinic.pageelement.HomePage;
import com.clinic.pageelement.MainPage;
import com.clinic.pageelement.SignInPage;

public class TestCase_AddPlayList extends BaseTest {
	HomePage homePage;
	SignInPage signInPage;
	MainPage mainPage;
	AddPlayListPage addPlayListPage;

	boolean signIn;

	public TestCase_AddPlayList() {
		super();
	}

	@Test(dataProvider = "dp_addPlayList", dataProviderClass = DataProviderFactory.class)
	public void AddPlayList_Tc(Hashtable<String, String> data) throws Exception {
		Common common = Common.getInstant();
		if(!signIn)
			signInMainPage();
		mainPage = new MainPage();
		System.out.println(keyword.getTitle());
		try {
			mainPage.clickToAdd();
			System.out.println(keyword.getTitle());
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		

	}
	public void signInMainPage() throws InterruptedException {
		// Log.info(data.get("TestCaseName"));
		String userName = "xuanhuynguyen0308@gmail.com";
		String password = "Huy163173491@";
		homePage = new HomePage();
		homePage.goToPage("Log in");

		signInPage = new SignInPage();
		Thread.sleep(2000);
		signInPage.inputToTheTextBox("username", userName);
		signInPage.inputToTheTextBox("password", password);
		Thread.sleep(2000);
		signInPage.clickOnButton("Log In");
		signIn = true;
	}
}
