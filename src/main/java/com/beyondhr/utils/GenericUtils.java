package com.beyondhr.utils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.beyondhr.driver.DriverFactory;

public class GenericUtils {

	WebDriver driver = DriverFactory.getDriver();

	public void waitForPageLoad() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void waitForElementToBeclickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForPresenceOfEelement(String xpathExpression) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathExpression)));
	}
	
	public void waitForPresenceOfEelement(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public void takeScreenShot(String screenShotName) throws IOException {
		File srcShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destShot= new File("./FailedTestScreenshots/"+screenShotName+".jpg");		
		FileUtils.copyFile(srcShot, destShot);		
	}
}
