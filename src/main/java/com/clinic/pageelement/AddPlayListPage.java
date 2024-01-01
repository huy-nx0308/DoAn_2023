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
	
}
