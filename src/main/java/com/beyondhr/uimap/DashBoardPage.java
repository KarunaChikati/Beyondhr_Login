package com.beyondhr.uimap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.beyondhr.driver.DriverFactory;

public class DashBoardPage {
	
	WebDriver driver = DriverFactory.getDriver();
	public static final String Dashboad_Heading_XPATH="//h3[@class='m-subheader__title']";
	
	@FindBy(xpath=Dashboad_Heading_XPATH)
	public static WebElement dashboardHeading;
	
	public DashBoardPage() {
		PageFactory.initElements(driver, this);
	}

}
