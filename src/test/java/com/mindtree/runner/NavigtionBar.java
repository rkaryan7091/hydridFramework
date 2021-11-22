package com.mindtree.runner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mindtree.pageobjects.NavBarValidationLC;
import com.mindtree.reusablecomponent.Base;



public class NavigtionBar extends Base {
	
	public static Logger log = LogManager.getLogger(NavigtionBar.class.getName());

	@BeforeMethod
	public void OpenBrowser() throws Exception {
		driver = initializeDriver();
	}
	
	
	@Test
	public void selectingProduct() throws Exception {
		
		
		log.info("Browser Opened");
		driver.get(property.getUrl());
		test.info("Navigate to Url : " + driver.getCurrentUrl());
		log.info("Navigate to Url : " + driver.getCurrentUrl());
		test.info("Hovering On Shop By Category in NavBar");
		log.info("Hovering On Shop By Category in NavBar");
		NavBarValidationLC nv=new NavBarValidationLC(driver);
		Actions a=new Actions(driver);
		WebElement move=nv.getNavShopByCategory();
		a.moveToElement(move).build().perform();
		log.info("Hover performed successfully");
		test.info("Selecting Product category");
		log.info("Selecting Product category");
		nv.getNavProductSelect().click();
		test.info("Product Selected from Drop Down");
		log.info("Product Selected from Drop Down");
		Assert.assertEquals(driver.getTitle(),"Coffee Mugs Online - Buy 3D Mugs, Travel Mugs, Funky Mugs [2021]– Bigsmall.in");
		test.pass("Navigation Bar Validated Succefully");
		log.info("Navigation Bar Validated Succefully");
		
		
		
	}


}
