package com.music.pageobject;

import java.util.Properties;

import com.music.configuration.PropertiesFile;
import com.music.core.BasePage;
import com.music.core.KeyWordWeb;

public class SearchPage extends BasePage {

	private PropertiesFile props;

	public SearchPage() {
		super();
		props = new PropertiesFile("Search");
	}

	public SearchPage(KeyWordWeb keyword) {
		super(keyword);
		props = new PropertiesFile("Search");
	}

	public boolean searchPagePresent() {
		keyword.webDriverWaitForElementPresent(props.getPropValue("TEXTBOX_SEARCH"), 5);
		if (keyword.verifyElementVisible(props.getPropValue("TEXTBOX_SEARCH"))) {
			return true;
		} else
			return false;
	}
	public void inputToTheTextBox(String textboxName, String value) {
		keyword.inputText(props.getPropValue("TEXTBOX_SEARCH").replace("param", textboxName), value);
	}
	public void clickFilter(String element) {
		System.out.println(props.getPropValue("FILTER").replace("param", element));
		keyword.click(props.getPropValue("FILTER").replace("param", element));
	}
}
