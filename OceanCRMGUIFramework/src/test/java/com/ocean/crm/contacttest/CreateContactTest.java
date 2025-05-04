package com.ocean.crm.contacttest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;

import com.ocean.crm.generic.baseutility.BaseClass;
import com.ocean.crm.objectrepositoryutility.ContactPage;
import com.ocean.crm.objectrepositoryutility.HomePage;
import com.ocean.crm.objectrepositoryutility.OrganizationsPage;

public class CreateContactTest extends BaseClass{
	
	@Test(retryAnalyzer =com.ocean.crm.generic.listenerutility.RetryListenerImp.class)
	public void createContactTest() throws IOException {
				
		String lastName=eLib.getDataFromExcel("contact", 1,2)+jLib.getRandomNumber();
		String phone = eLib.getDataFromExcel("contact", 1,4);
		HomePage hp= new HomePage(driver);
		hp.getConLink().click();
		ContactPage cp= new ContactPage(driver);
		cp.createContact(lastName, phone);
		String actLastName = driver.findElement(By.xpath("//span[text()='"+lastName+"']")).getText();
		String headerInfo =cp.getHeaderTxt().getText();
		boolean status=lastName.equals(actLastName);
		Assert.assertEquals(status, true);
		boolean sataus1 = headerInfo.contains(lastName);
		Assert.assertEquals(sataus1, true);
	}
	
	
	@Test(groups="RegressionTest")
	public void createContactWithOrgTest() throws EncryptedDocumentException, IOException {

		String lastName = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();
		String phone = eLib.getDataFromExcel("contact", 1, 4);
		String orgName = eLib.getDataFromExcel("org", 3, 2) + jLib.getRandomNumber();
		String phone1 = eLib.getDataFromExcel("org", 3, 5);
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		OrganizationsPage op = new OrganizationsPage(driver);
		op.createOrg(orgName, phone1);

		hp.getConLink().click();
		ContactPage cp = new ContactPage(driver);
		cp.getLastnameTxt().sendKeys(lastName);
		cp.getPhoneTxt().sendKeys(phone);
		cp.getAccountnameLookup();
		wLib.switchNewBrowserTab(driver, "module=Accounts");
		cp.getSearchTxt().sendKeys(orgName);
		cp.getSearchBtn().click();
		try {
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();
		wLib.switchNewBrowserTab(driver, "module=Contacts");
		cp.getSaveBtn().click();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		String actOrg = cp.getActorgTxt().getText();
		boolean status = orgName.equals(actOrg);
		Assert.assertEquals(status, true);

	}

	@Test(retryAnalyzer =com.ocean.crm.generic.listenerutility.RetryListenerImp.class)
	public void createContactWithSupportTest() throws IOException {
	
	
	String startDate = jLib.getSystemDate();
	String endDate = jLib.getRequiredDate(30);
		
	String lastName=eLib.getDataFromExcel("contact", 1,2)+jLib.getRandomNumber();
	String phone = eLib.getDataFromExcel("contact", 1,4);
	HomePage hp= new HomePage(driver);
	hp.getConLink().click();
	ContactPage cp= new ContactPage(driver);
	cp.createContact(lastName, phone);
//	JavascriptExecutor js=(JavascriptExecutor)driver;
//	js.executeScript("arguments[0].scrollIntoView(true);",cp.getSupportstartdateTxt());
//	cp.getSupportstartdateTxt().clear();
	cp.getSupportstartdateTxt().sendKeys(startDate);
	cp.getSupportenddateTxt().clear();
	cp.getSupportenddateTxt().sendKeys(endDate);
	cp.getSaveBtn();
	String actStart = cp.getActstartdateTxt().getText();
	String actEnd = cp.getActenddateTxt().getText();
	SoftAssert soft=new SoftAssert();
	boolean status = startDate.equals(actStart);
	soft.assertEquals(status, true);
	boolean status1 = endDate.equals(actEnd);
	soft.assertEquals(status1, true);
	soft.assertAll();
	
	}
}
