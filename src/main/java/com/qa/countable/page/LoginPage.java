package com.qa.countable.page;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.countable.base.Basepage;
import com.qa.countable.util.ElementUtil;

public class LoginPage extends Basepage {
	WebDriver driver;

	ElementUtil elementutil;

	// 1.create locators using by
	By emailid = By.xpath("//input[@formcontrolname='emailId']");
	By password = By.xpath("//input[@formcontrolname='password']");
	By Loginbtn = By.xpath("//span[contains(text(),'Login')]");
	By singup = By.xpath("//span[normalize-space()='Sign up']");
	By xeroicon = By.xpath("//img[@alt='xero']");
	By xeroemail = By.xpath("//input[@type='email']");
	By xeropass = By.xpath("//input[@type='password']");
	By xerologinbutton = By.xpath("//button[@value='login']");
	By notNow = By.xpath("//button[contains(text(),'Not now')]");
	By UserProfile = By.className("user-profile");
	By Logout = By.xpath("//span[contains(text(),'Log out')]");
	By sageIcon = By.xpath("//img[@alt='sage']");
	By sageemail = By.xpath("//input[@type='email']");
	By sagepass = By.xpath("//input[@type='password']");
	By sagelogin = By.xpath("//button[@name='submit']");
	By sagecountry = By.xpath("//li[@id='ca']");
	By allowbutton = By.className("carbon-button--primary");
	By qbicon=By.xpath("//img[@alt='qb']");
	By qbEmail=By.xpath("//input[@name='Email or User ID']");
	By qbPass=By.xpath("//input[@name='Password']");
	By qbSubmit=By.xpath("//button[@type='submit']");
	By qbSMS=By.xpath("//button[@data-testid='challengePickerOption_SMS_OTP']");

	public LoginPage(WebDriver driver) throws InterruptedException, AWTException {
		this.driver = driver;
		elementutil = new ElementUtil(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		elementutil.zoomout();
		
	}

	// Page Actions
	public String getPagetitle() {
		return elementutil.doGetTitle();
	}

	public boolean checksignuplink() {
		return elementutil.doIsdisplayed(singup);
	}

	public Dashboard dologin(String username, String pwd) throws InterruptedException {
		Thread.sleep(3000);
		elementutil.doSendkey(emailid, username);
		elementutil.doSendkey(password, pwd);
		elementutil.doClick(Loginbtn);
		Thread.sleep(3000);

		return new Dashboard(driver);
	}

	public void loginwithXero(String xusername, String xpwd) throws InterruptedException {
		elementutil.doClick(xeroicon);
		Thread.sleep(10000);

		elementutil.doSendkey(xeroemail, xusername);
		Thread.sleep(2000);
		elementutil.doSendkey(xeropass, xpwd);
		elementutil.doClick(xerologinbutton);
		elementutil.doClick(notNow);
		Thread.sleep(3000);
		logout();

	}

	public void loginwithSage(String susername, String spwd) throws InterruptedException {
		elementutil.doClick(sageIcon);
		Thread.sleep(10000);
		elementutil.doClick(sagecountry);
		Thread.sleep(2000);
		elementutil.doSendkey(sageemail, susername);
		elementutil.doSendkey(sagepass, spwd);
		elementutil.doClick(sagelogin);
		elementutil.doClick(allowbutton);
		Thread.sleep(3000);
		logout();

	}
	
	
	public void loginwithQB(String qusername, String qpwd) throws InterruptedException {
		elementutil.doClick(qbicon);
		Thread.sleep(10000);
		elementutil.doSendkey(qbEmail, qusername);
		elementutil.doSendkey(qbPass, qpwd);
		elementutil.doClick(qbSubmit);
		Thread.sleep(3000);
		elementutil.doClick(qbSMS);
		logout();

	}

	public void logout() throws InterruptedException {
		elementutil.getElement(UserProfile).click();
		Thread.sleep(3000);
		elementutil.getElement(Logout).click();
		Thread.sleep(3000);
	}
}
