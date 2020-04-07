package com.beyondhr.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.beyondhr.driver.DriverFactory;
import com.beyondhr.utils.GenericUtils;

public class BaseTest extends GenericUtils {

	WebDriver driver = DriverFactory.getDriver();

	public void setUp() {
		// URL also comes from properties file
		driver.get("http://switt.beyondhr.cloud/");
		driver.manage().window().maximize();
	}

	public void tearDown() {
		driver.quit();
	}

	public static String getProperty(String property) {
		InputStream input;
		String requiredProperty = null;
		try {
			input = new FileInputStream("resources/config.properties");
			Properties prop = new Properties();
			prop.load(input);
			requiredProperty = prop.getProperty(property);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return requiredProperty;
	}
}
