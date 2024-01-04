package com.clinic.pageelement;

import com.clinic.configuration.PropertiesFile;
import com.clinic.core.BasePage;
import com.clinic.core.KeyWordWeb;

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
	
	public void inputNameSong(String value) {
		keyword.webDriverWaitForElementPresent(props.getPropValue("TEXT_BOX_SEARCH"), 4);
		keyword.inputText(props.getPropValue("TEXT_BOX_SEARCH"), value);
	}
	public void clickButtonClose() {
		keyword.click(props.getPropValue("BUTTON_CLOSE"));
	}
	public void clickButtonFindMore() {
		keyword.click(props.getPropValue("BUTTON_FINDMORE"));
	}
	
	public void clickToNamePlaylist() {
		keyword.click(props.getPropValue("NAME_PLAYLIST"));
	}
	public void editNamePlaylist(String value) {
		keyword.webDriverWaitForElementPresent(props.getPropValue("TEXT_BOX_NAME"), 4);
		keyword.inputText(props.getPropValue("TEXT_BOX_NAME"), value);
		keyword.click(props.getPropValue("BUTTON_SAVE_NAME"));
	}
}
