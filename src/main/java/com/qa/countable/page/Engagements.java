package com.qa.countable.page;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.countable.base.Basepage;
import com.qa.countable.util.ElementUtil;

public class Engagements extends Basepage {
	WebDriver driver;
	ElementUtil elementutil;
	LoginPage lp;
	Dashboard dashboard;
	Robot robot = new Robot();

	By engagementsicon = By.xpath("//a[@title='Engagements']");
	By engagementText = By.xpath("//h4[contains(text(),'Engagements')]");
	By engagmentTotal = By.xpath("(//h1[1])[1]");
	By neworinprogress = By.xpath("(//h1[1])[2]");
	By completedEngagements = By.xpath("(//h1[1])[3]");
	By archivedEngagements = By.xpath("(//h1[1])[4]");
	By rowCount = By.xpath("//tr/td[2]");
	By inProgress = By.xpath("//p[@title='In Progress']");
	By newe = By.xpath("//p[@title='New']");
	By searchOnengagement = By.xpath("//input[@placeholder='Search']");
	By containSearchText = By.xpath("//tr/td[2]");
	By engagementId = By.xpath("//a[@title='COM-V14-Dec312021']");
	By procedureicon = By.xpath("//span[contains(text(),'Procedures')]");
	By assetsIcon = By.xpath("//span[@title='Assets']");
	By currentAssets = By.xpath("//span[contains(text(),'Current assets')]");
	By cashandequivalent = By.xpath("//span[contains(text(),'Cash and cash equivalents')]");
	By apply = By.xpath("//span[contains(normalize-space(),'Apply')]");
	By ticktoaster = By.xpath("//div[contains(text(),'Tickmark applied successfully')]");
	By newlyAdded = By.xpath("//span[@title='Newly Added']");
	By newadd = By.xpath("//button[@class='transparent-btn no-pad new']");
	By code = By.xpath("//i[normalize-space()='Code']/following::input[1]");
	By description = By.xpath("//i[normalize-space()='Code']/following::input[2]");
	By addButton = By.xpath("//span[contains(text(),'Add')]");
	By addticktoaster = By.xpath("//div[contains(text(),'Tickmark added successfully')]");
	By addnoteTextarea = By.xpath("//textarea[@placeholder='Type here']");
	By savenoteButton = By.xpath("//textarea[@placeholder='Type here']/following::span[text()=' Save ']");
	// By
	// tick=By.xpath("((//p[normalize-space()='1001']/following::td/div/div/p)[1]");
	By note = By.xpath("(//button[@title='Note']/i[contains(text(),'note')][1])[1]");
	By tick = By.xpath("(//tr/td[9])[1]");
	By nmtick = By.xpath("(//tbody/tr/td/mat-checkbox)[2]");
	By pytick = By.xpath("(//tbody/tr/td/mat-checkbox)[3]");
	By addnotetoaster = By.xpath("//div[contains(text(),'Added note successfully')]");
	By middlePanel = By.xpath("//div[@class='ntr-panel-middle']");
	By tickaalreadyexist = By.xpath("//p[contains(text(),'Tick Mark already exists')]");
	By backArrow = By.xpath("//i[contains(text(),'arrow_back')]");
	// Comment
	By comment = By.xpath("(//i[contains(text(),'comment')][1])[1]");
	By commentTextArea = By.xpath("//textarea[@formcontrolname='commentDesc']");
	By submitComment = By.xpath("//span[contains(text(),'Submit')]");
	By toasterComment = By.xpath("//div[contains(text(),'New comment created successfully')]");
	// Issue
	By issueIcon = By.xpath("(//i[contains(text(),'assignment_late')])[1]");
	By issueTitle = By.xpath("//input[@formcontrolname='issueTitle']");
	By issueDescription = By.xpath("//textarea[@formcontrolname='issueDescription']");
	By clickCalendaricon = By.xpath("//button[@aria-label='Open calendar']");
	By date = By.xpath("//button[@aria-label='May 31, 2023']");
	By submitIssue = By.xpath("//span[contains(text(),'Submit')]");

	// DocRequest
	By newDocRequesticon = By.xpath("(//span[contains(text(),'folder')])[1]");
	By docName = By.xpath("//input[@formcontrolname='reqdocname']");
	By docRequestdesc = By.xpath("//textarea[@formcontrolname='description']");
	By browseAttach = By.xpath("//input[@type='file']");
	By sendRequestbutton = By.xpath("//span[contains(text(),'Send Request')]");
	By sendNow = By.xpath("//button[contains(text(),'Send Now')]");
	
	//Add Reference
	By addreficon=By.xpath("(//i[contains(text(),'note_add')])[1]");
	By selectDoc=By.xpath("(//div[@role='combobox'])[2]");
	By file=By.xpath("//div[@class='file-name']");
	By addDoc=By.xpath("//span[normalize-space()='Add']");
	By refToaster=By.xpath("//div[contains(text(),'References added successfully')]");
	
	

