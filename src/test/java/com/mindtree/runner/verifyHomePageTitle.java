package com.mindtree.runner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mindtree.pageobjects.HomePageLC;
import com.mindtree.reusablecomponent.Base;


public class verifyHomePageTitle extends Base {
	
	public static Logger log=LogManager.getLogger(verifyHomePageTitle.class.getName());
	
	@BeforeMethod
	public void OpenBrowser() throws Exception
	{
		 driver=initializeDriver();		 
	}
	
	
	
	@Test
	public void verifyTitle() throws Exception
	{
		test.info("Browser Opened");
		log.info("Browser Opened");
		driver.get(property.getUrl());
		log.info("Navigate to Url : "+driver.getCurrentUrl());
		test.info("Navigate to Url "+driver.getCurrentUrl());
		test.info("validating HomePage Logo");
		HomePageLC hp=new HomePageLC(driver);
		Assert.assertTrue(hp.getTitleImg().isDisplayed());
		log.info("Home Page logo is displayed");
		test.pass("Home Page logo is displayed");
		Assert.assertTrue(hp.getNavigationBar().isDisplayed());
		log.info("Navigation Bar is Displayed");
		test.pass("Navigation Bar is displayed");	  
			  
	}
	

}
