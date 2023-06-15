package com.qa.countable.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public String doGetTitle() {

		try {
			return driver.getTitle();
		} catch (Exception e) {

		}
		return null;
	}

	public static String getCurrentDateTime() {
		return new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss").format(new Date());
	}

	public static void captureScreenShotOfWebElement(WebDriver driver, WebElement ele) {
		try {
			FileHandler.copy(ele.getScreenshotAs(OutputType.FILE),
					new File("./screenshots/selenium" + System.currentTimeMillis() + ".png"));

		} catch (IOException e) {

			System.out.println("Could not save the screenshot");
		}
	}

	public static void captureScreenShot(WebDriver driver) {
		try {
			FileHandler.copy(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE),
					new File("./screenshots/selenium" + System.currentTimeMillis() + ".png"));

		} catch (IOException e) {

			System.out.println("Could not save the screenshot");
		}
	}

	public static String captureScreenShotInBase64(WebDriver driver) {
		String screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

		return screenshot;
	}

	public void wait(int time) {

		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {

		}

	}

	public static WebElement elementHighlight(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].setAttribute('style','border: solid 2px red; background: yellow');", ele);

		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", ele);

		return ele;

	}

	public WebElement getElement(By locator) {
		WebElement element = null;

		try {
			element = driver.findElement(locator);
		} catch (Exception e) {

		}
		return element;

	}

	// List Method
	public List<WebElement> getElements(By List) {
		List<WebElement> elements = null;

		try {
			elements = driver.findElements(List);
		} catch (Exception e) {

		}
		return elements;

	}

	public void doClick(By locator) {

		try {
			getElement(locator).click();

		} catch (Exception e) {

		}

	}

	public void doSendkey(By locator, String value) {

		try {
			WebElement ele = getElement(locator);
			ele.clear();
			ele.sendKeys(value);

		} catch (Exception e) {

		}

	}

	public boolean doIsdisplayed(By locator) {
		try {
			return getElement(locator).isDisplayed();
		} catch (Exception e) {

		}
		return false;

	}

	public String getText(By locator) {
		try {
			return getElement(locator).getText();
		} catch (Exception e) {

		}
		return null;

	}

	/*
	 * public void wait(WebDriver driver,Duration seconds,By locator) {
	 * WebDriverWait wait = new WebDriverWait(driver,time);
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); }
	 */

	public void zoomout() throws InterruptedException, AWTException {
		Robot robot = new Robot();
		Thread.sleep(5000);
		System.out.println("About to zoom out");
		for (int i = 0; i < 4; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
	}

	public void switchWindow() throws InterruptedException {
		Thread.sleep(4000);
		String originalWindow = driver.getWindowHandle();
		for (String windowHandle : driver.getWindowHandles()) {
			if (!originalWindow.contentEquals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				driver.manage().window().maximize();
				break;
			}
			
		}
	}

}
