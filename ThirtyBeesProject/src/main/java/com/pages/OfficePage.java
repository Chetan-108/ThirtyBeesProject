package com.pages;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;
import com.utility.DriverUtility;

public class OfficePage extends BasePage {

	WebDriver driver;

	public OfficePage(WebDriver driver) {
		//super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(partialLinkText = "New products")
	public static WebElement newProducts;
	
	@FindBy(xpath = "//span[text()='Office']")
	public static WebElement office;
	
	@FindBy(xpath = "//a[contains(@href,'http://javabykiran.in/Other/thbees/office#size')]")
	public List <WebElement> size;
	
	@FindBy(xpath = "//div[@class='top-pagination-content form-inline clearfix']//p[contains(text(),'Showing 1 - 5 of 5 items')]")
	public WebElement noOfItemsBeforeSize;
	
	@FindBy(xpath = "//div[@class='top-pagination-content form-inline clearfix']//p[contains(text(),'Showing 1 - 1 of 1 items')]")
	public WebElement noOfItemsAfterSize;
	
	@FindBy(xpath = "//a[@style='left: 100%;']")
	public WebElement slider;
	
	@FindBy(xpath = "//div[@class='top-pagination-content form-inline clearfix']//p[contains(text(),'Showing 1 - 5 of 5 items')]")
	public WebElement noOfItemsBeforeSlider;
	
	@FindBy(xpath = "//div[@class='top-pagination-content form-inline clearfix']//p[contains(text(),'Showing 1 - 3 of 3 items')]")
	public WebElement noOfItemsAfterSlider;
	
	@FindBy(xpath = "//h3//a[@class='product-name']")
	public List <WebElement> productNames;
	
	@FindBy(id = "selectProductSort")
	public WebElement sortby;
	
	@FindBy(xpath = "//a[@title='Picture Frame']//img[@class='img-responsive center-block']")
	public WebElement moveHoverAddToCart;
	
	@FindBy(xpath = "//a[@class='product-name' and @title='Picture Frame']")
	public WebElement productTitle; 
	
	@FindBy(xpath = "//button[@type='submit' and @name='Submit']")
	public WebElement addToCart;
	
	@FindBy(xpath = "//button[@class='close cross']")
	public WebElement cancel;
	
	@FindBy(xpath = "//a[@id='blockcart-header']//span[@class='ajax_cart_quantity']")
	public WebElement moveHover;
	
	@FindBy(xpath = "//span[contains(@class,'price cart_block_total ajax_block_cart_total')]")
	public WebElement totalPrice1;
	
	@FindBy(xpath = "//a[@title='Proceed to checkout']")
	public WebElement checkout;
	
	@FindBy(xpath = "//a[@title='Add']")
	public WebElement add;
	
	@FindBy(id = "total_price")
	public WebElement totalPrice2;
	
	@FindBy(xpath = "//span[text()='Proceed to checkout ']")
	public WebElement procedeToCheckout1;
	
	@FindBy(id = "SubmitLogin")
	public WebElement email1;
	
	@FindBy(xpath = "//a[@title='Recover your forgotten password']")
	public WebElement forgotPass;
	
	@FindBy(id = "email")
	public WebElement email2;
	
	@FindBy(xpath = "//span[text()='Retrieve Password ']")
	public WebElement retrievePass;
	
	@FindBy(xpath = "//div[@class='alert alert-success']")
	public WebElement confirmationMsg;
	
	@FindBy(id = "passwd")
	public WebElement pass;
	
	@FindBy(id = "SubmitLogin")
	public WebElement signin;
	
	@FindBy(xpath = "//span[text()='I agree to the terms of service and will adhere to them unconditionally.']")
	public WebElement iAgree;
	
	@FindBy(xpath = "//button[@type='submit']//span")
	public WebElement procedeToCheckout2;
	
	@FindBy(xpath = "//a[@class='bankwire']")
	public WebElement payByBankwire;
	
	@FindBy(xpath = "//span[text()='I confirm my order ']")
	public WebElement confirmOrderButton;
	
	@FindBy(xpath = "//div[text()='Your order on BEE is complete.']")
	public WebElement confirmOrderMsg;
	
	@FindBy(xpath = "//a[@class='btn btn-lg btn-default']")
	public WebElement viewOrderHistory;
	
	@FindBy(xpath = "//td[@class='history_link bold footable-first-column']")
	public List <WebElement> orderReferences;
	
	@FindBy(xpath = "//td[@class='history_date bold']")
	public List <WebElement> dates;
	
	public boolean checkNumberOfItemsAfterChoosingSize() throws Exception {		
	//	DriverUtility.click(newProducts);
	//	DriverUtility.click(office);
		System.out.println("Number of items before choosing size: "+noOfItemsBeforeSize.getText());
		DriverUtility.column=1;
		String checkbox1= DriverUtility.getCellData("TestDataBees.xlsx", "Sheet1", 0, DriverUtility.column);		
		DriverUtility.clickOnCheckbox(size,checkbox1);
		DriverUtility.expliciteWait(noOfItemsAfterSize);
		String actual=noOfItemsAfterSize.getText();
		System.out.println("Number of items after choosing size: "+actual);
		String expected="Showing 1 - 1 of 1 items";
		if(actual.equals(expected)) {
			System.out.println("matched");
			return true;
		}else {
			System.out.println("not matched");
		return false;
	}
	}
	
	public boolean checkNumberOfItemsAfterSettingPriceRange() {
	//	DriverUtility.click(newProducts);
	//	DriverUtility.click(office);
		System.out.println("Location of max slider: "+slider.getLocation());
		System.out.println("Number of items before setting slider: "+noOfItemsBeforeSlider.getText());
		DriverUtility.sliderByDrag(slider,-150,0);
		String actual=noOfItemsAfterSlider.getText();
		System.out.println("Number of items after setting slider: "+actual);
		String expected="Showing 1 - 3 of 3 items";
		if(actual.equals(expected)) {
			System.out.println("matched");
			return true;
		}else {
			System.out.println("not matched");
		return false;
	}
	}
	public boolean checkSortingOfProducts() throws Exception {
	//	DriverUtility.click(newProducts);
	//	DriverUtility.click(office);
		ArrayList<String> originalList=new ArrayList<String>();		
		DriverUtility.checkSorting1(productNames,originalList);
		System.out.println(originalList);
		DriverUtility.column=1;
		String sortingOptions= DriverUtility.getCellData("TestDataBees.xlsx", "Sheet1", 1, DriverUtility.column);	
		DriverUtility.selectDropDown(sortby,sortingOptions);
		Thread.sleep(3000);
		ArrayList<String> sortedList=new ArrayList<String>();
		DriverUtility.checkSorting2(productNames,sortedList);
		System.out.println(sortedList);
		if(originalList.equals(sortedList)) {
			System.out.println("matched");
			return true;
		}else {
			System.out.println("not matched");
		return false;
	}
	}
	public boolean checkTotalPriceInCart() throws Exception {
	//	DriverUtility.click(newProducts);
	//	DriverUtility.click(office);
		DriverUtility.click(productTitle);
		DriverUtility.click(addToCart);
		DriverUtility.click(cancel);
		DriverUtility.moveHoverElement(moveHover);
		Thread.sleep(2000);
		String actual=totalPrice1.getText();
		System.out.println(actual);
		String expected="$30.00";
		if(actual.equalsIgnoreCase(expected)) {
			System.out.println("matched");
			return true;
		}else {
			System.out.println("not matched");
		return false;
	}
	}
	public boolean checkTotalAmountAfterIncreasingQty() throws Exception {
	//	DriverUtility.click(newProducts);
	//	DriverUtility.click(office);
		DriverUtility.click(productTitle);
		DriverUtility.click(addToCart);
		DriverUtility.click(checkout);		
		DriverUtility.click(add);
		Thread.sleep(3000);
		String actual=totalPrice2.getText();
		System.out.println(actual);
		String expected="$ 55.00";
		if(actual.equals(expected)) {
			System.out.println("matched");
			return true;
		}else {
			System.out.println("not matched");
		return false;
	}
	}
	public boolean checkConfirmationMessageAfterRetrievePassword() throws Exception {
	//	DriverUtility.click(newProducts);
	//	DriverUtility.click(office);
		DriverUtility.click(productTitle);
		DriverUtility.click(addToCart);
		DriverUtility.click(checkout);		
		DriverUtility.click(add);
		Thread.sleep(3000);
		DriverUtility.click(procedeToCheckout1);
		DriverUtility.column=1;
		String emailAddress= DriverUtility.getCellData("TestDataBees.xlsx", "Sheet1", 2, DriverUtility.column);	
		DriverUtility.sendKeys(email1, emailAddress);
		DriverUtility.click(forgotPass);
		DriverUtility.sendKeys(email2, emailAddress);
		DriverUtility.click(retrievePass);
		String actual=confirmationMsg.getText();
		String expected= DriverUtility.getCellData("TestDataBees.xlsx", "Sheet1", 3, DriverUtility.column);
		if(actual.equals(expected)) {
			System.out.println("matched");
			return true;
		}else {
			System.out.println("not matched");
		return false;
	}
	}
	public boolean checkMessageAfterOrderConfirmation() throws Exception {
	//	DriverUtility.click(newProducts);
	//	DriverUtility.click(office);
		DriverUtility.click(productTitle);
		DriverUtility.click(addToCart);
		DriverUtility.click(checkout);		
		DriverUtility.click(add);
		Thread.sleep(3000);
		DriverUtility.click(procedeToCheckout1);
		DriverUtility.column=1;
		String emailAddress= DriverUtility.getCellData("TestDataBees.xlsx", "Sheet1", 2, DriverUtility.column);	
		DriverUtility.sendKeys(email2, emailAddress);
		String password= DriverUtility.getCellData("TestDataBees.xlsx", "Sheet1", 4, DriverUtility.column);
		DriverUtility.sendKeys(pass,password);
		DriverUtility.click(signin);
		DriverUtility.click(procedeToCheckout1);
		DriverUtility.click(iAgree);
		DriverUtility.click(procedeToCheckout2);
		DriverUtility.click(payByBankwire);
		DriverUtility.click(confirmOrderButton);
		String actual=confirmOrderMsg.getText();
		String expected= DriverUtility.getCellData("TestDataBees.xlsx", "Sheet1", 5, DriverUtility.column);
		if(actual.equals(expected)) {
			System.out.println("matched");
			return true;
		}else {
			System.out.println("not matched");
		return false;
	}
	}
	public boolean checkOrderReferenceForParticularDate() throws Exception {
	//	DriverUtility.click(newProducts);
	//	DriverUtility.click(office);
		DriverUtility.click(productTitle);
		DriverUtility.click(addToCart);
		DriverUtility.click(checkout);		
		DriverUtility.click(add);
		Thread.sleep(3000);
		DriverUtility.click(procedeToCheckout1);
		DriverUtility.column=1;
		String emailAddress= DriverUtility.getCellData("TestDataBees.xlsx", "Sheet1", 2, DriverUtility.column);	
		DriverUtility.sendKeys(email2, emailAddress);
		String password= DriverUtility.getCellData("TestDataBees.xlsx", "Sheet1", 4, DriverUtility.column);
		DriverUtility.sendKeys(pass,password);
		DriverUtility.click(signin);
		DriverUtility.click(procedeToCheckout1);
		DriverUtility.click(iAgree);
		DriverUtility.click(procedeToCheckout2);
		DriverUtility.click(payByBankwire);
		DriverUtility.click(confirmOrderButton);
		DriverUtility.click(viewOrderHistory);
		String dateOfOrder= DriverUtility.getCellData("TestDataBees.xlsx", "Sheet1", 6, DriverUtility.column);
		for (int i = 0; i < dates.size(); i++) {

			String date = dates.get(i).getText();///This Logic needs to use for index match
			if (date.equals(dateOfOrder)) {
				String orderReference = orderReferences.get(i).getText();///This Logic needs to use for index match
				System.out.println(orderReference);
			}
		}
		return true;
	}
	}

