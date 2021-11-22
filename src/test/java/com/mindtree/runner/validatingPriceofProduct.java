package com.mindtree.runner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mindtree.pageobjects.priceComparisonLC;
import com.mindtree.reusablecomponent.Base;

public class validatingPriceofProduct extends Base {

	public static Logger log = LogManager.getLogger(validatingPriceofProduct.class.getName());

	@BeforeMethod
	public void OpenBrowser() throws Exception {
		driver = initializeDriver();
	}

	@Test
	public void validatingPrice() throws Exception {
		// test.info("Browser Opened");
		log.info("Browser Opened");
		driver.get(property.getUrl());
		log.info("Navigate to Url : " + driver.getCurrentUrl());
		test.info("Navigate to Url "+driver.getCurrentUrl());
		priceComparisonLC pc=new priceComparisonLC(driver);
		test.info("Sending keys to search Bar");
		pc.getSearchButton().sendKeys("adiyogi",Keys.ENTER);
		test.info("Clicking Enter");
		log.info("seanding keys to search box and clicking enter Button");
		test.info("getting Price of first Product from search product list");
		String searchPrice=pc.getProductPrice().getText();
		log.info("getting price from search list of first product : Price : "+searchPrice);
		pc.getSelectProduct().click();
		test.info("Clicking on First Item");
		log.info("selecting first product");
		String productPrice=pc.getProductPrice2().getText();
		test.info("getting price from product page");
		log.info("getting price from product page");
		log.info("matching price");
		test.info("Matching Price");
		Assert.assertEquals(searchPrice, productPrice);
		log.info("Price Matched");
		test.pass("Price Matched");
	
		
		
	}

}
