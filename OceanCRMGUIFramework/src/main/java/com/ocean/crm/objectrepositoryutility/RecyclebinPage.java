package com.ocean.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecyclebinPage {
	@FindBy(xpath="//input[@class='txtBox']")
	private WebElement searchTbx;
	@FindBy(id="bas_searchfield")
	private WebElement inDrop;
	@FindBy(xpath="//input[@class='crmbutton small create']")
	private WebElement searchBtn;
	
	public RecyclebinPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/**
	 * @return the searchTbx
	 */
	public WebElement getSearchTbx() {
		return searchTbx;
	}

	/**
	 * @return the inDrop
	 */
	public WebElement getInDrop() {
		return inDrop;
	}

	/**
	 * @return the searchBtn
	 */
	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
}
