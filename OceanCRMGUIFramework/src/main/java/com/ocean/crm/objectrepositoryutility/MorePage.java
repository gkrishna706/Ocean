package com.ocean.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MorePage {
	@FindBy(linkText="Campaigns")
	private WebElement campLink;
	@FindBy(name="Recycle Bin")
	private WebElement recycleLink;
	
	/**
	 * @return the recycleLink
	 */
	public WebElement getRecycleLink() {
		return recycleLink;
	}
	public MorePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	/**
	 * @return the campLink
	 */
	public WebElement getCampLink() {
		return campLink;
	}

}
