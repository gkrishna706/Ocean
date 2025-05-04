package com.ocean.crm.generic.baseutility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.ocean.crm.generic.fileutility.ExcelUtility;
import com.ocean.crm.generic.fileutility.FileUtility;
import com.ocean.crm.generic.webdriverutility.JavaUtility;
import com.ocean.crm.generic.webdriverutility.UtilityClassObject;
import com.ocean.crm.generic.webdriverutility.WebDriverUtility;
import com.ocean.crm.objectrepositoryutility.HomePage;
import com.ocean.crm.objectrepositoryutility.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sdriver;
	public FileUtility fLib = new FileUtility();
	public JavaUtility jLib = new JavaUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public ExtentReports report;
//	public ThreadLocal<WebDriver> driverRef=new ThreadLocal();
//	@Parameters("BROWSER")

//	@BeforeSuite
//	public void configBS() {
//		// spark report config
//		ExtentSparkReporter spark= new ExtentSparkReporter("./AdvanceReport/report.html");
//		spark.config().setDocumentTitle("CRM test suite result");
//		spark.config().setReportName("CRM report");
//		spark.config().setTheme(Theme.DARK);
//		// add env information & create config
//		report= new ExtentReports();
//		report.attachReporter(spark);
//		report.setSystemInfo("OS", "Windows-10");
//		report.setSystemInfo("Browser", "Chrome-135");
//	}

	@BeforeClass(alwaysRun = true)
	public void openBrowser() throws IOException {
		String browser = fLib.getDataFromPropertyFile("browser");
		String url = fLib.getDataFromPropertyFile("url");
		if (browser.equals("chrome"))
			driver = new ChromeDriver();
		else if (browser.equals("firefox"))
			driver = new FirefoxDriver();
		else
			driver = new EdgeDriver();
//		setDriver(driver);
		wLib.maximizeWindow(driver);
		wLib.waitForPageToLoad(driver);
		driver.get(url);
//		sdriver=driver;
//		UtilityClassObject.setDriver(driver);
	}

	@BeforeMethod(alwaysRun = true)
	public void login() throws IOException {
		String userName = fLib.getDataFromPropertyFile("un");
		String password = fLib.getDataFromPropertyFile("pwd");

		LoginPage lp = new LoginPage(driver);
		lp.loginToapp(userName, password);
	}

	@AfterMethod(alwaysRun = true)
	public void logout() {
		HomePage hp = new HomePage(driver);
		WebElement ele = hp.getLogoutIcon();
		wLib.mousemoveOnElement(driver, ele);
		hp.getSignoutLink().click();
	}

	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();

	}
//	public WebDriver getDriver()
//	{
//		return driverRef.get();
//	}
//	public void setDriver(WebDriver driver)
//	{
//		driverRef.set(driver);
//	}

}
