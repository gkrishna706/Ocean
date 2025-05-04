package com.ocean.crm.objectrepositoryutility;

 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ContactPage {
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createContactBtn;
	@FindBy(name="lastname")
	private WebElement lastnameTxt;
	@FindBy(name="mobile")
	private WebElement phoneTxt;
	@FindBy(xpath="//td[text()='Support Start Date']")
	private WebElement supportstartdateTxt;
	@FindBy(xpath="//td[text()='Support End Date']")
	private WebElement supportenddateTxt;
	@FindBy(xpath="//span[@id='dtlview_Support Start Date']")
	private WebElement actstartdateTxt;
	@FindBy(xpath="//span[@id='dtlview_Support End Date']")
	private WebElement actenddateTxt;
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement accountnameLookup;
	@FindBy(name="search_text")
	private WebElement searchTxt;
	@FindBy(name="search")
	private WebElement searchBtn;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	@FindBy(id="mouseArea_Organization Name")
	private WebElement actorgTxt;
	@FindBy(className="dvHeaderText")
	private WebElement headerTxt;
	
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/**
	 * @return the createContactBtn
	 */
	public WebElement getCreateContactBtn() {
		return createContactBtn;
	}

	/**
	 * @return the lastnameTxt
	 */
	public WebElement getLastnameTxt() {
		return lastnameTxt;
	}

	/**
	 * @return the phoneTxt
	 */
	public WebElement getPhoneTxt() {
		return phoneTxt;
	}

	/**
	 * @return the supportstartdateTxt
	 */
	public WebElement getSupportstartdateTxt() {
		return supportstartdateTxt;
	}

	/**
	 * @return the supportenddateTxt
	 */
	public WebElement getSupportenddateTxt() {
		return supportenddateTxt;
	}

	/**
	 * @return the actstartdateTxt
	 */
	public WebElement getActstartdateTxt() {
		return actstartdateTxt;
	}

	/**
	 * @return the actenddateTxt
	 */
	public WebElement getActenddateTxt() {
		return actenddateTxt;
	}

	/**
	 * @return the accountnameLookup
	 */
	public WebElement getAccountnameLookup() {
		return accountnameLookup;
	}

	/**
	 * @return the searchTxt
	 */
	public WebElement getSearchTxt() {
		return searchTxt;
	}

	/**
	 * @return the searchBtn
	 */
	public WebElement getSearchBtn() {
		return searchBtn;
	}

	/**
	 * @return the saveBtn
	 */
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	/**
	 * @return the actorgTxt
	 */
	public WebElement getActorgTxt() {
		return actorgTxt;
	}

	/**
	 * @return the headerTxt
	 */
	public WebElement getHeaderTxt() {
		return headerTxt;
	}
	public void createContact(String lastname, String phone) {
		createContactBtn.click();
		lastnameTxt.sendKeys(lastname);
		phoneTxt.sendKeys(phone);
		saveBtn.click();	
	}
	public void createContact(String lastname, String phone, String startdate, String supportend ) {
		createContactBtn.click();
		lastnameTxt.sendKeys(lastname);
		phoneTxt.sendKeys(phone);
		supportstartdateTxt.sendKeys(startdate);
		supportenddateTxt.sendKeys(supportend);
		saveBtn.click();	
	}
}
