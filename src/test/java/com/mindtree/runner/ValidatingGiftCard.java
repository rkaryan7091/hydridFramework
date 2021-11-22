package com.mindtree.runner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mindtree.pageobjects.GiftCardLC;
import com.mindtree.reusablecomponent.Base;

public class ValidatingGiftCard extends Base {

	public static Logger log = LogManager.getLogger(ValidatingGiftCard.class.getName());

	@BeforeMethod
	public void OpenBrowser() throws Exception {
		driver = initializeDriver();
	}

	@Test
	public void verifyGiftCardOption() throws Exception {
		test.info("Browser Opened");
		log.info("Browser Opened");
		driver.get(property.getUrl());
		log.info("Navigate to Url : " + driver.getCurrentUrl());
		test.info("Navigate to Url " + driver.getCurrentUrl());
		GiftCardLC gc = new GiftCardLC(driver);
		test.info("clicking on GiftCard");
		log.info("clicking on GiftCard");
		gc.getGiftCardButton().click();
		test.info("validating Gift card Page");
		log.info("validating Gift Card Page");
		Assert.assertTrue(gc.getGiftCardTitle().isDisplayed());
		test.pass("GiftCard Page Open" + driver.getTitle());
		log.info("Gift card Validate passed");

	}

}
