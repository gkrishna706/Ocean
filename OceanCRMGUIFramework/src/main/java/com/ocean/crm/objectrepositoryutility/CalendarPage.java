package com.ocean.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarPage {
	@FindBy(className="calAddButton")
	private WebElement addBtn;
	@FindBy(id="addmeeting")
	private WebElement meetingBtn;
	
	public CalendarPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/**
	 * @return the addBtn
	 */
	public WebElement getAddBtn() {
		return addBtn;
	}

	/**
	 * @return the meetingBtn
	 */
	public WebElement getMeetingBtn() {
		return meetingBtn;
	}
	
}
