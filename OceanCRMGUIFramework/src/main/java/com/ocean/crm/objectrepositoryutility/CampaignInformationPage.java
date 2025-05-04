package com.ocean.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInformationPage {
	@FindBy(id="dtlview_Campaign Name")
	private WebElement campaignverificationTxt;
	
	WebDriver driver;
	public CampaignInformationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	/**
	 * @return the campaignverificationTxt
	 */
	public WebElement getCampaignverificationTxt() {
		return campaignverificationTxt;
	}
	
}
