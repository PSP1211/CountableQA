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
import com.qa.countable.page.Team;

public class EngagementTest  {

	WebDriver driver;
	Basepage basepage;
	Properties prop;
	LoginPage lp;
	Dashboard dashboard;
	Team tm;
	Engagements em;

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
		

	}

	@Test(priority = 1)
	public void engagementList() throws InterruptedException, AWTException {
		String et = em.navigateEngagement();
		System.out.println(et);
		Assert.assertEquals(et, "Engagements");

	}

	@Test(priority = 2)
	public void engagementListCount() {
		String total = em.totalEngagementsCount();
		int t = Integer.parseInt(total);
		System.out.println("Total engagements count is " + t);
		int rowcount = em.engagementRowCount();
		Assert.assertEquals(t, rowcount);

	}

	@Test(priority = 3)
	public void inprogressengagements() {
		int i = em.inprogressEngagements();
		System.out.println("Total Inprogress engagements are " + i);
		int j = em.newEngagements();
		System.out.println("Total New engagements are " + j);
		int k = i + j;
		int l = Integer.parseInt(em.neworinprogressEngagementsCount());
		Assert.assertEquals(k, l);
	}

	@Test(priority = 4)
	public void countMatch() {
		int i = em.inprogressEngagements();
		int j = em.newEngagements();
		int k = Integer.parseInt(em.completedEngagementsCount());
		int l = Integer.parseInt(em.archivedEngagementsCount());
		int total = i + j + k + l;

		Assert.assertEquals(total, Integer.parseInt(em.totalEngagementsCount()));
	}

	@Test(priority = 5)
	public void searchOnEngagements() throws InterruptedException {
		em.searchOnEngagement();
	}

	@Test(priority = 6)
	public void clickonEngagements() {
		em.clickOnEngagementId();
		System.out.println("Successfully clicked on engagement Id");
	}

	@Test(priority = 7)
	public void clickOnprocedures() throws InterruptedException {
		em.procedures();
		System.out.println("Successfully navigated to Cash & Equivalent ");
	}

	@Test(priority = 10)
	public void clickTick() throws InterruptedException {
		String ticktoastermessage = em.tick();
		System.out.println(ticktoastermessage);
		Assert.assertEquals(ticktoastermessage, "Tickmark applied successfully");
	}

	@Test(priority = 9)
	public void addnewtick() throws InterruptedException {
		String addtick = em.addNewtick();
		System.out.println(addtick);
		Assert.assertEquals(addtick, "Tickmark added successfully");

	}

	@Test(priority = 8)
	public void addNewNote() throws InterruptedException {
		String note=em.addNote();
		System.out.println(note);
		Assert.assertEquals(note, "Added note successfully");
	}

	@Test(priority = 11)
	public void addComment() throws InterruptedException {
		em.commentinProcedures();

	}

	@Test(priority = 12)
	public void addIssue() throws InterruptedException {
		em.issueInProcedures();

	}

	@Test(priority = 13)
	public void requestDoc() throws InterruptedException {
		em.newDocrequest();

	}

	@Test(priority = 14)
	public void addRef() throws InterruptedException {
		String aref = em.addReferenceDoc();
		System.out.println(aref);
		Assert.assertEquals(aref, "References added successfully");

	}

}
