package miscellaneous;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ocean.crm.generic.fileutility.FileUtility;
import com.ocean.crm.generic.webdriverutility.WebDriverUtility;

public class TestMethods {

	public static void main(String[] args) throws IOException {
		//create object
				FileUtility fLib=new FileUtility();
				WebDriverUtility wLib=new WebDriverUtility();
				
				
				String browser = fLib.getDataFromPropertyFile("browser");
				
				WebDriver driver=null;
				if(browser.equals("chrome"))
					driver=new ChromeDriver();
				else if(browser.equals("firefox"))
					driver=new FirefoxDriver();
				else
					driver=new EdgeDriver();
				
				wLib.maximizeWindow(driver);
				wLib.waitForPageToLoad(driver);
				driver.get("https://www.flipkart.com/");
				wLib.scrollDown(driver, 5000);
				wLib.takesScreenShot(driver);

	}

}
