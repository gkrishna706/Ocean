package com.ocean.crm.campaigntest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ocean.crm.generic.baseutility.BaseClass;
import com.ocean.crm.objectrepositoryutility.CampaignInformationPage;
import com.ocean.crm.objectrepositoryutility.CreatecampaignPage;
import com.ocean.crm.objectrepositoryutility.HomePage;
import com.ocean.crm.objectrepositoryutility.MorePage;

public class CreateCampaignTest extends BaseClass {
	
	@Test(groups="SmokeTest")
	public void createCampaign() throws EncryptedDocumentException, IOException {
		String cName = eLib.getDataFromExcel("campaign", 1, 1)+jLib.getRandomNumber();
		
		
		HomePage hp=new HomePage(driver);
		hp.getMoreLink().click();
		MorePage mp=new MorePage(driver);
		mp.getCampLink().click();
		
		CreatecampaignPage creCampPage=new CreatecampaignPage(driver);
		creCampPage.createCampaign(cName, "2025-04-10", "Partners");
		CampaignInformationPage cip=new CampaignInformationPage(driver);
		String actName = cip.getCampaignverificationTxt().getText();
		Assert.assertEquals(actName, cName);
	
			
	}

}
