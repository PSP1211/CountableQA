package com.qa.countable.page;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.qa.countable.base.Basepage;
import com.qa.countable.util.ElementUtil;

public class StatementInWorkbook extends Basepage {

	WebDriver driver;
	ElementUtil elementutil;
	LoginPage lp;
	Dashboard dashboard;
	Engagements em;

	By workBookIcon = By.xpath("//button[@title='Workbook']");
	By statementIcon = By.xpath("//span[@title='Statement of Loss and Deficit']");
	By collapse = By.xpath("//button[contains(@title,'Collapse All')]");
	By expand = By.xpath("//button[contains(@title,'Expand All')]");
	By checkBox = By.xpath("//label[@for='mat-checkbox-343-input']");
	By areaExpanded = By.xpath("(//mat-expansion-panel-header[@aria-expanded='false'])[1]");
	By createGroupbutton = By.xpath("//span[contains(text(),'Create Group')]");
	By groupName = By.xpath("//input[@class='cg-text txt-fld ng-untouched ng-pristine ng-valid']");
	By create = By.xpath("//span[normalize-space()='Create']");
	By previewOpen = By.xpath("(//i[contains(text(),'keyboard_arrow_left')])[2]");
	By preview = By.id("income-statement-preview");

	public StatementInWorkbook(WebDriver driver) throws InterruptedException, AWTException {
		this.driver = driver;
		elementutil = new ElementUtil(driver);
		Thread.sleep(2000);
		em = new Engagements(driver);
	}

	public void navigateWB() throws InterruptedException {

		em.navigatetoEngagementList();
		Thread.sleep(5000);
		em.searchOnEngagement();
		Thread.sleep(2000);
		em.clickOnEngagementId();
		Thread.sleep(2000);
		elementutil.doClick(workBookIcon);
		Thread.sleep(5000);
		elementutil.switchWindow();
		Thread.sleep(5000);
		elementutil.doClick(statementIcon);

	}

	public void expandCollapse() throws InterruptedException {

		// elementutil.doClick(collapse);
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		WebElement collele = elementutil.getElement(collapse);
		Thread.sleep(3000);
		action.click(collele).build().perform();
		Thread.sleep(3000);
		WebElement ele = elementutil.getElement(expand);
		Thread.sleep(3000);
		action.click(ele).build().perform();

	}

	public void createGroup() throws InterruptedException {
		elementutil.wait(1);
		elementutil.doClick(checkBox);
		elementutil.doClick(createGroupbutton);
		elementutil.wait(2);
		elementutil.doSendkey(groupName, "SelWebDriver");
		elementutil.doClick(create);
		elementutil.wait(2);

	}

	public void preview() {
		elementutil.wait(2);
		elementutil.getElement(preview).isDisplayed();
		elementutil.doClick(previewOpen);
		elementutil.wait(2);
		elementutil.getElement(preview).isDisplayed();
	}

}
