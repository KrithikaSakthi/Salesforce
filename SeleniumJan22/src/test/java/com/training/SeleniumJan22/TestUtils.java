package com.training.SeleniumJan22;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestUtils {

	static WebDriver driver;
	static ExtentReports report;
	static ExtentTest logger = null;

	/* 
	 * Name of the Method  : extentReports()
	 * Description         : Getting the report about the testcases
	 * Arguments           : String path -> setting up the path
	 * 					   : String testCase -> testcase number
	 * Created 			   : 03/21/19
	 * Last Modified       : 03/21/19
	 */
	
	public static void extentReports(String path, String testCase)
	{
		report = new ExtentReports(path);
		logger = report.startTest(testCase);
		logger.log(LogStatus.INFO, "Performing TestCase ");
	}

	/* 
	 * Name of the Method  : startApplication()
	 * Description         : Initializing the driver
	 * Created 			   : 03/21/19
	 * Last Modified       : 03/21/19
	 */
	
	public static void startApplication()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/sakeerthi/Documents/chromedriver");		
		driver = new ChromeDriver();
	}

	/* 
	 * Name of the Method  : launchURL()
	 * Description         : Launching the URL
	 * Arguments           : String Url
	 * Created 			   : 03/21/19
	 * Last Modified       : 03/21/19
	 */
	
	public static void launchURL(String Url)
	{
		driver.get(Url);
		driver.manage().window().maximize();
		System.out.println("Application launched successfully");
		logger.log(LogStatus.PASS, "Application started");
	}

	/* 
	 * Name of the Method  : wait()
	 * Description         : tells the web driver tpo wait for certain 
	 * 						 amount of time before thowing an exception
	 * Arguments           : int w 
	 * Created 			   : 03/21/19
	 * Last Modified       : 03/21/19
	 */
	
	public static void wait(int w) throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(w, TimeUnit.SECONDS);
	}

	/* 
	 * Name of the Method  : findLocation()
	 * Description         : Locators to find and match the elements of the page 
	 * Arguments           : int x -> choosing the locators
	 * 						 String path -> locating the element
	 * Created 			   : 03/21/19
	 * Last Modified       : 03/21/19
	 */

	public static WebElement findLocation(int x,String path)
	{
		WebElement element = null;
		 
		switch(x)
		{
		case 1:
			element = driver.findElement(By.id(path));
			break;
		case 2:
			element = driver.findElement(By.xpath(path));
			break;
		case 3:
			element = driver.findElement(By.cssSelector(path));
			break;
		case 4:
			element = driver.findElement(By.className(path));
			break;
		case 5:
			element = driver.findElement(By.name(path));
			break;
		case 6:
			element = driver.findElement(By.linkText(path));
			break;
		case 7:
			element = driver.findElement(By.partialLinkText(path));
			break;
		case 8:
			element = driver.findElement(By.tagName(path));
			break;
		}
		return element;

	} 
	
	/* 
	 * Name of the Method  : findElement()
	 * Description         : finding the elements of the page
	 * Arguments           : int x -> choosing the locators
	 * 						 String path -> locating the element
	 * Created 			   : 03/21/19
	 * Last Modified       : 03/21/19
	 */
	
	public static WebElement findElement(int x , String path)
	{
		WebElement obj = null;
		
		obj = findLocation(x,path); 
		
		return obj;
		
	}
	
	/* 
	 * Name of the Method  : enterText()
	 * Description         : sending the values for the given elements 
	 * Arguments           : webElement obj -> creating webelement object
	 * 						 String textValue -> sending values 
	 * Created 			   : 03/21/19
	 * Last Modified       : 03/21/19
	 */

	public static void enterText( WebElement obj , String textValue) throws InterruptedException
	{	
		
		if(obj.isDisplayed())
		{
			Thread.sleep(2000);
			obj.sendKeys(textValue);
			System.out.println("Enter into text field is success");
			
		}
		else
		{
			System.out.println("It doesnt exist please check");
			
		}
	}
	
	/* 
	 * Name of the Method  : clickButton()
	 * Description         : clicking the button
	 * Arguments           : webElement element
	 * Created 			   : 03/21/19
	 * Last Modified       : 03/21/19
	 */
	
	public static void clickButton(WebElement element) throws InterruptedException
	{
		if(element.isDisplayed())
		{
			Thread.sleep(2000);
			element.click();
			System.out.println("Element is clicked successfully");
			
		}else
		{
			System.out.println("Unable to find the button");
			
		}
		
	}
	
	/* 
	 * Name of the Method  : getAction()
	 * Description         : performing action
	 * Arguments           : webElement obj
	 * Created 			   : 03/21/19
	 * Last Modified       : 03/21/19
	 */
	
	public static Actions getAction(WebElement obj) {
	    Actions action = new Actions(driver);
	   action.moveToElement(obj).build().perform();
	    return action;
	}

	/* 
	 * Name of the Method  : dropElement()
	 * Description         : selecting the values from dropdown
	 * Arguments           : webElement obj
	 * 					     int y
	 * 						 String index
	 * Created 			   : 03/21/19
	 * Last Modified       : 03/21/19
	 */
	
	public static Select dropElement(WebElement obj,int y, String index)
	{
		Select select = new Select(obj);
		
		switch(y)
		{
		case 1:
			select.selectByIndex(Integer.valueOf(index));
			break;			
		case 2:
			select.selectByValue(index);
			break;
		case 3:
			select.selectByVisibleText(index);
			break;
		}
		return select;
		
	}

	/* 
	 * Name of the Method  : readExcelData()
	 * Description         : reading data from excel sheet
	 * Arguments           : String dataTablePath 
	 * 						 String sheetName
	 * Created 			   : 03/21/19
	 * Last Modified       : 03/21/19
	 */
	
	public static String[][] readExcelData(String dataTablepath, String
			sheetName) throws IOException {
		
		File xlFile = new File(dataTablepath);
		FileInputStream xlDoc = new FileInputStream(xlFile);
		HSSFWorkbook wb = new HSSFWorkbook(xlDoc);
		HSSFSheet sheet = wb.getSheet(sheetName);
		
		String val;
		
		int iRowCount = sheet.getLastRowNum()+1;
		int iColumnCount = sheet.getRow(0).getLastCellNum();

		String[][] xldata = new String[iRowCount][iColumnCount];
		
		for(int i = 0; i <iRowCount; i++) {
			for(int j = 0; j<iColumnCount; j++) {
				xldata[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();

			}
		}
		return xldata;
	}

	/* 
	 * Name of the Method  : endApplication()
	 * Description         : Exit from the Application
	 * Created 			   : 03/21/19
	 * Last Modified       : 03/21/19
	 */
	
	public static void endApplication() throws InterruptedException
	{
		wait(30);
		Thread.sleep(5000);
		driver.quit();
		logger.log(LogStatus.PASS, "Exit from the Application");
		report.endTest(logger);
		report.flush();
		System.out.println("End");
	}

}
