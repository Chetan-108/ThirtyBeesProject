package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class NewProductsPage {

	WebDriver driver;

	public NewProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[text()='Office']")
	public static WebElement office;

	public OfficePage navigateToOfficePage(WebDriver driver) {
		office.click();
		return new OfficePage(driver);
	}

	public OfficePage loadOfficePage(){

		OfficePage op=new OfficePage(driver);
		return op;
	}
}
