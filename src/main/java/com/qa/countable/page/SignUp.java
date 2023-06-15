package com.qa.countable.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.countable.base.Basepage;
import com.qa.countable.util.ElementUtil;



public class SignUp extends Basepage {
	
	
	WebDriver driver;
	ElementUtil elementutil;
	
	By signUplink=By.xpath("//span[normalize-space()='Sign up']");
	By cc=By.xpath("//div[contains(@class,'mat-select-arrow')]");
	
	
	public SignUp(WebDriver driver) throws InterruptedException {
		this.driver = driver;
		elementutil = new ElementUtil(driver);
		Thread.sleep(2000);
		
	}
	public void signuplinkDisplayed() throws InterruptedException
	{
		
		
		Thread.sleep(4000);
		System.out.println("QA team working together");
		try {
		elementutil.doClick(signUplink);
		}
		catch(Exception e)
		{
			System.out.println("Some exception is occuring due to the clickable method");
		}
	
	}
	

}