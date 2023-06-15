package com.qa.countable.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.countable.base.Basepage;
import com.qa.countable.util.ElementUtil;

public class Dashboard extends Basepage {

	WebDriver driver;
	ElementUtil elementutil;

	By header = By.xpath("//h4[contains(text(),'Dashboard')]");
	By search = By.xpath("//input[@id='mat-input-2']");
	By notifications = By.xpath("//mat-icon[contains(text(),'notifications')]");
	By viewteam = By.xpath("//span[contains(text(),'View Team')]");
	By viewclient = By.xpath("//span[contains(text(),'View Clients')]");
	By dashboardredirect = By.xpath("//span[contains(text(),'Dashboard')]");
			//.xpath("/html/body/app-root/app-dashboard/div/div[2]/div/div[1]/app-side-menu/nav/ul/li[1]/a/span[1]/i");
	By SearchResults = By.xpath("//div[contains(@class,'body-details-body')]//div[contains(@class,'engname')]");
	By clickengagement = By.xpath(("//p[contains(text(),'Sage v15.0')]/preceding::p[1]"));

	public Dashboard(WebDriver driver) {
		this.driver = driver;
		elementutil = new ElementUtil(driver);

	}

	public String dashboardtitle() {
		return elementutil.doGetTitle();

	}

	public String getHomepageheader() {
		// return driver.findElement(header).getText();
		return elementutil.getText(header);
	}

	public void searchonDashboard() throws InterruptedException {
		// driver.findElement(search).sendKeys("v15");
		Thread.sleep(3000);
		elementutil.doSendkey(search, "v15");
		Thread.sleep(5000);
		List<WebElement> elements = driver.findElements(SearchResults);
		System.out.println("No of engagaments contains v15: " + elements.size());
		Thread.sleep(5000);
		for (WebElement i : elements) {

			String s = i.getText();
			System.out.println(s);

		}
		elementutil.doClick(clickengagement);

		Thread.sleep(5000);
		BackOnDashboard();

	}

	public void ViewTeamClick() throws InterruptedException {
		// driver.findElement(viewteam).click();
		elementutil.doClick(viewteam);
		Thread.sleep(3000);
		System.out.println("Successfully clicked on Team");

		BackOnDashboard();
	}

	public void BackOnDashboard() throws InterruptedException {

		elementutil.doClick(dashboardredirect);

		Thread.sleep(5000);
	}

	public void ViewClientClick() throws InterruptedException {
		// driver.findElement(viewclient).click();
		Thread.sleep(2000);
		elementutil.doClick(viewclient);
		Thread.sleep(2000);
		// return new Team(driver);
		System.out.println("Successfully clicked on Client");
		Thread.sleep(2000);
		BackOnDashboard();
	}

}
