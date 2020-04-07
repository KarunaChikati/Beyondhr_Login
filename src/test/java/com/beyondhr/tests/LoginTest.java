package com.beyondhr.tests;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.beyondhr.testbase.BaseTest;
import com.beyondhr.uimap.DashBoardPage;
import com.beyondhr.uimap.LoginPage;

import com.beyondhr.utils.ExcelUtils;

@Listeners(com.beyondhr.tests.ListenerClass.class)
public class LoginTest extends BaseTest {

	LoginPage loginPage = new LoginPage();
	DashBoardPage dashboadPage = new DashBoardPage();

	@BeforeClass
	public void setUp() {
		super.setUp();
		super.waitForPageLoad();
	}

	@DataProvider
	public Object[][] getTestCaseData(Method testMethod) {
		return ExcelUtils.getTestcaseAllData(testMethod.getName(),  super.getProperty("loginsheet"), super.getProperty("datatable"));
	}

	@SuppressWarnings("static-access")
	@Test(dataProvider = "getTestCaseData")
	public void loginToBeyondHrValidCredentials(String username, String password) {
		loginPage.loginToAdminBtn.click();
		loginPage.fillLoginFormAndSubmit(username, password);
		super.waitForPresenceOfEelement(DashBoardPage.Dashboad_Heading_XPATH);
		Assert.assertEquals("Dashboard", dashboadPage.dashboardHeading.getText().trim());
	}

	@AfterClass
	public void tearDown() {
		super.tearDown();
	}
}
