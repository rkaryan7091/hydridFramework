package com.mindtree.runner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mindtree.pageobjects.ValidationSocialNavigationLC;
import com.mindtree.reusablecomponent.Base;

public class ValidatingSocilNavBar extends Base {
	
	public static Logger log = LogManager.getLogger(ValidatingSocilNavBar.class.getName());

	@BeforeMethod
	public void OpenBrowser() throws Exception {
		driver = initializeDriver();
	}

	@Test
	public void verifySocialLinks() throws Exception {
		test.info("Browser Opened");
		log.info("Browser Opened");
		driver.get(property.getUrl());
		log.info("Navigate to Url : " + driver.getCurrentUrl());
		test.info("Navigate to Url " + driver.getCurrentUrl());
		ValidationSocialNavigationLC sn=new ValidationSocialNavigationLC(driver);
		test.info("clicking on FaceBook Logo");
		log.info("Clicking on Facebook Logo");
		sn.getFacebook().click();
		test.info("Getting current page title and verifing it");
		log.info("Getting current page title and verifing it");
        Assert.assertEquals("Log in to Facebook",driver.getTitle());
        test.pass("page navigated to facebook site");
        log.info("page navigated to facebook site");
        driver.navigate().back();
        test.info("driver navigate back to bigsmall site");
        log.info("driver navigate back to bigsmall site");
        test.info("clicking on youtube Logo");
		log.info("Clicking on youtube Logo");
		sn.getYoutube().click();
		test.info("Getting current page title and verifing it");
		log.info("Getting current page title and verifing it");
        Assert.assertEquals("bigsmall.in - YouTube",driver.getTitle());
        test.pass("page navigated to youtube site");
        log.info("page navigated to youtube site");
        driver.navigate().back();
        test.info("driver navigate back to bigsmall site");
        log.info("driver navigate back to bigsmall site");
        test.info("clicking on twitter Logo");
		log.info("Clicking on twitter Logo");
		sn.getTwitter().click();
		test.info("Getting current page title and verifing it");
		log.info("Getting current page title and verifing it");
		Thread.sleep(3000);
        Assert.assertEquals("bigsmall.in (@Bigsmallstore) / Twitter",driver.getTitle());
        test.pass("page navigated to twitter site");
        log.info("page navigated to twitter site");
        driver.navigate().back();
        test.info("driver navigate back to bigsmall site");
        log.info("driver navigate back to bigsmall site");
        test.pass("Social Link verified Successfully");
        
        
		
		
	}

}
