package com.clinic.configuration;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.clinic.pageelement.SignIn_Page;

public class Utility {
	public static WebDriver driver = null;

	public static WebDriver openBrowser(String browserName) throws Exception {
		try {
			if (browserName.equals("Mozila")) {
				//System.setProperty("web.driver.chrome","D:\\Selenium Java\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
				driver = new FirefoxDriver();
				Log.info("New driver is instantiated");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				Log.info("Implicit wait applied on the driver for 20 seconds");
				driver.manage().window().maximize();
				Log.info("maximize browser");
				driver.get(Constant.url);
				Log.info("Open web application");
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			Log.error("Class utils | Method OpenBrowser | Exception desc: " + e.getMessage());
		}

		return driver;
	}

	public static void waitForElement(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}
