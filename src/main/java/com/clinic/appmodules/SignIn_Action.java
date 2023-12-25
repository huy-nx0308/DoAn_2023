package com.clinic.appmodules;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.clinic.configuration.ExcelUtils;
import com.clinic.configuration.Log;
import com.clinic.pageelement.SignIn_Page;

public class SignIn_Action {
	public static WebDriver driver;
	
	public static void testCase1(ExcelUtils excel)throws Exception{
		String email = excel.getCellData(1, 2);
		Log.info("Email address taken from Excelfile is" + email);
		String password = excel.getCellData(1, 3);
		Log.info("Email address taken from Excelfile is" + password);
		SignIn_Page.email().sendKeys(email);
		Log.info("Enter email");
		SignIn_Page.password().sendKeys(password);
		Log.info("Enter password");
		SignIn_Page.btn_LogIn().click();
		Log.info("Click in button Login button");
		Reporter.log("Sign in action successfully");
	}
}
