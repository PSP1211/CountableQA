package com.qa.countable.tests;

import java.awt.AWTException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.countable.base.Basepage;
import com.qa.countable.page.Dashboard;
import com.qa.countable.page.LoginPage;
import com.qa.countable.page.Team;

public class TeamTest {
	WebDriver driver;
	Basepage basepage;
	Properties prop;
	LoginPage lp;
	Dashboard dashboard;
	Team tm;
	int a, b, c, d, e, f;

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
	}

	@Test(priority = 1)
	public void teampageDisplayed() throws InterruptedException {
		tm.navigateTeam();

	}

	
	public void SearchTeam() throws InterruptedException {
		tm.Search();

	}

	@Test(priority = 2)
	public void TeamCount() throws InterruptedException {
		a = tm.partnerCount();
		System.out.println("Total Partner members " + a);
		d = tm.actualPartner();
		Assert.assertEquals(a, d);
		b = tm.staffCount();
		System.out.println("Total Staff members " + b);
		e = tm.actualStaff();
		Assert.assertEquals(b, e);
		c = a + b;
		System.out.println("Total Team members " + c);
		f = tm.TotalTeam();
		Assert.assertEquals(c, f);

	}

	/*
	 * @Test(priority=3) public void deleteTeam() throws InterruptedException {
	 * tm.deleteTeam();
	 * 
	 * }
	 */
	@Test(priority = 3)
	public void inviteEmails() throws InterruptedException {
		tm.emailInvite();
	}

}
