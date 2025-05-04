package miscellaneous;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ocean.crm.generic.webdriverutility.WebDriverUtility;

public class SwtichWindows {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		List<String> urls = new ArrayList<>(List.of(
			    "http://www.facebook.com",
			    "http://www.instagram.com",
			    "http://www.amazon.com"
			));
		
		
		WebDriverUtility wLib=new WebDriverUtility();
		wLib.openMultipleUrlsInNewTabs(driver, urls);
		wLib.switchToWindowByTitle(driver, "amazon");
		driver.findElement(By.name("field-keywords")).sendKeys("Gopal");
	}

}
