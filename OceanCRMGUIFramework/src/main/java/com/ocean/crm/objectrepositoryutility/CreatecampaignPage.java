package com.ocean.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ocean.crm.generic.webdriverutility.WebDriverUtility;

public class CreatecampaignPage {
	
	@FindBy(xpath="//img[@title='Create Campaign...']")
	private WebElement createcampaignBtn;
	@FindBy(name="campaignname")
	private WebElement camapignnameTxt;
	@FindBy(name="closingdate")
	private WebElement closingdateTxt;
	@FindBy(name="campaigntype")
	private WebElement campaigntypeDropdown;
	@FindBy(xpath="//input[@type='radio']/following-sibling::input")
	private WebElement radioBtn;
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submitBtn;
	
	public CreatecampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public void createCampaign(String name,String date, String type) {
		createcampaignBtn.click();
		camapignnameTxt.sendKeys(name);
		closingdateTxt.clear();
		closingdateTxt.sendKeys(date);
		WebDriverUtility wLib= new WebDriverUtility();
		wLib.select(campaigntypeDropdown, type);
		radioBtn.click();
		submitBtn.click();
	}


	/**
	 * @return the createcampaignBtn
	 */
	public WebElement getCreatecampaignBtn() {
		return createcampaignBtn;
	}


	/**
	 * @return the camapignnameTxt
	 */
	public WebElement getCamapignnameTxt() {
		return camapignnameTxt;
	}


	/**
	 * @return the closingdateTxt
	 */
	public WebElement getClosingdateTxt() {
		return closingdateTxt;
	}


	/**
	 * @return the campaigntypeDropdown
	 */
	public WebElement getCampaigntypeDropdown() {
		return campaigntypeDropdown;
	}


	/**
	 * @return the radioBtn
	 */
	public WebElement getRadioBtn() {
		return radioBtn;
	}


	/**
	 * @return the submitBtn
	 */
	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	

}
