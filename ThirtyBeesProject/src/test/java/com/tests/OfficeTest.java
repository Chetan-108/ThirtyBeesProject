package com.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BasePage;
import com.pages.OfficePage;

public class OfficeTest extends BasePage{
	
	
	OfficePage officePage ;
	@BeforeMethod
	public void setup() {
	   initialization();
	   officePage=loadHomepage().navigateToNewProductsPage(driver).navigateToOfficePage(driver);
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	@Test(priority=1)
	public void verifyNumberOfItemsAfterChoosingSize() throws Exception{
		
		Assert.assertTrue(officePage.checkNumberOfItemsAfterChoosingSize());
	}
	@Test(priority=2)
	public void verifyNumberOfItemsAfterSettingPriceRange() throws Exception{
	
		Assert.assertTrue(officePage.checkNumberOfItemsAfterSettingPriceRange());
	}
	@Test(priority=3)
	public void verifySortingOfProducts() throws Exception{
	
		Assert.assertFalse(officePage.checkSortingOfProducts());
	}
	@Test(priority=4)
	public void verifyTotalPriceInCart() throws Exception{
	
		Assert.assertTrue(officePage.checkTotalPriceInCart());
	}
	@Test(priority=5)
	public void verifyTotalAmountAfterIncreasingQty() throws Exception{
		
		Assert.assertTrue(officePage.checkTotalAmountAfterIncreasingQty());
	}
	@Test(priority=6)
	public void verifyConfirmationMessageAfterRetrievePassword() throws Exception{
	
		Assert.assertTrue(officePage.checkConfirmationMessageAfterRetrievePassword());
	}
	@Test(priority=7)
	public void verifyMessageAfterOrderConfirmation() throws Exception{
	
		Assert.assertTrue(officePage.checkMessageAfterOrderConfirmation());
	}
	@Test(priority=8)
	public void verifyOrderReferenceForParticularDate() throws Exception{
	
		Assert.assertTrue(officePage.checkOrderReferenceForParticularDate());
	}
}
