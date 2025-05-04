package com.ocean.crm.generic.listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.ocean.crm.generic.baseutility.BaseClass;

public class ListenerImp implements ITestListener, ISuiteListener {
	ExtentReports report;
	ExtentTest test;
	String time = new Date().toString().replace(" ","_").replaceAll(":","_");

	@Override
	public void onStart(ISuite suite) {
		//spark report config
		System.out.println("Report configuration");
		ExtentSparkReporter spark= new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		spark.config().setDocumentTitle("CRM testsuite result");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		//add configuration and create test
		report= new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("Browser", "Chrome-135");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report Backup");
		report.flush();
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("=====Start======>"+result.getMethod().getMethodName());
		test= report.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("=====End======>"+result.getMethod().getMethodName());
		test= report.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		TakesScreenshot ts=(TakesScreenshot)BaseClass.sdriver;
		String testName=result.getMethod().getMethodName();
		
//		File src = ts.getScreenshotAs(OutputType.FILE);
//		
//		try {
//			File dest = new File("./ScreenShot/"+testName+" "+time+".png");
//			FileUtils.copyFile(src, dest);
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//		}
		String filePath = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(filePath,testName+" "+time);
		test.log(Status.FAIL, result.getMethod().getMethodName());	
	}
	

	@Override
	public void onTestSkipped(ITestResult result) {
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {
	}
	

}
