package com.clinic.pageelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.clinic.configuration.Log;

public class SignIn_Page {
	public static WebDriver driver;
	public static WebElement element = null;
	public SignIn_Page(WebDriver driver) {
		this.driver =driver;
	}
	//tìm kiếm element email trên trang Login 
	public static WebElement email() throws Exception  {
		try {
			driver.findElement(By.id("email"));
			element = driver.findElement(By.id("email"));
			Log.info("Email text box is found on Login Page");
			
		} catch (Exception e) {
			// TODO: handle exception
			Log.error("Email text box is not found on Login Page");
			throw(e);
		}
		return element;
	}
	
	//tìm kiếm element password trên trang Login 
		public static WebElement password() throws Exception  {
			try {
				element = driver.findElement(By.id("password"));
				Log.info("Password input area is found on Login Page");
				
			} catch (Exception e) {
				// TODO: handle exception
				Log.error("Password input area is not found on Login Page");
				throw(e);
			}
			return element;
		}
		//tìm kiếm element button logIn trên trang Login 
				public static WebElement btn_LogIn() throws Exception  {
					try {
						element = driver.findElement(By.xpath("//button[@id='kt_login_signin_submit']"));
						Log.info("LogIn button is found on Login Page");
						
					} catch (Exception e) {
						// TODO: handle exception
						Log.error("LogIn button is not found on Login Page");
						throw(e);
					}
					return element;
				}
}
