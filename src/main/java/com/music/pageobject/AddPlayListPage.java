package com.music.pageobject;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.music.configuration.PropertiesFile;
import com.music.core.BasePage;
import com.music.core.KeyWordWeb;

public class AddPlayListPage extends BasePage{
	private PropertiesFile props;
	
	public AddPlayListPage() {
		super();
		props = new PropertiesFile("Add_Playlist_Page");
	}
	
	public AddPlayListPage(KeyWordWeb keyword) {
		super(keyword);
		props = new PropertiesFile("Add_Playlist_Page");
	}
	
	public void inputSongName(String value) {
		keyword.webDriverWaitForElementPresent(props.getPropValue("TEXT_BOX_SEARCH"), 4);
		keyword.inputText(props.getPropValue("TEXT_BOX_SEARCH"), value);
	}
	//Add song after search
	public void clickBtnToAddSong(String text) {
		keyword.click(props.getPropValue("BUTTON_ADD_SONG").replace("param", text));
	}
	//Add song after click X button
	public void addSongInRecom() {
		List<WebElement> elements = keyword.getListElement(props.getPropValue("BTN_ADD_SONG_RECOM"));
		//Add random song 
		elements.get(0).click();// Add song 1
		elements.get(4).click(); //Add song 5
	}
	// click findmore
	public void clickBtnToAddSongInFindmore() {
		
	}
	//close button in addlistpage
	public void clickButtonClose() {
		keyword.click(props.getPropValue("BUTTON_CLOSE"));
	}
	//button findmore display after click button close
	public void clickButtonFindMore() {
		keyword.click(props.getPropValue("BUTTON_FINDMORE"));
	}
	//Check song added in playlist
	public boolean checkSongInPlaylist(String songName) {
		boolean check = keyword.verifyElementVisible(props.getPropValue("CHECK").replace("param", songName));
		System.out.println(check);
		return check;
	}
	//Delete song in playlist
	public void deleteSong(String songName) throws InterruptedException {
		String btnMore = props.getPropValue("BTN_MORE_BUTTON").replace("param", songName);
		keyword.click(btnMore);
		Thread.sleep(1000);
		keyword.click(props.getPropValue("BTN_REMOVE"));
		
	}
	//Rename playlist
	public void reNamePlaylist(String name) throws InterruptedException {
		keyword.click(props.getPropValue("NAME_PLAYLIST"));
		Thread.sleep(1000);
		keyword.inputText(props.getPropValue("TEXT_BOX_NAME"), name);
		Thread.sleep(2000);
		keyword.click(props.getPropValue("BTN_SAVE_NAME"));
	}
	//Verify new name
	public boolean checkNewName (String name) {
		String nameAfterEdit = keyword.getText(props.getPropValue("NAME_PLAYLIST"));
		System.out.println(nameAfterEdit);
		if (nameAfterEdit.equals(name)) {
			return true;
		}else return false;
		
	}
	
}
