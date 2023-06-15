package com.qa.countable.page;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.countable.base.Basepage;
import com.qa.countable.util.ElementUtil;

public class addTeam extends Basepage {

	WebDriver driver;
	ElementUtil elementutil;
	LoginPage lp;
	Dashboard dashboard;

	By NavigateTeam = By.xpath("//i[normalize-space()='person']");
	By addTeamM = By.xpath("//span[contains(text(),'Add Team')]");
	By addNewTeam = By.xpath("//button[contains(text(),'Add New Member')]");
	By category = By.xpath("//ng-select[@formcontrolname='category']");
	By partcategory = By.xpath("//span[normalize-space()='Partner']");
	By staffcategory = By.xpath("//span[contains(text(),'Staff')]");
	By firstName = By.xpath("//input[@formcontrolname='firstName']");
	By lastName = By.xpath("//input[@formcontrolname='lastName']");
	By businessphone = By.xpath("//input[@formcontrolname='businessPhone']");
	By cellphone = By.xpath("//input[@formcontrolname='cellPhone']");

	By hrlyrate = By.xpath("//input[@formcontrolname='hourlyRate']");
	By email = By.xpath("//input[@formcontrolname='teamEmail']");
	By licence = By.xpath("//input[@formcontrolname='licenseNo']");
	By title = By.xpath("//input[@formcontrolname='teamTitle']");
	By selectaccessdrp = By.xpath("//ng-select[@formcontrolname='memberaccessType']");
	By admin = By.xpath("(//span[contains(text(),'Admin')])[2]");
	By limited = By.xpath("//span[contains(text(),'Limited')]");
	By addbutton = By.xpath("(//button[@color='primary'])[1]");
	By uploadteam = By.xpath("//button[contains(text(),'Upload Existing Member')]");
	By browseteam = By.xpath("//input[@type='file']");
	By upload = By.xpath("//span[normalize-space()='Upload']");
	By deleteteam=By.xpath("(//i[contains(.,'delete')])[1]");
	By deleteyes=By.xpath("//span[contains(text(),'Yes')]");
	By deletetoaster=By.xpath("//div[contains(text(),'Team member deleted successfully')]");

	public addTeam(WebDriver driver) {
		this.driver = driver;
		elementutil = new ElementUtil(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void teamNavigation() throws InterruptedException {
		Thread.sleep(2000);
		elementutil.doClick(NavigateTeam);
		Thread.sleep(10000);
		elementutil.doClick(addTeamM);
		elementutil.doClick(addNewTeam);

	}

	public void addgenUser() throws InterruptedException {
		Thread.sleep(2000);
		elementutil.doClick(category);
		elementutil.doClick(partcategory);

		elementutil.doSendkey(firstName, "Selenium");
		elementutil.doSendkey(lastName, "With Java");
		elementutil.doSendkey(businessphone, "9975345336");
		elementutil.doSendkey(cellphone, "9975345676");
		elementutil.doSendkey(hrlyrate, "20");
		elementutil.doSendkey(email, "seleniumwithjava@yopmail.com");
		elementutil.doSendkey(licence, "32123");
		elementutil.doSendkey(title, "QA");

		Thread.sleep(3000);
		elementutil.doClick(addbutton);
		Thread.sleep(5000);

	}

	public void addAdminUser() throws InterruptedException {

		elementutil.doClick(addTeamM);
		elementutil.doClick(addNewTeam);
		Thread.sleep(2000);
		elementutil.doClick(category);
		elementutil.doClick(staffcategory);

		elementutil.doSendkey(firstName, "Selenium");
		elementutil.doSendkey(lastName, "Admin");
		elementutil.doSendkey(businessphone, "9977645336");
		elementutil.doSendkey(cellphone, "9990345676");
		elementutil.doSendkey(hrlyrate, "30");
		elementutil.doSendkey(email, "seleniumadmin@yopmail.com");
		elementutil.doSendkey(licence, "321523");
		elementutil.doSendkey(title, "QAQA");
		Thread.sleep(2000);
		elementutil.doClick(selectaccessdrp);
		Thread.sleep(2000);
		elementutil.doClick(admin);
		Thread.sleep(3000);
		elementutil.doClick(addbutton);

		Thread.sleep(3000);
	}

	public void addLimUser() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		elementutil.doClick(addTeamM);
		elementutil.doClick(addNewTeam);
		Thread.sleep(2000);
		elementutil.doClick(category);
		elementutil.doClick(staffcategory);

		elementutil.doSendkey(firstName, "Selenium");
		elementutil.doSendkey(lastName, "Limited");
		elementutil.doSendkey(businessphone, "9977667336");
		elementutil.doSendkey(cellphone, "9987345676");
		elementutil.doSendkey(hrlyrate, "15");
		elementutil.doSendkey(email, "seleniumlimited@yopmail.com");
		elementutil.doSendkey(licence, "327823");
		elementutil.doSendkey(title, "QAQAQA");
		Thread.sleep(2000);
		elementutil.doClick(selectaccessdrp);
		Thread.sleep(2000);
		elementutil.doClick(limited);
		Thread.sleep(3000);
		elementutil.doClick(addbutton);

		Thread.sleep(3000);
	}

	public void uploadteam() throws InterruptedException {
		
		Thread.sleep(3000);
		elementutil.doClick(addTeamM);

		elementutil.doClick(uploadteam);
		try {
			elementutil.doSendkey(browseteam, "C:/Users/Dell/Desktop/AccountTeamImport.csv");
		}catch(Exception e)
		{
			System.out.println("File path is not found");
		}
		

		elementutil.doClick(upload);

	}
	
	public String deleteTeam() throws InterruptedException
	{
		Thread.sleep(3000);
		elementutil.doClick(deleteteam);
		elementutil.doClick(deleteyes);
		//Alert alt=driver.switchTo().alert();
		//alt.accept();
		Thread.sleep(2000);
		return elementutil.getText(deletetoaster);
	}

}
