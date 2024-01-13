package com.music.pageobject;

import com.music.configuration.PropertiesFile;
import com.music.core.BasePage;
import com.music.core.KeyWordWeb;

public class MainPage extends BasePage {
	private PropertiesFile props;

	public MainPage() {
		super();
		props = new PropertiesFile("Main_Page");
	}

	public MainPage(KeyWordWeb keyword) {
		super(keyword);
		props = new PropertiesFile("Main_Page");
	}

	public boolean visibleInstallBtn() {
		//System.out.println(props.getPropValue("BTN_INSTALL"));
		keyword.webDriverWaitForElementPresent(props.getPropValue("BTN_INSTALL"), 7);
		if (keyword.verifyElementVisible(props.getPropValue("BTN_INSTALL"))) {
			return true;
		}

		else
			return false;
	}
	public void clickToSearch () {
		keyword.webDriverWaitForElementPresent(props.getPropValue("BTN_SEARCH"), 5);
		//jump to search page
		keyword.click(props.getPropValue("BTN_SEARCH"));
		
	}
	//Click add button playlist
	public void clickToAdd() {
		keyword.webDriverWaitForElementPresent(props.getPropValue("BTN_ADD"), 5);
		keyword.click(props.getPropValue("BTN_ADD"));
		//click to jump addplaylist page
		keyword.webDriverWaitForElementPresent(props.getPropValue("BTN_ADD_PLAYLIST"), 5);
		keyword.click(props.getPropValue("BTN_ADD_PLAYLIST"));
		
	}
}
