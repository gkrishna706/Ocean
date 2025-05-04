package com.ocean.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddeventPage {
	@FindBy(xpath="//input[@name='subject']")
	private WebElement eventnameTxt;
	@FindBy(xpath="//textarea[@name='description']")
	private WebElement descriptionTxt;
	@FindBy(xpath="//input[@name='location']")
	private WebElement locationTxt;
	@FindBy(xpath="//input[@name='date_start']")
	private WebElement startdateTxt;
	@FindBy(name="eventsave")
	private WebElement eventsaveBtn;
	
	public AddeventPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}
	public void addEvent(String name, String desc, String loc, String edate) {
		eventnameTxt.sendKeys(name);
		descriptionTxt.sendKeys(desc);
		locationTxt.sendKeys(loc);
		startdateTxt.clear();
		startdateTxt.sendKeys(edate);
		eventsaveBtn.click();	
	}
}
