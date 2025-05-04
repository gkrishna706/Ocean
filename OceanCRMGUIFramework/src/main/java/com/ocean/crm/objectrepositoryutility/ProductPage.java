package com.ocean.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ocean.crm.generic.webdriverutility.WebDriverUtility;

public class ProductPage {
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement createproBtn;
	
	@FindBy(name="productname")
	private WebElement pronameTxt;
	
	@FindBy(id="my_file_element")
	private WebElement fileloadBtn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//td[@id='mouseArea_Product Name']")
	private WebElement actproductName;
	
	@FindBy(className ="lvtHeaderText")
	private WebElement headerTxt;
	
	@FindBy(xpath="//input[@title='Delete [Alt+D]']")
	private WebElement deleteBtn;
	
	@FindBy(name="search_text")
	private WebElement searchTxt;
	
	@FindBy(xpath="//select[@name='search_field']")
	private WebElement inDrop;
	
	@FindBy(xpath="//input[@name='submit']")
	private WebElement searchBtn;
	
	@FindBy(xpath="//span[@class='genHeaderSmall']")
	private WebElement noproductTxt;
	
	/**
	 * @return the createproBtn
	 */
	public WebElement getCreateproBtn() {
		return createproBtn;
	}

	/**
	 * @return the pronameTxt
	 */
	public WebElement getPronameTxt() {
		return pronameTxt;
	}

	/**
	 * @return the fileloadBtn
	 */
	public WebElement getFileloadBtn() {
		return fileloadBtn;
	}

	/**
	 * @return the saveBtn
	 */
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	/**
	 * @return the actproductName
	 */
	public WebElement getActproductName() {
		return actproductName;
	}

	/**
	 * @return the headerTxt
	 */
	public WebElement getHeaderTxt() {
		return headerTxt;
	}

	/**
	 * @return the deleteBtn
	 */
	public WebElement getDeleteBtn() {
		return deleteBtn;
	}

	/**
	 * @return the searchTxt
	 */
	public WebElement getSearchTxt() {
		return searchTxt;
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

	/**
	 * @return the noproductTxt
	 */
	public WebElement getNoproductTxt() {
		return noproductTxt;
	}
	WebDriver driver;
	public ProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void createProduct(String pname) {
		createproBtn.click();
		pronameTxt.sendKeys(pname);
		fileloadBtn.sendKeys("C:\\Users\\G. Krishna\\eclipse-workspace\\OceanCRMGUIFramework\\img\\download.jpeg");
		saveBtn.click();
	}
	public void createAndDeleteProduct(String pname) {
		createproBtn.click();
		pronameTxt.sendKeys(pname);
		fileloadBtn.sendKeys("C:\\Users\\G. Krishna\\eclipse-workspace\\OceanCRMGUIFramework\\img\\download.jpeg");
		saveBtn.click();
		deleteBtn.click();
		WebDriverUtility wLib=new WebDriverUtility();
		
		wLib.switchToAlertAndAccept(driver);
		searchTxt.sendKeys(pname);
		wLib.select(inDrop, 1);
		searchBtn.click();
		
	}
}
