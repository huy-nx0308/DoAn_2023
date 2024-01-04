package com.clinic.testcases;

import java.util.Hashtable;

import com.clinic.configuration.Listener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.clinic.pageelement.Common;
import com.clinic.pageelement.HomePage;
import com.clinic.pageelement.MainPage;
import com.clinic.pageelement.SearchPage;
import com.clinic.pageelement.SignInPage;
import com.clinic.configuration.DataProviderFactory;
import com.clinic.configuration.Log;
import com.clinic.core.BaseTest;

@Listeners(Listener.class)
public class TestCase_Search extends BaseTest {
	MainPage mainPage;
	HomePage homePage;
	SignInPage signInPage;
	SearchPage searchPage;

	boolean signIn;
	Common common;

	public TestCase_Search() {
		super();
	}

	@Test(dataProvider = "dp_search", dataProviderClass = DataProviderFactory.class)
	public void search_TC(Hashtable<String, String> data) throws Exception {
		Common common = Common.getInstant();
		if (!signIn)
			signInMainPage();
		Thread.sleep(2000);
		mainPage = new MainPage();
		System.out.println(keyword.getTitle());
		try {

			mainPage.clickToSearch();
			Thread.sleep(2000);
			System.out.println(keyword.getTitle());
			searchPage = new SearchPage();

			String searchKeyword = data.get("SearchText").toString();
			searchPage.inputToTheTextBox("Search", searchKeyword);

			if (data.get("Filter") != null && data.get("Filter").length() > 0) {
				searchPage.clickFilter(data.get("Filter").toString());
				String expectedKey = data.get("Expectation key").toString();
				keyword.webDriverWaitForElementPresent(expectedKey, 4);
				if (keyword.verifyElementVisible(expectedKey)) {
					common.setDataToExcel("Pass", Integer.parseInt(data.get("STT")), 5);
				}
				
			} else {
				String expectedKey = data.get("Expectation key").toString();
				keyword.webDriverWaitForElementPresent(expectedKey, 4);
				if (keyword.verifyElementVisible(expectedKey)) {
					common.setDataToExcel("Pass", Integer.parseInt(data.get("STT")), 5);
				}
			}
			Thread.sleep(4000);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			e.printStackTrace();
			common.setDataToExcel("Fail", Integer.parseInt(data.get("STT")), 5);
			Thread.sleep(4000);
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
