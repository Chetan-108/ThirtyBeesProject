package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(partialLinkText = "New products")
	public static WebElement newProducts;
	
	public NewProductsPage navigateToNewProductsPage(WebDriver driver) {
		newProducts.click();
		return new NewProductsPage(driver);
	}
	public NewProductsPage loadNewProductsPage(){
		
		NewProductsPage np=new NewProductsPage(driver);
		return np;
	}

}
