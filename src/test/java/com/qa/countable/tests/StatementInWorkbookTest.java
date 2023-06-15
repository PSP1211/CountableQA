package com.qa.countable.tests;

import java.awt.AWTException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.countable.base.Basepage;
import com.qa.countable.page.Dashboard;
import com.qa.countable.page.Engagements;
import com.qa.countable.page.LoginPage;
import com.qa.countable.page.StatementInWorkbook;
import com.qa.countable.page.Team;

public class StatementInWorkbookTest {

	WebDriver driver;
	Basepage basepage;
	Properties prop;
	LoginPage lp;
	Dashboard dashboard;
	Team tm;
	Engagements em;
	StatementInWorkbook swb;

	@BeforeTest
	public void setup() throws InterruptedException, AWTException {
		basepage = new Basepage();
		prop = basepage.init_properties();
		String browserName = prop.getProperty("browser");
		driver = basepage.init_driver(browserName);
		driver.get(prop.getProperty("url"));

		lp = new LoginPage(driver);
		dashboard = lp.dologin(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(5000);
		tm = new Team(driver);
		em = new Engagements(driver);
		swb = new StatementInWorkbook(driver);

	}

	@Test(priority = 1)
	public void navigateWorkbook() throws InterruptedException {
		swb.navigateWB();
	}
	
	@Test(priority=2)
	public void expandCollapsetest() throws InterruptedException
	{
		swb.expandCollapse();
		
	}
	
	@Test(priority=3)
	public void createGroupInStatement() throws InterruptedException
	{
		swb.createGroup();
	}
	@Test(priority=4)
	public void previewInStatement()
	{
		swb.preview();
	}

}
