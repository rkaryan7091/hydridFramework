package com.mindtree.runner;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.mindtree.pageobjects.CartLC;
import com.mindtree.reusablecomponent.Base;

public class AddingProductToCart extends Base {

	public static Logger log = LogManager.getLogger(AddingProductToWishList.class.getName());

	@BeforeMethod
	public void OpenBrowser() throws Exception {
		driver = initializeDriver();
	}

	@Test
	public void validatingCart() throws Exception {

		log.info("Browser Opened");
		driver.get(property.getUrl());
		test.info("Navigate to Url : " + driver.getCurrentUrl());
		log.info("Navigate to Url : " + driver.getCurrentUrl());
		CartLC ct = new CartLC(driver);
		test.info("searching a Product");
		log.info("Searching a Product");
		ct.getSearchButton().sendKeys("captain America", Keys.ENTER);
		test.info("Selecting second Product from Product List");
		log.info("Selecting second Product from Product List");
		ct.getSelectProduct().click();
		test.info("Getting Product name from Product page");
		log.info("Getting Product name from Product page");
		String productName = ct.getProductName().getText();
		test.info("Clicking on Add to Cart Button");
		log.info("Clicking on Add to Cart Button");
		ct.getAddToCartButton().click();
		test.info("Opening Cart");
		log.info("Opening Cart");
		ct.getCartButton().click();
		test.info("Validating Product By Product Name");
		log.info("Validating Product By Product Name");
		Thread.sleep(3000);
		Assert.assertEquals(productName,ct.getProductCartName().getText());
		test.pass("Name Matched");
		log.info("Name Matched");
		test.info("Validating Checkout Button");
		log.info("Validating CheckOut Button");
		Assert.assertTrue(ct.getCheckoutButton().isDisplayed());
		test.pass(productName + " Item Succefully added To Cart");
		log.info(productName + " Item Succefully added To Cart");

	}

}
