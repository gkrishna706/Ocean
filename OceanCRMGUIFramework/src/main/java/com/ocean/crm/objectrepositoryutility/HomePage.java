package com.ocean.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(linkText ="Calendar")
	private WebElement calLink;
	
	@FindBy(linkText ="Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText="Contacts")
	private WebElement conLink;
	
	@FindBy(linkText="Products")
	private WebElement proLink;
	
	@FindBy(linkText="Documents")
	private WebElement docLink;
	
	@FindBy(linkText="Trouble Tickets")
	private WebElement ttLink;
	
	@FindBy(linkText="Dashboard")
	private WebElement dashLink;
	
	@FindBy(linkText="More")
	private WebElement moreLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement logoutIcon;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutLink;
	
	
	
	/**
	 * @return the logoutIcon
	 */
	public WebElement getLogoutIcon() {
		return logoutIcon;
	}

	/**
	 * @return the signoutLink
	 */
	public WebElement getSignoutLink() {
		return signoutLink;
	}

	/**
	 * @return the calLink
	 */
	public WebElement getCalLink() {
		return calLink;
	}

	public WebElement getOrgLink() {
		return orgLink;
	}

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/**
	 * @return the conLink
	 */
	public WebElement getConLink() {
		return conLink;
	}
	/**
	 * @return the proLink
	 */
	public WebElement getProLink() {
		return proLink;
	}
	/**
	 * @return the docLink
	 */
	public WebElement getDocLink() {
		return docLink;
	}
	/**
	 * @return the ttLink
	 */
	public WebElement getTtLink() {
		return ttLink;
	}
	/**
	 * @return the dashLink
	 */
	public WebElement getDashLink() {
		return dashLink;
	}
	/**
	 * @return the moreLink
	 */
	public WebElement getMoreLink() {
		return moreLink;
	}
}
