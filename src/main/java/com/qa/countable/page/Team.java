package com.qa.countable.page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.countable.base.Basepage;
import com.qa.countable.util.ElementUtil;

public class Team extends Basepage {

	WebDriver driver;
	ElementUtil elementutil;
	LoginPage lp;
	Dashboard dashboard;

	By NavigateTeam = By.xpath("//i[normalize-space()='person']");
	By SearchOnTeam = By.xpath("//input[@id='mat-input-4']");
	By Result = By.className("mat-row");
	By Partner = By.xpath("(//div[@title='Partner']");
	By staff = By.xpath("(//div[@title='Staff']");
	By partneronApplication = By.xpath("(//div[contains(@class,'client-list')]/div/h1)[1]");
	By StaffOnApplication = By.xpath("(//div[contains(@class,'client-list')]/div/h1)[2]");
	By TeamOnApplication = By.xpath("(//div[contains(@class,'client-list')]/div/h1)[3]");
	By deleteTeamM = By.xpath("(//tr[@role='row']//button[@title='Delete'])[2]");
	By DeleteYes = By.xpath("//span[contains(text(),'Yes')]");
	By InviteSent = By.xpath("//td/div/p[@title='Invite Sent']/preceding::td[4]/mat-checkbox");
	By InviteNow = By.xpath("//td/div/p[@title='Invite Now']/preceding::td[4]/mat-checkbox");
	By InviteAll = By.xpath("//span[normalize-space()='Invite All']");

	By InviteYes = By.xpath("//span[normalize-space()='Yes']");
	By TotalTeamStatus = By.xpath("//tr/td[5]");
	By totalcheckbox = By.xpath("//tr/td[1]/mat-checkbox");
	By associateStatus = By.xpath("//tr/td[1]/following-sibling::td[4]/div/p");
	// By InviteAllDisable = By.xpath("//button[@class='mat-focus-indicator
	// client-docs-btn mat-stroked-button mat-button-base ng-star-inserted
	// disable-invite-button mat-button-disabled']");
	// By InviteAllEnable=By.xpath("//button[@class='mat-focus-indicator
	// client-docs-btn mat-stroked-button mat-button-base ng-star-inserted']");

	public Team(WebDriver driver) throws InterruptedException {
		this.driver = driver;
		elementutil = new ElementUtil(driver);
		Thread.sleep(2000);

	}

	public void navigateTeam() throws InterruptedException {

		Thread.sleep(3000);
		elementutil.doClick(NavigateTeam);
		Thread.sleep(2000);
		System.out.println("Successfully navigated to team module");

	}

	public void Search() throws InterruptedException {

		elementutil.doSendkey(SearchOnTeam, "QA");
		Thread.sleep(2000);

		List<WebElement> teamelements = driver.findElements(Result);
		System.out.println("No of Team members contains QA: " + teamelements.size());
		Thread.sleep(2000);
		elementutil.getElement(SearchOnTeam).clear();
		elementutil.getElement(SearchOnTeam);
		Thread.sleep(5000);

	}

	public int partnerCount() throws InterruptedException {
		Thread.sleep(5000);
		List<WebElement> TotalPartner = driver.findElements(By.xpath("//div[@title='Partner']"));
		Thread.sleep(2000);
		return TotalPartner.size();

	}

	public int staffCount() throws InterruptedException {

		Thread.sleep(2000);
		List<WebElement> TotalStaff = driver.findElements(By.xpath("//div[@title='Staff']"));
		Thread.sleep(2000);
		return TotalStaff.size();

	}

	public int actualPartner() {
		String part = elementutil.getElement(partneronApplication).getText();

		int p = Integer.parseInt(part);
		return p;

	}

	public int actualStaff() {
		String stf = elementutil.getElement(StaffOnApplication).getText();
		int s = Integer.parseInt(stf);
		return s;

	}

	public int TotalTeam() {
		String tt = elementutil.getElement(TeamOnApplication).getText();
		int q = Integer.parseInt(tt);
		return q;

	}

	public void deleteTeam() throws InterruptedException {
		elementutil.doClick(deleteTeamM);
		Thread.sleep(2000);

		elementutil.doClick(DeleteYes);
		System.out.println("Team member deleted successfully ");

	}

	public void emailInvite() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> invites = driver.findElements(By.xpath("//tr/td[14]/div/button[@title='Invite(Re-invite)']"));
		System.out.println(invites.size());
		for (WebElement i : invites) {
			i.click();

		}

	}

	public void InviteSentCheckbox() throws InterruptedException {

		List<WebElement> checkboxes = driver.findElements(totalcheckbox);

		// Loop through the list of checkboxes and find the desired checkbox element
		for (WebElement checkbox : checkboxes) {
			WebElement statusElement = checkbox.findElement(associateStatus); // find the status element associated with
																				// the checkbox
			String statusText = statusElement.getText().trim(); // get the text of the status element
			if (statusText.equals("Invite Sent") || statusText.equals("Invite Now")) {
				checkbox.click(); // click on the checkbox element to check it
			}
		}

		// System.out.println(elementutil.getElement(InviteAllDisable).isEnabled());

		/*
		 * elementutil.doClick(InviteSent); Thread.sleep(2000);
		 * elementutil.doClick(InviteNow); Thread.sleep(2000);
		 * elementutil.doClick(InviteAll);
		 * //System.out.println(elementutil.getElement(InviteAllEnable).isEnabled());
		 * Thread.sleep(2000); //driver.switchTo().alert().accept();
		 * elementutil.doClick(InviteYes);
		 */

		/*
		 * List<WebElement> teamStatus = driver.findElements(TotalTeamStatus);
		 * List<WebElement> checkboxes = driver.findElements(totalcheckbox); int ts =
		 * teamStatus.size(); for (WebElement j : checkboxes) { for (WebElement i :
		 * teamStatus) { if (i.equals(InviteSent) || (i.equals(InviteNow))) { j.click();
		 * }
		 * 
		 * }
		 */

		/*
		 * if(ss.equalsIgnoreCase("Invite Now") || ss.equalsIgnoreCase("Invite Sent")) {
		 * 
		 * Thread.sleep(3000); elementutil.doClick(InviteSent); Thread.sleep(3000);
		 * elementutil.doClick(InviteNow); Thread.sleep(3000);
		 * 
		 * 
		 * }
		 */

	}

}
