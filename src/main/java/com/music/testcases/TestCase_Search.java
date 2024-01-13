package com.music.testcases;

import java.util.Hashtable;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.music.configuration.DataProviderFactory;
import com.music.configuration.Listener;
import com.music.configuration.Log;
import com.music.core.BaseTest;
import com.music.pageobject.Common;
import com.music.pageobject.HomePage;
import com.music.pageobject.MainPage;
import com.music.pageobject.SearchPage;
import com.music.pageobject.SignInPage;

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
			Thread.sleep(2000);
			if (data.get("Filter") != null && data.get("Filter").length() > 0) {
				searchPage.clickFilter(data.get("Filter").toString());
				System.out.println("click thanh cong");
				Thread.sleep(3000);
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
		boolean result = common.getDataFromExcel(Integer.parseInt(data.get("STT")), 5).equals("Pass");
		assert(result);
	}

	public void signInMainPage() throws InterruptedException {
		// Log.info(data.get("TestCaseName"));
		String userName = "xuanhuynguyen0308@gmail.com";
		String password = "Huy030820@";
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
