package com.ocean.crm.troubleticketstest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ocean.crm.generic.baseutility.BaseClass;

public class CreateTroubleTicketTest extends BaseClass {
	@Test
	public void createTicketTest() throws IOException {
		
		
		String lastName=eLib.getDataFromExcel("contact", 1,2)+jLib.getRandomNumber();
		String phone = eLib.getDataFromExcel("contact", 1,4);
		String title = eLib.getDataFromExcel("trouble", 1, 1);
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.name("mobile")).sendKeys(phone);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		driver.findElement(By.linkText("Trouble Tickets")).click();
		driver.findElement(By.xpath("//img[@title='Create Ticket...']")).click();
		driver.findElement(By.name("ticket_title")).sendKeys(title);
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		wLib.switchNewBrowserTab(driver, "module=Contacts&action");
		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(lastName);
		WebElement ele = driver.findElement(By.xpath("//select[@name='search_field']"));
		wLib.select(ele, 0);
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.linkText(""+lastName+"")).click();
		wLib.switchNewBrowserTab(driver, "module=HelpDesk&action");
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		String headerInfo = driver.findElement(By.className("dvHeaderText")).getText();
		Assert.assertTrue(headerInfo.contains(title),"Header& title are not matching");
		System.out.println("Header contains: "+title);
	}
}
