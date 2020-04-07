package com.beyondhr.uimap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.beyondhr.driver.DriverFactory;

public class LoginPage {
	
	WebDriver driver = DriverFactory.getDriver();
	
	private static final String LOGIN_PAGE_ROOT="//div[@class='m-login__contanier']";
	
	@FindBy(xpath=LOGIN_PAGE_ROOT+"//button[contains(text(),'Login to Admin')]")
	public WebElement loginToAdminBtn;
	
	@FindBy(xpath=LOGIN_PAGE_ROOT+"//button[contains(text(),'Login to candidate')]")
	public  WebElement loginToCandidateBtn;
	
	@FindBy(name="email")
	private WebElement emailText; 
	
	@FindBy(name="password")
	private WebElement passwordText;
	
	@FindBy(id="m_login_signin_submit")
	private WebElement submitLoginBtn;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void fillLoginFormAndSubmit(String userName, String password) {
		emailText.sendKeys(userName);
		passwordText.sendKeys(password);
		submitLoginBtn.click();
	}

}
