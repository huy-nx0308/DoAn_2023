package com.music.testcases;

import java.util.Hashtable;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.music.configuration.DataProviderFactory;
import com.music.configuration.Listener;
import com.music.core.BaseTest;
import com.music.pageobject.AddPlayListPage;
import com.music.pageobject.Common;
import com.music.pageobject.HomePage;
import com.music.pageobject.MainPage;
import com.music.pageobject.SignInPage;

@Listeners(Listener.class)
public class TestCase_AddPlayList extends BaseTest {
	HomePage homePage;
	SignInPage signInPage;
	MainPage mainPage;
	AddPlayListPage addPlayListPage;

	boolean signIn;
	boolean add;

	public TestCase_AddPlayList() {
		super();
	}

	@Test(dataProvider = "dp_addPlayList", dataProviderClass = DataProviderFactory.class)
	public void AddPlayList_Tc(Hashtable<String, String> data) throws Exception {
		Common common = Common.getInstant();
		if (!signIn)
			signInMainPage();
		Thread.sleep(2000);
		mainPage = new MainPage();
		System.out.println(keyword.getTitle());
		try {
			// Add only 1 playlist
			if (!add) {
				mainPage.clickToAdd();
				System.out.println(keyword.getTitle());
				Thread.sleep(2000);
				add = true;
			}
			addPlayListPage = new AddPlayListPage();
			Thread.sleep(2000);
			// add song
			if (data.get("SearchText") != null && data.get("SearchText").length() > 0) {
				addPlayListPage.inputSongName(data.get("SearchText").toString());
				System.out.println(data.get("SearchText").toString());
				Thread.sleep(2000);
				String songName = data.get("Expected song name").toString();
				addPlayListPage.clickBtnToAddSong(songName);
				Thread.sleep(3000);
				// Check song added in playlist
				if (addPlayListPage.checkSongInPlaylist(songName)) {
					common.setDataToExcel("Pass", Integer.parseInt(data.get("STT")), 5);
				} else {
					common.setDataToExcel("Fail", Integer.parseInt(data.get("STT")), 5);
				}
			}
			// Delete song
			if (data.get("DeleteSongName") != null && data.get("DeleteSongName").length() > 0) {
				addPlayListPage.deleteSong(data.get("DeleteSongName").toString());
				Thread.sleep(1000);
				try {
					if (addPlayListPage.checkSongInPlaylist(data.get("DeleteSongName").toString())) {
						common.setDataToExcel("Fail", Integer.parseInt(data.get("STT")), 5);
					} 
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Exception khong co phan tu");
					common.setDataToExcel("Pass", Integer.parseInt(data.get("STT")), 5);
				}

			}
			
			//Edit name Playlist
			if (data.get("NamePlaylist") != null && data.get("NamePlaylist").length() > 0) {
				String namePlayList = data.get("NamePlaylist").toString();
				
				addPlayListPage.reNamePlaylist(namePlayList);
				Thread.sleep(2000);
				if (addPlayListPage.checkNewName(namePlayList)) {
					common.setDataToExcel("Pass", Integer.parseInt(data.get("STT")), 5);
				}else {
					common.setDataToExcel("Fail", Integer.parseInt(data.get("STT")), 5);
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			e.printStackTrace();
			common.setDataToExcel("Fail", Integer.parseInt(data.get("STT")), 5);
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
