package com.qa.countable.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.qa.countable.base.Basepage;
import com.qa.countable.util.ElementUtil;

public class ExtentTestNGTestListener implements ITestListener {

	ExtentReports extent = ExtentManager.getInstance();

	ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();

	ExtentTest extentTest;

	public synchronized void onTestStart(ITestResult result) {

		System.out.println("LOG:INFO - Test Created In report");

		extentTest = extent.createTest(result.getName());

		parentTest.set(extentTest);

	}

	public synchronized void onTestSuccess(ITestResult result) {
		System.out.println("LOG:INFO - Test Executed Successfully");

	}

	public synchronized void onTestFailure(ITestResult result) {
		System.out.println("LOG:INFO - Test Failed");

		String screenshot = ElementUtil.captureScreenShotInBase64(Basepage.getBrowserInstance());

		parentTest.get().log(Status.FAIL, result.getThrowable().getMessage(),
				MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());

		System.out.println("LOG:INFO - Appending Test Result To Report");
	}

	public synchronized void onTestSkipped(ITestResult result) {
		System.out.println("LOG:INFO - Test Skipped");

	}

	public synchronized void onFinish(ITestContext context) {

		extent.flush();
		System.out.println("LOG:INFO - Writing all result to report");

	}
}
