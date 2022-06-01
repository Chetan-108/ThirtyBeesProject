package com.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.base.BasePage;
import com.pages.HomePage;

public class HomeTest extends BasePage{

	HomePage hp;

	@BeforeMethod
	public void beforeMethod() {
		initialization();
		System.out.println("Login Page Open Sucessfully");
		hp = new HomePage(driver);
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
}
