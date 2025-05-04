package com.ocean.crm.generic.webdriverutility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class UtilityClassObject {
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	public static ThreadLocal<WebDriver> driver= new ThreadLocal<WebDriver>();
	/**
	 * @return the test
	 */
	public static ThreadLocal<ExtentTest> getTest() {
		return test;
	}
	/**
	 * @param test the test to set
	 */
	public static void setTest(ThreadLocal<ExtentTest> test) {
		UtilityClassObject.test = test;
	}
	/**
	 * @return the driver
	 */
	public static ThreadLocal<WebDriver> getDriver() {
		return driver;
	}
	/**
	 * @param driver the driver to set
	 */
	public static void setDriver(ThreadLocal<WebDriver> driver) {
		UtilityClassObject.driver = driver;
	}
	

}
