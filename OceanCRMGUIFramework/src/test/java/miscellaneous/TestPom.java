package miscellaneous;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.ocean.crm.generic.fileutility.FileUtility;
import com.ocean.crm.generic.webdriverutility.WebDriverUtility;
import com.ocean.crm.objectrepositoryutility.LoginPage;
import com.ocean.crm.objectrepositoryutility.OrganizationsPage;

public class TestPom {
	
	@Test
	public void login()  throws IOException {
		FileUtility fLib=new FileUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		String browser = fLib.getDataFromPropertyFile("browser");
		String url = fLib.getDataFromPropertyFile("url");
		
		WebDriver driver=null;
		if(browser.equals("chrome"))
			driver=new ChromeDriver();
		else if(browser.equals("firefox"))
			driver=new FirefoxDriver();
		else
			driver=new EdgeDriver();
		driver.get(url);
		
		wLib.waitForPageToLoad(driver);
		LoginPage lp=new LoginPage(driver);
		lp.loginToapp("admin", "admin");
//		HomePage hp=new HomePage(driver);
//		hp.getOrgLink().click();
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateOrg().click();
		
		op.createOrg("MunnaCrop", "www.munna.com", "987456230", "100");
		driver.quit();

	}

}
