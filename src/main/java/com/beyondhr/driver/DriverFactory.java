package com.beyondhr.driver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

	private DriverFactory() {

	}
	private static WebDriver driver = null;
	
	synchronized public static WebDriver getDriver() {
		try {
			InputStream input = new FileInputStream("resources/config.properties");
			Properties prop = new Properties();
			prop.load(input);
			String browser = prop.getProperty("browser");
			switch (browser) {
			case "chrome":
				if (driver == null) {
					System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriver"));
					driver = new ChromeDriver();
				}
				return driver;
			case "firefox":
				if (driver == null) {
					System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxdriver"));
					driver = new FirefoxDriver();
				}				
				return driver;
			/*
			 * case "internet explorer": System.setProperty("", ""); driver = new
			 * InternetExplorerDriver(); return driver;
			 */
			default:
				System.out.print(browser + "is not supported please try other");
				return null;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			System.out.print("Check config.properties file having some issues");
			e.printStackTrace();
			return null;
		}
	}
}
