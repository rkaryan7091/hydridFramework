package com.mindtree.runner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mindtree.pageobjects.ContactUsLC;
import com.mindtree.reusablecomponent.Base;

public class ValidationContantUs extends Base {

	public static Logger log = LogManager.getLogger(ValidationContantUs.class.getName());

	@BeforeMethod
	public void OpenBrowser() throws Exception {
		driver = initializeDriver();
	}

	@Test
	public void validatingContactus() throws Exception {

		log.info("Browser Opened");
		driver.get(property.getUrl());
		test.info("Navigate to Url : " + driver.getCurrentUrl());
		log.info("Navigate to Url : " + driver.getCurrentUrl());
	    ContactUsLC cu=new ContactUsLC(driver);	
	    test.info("Clicking on Contact Us");
	    log.info("Clicking on Contact Us");
	    cu.getContactUs().click();
	    test.info("Navigated To contact us page");
	    log.info("Navigated TO Contact us Page");
	    test.info("Enetering Name");
	    log.info("Entering Name");
	    cu.getName().sendKeys(property.getName());
	    test.info("Enetering Email");
	    log.info("Entering Email");
	    cu.getEmail().sendKeys(property.getEmail());
	    test.info("Enetering Message");
	    log.info("Entering Message");
	    cu.getMessage().sendKeys(property.getMessage());
	    test.info("Click on Send Button");
	    log.info("clicking on Send Button");
	    cu.getSendButton().click();
	    Assert.assertTrue(cu.getThanksMessage().isDisplayed());
		log.error("Thankyou message is not displayed");

	}
	
}
