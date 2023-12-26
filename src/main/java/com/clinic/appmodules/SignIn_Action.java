package com.clinic.appmodules;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.clinic.configuration.ExcelUtils;
import com.clinic.configuration.Log;
import com.clinic.pageelement.SignIn_Page;

public class SignIn_Action {
	public static WebDriver driver;
	
	public static void testCase1(ExcelUtils excel)throws Exception{
		String email = excel.getCellData(1, 2);
		Log.info("Email address taken from Excelfile is" + email);
		String password = excel.getCellData(1, 3);
		Log.info("Password taken from Excelfile is" + password);
		SignIn_Page.email().sendKeys(email);
		Thread.sleep(2000);
		Log.info("Enter email");
		SignIn_Page.password().sendKeys(password);
		Thread.sleep(2000);
		Log.info("Enter password");
		SignIn_Page.btn_LogIn().click();
		Thread.sleep(2000);
		Log.info("Click in button Login button");
		Reporter.log("Sign in action successfully performed");
	}
	public static void testCase2(ExcelUtils excel) throws Exception{
		String email = excel.getCellData(2, 2);
		Log.info("Email address taken from Excelfile is" + email);
		String password = excel.getCellData(2, 3);
		Log.info("Password taken from Excelfile is "+ password);
		SignIn_Page.email().clear();
		SignIn_Page.email().sendKeys(email);
		Log.info("Enter email");
		SignIn_Page.password().sendKeys(password);
		Thread.sleep(2000);
		Log.info("Enter password");
		SignIn_Page.btn_LogIn().click();
		Thread.sleep(2000);
		Log.info("Click in button Login button");
		Reporter.log("Sign in action is not successfully performed");
	}
	
	public static void testCase3(ExcelUtils excel) throws Exception{
		String email = excel.getCellData(3, 2);
		Log.info("Email address taken from Excelfile is" + email);
		String password = excel.getCellData(3, 3);
		Log.info("Password taken from Excelfile is "+ password);
		SignIn_Page.email().clear();
		SignIn_Page.email().sendKeys(email);
		Log.info("Enter email");
		SignIn_Page.password().sendKeys(password);
		Thread.sleep(2000);
		Log.info("Enter password");
		SignIn_Page.btn_LogIn().click();
		Thread.sleep(2000);
		Log.info("Click in button Login button");
		Reporter.log("Sign in action is not successfully performed");
	}
	
	
	public static void testCase4(ExcelUtils excel) throws Exception{
		String email = excel.getCellData(4, 2);
		Log.info("Email address taken from Excelfile is" + email);
		String password = excel.getCellData(4, 3);
		Log.info("Password taken from Excelfile is "+ password);
		SignIn_Page.email().clear();
		SignIn_Page.email().sendKeys(email);
		Log.info("Enter email");
		SignIn_Page.password().sendKeys(password);
		Thread.sleep(2000);
		Log.info("Enter password");
		SignIn_Page.btn_LogIn().click();
		Thread.sleep(2000);
		Log.info("Click in button Login button");
		Reporter.log("Sign in action is not successfully performed");
	}
	
	public static void testCase5(ExcelUtils excel) throws Exception{
		String email = excel.getCellData(5, 2);
		Log.info("Email address taken from Excelfile is" + email);
		String password = excel.getCellData(5, 3);
		Log.info("Password taken from Excelfile is "+ password);
		SignIn_Page.email().clear();
		SignIn_Page.email().sendKeys(email);
		Log.info("Enter email");
		SignIn_Page.password().sendKeys(password);
		Thread.sleep(2000);
		Log.info("Enter password");
		SignIn_Page.btn_LogIn().click();
		Thread.sleep(2000);
		Log.info("Click in button Login button");
		Reporter.log("Sign in action is not successfully performed");
	}
	
	public static void testCase6(ExcelUtils excel) throws Exception{
		String email = excel.getCellData(6, 2);
		Log.info("Email address taken from Excelfile is" + email);
		String password = excel.getCellData(6, 3);
		Log.info("Password taken from Excelfile is "+ password);
		SignIn_Page.email().clear();
		SignIn_Page.email().sendKeys(email);
		Log.info("Enter email");
		SignIn_Page.password().sendKeys(password);
		Thread.sleep(2000);
		Log.info("Enter password");
		SignIn_Page.btn_LogIn().click();
		Thread.sleep(2000);
		Log.info("Click in button Login button");
		Reporter.log("Sign in action is not successfully performed");
	}
}
