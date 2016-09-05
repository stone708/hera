package com.test;

import org.junit.rules.TestWatchman;
import org.junit.runners.model.FrameworkMethod;

import com.relevantcodes.extentreports.ExtentReports;

public class ScreenshotTaker extends TestWatchman {

	private String testName;
	private String filenameOfReport = "L:/myReportingDir/testReport.html";

	private  ExtentReports report = null;
	
	public ScreenshotTaker(String testName) {
		this.testName = testName;
		//report = new ExtentReports(filenameOfReport, true);
		//report.startTest(testName);
	}

	
	
	@Override
	public void failed(Throwable e, FrameworkMethod method) {
		System.out.println("Write report:error"+method.getName()+e.getMessage());
	}

	// When passed only write to the log.
	@Override
	public void succeeded(FrameworkMethod method) {
		System.out.println("Write report:success");
	}




}