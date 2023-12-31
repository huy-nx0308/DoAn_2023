package com.clinic.pageelement;

import com.clinic.configuration.Log;
import com.clinic.configuration.PropertiesFile;
import com.clinic.core.BasePage;
import com.clinic.core.KeyWordWeb;

public class SignInPage extends BasePage {
	private PropertiesFile props;
	
	public SignInPage() {
		super();
		props = new PropertiesFile("Sign_In");
	}

	public SignInPage(KeyWordWeb keyword) {
		super(keyword);
		props = new PropertiesFile("Sign_In");
	}

	public void inputToTheTextBox(String textboxName, String value) {
		keyword.inputText(props.getPropValue("TEXT_BOX").replace("param", textboxName), value);
	}

	public void clickOnButton(String buttonName) {
		keyword.click(props.getPropValue("BUTTON").replace("param", buttonName));
	}

}
