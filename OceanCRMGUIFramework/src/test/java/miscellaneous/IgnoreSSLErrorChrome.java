package miscellaneous;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class IgnoreSSLErrorChrome {
	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true); // Ignore HTTPS certificate errors
		
		//Hides "Chrome is being controlled" info bar
		options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
		
		options.addArguments("--start-maximized");
		
		//Runs browser in headless mode (no UI)
//		options.addArguments("--headless");

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://self-signed.badssl.com/"); // Example of an insecure site
		System.out.println("execute successfully");
	}
}
