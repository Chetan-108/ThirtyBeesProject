package com.listeners;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import com.aventstack.extentreports.Status;
import com.utility.DriverUtility;
import com.utility.ReportUtils;


	public class ListnerExample implements ITestListener{

		public void onTestStart(ITestResult result) {
		ReportUtils.test=ReportUtils.report.createTest(result.getName());
		}

		public void onTestSuccess(ITestResult result) {
			ReportUtils.test.log(Status.PASS, "testcase pass with name: "+result.getName() );
			  
		}

		public void onTestFailure(ITestResult result) {
			ReportUtils.test.log(Status.FAIL, "testcase failed with name: "+result.getName() );
		    String path=DriverUtility.getScreenshot(result.getName());
			ReportUtils.test.addScreenCaptureFromPath(path);
		}

		public void onTestSkipped(ITestResult result) {
		 ReportUtils.test.log(Status.SKIP, "testcase skipped with name: "+result.getName());
		}

		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			}

		public void onStart(ITestContext result) {
			ReportUtils.reportInit();
		}

		public void onFinish(ITestContext result) {
			ReportUtils.report.flush();
		}  
		
	}

