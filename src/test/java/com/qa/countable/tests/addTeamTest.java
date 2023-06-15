package com.qa.countable.tests;

import java.awt.AWTException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.countable.base.Basepage;
import com.qa.countable.page.Dashboard;
import com.qa.countable.page.LoginPage;
import com.qa.countable.page.Team;
import com.qa.countable.page.addTeam;

public class addTeamTest {

	WebDriver driver;
	Basepage basepage;
	Properties prop;
	LoginPage lp;
	Dashboard dashboard;
	Team tm;
	addTeam at;

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
		at = new addTeam(driver);

	}

	@Test(priority = 1)
	public void navigateTeam() throws InterruptedException {
		at.teamNavigation();
	}

	@Test(priority = 2)
	public void addGen() throws InterruptedException {
		at.addgenUser();
		System.out.println("General user added successfully ");
	}

	@Test(priority = 3)
	public void addAdm() throws InterruptedException {
		at.addAdminUser();
		
		System.out.println("Admin user added successfully ");
	}

	@Test(priority = 4)
	public void addLim() throws InterruptedException

	{
		at.addLimUser();
		System.out.println("Limited user added successfully ");
	}
	
	@Test(priority=5)
	public void deleteTeamMember() throws InterruptedException
	{
		at.deleteTeam();
		String dt=at.deleteTeam();
		System.out.println("Toaster message is "+dt);
		try {
			Assert.assertEquals(dt, "Team member deleted successfully");
		}catch(Exception e)
		{
			System.out.println("Toaster message is incorrect");
		}
		
		System.out.println("Team Members deleted Successfully ");
		
	}

	@AfterTest
	public void uploadTeamM() throws InterruptedException {
		at.uploadteam();
		System.out.println("Team Members browsed Successfully ");
	}

}
