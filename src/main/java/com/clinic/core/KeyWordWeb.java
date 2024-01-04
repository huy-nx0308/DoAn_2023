package com.clinic.core;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.clinic.configuration.Log;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyWordWeb {
	private static WebDriver driver;

	public KeyWordWeb() {

	}

	// all action keywords
	public void openBrowser(String browser, String... url) {
		switch (browser.toUpperCase()) {
		case "CHROME":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "FIREFOX":
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addPreference("intl.accept_languages", "en-US,en");
			driver = new FirefoxDriver(options);
			break;
		case "EDGE":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		}
		String rawUrl = url.length > 0 ? url[0] : "";
		if (rawUrl != null && !rawUrl.isEmpty()) {
			Log.info("Go to url: " + rawUrl);

			Log.info("url: " + url);
			driver.get(rawUrl);
		}

	}

	public void closeBrowser() {
		Log.info("Browser closed");
		driver.quit();
	}

	public void click(String element) {
		Log.info("CLicked element: " + element);
		driver.findElement(By.xpath(element)).click();

	}

	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	public void doubleClick(String element) {
		Log.info("Double clicked element: " + element);
		Actions builder = new Actions(driver);
		WebElement elementRef = driver.findElement(By.xpath(element));
		builder.doubleClick(elementRef).perform();
	}

	public void dragAndDropToObj(String startElement, String endElement) {
		Log.info("Drag from" + startElement + " to" + endElement);
		Actions builder = new Actions(driver);
		WebElement source = driver.findElement(By.xpath(startElement));
		WebElement target = driver.findElement(By.xpath(endElement));
		builder.dragAndDrop(source, target).perform();
	}

	public void rightClick(String element, String menuItem) {
		Log.info("Right clicked element " + element);
		Actions builder = new Actions(driver);
		WebElement clickMe = driver.findElement(By.xpath(element));
		WebElement editMenuItem = driver.findElement(By.xpath(menuItem));
		builder.contextClick(clickMe).moveToElement(editMenuItem).perform();
	}

	public void maximizeWindow() {
		Log.info("Maximize Window Browser");
		driver.manage().window().maximize();
	}

	public void back() {
		Log.info("Back window...");
		driver.navigate().back();
	}

	public void navigateToUrl(String url) {
		Log.info("Navigate To URL: " + url);
		driver.navigate().to(url);
	}

	public void switchToFrame(String frame) {
		Log.info("Switch To Frame...");
		driver.switchTo().frame(frame);
	}

	public void switchToFrameByIndex(int index) {
		Log.info("Switch To Frame By Index: ");
		driver.switchTo().frame(index);
	}

	public void switchToIFrame() {
		Log.info("Switch To Iframe");
		WebElement iframe = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(iframe);
	}

	// verify keywords

	public boolean verifyElementPresent(String element) {
		try {
			driver.findElement(By.xpath(element));
			return true;
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			e.printStackTrace();
			e.getMessage();
			return false;
		}
	}

	public boolean verifyElementVisible(String element) {
		try {
			// Dùng Boolean vì có thể null
			Boolean blnVerify = driver.findElement(By.xpath(element)).isDisplayed();
			return blnVerify;
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			e.printStackTrace();
			e.getMessage();
			return false;

		}
	}

	// Wait keywords
	@SuppressWarnings("deprecation")
	public void inWait(int timeout) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(timeout, null);
	}

	public void webDriverWaitForElementPresent(String element, long timeout) {
		Log.info("WebDriver wait for element present");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));
	}

	public void fluentWaitForElementPresent(String element, Duration polling, Duration timeout) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(polling).pollingEvery(polling)
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));

	}

	// Input data
	public void inputText(String element, String text) {
		// clear old data before input new data
		driver.findElement(By.xpath(element)).clear();
		driver.findElement(By.xpath(element)).sendKeys(text);
	}

}
