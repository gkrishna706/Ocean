package miscellaneous;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.ocean.crm.generic.baseutility.BaseClass;
import com.ocean.crm.generic.fileutility.ExcelUtility;
import com.ocean.crm.generic.webdriverutility.JavaUtility;

public class CreateCampaign extends BaseClass {
	
	@Test
	public void createCampaign() throws EncryptedDocumentException, IOException {
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		String cName = eLib.getDataFromExcel("campaign", 1, 1)+jLib.getRandomNumber();
		
		WebElement ele = driver.findElement(By.id("qccombo"));
		wLib.select(ele, "New Campaign");
		driver.findElement(By.name("campaignname")).sendKeys(cName);
		driver.findElement(By.name("closingdate")).clear();
		driver.findElement(By.name("closingdate")).sendKeys("2025-04-10");
		WebElement ele2 = driver.findElement(By.name("campaigntype"));
		wLib.select(ele2, 3);
		driver.findElement(By.xpath("//input[@type='radio']/following-sibling::input")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String actName = driver.findElement(By.id("dtlview_Campaign Name")).getText();
		if(actName.equals(cName))
			System.out.println(cName+ " is verified");
		else
			System.out.println(cName+ " is not verified");
	
		
	
			
	}

}
