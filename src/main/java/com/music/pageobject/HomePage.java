package com.music.pageobject;

import com.music.configuration.Log;
import com.music.configuration.PropertiesFile;
import com.music.core.BasePage;
import com.music.core.KeyWordWeb;

public class HomePage extends BasePage {
	Common common;
	PropertiesFile props;

	public HomePage() {
		super();
		props = new PropertiesFile("Home_Page");
	}

	public HomePage(KeyWordWeb keyword) {
		super(keyword);
		props = new PropertiesFile("Home_Page");
	}
	

	public PropertiesFile getProps() {
		return props;
	}

	public void goToPage(String page) {
		String button = "";
		switch (page.toLowerCase()) {
		case "log in":
			button = props.getPropValue("BTN_LOG_IN");
			break;
		case "sign up":
			button = props.getPropValue("BTN_SIGN_UP");
			break;
		}
		keyword.click(button);
		try {
			Thread.sleep(3500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		common = Common.getInstant();
		common.verifyPageDisplay(page);
		Log.info("page " + page + " displayed!");
	}

}
