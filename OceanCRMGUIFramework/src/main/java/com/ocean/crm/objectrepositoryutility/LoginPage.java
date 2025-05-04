package com.ocean.crm.objectrepositoryutility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Rule-01 create a separate java class
public class LoginPage { 
	
	//Rule-2 Object Creation
	@FindBy(name="user_name")
	private WebElement unEdt;
	@FindBy(name="user_password")
	private WebElement pwdEdt;
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	//Rule-3 object initialization
	   WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this );
	}
	 
	//Rule-4 Object Encapsulation
	public WebElement getUnEdt() {
		return unEdt;
	}
	public WebElement getPwdEdt() {
		return pwdEdt;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	
	//Rule-05 provide action through Business method
	public void loginToapp(String un, String pwd) {
//		unEdt.clear();
		unEdt.sendKeys(un);
//		pwdEdt.clear();
		pwdEdt.sendKeys(pwd);
		loginBtn.click();
	}
	
	
	
	

}
