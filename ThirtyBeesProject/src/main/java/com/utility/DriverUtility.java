package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BasePage;

public class DriverUtility extends BasePage{

	//WebDriver driver=new ChromeDriver();
	public static String getScreenshot(String name) {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
	    String path=System.getProperty("user.dir")+"/screenshots/"+name+".jpg";
		File dest = new File(path);
		try {
			FileUtils.copyFile(src,  dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
		}
	public static void click(WebElement elem) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(elem));
		elem.click();
	}
	public static void sendKeys(WebElement elem, String value) {

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(elem));
		elem.click();
		elem.sendKeys(value);
	}
	public static void expliciteWait(WebElement elem) {

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(elem));

	}
	

	public static void selectRadioButton(List<WebElement> elems, String value) {
		for (WebElement locator : elems) {
			if (locator.getText().equalsIgnoreCase(value)) {
				locator.click();
				break;
			}
		}
	}

	public static void clickOnCheckbox(List<WebElement> elems, String... value) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		for (WebElement locator : elems) {
			for (String val : value) {
				if (locator.getText().equalsIgnoreCase(val)) {
					wait.until(ExpectedConditions.elementToBeClickable(locator));
					locator.click();
					break;
				}
			}
		}
	}

	public static void selectDropDown(WebElement element, String value) throws Exception {
		Select drp = new Select(element);
		List<WebElement> allOptions = drp.getOptions();
		for (WebElement option : allOptions) {
			if (option.getText().equals(value)) {
				option.click();
				break;
			}
		}
	}

	public static void selectLanguageDropDown(List<WebElement> element1, WebElement element2, String... value)
			throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		element2.click();
		List<WebElement> allOptions = element1;
		for (WebElement option : allOptions) {
			for (String val : value) {
				if (option.getText().equals(val)) {
					wait.until(ExpectedConditions.elementToBeClickable(element2));
					option.click();
					break;
				}
			}
		}
	}

	public static void selectCountryDropDown(List<WebElement> element1, WebElement element2, String value) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		element2.click();
		List<WebElement> allOptions = element1;
		for (WebElement option : allOptions) {

			if (option.getText().equals(value)) {
				wait.until(ExpectedConditions.elementToBeClickable(element2));
				option.click();
				break;
			}
		}
	}

	public static void checkSorting1(List <WebElement> element1,ArrayList<String> originalList) throws Exception  {

		for(WebElement option:element1) {
			originalList.add(option.getText());		
		}}
	public static void checkSorting2(List <WebElement> element1,ArrayList<String> sortedList) throws Exception  {

		for(WebElement option:element1) {
			sortedList.add(option.getText());

		}}
	public static void switchIFrame(WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public static void scrollForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(element));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	public static void moveHoverElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(element));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	public static void sliderByDrag(WebElement element,int a,int b) {
		Actions action = new Actions(driver);
		action.dragAndDropBy(element, a, b).perform();

	}
	public static DataFormatter df = new DataFormatter();
	//public static int count ;
	public static int column ;
	public static String getCellData(String filePath, String sheetName, int count, int col) throws Exception {
		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		return df.formatCellValue(sh.getRow(count).getCell(column));
	}
}
