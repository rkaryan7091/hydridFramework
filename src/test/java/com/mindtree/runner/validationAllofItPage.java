package com.mindtree.runner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mindtree.pageobjects.AllProductTabLC;
import com.mindtree.reusablecomponent.Base;


public class validationAllofItPage extends Base {

	
	public static Logger log = LogManager.getLogger(validationAllofItPage.class.getName());

	@BeforeMethod
	public void OpenBrowser() throws Exception {
		driver = initializeDriver();
	}

	@Test
	public void validatingPageNavigation() throws Exception {

		log.info("Browser Opened");
		driver.get(property.getUrl());
		test.info("Navigate to Url : " + driver.getCurrentUrl());
		log.info("Navigate to Url : " + driver.getCurrentUrl());
		AllProductTabLC ap=new AllProductTabLC(driver);
		test.info("Clicking on ALL OF IT in nav Bar");
		log.info("Clicking on ALL OF IT in nav Bar");
		ap.getAllOfIt().click();
		test.info("Clicking on 2nd Page");
		log.info("Clicking on 2nd Page");
		ap.getPageSelect().click();
		test.info("Validating Current Page");
		log.info("Validating Current Page");
		Assert.assertEquals("2",ap.getGetCurrntPage().getText());
		test.pass("Successfully Navigated to 2nd Page");
		log.info("Successfully Navigated to 2nd Page");
		
	
	
	}
	
}
