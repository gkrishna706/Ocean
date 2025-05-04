package com.ocean.crm.organizationtest;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ocean.crm.generic.baseutility.BaseClass;
import com.ocean.crm.objectrepositoryutility.HomePage;
import com.ocean.crm.objectrepositoryutility.MorePage;
import com.ocean.crm.objectrepositoryutility.OrganizationsPage;
import com.ocean.crm.objectrepositoryutility.RecyclebinPage;

//@Listeners(com.ocean.crm.generic.listenerutility.ListenerImplimentation.class)
public class CreateOrgTest extends BaseClass {
	
	
	@Test(groups="SmokeTest")

	public void createOrgTest () throws IOException {
		HomePage hp=new HomePage(driver);
		OrganizationsPage op= new OrganizationsPage(driver);
		
		hp.getOrgLink().click();
		op.getCreateOrg().click();
		
		String orgName=eLib.getDataFromExcel("org", 3,2)+ jLib.getRandomNumber();
		
		op.getOrgNameTxt().sendKeys(orgName);
		op.getSaveBtn().click();
		
		String headerInfo = op.getHeaderTxt().getText();
		String actOrgName = op.getActorgTxt().getText();
		
		boolean status = headerInfo.contains(actOrgName);
		Assert.assertEquals(status, true);
		Reporter.log(actOrgName+ " create successfully", true);

		
	}
	@Test(groups="RegressionTest")
	public void createOrgWithIndustryTest() throws EncryptedDocumentException, IOException {
		HomePage hp=new HomePage(driver);
		OrganizationsPage op= new OrganizationsPage(driver);

		hp.getOrgLink().click();
		op.getCreateOrg().click();

		String orgName = eLib.getDataFromExcel("org", 3, 2)+jLib.getRandomNumber();
		String manufac = eLib.getDataFromExcel("org", 3, 3);
		String resel = eLib.getDataFromExcel("org", 3, 4);
		
		op.getOrgNameTxt().sendKeys(orgName);

		WebElement ele = op.getIndustryDrop();
		wLib.select(ele, manufac);

		WebElement ele1 = op.getTypeDrop();
		wLib.select(ele1, resel);
		
		op.getSaveBtn().click();

		String industry=op.getActindustryTxt().getText();
		String type=op.getActtypeTxt().getText();
		boolean status = industry.equals(manufac);
		boolean status1 = type.equals(resel);
		Assert.assertEquals(status, true);
		Assert.assertEquals(status1, true);
		Reporter.log(orgName+ " create successfully With industry", true);
	}
	@Test(groups="RegressionTest")
	public void createOrWithPhoneTest() throws EncryptedDocumentException, IOException, InterruptedException {
		HomePage hp=new HomePage(driver);
		OrganizationsPage op= new OrganizationsPage(driver);
	
		hp.getOrgLink().click();
		op.getCreateOrg().click();
	
		String orgName=eLib.getDataFromExcel("org", 3,2)+ jLib.getRandomNumber();
		String phone = eLib.getDataFromExcel("org", 3,5);
		op.createOrg(orgName, phone);
		
		String actphone = driver.findElement(By.xpath("//span[text()='"+phone+"']")).getText();
		boolean status = phone.equals(actphone);
		Assert.assertEquals(status, true);
		Reporter.log(orgName+ " create successfully with phone", true);
	}
	
	@Test(groups="RegressionTest")
	public void createAndDeleteOrgTest() throws EncryptedDocumentException, IOException {
		HomePage hp=new HomePage(driver);
		OrganizationsPage op= new OrganizationsPage(driver);
		
		hp.getOrgLink().click();
		op.getCreateOrg().click();
		
		String orgName=eLib.getDataFromExcel("org",3,2)+jLib.getRandomNumber();
		
		op.getOrgNameTxt().sendKeys(orgName);
		op.getSaveBtn().click();
		Reporter.log(orgName+ " create successfully", true);
		
		
		op.getDeleteBtn().click();
		
		driver.switchTo().alert().accept();
		hp.getMoreLink().click();
		
		MorePage mp=new MorePage(driver);
		mp.getRecycleLink().click();
		
		RecyclebinPage rb=new RecyclebinPage(driver);
		rb.getSearchTbx().sendKeys(orgName);
		WebElement ele =rb.getInDrop();		
		wLib.select(ele, 1);
		rb.getSearchBtn().click();
		
		String actOrg = driver.findElement(By.linkText(""+orgName+"")).getText();
		boolean status = orgName.equals(actOrg);
		Assert.assertEquals(status, true);
		Reporter.log(orgName+ " delete successfully", true);
	}

}
