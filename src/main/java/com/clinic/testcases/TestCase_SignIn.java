package com.clinic.testcases;

import java.time.Duration;

import org.apache.log4j.xml.DOMConfigurator;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.clinic.appmodules.SignIn_Action;
import com.clinic.configuration.Constant;
import com.clinic.configuration.ExcelUtils;
import com.clinic.configuration.Log;
import com.clinic.configuration.Utility;
import com.clinic.pageelement.SignIn_Page;

public class TestCase_SignIn {
	public WebDriver driver;

	ExcelUtils excel;
	
	@BeforeMethod
	public void beforeMethod() throws Exception {
		
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("SignIn");
		String path = Constant.pathTestData + Constant.fileTestData;
		System.out.println(path);
		excel = new ExcelUtils(path, "Sign_In");	
		Log.info("Excel sheet opened");
		String browserName = excel.getCellData(1, 5);
		System.out.println(browserName);
		driver = Utility.openBrowser(browserName);
		System.out.println(driver);
		// Đợi 10s để mở
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		Log.info("Browser full screen");
		driver.get(Constant.url);
		Log.info("Web application launched successfully");
		new SignIn_Page(driver);
	}

	@Test(priority = 1)
	public void signIn_TC1() throws Exception {
		try {
			SignIn_Action.testCase1(excel);
			if (driver.findElement(By.xpath("//span[text()='Cài đặt Ứng dụng']")).isDisplayed()) {
				Log.info("Check display xpath form SignIn ");
				excel.setCellData("Pass", 1, 4);
			}
		} catch (Exception e) {
			excel.setCellData("Fail", 1, 4);
			// Utility.takeScreenshot(driver, ExcelUtils.getCellData(1, 0));
			Log.error(e.getMessage());
			throw (e);
		}

	}
	
	@Test(priority = 2)
	public void signIn_TC2() throws Exception{
		try {
			SignIn_Action.testCase2(excel);
			if(driver.findElement(By.xpath("//span[text()='Tên người dùng hoặc mật khẩu không chính xác.']")).isDisplayed()){
				excel.setCellData("Pass", 2, 4);
			}
		} catch (Exception e) {
			// TODO: handle exception
			excel.setCellData("Fail", 2, 4);
			Log.error(e.getMessage());
			throw (e);
		}
	}
	
	@Test(priority = 3)
	public void signIn_TC3() throws Exception{
		try {
			SignIn_Action.testCase3(excel);
			if(driver.findElement(By.xpath("//span[text()='Tên người dùng hoặc mật khẩu không chính xác.']")).isDisplayed()){
				excel.setCellData("Pass", 3, 4);
			}
		} catch (Exception e) {
			// TODO: handle exception
			excel.setCellData("Fail", 3, 4);
			throw (e);
		}
	}
	
	@Test(priority = 4)
	public void signIn_TC4() throws Exception{
		try {
			SignIn_Action.testCase3(excel);
			if(driver.findElement(By.xpath("//span[text()='Tên người dùng hoặc mật khẩu không chính xác.']")).isDisplayed()){
				excel.setCellData("Pass", 4, 4);
			}
		} catch (Exception e) {
			// TODO: handle exception
			excel.setCellData("Fail", 4, 4);
			throw (e);
		}
	}
	
	@Test(priority = 5)
	public void signIn_TC5() throws Exception{
		try {
			SignIn_Action.testCase3(excel);
			if(driver.findElement(By.xpath("//span[text()='Tên người dùng hoặc mật khẩu không chính xác.']")).isDisplayed()){
				excel.setCellData("Pass", 5, 4);
			}
		} catch (Exception e) {
			// TODO: handle exception
			excel.setCellData("Fail", 5, 4);
			throw (e);
		}
	}
	@Test(priority = 6)
	public void signIn_TC6() throws Exception{
		try {
			SignIn_Action.testCase6(excel);
			if(driver.findElement(By.xpath("//span[text()='Tên người dùng hoặc mật khẩu không chính xác.']")).isDisplayed()){
				excel.setCellData("Pass", 6, 4);
			}
		} catch (Exception e) {
			// TODO: handle exception
			excel.setCellData("Fail", 6, 4);
			throw (e);
		}
	}
	
	
	@AfterMethod
	public void afterMethod() {
		Log.endTestCase("SignIn");
		driver.quit();
	}
}
