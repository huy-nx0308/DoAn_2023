package com.clinic.pageelement;

import com.clinic.configuration.Log;
import com.clinic.configuration.PropertiesFile;
import com.clinic.core.BasePage;
import com.clinic.core.KeyWordWeb;

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
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		common = Common.getInstant();
		common.verifyPageDisplay(page);
		Log.info("page " + page + " displayed!");
	}

}
