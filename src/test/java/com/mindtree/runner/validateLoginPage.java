package com.mindtree.runner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mindtree.pageobjects.LoginPageLC;
import com.mindtree.reusablecomponent.Base;
import com.mindtree.utilities.excelSheet;

public class validateLoginPage extends Base {

	public static Logger log = LogManager.getLogger(validateLoginPage.class.getName());

	@BeforeMethod
	public void OpenBrowser() throws Exception {
		driver = initializeDriver();
	}

	@Test
	public void loginPage() throws Exception {
		// test.info("Browser Opened");
		log.info("Browser Opened");
		driver.get(property.getUrl());
		log.info("Navigate to Url : " + driver.getCurrentUrl());
		test.info("Navigate to Url "+driver.getCurrentUrl());
		//Creating object of loginpage locator class
		LoginPageLC lg=new LoginPageLC(driver);
		//click on sign in Button on HomePage
		test.info("Clicling on SignIn Button");
		lg.getHomeSignInButtond().click();
		log.info("clicked on SignIn Button");
		log.info("navigated to Login Page");
		test.info("navigated to Login Page");
		//sending email addreess from excelsheet to loginPage
		log.info("getting email addreess from excel and sending to username");
		test.info("Entering Username");
		lg.getemailBox().sendKeys(excelSheet.getExcelSheetData("sheet1",1,0));
		//sending Password from excelSheet to loginPage
		log.info("getting password from excelSheet and sending to password");
		test.info("Entering password");
		lg.getpasswordBox().sendKeys(excelSheet.getExcelSheetData("sheet1", 1, 1));
		//Clicking on signIn Button
		log.info("clicking on signButton");
		test.info("Clicking SignIn Button");
		lg.getLoginSignButton().click();
		log.info("Validation Login Page");
		test.info("Validating Login Page");
		Assert.assertTrue(lg.getAccountDetail().isDisplayed());
		test.pass("Login Succesfull");
		test.pass("Login Succesfull");
	}
}
