package com.qa.countable.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.countable.util.ElementUtil;


public class ExtentManager 
{
	public static ExtentReports extent;
	
	public static ExtentReports getInstance()
	{
		
		if(extent==null)
		{
			extent=createInstance();
			return extent;
		}
		else
		{
			return extent;
		}
	
	}

	public static ExtentReports createInstance()
	{
		ExtentSparkReporter reporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/Report_"+ElementUtil.getCurrentDateTime() +".html");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setDocumentTitle("Countable");
		reporter.config().setReportName("Automation Report");
		
		ExtentReports extent=new ExtentReports();
		
		extent.attachReporter(reporter);
		
		return extent;
		
		
	}
	
}
