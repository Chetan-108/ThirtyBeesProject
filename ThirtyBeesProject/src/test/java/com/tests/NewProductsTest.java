package com.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.base.BasePage;
import com.pages.NewProductsPage;


public class NewProductsTest extends BasePage{

	NewProductsPage np;

	
	@BeforeMethod
	public void BeforeMethod() {
		
		initialization();
		np=loadHomepage().navigateToNewProductsPage(driver);
		
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
}
