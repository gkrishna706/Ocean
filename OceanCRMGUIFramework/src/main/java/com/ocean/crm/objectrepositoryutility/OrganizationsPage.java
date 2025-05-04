package com.ocean.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrg;
	@FindBy(name="accountname")
	private WebElement orgNameTxt;
	@FindBy(xpath="//input[@name='website']")
	private WebElement webTxt;
	@FindBy(xpath="//input[@name='phone']")
	private WebElement phoneTxt;
	@FindBy(xpath="//input[@name='employees']")
	private WebElement empTxt; 
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	@FindBy(name="industry")
	private WebElement industryDrop;
	@FindBy(name="accounttype")
	private WebElement typeDrop;
	@FindBy(xpath="//input[@title='Delete [Alt+D]']")
	private WebElement deleteBtn;
	@FindBy(className="dvHeaderText")
	private WebElement headerTxt;
	@FindBy(id="dtlview_Organization Name")
	private WebElement actorgTxt;
	@FindBy(id="dtlview_Industry")
	private WebElement actindustryTxt;
	@FindBy(id="dtlview_Type")
	private WebElement acttypeTxt;
//	@FindBy(xpath="//td[@id='mouseArea_Part Number']")
//	private WebElement actphoneTxt;

	/**
	 * @return the createOrg
	 */
	public WebElement getCreateOrg() {
		return createOrg;
	}
	
	/**
	 * @return the actindustryTxt
	 */
	public WebElement getActindustryTxt() {
		return actindustryTxt;
	}
	/**
	 * @return the acttypeTxt
	 */
	public WebElement getActtypeTxt() {
		return acttypeTxt;
	}
//	/**
//	 * @return the actphoneTxt
//	 */
//	public WebElement getActphoneTxt() {
//		return actphoneTxt;
//	}
	/**
	 * @return the headerTxt
	 */
	public WebElement getHeaderTxt() {
		return headerTxt;
	}
	/**
	 * @return the actorgTxt
	 */
	public WebElement getActorgTxt() {
		return actorgTxt;
	}
	/**
	 * @return the deleteBtn
	 */
	public WebElement getDeleteBtn() {
		return deleteBtn;
	}
	WebDriver driver;
	public OrganizationsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	/**
	 * @return the orgNameTxt
	 */
	public WebElement getOrgNameTxt() {
		return orgNameTxt;
	}
	/**
	 * @return the webTxt
	 */
	public WebElement getWebTxt() {
		return webTxt;
	}
	/**
	 * @return the phoneTxt
	 */
	public WebElement getPhoneTxt() {
		return phoneTxt;
	}
	/**
	 * @return the empTxt
	 */
	public WebElement getEmpTxt() {
		return empTxt;
	}
	/**
	 * @return the saveBtn
	 */
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	/**
	 * @return the industryDrop
	 */
	public WebElement getIndustryDrop() {
		return industryDrop;
	}
	/**
	 * @return the typeDrop
	 */
	public WebElement getTypeDrop() {
		return typeDrop;
	}
	public void createOrg(String orgName, String phoneNum) {
		createOrg.click();
		orgNameTxt.sendKeys(orgName);
		phoneTxt.sendKeys(phoneNum);
		saveBtn.click();
	}
	public void createOrg(String orgName, String website, String phoneNum,String empSize) {
		createOrg.click();
		orgNameTxt.sendKeys(orgName);
		webTxt.sendKeys(website);
		phoneTxt.sendKeys(phoneNum);
		empTxt.sendKeys(empSize);
		saveBtn.click();
	}
	

}
