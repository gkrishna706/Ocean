package com.ocean.crm.generic.webdriverutility;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * This class contains all the methods which is frequently use in selenium.
 */
public class WebDriverUtility {
	/**
	 * This method help us to maximize a browser window.
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * 
	 * @param driver
	 */
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
	}
	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitForElementPresent(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	/**
	 * 
	 * @param driver
	 * @param partialTitle
	 */
	public void switchNewBrowserTab(WebDriver driver, String partialTitle) {
		Set<String> set = driver.getWindowHandles();
        Iterator<String> it = set.iterator();
        while(it.hasNext()) {
        	String wid = it.next();
        	driver.switchTo().window(wid);
			String actUrl = driver.getCurrentUrl();
			if(actUrl.contains(partialTitle)) {
				break;
			}
		}
	}
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	public void switchToFrame(WebDriver driver, String nameID) {
		driver.switchTo().frame(nameID);
	}
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void switchToAlertAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public void select(WebElement element, String text) {
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	public void select(WebElement element, int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	public void deselect(WebElement element, int index) {
		Select sel=new Select(element);
		sel.deselectByIndex(index);
	}
	/**
	 * This method is used to de-select the selected items in list box
	 * @param element
	 * @param text
	 */
	public void deselect(WebElement element, String text) {
		Select sel=new Select(element);
		sel.deselectByValue(text);
	}
	public void deselectAll(WebElement element) {
		Select sel=new Select(element);
		sel.deselectAll();
	}
	public void selectAllOptions(WebElement element) {
		Select sel=new Select(element);
		sel.getAllSelectedOptions();
	}
	public void mousemoveOnElement(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	public void doubleclick(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	public void rightclick(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * This method is used to scroll the browser.
	 * Pass x and y value.
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void scrollDown(WebDriver driver, int x, int y) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy("+x+" ,"+y+");");
	}
	/**
	 * This method is used to scroll the browser.
	 * Pass y value..
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void scrollDown(WebDriver driver, int y) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,"+y+");");
	}
	public void takesScreenShot(WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShot/error.png");
		FileUtils.copyFile(src, dest);
	}
	public boolean switchToWindowByTitle(WebDriver driver, String targetTitle) {
	    String originalWindow = driver.getWindowHandle();
	    Set<String> allWindows = driver.getWindowHandles();

	    for (String windowHandle : allWindows) {
	        driver.switchTo().window(windowHandle);
	        if (driver.getTitle().equalsIgnoreCase(targetTitle)) {
	            return true; // Successfully switched
	        }
	    }

	    // If no matching window is found, switch back to original
	    driver.switchTo().window(originalWindow);
	    return false;
	}
	public void openMultipleUrlsInNewTabs(WebDriver driver, List<String> urls) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    for (int i = 0; i < urls.size(); i++) {
	        String url = urls.get(i);

	        if (i == 0) {
	            // Open first URL in the current tab
	            driver.get(url);
	        } else {
	            // Open new tab and switch to it
	            js.executeScript("window.open('" + url + "', '_blank');");

	            // Switch to the newly opened tab
	            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
	            driver.switchTo().window(tabs.get(tabs.size() - 1));
	        }
	    }
	}


	
	
}