	public Engagements(WebDriver driver) throws InterruptedException, AWTException {

		this.driver = driver;
		elementutil = new ElementUtil(driver);
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

	}
	
	public void navigatetoEngagementList()
	{
		
		elementutil.doClick(engagementsicon);
	}

	public String navigateEngagement() throws InterruptedException, AWTException {
		
		elementutil.doClick(engagementsicon);
		Thread.sleep(3000);
		return elementutil.getText(engagementText);

	}

	public String totalEngagementsCount() {
		return elementutil.getText(engagmentTotal);

	}

	public String neworinprogressEngagementsCount() {
		return elementutil.getText(neworinprogress);

	}

	public String completedEngagementsCount() {
		return elementutil.getText(completedEngagements);

	}

	public String archivedEngagementsCount() {
		return elementutil.getText(archivedEngagements);

	}

	public int engagementRowCount() {

		List<WebElement> engagementList = driver.findElements(rowCount);

		int e = engagementList.size();
		return e;

	}

	public int inprogressEngagements() {
		List<WebElement> inProg = driver.findElements(inProgress);
		return inProg.size();

	}

	public int newEngagements() {
		List<WebElement> newk = driver.findElements(newe);
		return newk.size();

	}

	public void searchOnEngagement() throws InterruptedException {
		elementutil.doSendkey(searchOnengagement, "v14");
		Thread.sleep(3000);
		List<WebElement> engagementList = driver.findElements(containSearchText);
		engagementList.size();
		for (WebElement i : engagementList) {
			System.out.println(i.getText());
		}
	}

	public void clickOnEngagementId() {
		elementutil.doClick(engagementId);
	}

	public void procedures() throws InterruptedException {
		Thread.sleep(5000);
		elementutil.doClick(procedureicon);
		elementutil.doClick(assetsIcon);
		elementutil.doClick(currentAssets);
		elementutil.doClick(cashandequivalent);
		Thread.sleep(5000);
	}

	public String tick() {
		elementutil.doClick(tick);
		elementutil.doClick(nmtick);
		elementutil.doClick(pytick);
		elementutil.doClick(apply);
		return elementutil.getText(ticktoaster);
	}

	public String addNewtick() throws InterruptedException {

		Thread.sleep(2000);
		elementutil.doClick(tick);
		elementutil.doClick(newadd);
		
		elementutil.doSendkey(code, "PC");

		elementutil.doSendkey(description, "Permutation and Combination");
		elementutil.doClick(addButton);

		Thread.sleep(2000);
		elementutil.doClick(middlePanel);
		return elementutil.getText(addticktoaster);

	}

	public String addNote() throws InterruptedException {
		Thread.sleep(2000);
		elementutil.doClick(note);
		elementutil.doSendkey(addnoteTextarea, "This is the new note added through automation");
		elementutil.doClick(savenoteButton);
		return elementutil.getText(addnotetoaster);
		
	}

	public void commentinProcedures() throws InterruptedException {
		Thread.sleep(1000);
		elementutil.doClick(comment);
		Thread.sleep(1000);

		elementutil.doSendkey(commentTextArea, "This is my comment added using selenium ");
		elementutil.doClick(submitComment);
		Thread.sleep(2000);

	}

	public void issueInProcedures() throws InterruptedException {
		Thread.sleep(2000);
		elementutil.doClick(issueIcon);
		elementutil.doSendkey(issueTitle, "PSP automation testing");
		elementutil.doSendkey(issueDescription, "This is description entered with the help of automation tools");
		elementutil.doClick(clickCalendaricon);
		elementutil.doClick(date);
		elementutil.doClick(submitIssue);
		Thread.sleep(2000);
	}

	public void newDocrequest() throws InterruptedException {
		Thread.sleep(2000);
		elementutil.doClick(newDocRequesticon);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",tick);
		Thread.sleep(1000);
		elementutil.doSendkey(docName, "ITR 2022");
		elementutil.doSendkey(docRequestdesc, "Kindly provide the document");
		elementutil.doClick(clickCalendaricon);
		elementutil.doClick(date);
		elementutil.doSendkey(browseAttach, "C:/Users/Dell/Desktop/COMP-5117.pdf");
		elementutil.doClick(sendRequestbutton);
		elementutil.doClick(sendNow);
		Thread.sleep(2000);
	}

	
	public String addReferenceDoc() throws InterruptedException
	{
		Thread.sleep(2000);
		elementutil.doClick(addreficon);
		elementutil.doClick(selectDoc);
		elementutil.doClick(file);
		elementutil.doClick(addDoc);
		return elementutil.getText(refToaster);
	}
	
	
	
	
	
	
	
	
	
}
