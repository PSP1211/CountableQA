package com.qa.countable.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basepage {
	static WebDriver driver;
	Properties prop;
	
	
	public static WebDriver getBrowserInstance() {
		// TODO Auto-generated method stub
		return driver;
	}

	public WebDriver init_driver(String browsername) {
		System.out.println("Browser Name is " + browsername);
		if (browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new ChromeDriver();
		} else {

			System.out.println("browser Name " + browsername + " is not found");
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return driver;
	}

	public Properties init_properties() {

		prop = new Properties();
		String path = "C:/Users/Dell/eclipse-workspace/April2023Automation/src/main/java/com/qa/countable/config/config.properties";
		try {
			FileInputStream ip = new FileInputStream(path);
			prop.load(ip);
		} catch (FileNotFoundException e) {

			System.out.println("Config file path is not correct...Please chnage the path");
		} catch (IOException e) {

			e.printStackTrace();
		}
		return prop;

	}
	public static String getProperty(String key)
	{
		Properties pro=new Properties();
		
		try 
		{
			pro.load(new FileInputStream(new File(System.getProperty("user.dir")+"/Config/Config.properties")));
		} catch (FileNotFoundException e) 
		{
			System.out.println("File not present "+e.getMessage());
		} catch (IOException e) 
		{
			System.out.println("Unable to load the file "+e.getMessage());
		}
		
		String value=pro.getProperty(key);
		
		return value;
	}
	

}
