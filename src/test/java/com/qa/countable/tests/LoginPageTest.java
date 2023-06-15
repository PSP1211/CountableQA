package com.qa.countable.tests;

import java.awt.AWTException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.countable.base.Basepage;
import com.qa.countable.page.LoginPage;

public class LoginPageTest {
	WebDriver driver;
	Basepage basepage;
	Properties prop;
	LoginPage lp;

	@BeforeTest
	public void setup() throws InterruptedException, AWTException {
		basepage = new Basepage();
		prop = basepage.init_properties();
		String browserName = prop.getProperty("browser");
		driver = basepage.init_driver(browserName);
		driver.get(prop.getProperty("url"));

		lp = new LoginPage(driver);

	}

	@Test(priority = 1)
	public void verifyLoginTitleTest() {
		String title = lp.getPagetitle();
		System.out.println("Login Page Title is " + title);

	}

	@Test(priority = 2)
	public void verifysignuplink() {
		Assert.assertTrue(lp.checksignuplink());
	}

	@Test(priority = 3)
	public void loginTest() throws InterruptedException {
		lp.dologin(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println("Successfully Login into countable application ");
	}

	
	public void xerologinTest() throws InterruptedException {
		lp.loginwithXero(prop.getProperty("xusername"), prop.getProperty("xpassword"));
		System.out.println("Successfully Login using Xero SSO ");
	}

	
	public void sageloginTest() throws InterruptedException {
		lp.loginwithSage(prop.getProperty("susername"), prop.getProperty("spassword"));
		System.out.println("Successfully Login using QBO SSO ");
	}
	

	
	
	public void qbloginTest() throws InterruptedException {
		lp.loginwithQB(prop.getProperty("qusername"), prop.getProperty("qpassword"));
		System.out.println("Successfully Login using Sage SSO ");
	}
	
	@AfterTest
	public void teardown() {
		System.out.println("Chrome is launch successfully");
	}

}
