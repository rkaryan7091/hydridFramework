package com.mindtree.runner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



import com.mindtree.pageobjects.wishListLC;
import com.mindtree.reusablecomponent.Base;


public class AddingProductToWishList extends Base {

	public static Logger log = LogManager.getLogger(AddingProductToWishList.class.getName());

	@BeforeMethod
	public void OpenBrowser() throws Exception {
		driver = initializeDriver();
	}

	@Test
	public void wishListProduct() throws Exception {
		
		
		log.info("Browser Opened");
		driver.get(property.getUrl());
		test.info("Navigate to Url : " + driver.getCurrentUrl());
		log.info("Navigate to Url : " + driver.getCurrentUrl());
		wishListLC wl = new wishListLC(driver);
		test.info("sending keys to search Box");
		log.info("sending keys to search Box");
		wl.getSearchBox().sendKeys("ironman", Keys.ENTER);
		test.info("selecting first product from searchList");
		log.info("Selecting first product from  searchList");
		wl.getSelectProduct().click();
		test.info("getting Product Name");
		String productName = wl.getProductName().getText();
		test.info("adding on WishList");
		log.info("adding on WishList");
		wl.getAddingToWishList().click();
		test.info("Opening Wishlist Section");
		log.info("Opening WishList Section");
		wl.getWishListButton().click();
		log.info("Accepting welcome Message");
		wl.getWelcomeButton().click();
		test.info("Clicking on Welcome Button");
		test.info("Checking product is added to wishlist or not");
		log.info("Checking product is added to wishlist or not");
		Assert.assertEquals(wl.getWishListProductName().getText(),productName);
		test.info("Item successfully added to wishList");
		log.info("Item successfully addtd to wishList");
	}

}
