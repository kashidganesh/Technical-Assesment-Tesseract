package com.PageObject;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.testCases.TC01;

public class Listener extends TestListenerAdapter{
	private static final Logger log = Logger.getLogger(TC01.class);
	public void onTestStart(ITestResult tr) {
		System.out.println("Test started");
		log.info("Test started");
	}
	
	public void onTestSuccess(ITestResult tr) {
		System.out.println("Test passed");
		log.info("Test passed");
	}
	
	public void onTestFailure(ITestResult tr) {
		System.out.println("Test failed");
		log.info("Test failed");
	}
	
	public void onTestSkipped(ITestResult tr) {
		System.out.println("Test Skipped");
		log.info("Test Skipped");
	}
	
}
