package com.qa.countable.tests;
import org.testng.annotations.Test;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import com.qa.countable.base.Basepage;
import com.qa.countable.page.Dashboard;
import com.qa.countable.page.LoginPage;
import com.qa.countable.page.SignUp;
public class SignupTest extends Basepage {
	WebDriver driver;
	Basepage basepage;
	Properties prop;
	SignUp signup;
	
	@BeforeTest
	public void setup() throws InterruptedException {
		signup=new SignUp(driver);
		basepage = new Basepage();
		prop = basepage.init_properties();
		String browserName = prop.getProperty("browser");
		driver = basepage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
	}

	
	@Test(priority=1)
	public void signupClick() throws InterruptedException {
		
		signup.signuplinkDisplayed();
	
	}
	
	
	
}







