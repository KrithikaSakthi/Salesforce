package com.training.SeleniumJan22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

public class TestCase04A extends TestUtils{

	public static void main(String[] args) throws InterruptedException {
		
		extentReports("test-output/TC 04A.html","TC 04A");
		startApplication();
		launchURL("https://login.salesforce.com/");
		wait(30);
		
		WebElement username = findElement(1,"username");
		enterText(username, "krithika@oracle.com");
		logger.log(LogStatus.PASS, " Username Entered");
		
		WebElement fgtpswd = findElement(2,"//a[@class='fl small']");
		clickButton(fgtpswd);
		logger.log(LogStatus.PASS, "Forgot Password Link clicked");
		
		Thread.sleep(2000);
		
		WebElement un = findElement(2,"//input[@id='un']");
		enterText(un, "krithika@oracle.com");
		
		WebElement con = findElement(2,"//input[@value='Continue']");
		clickButton(con);
		
		Thread.sleep(2000);
		
		//Return to Login
		WebElement returnToLogin = findElement(2,"//a[@class='primary button wide mb16']");
		clickButton(returnToLogin);
		logger.log(LogStatus.PASS, "Returned to Login Page");
		
		endApplication();
	}

}
