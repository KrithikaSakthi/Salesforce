package com.training.SeleniumJan22;

import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

public class TestCase04B extends TestUtils{

	public static void main(String[] args) throws InterruptedException {
		
		extentReports("test-output/TC 04B.html","TC 04B");
		startApplication();
		launchURL("https://login.salesforce.com/");
		wait(30);
		
		WebElement username = findElement(1,"username");
		enterText(username, "123");
		logger.log(LogStatus.PASS, "Username Entered Wrongly");
		
		WebElement password = findElement(1,"password");
		enterText(password, "22131");
		logger.log(LogStatus.PASS, "Password Entered Wrongly");
		
		WebElement login = findElement(1,"Login");
		clickButton(login);
		logger.log(LogStatus.PASS, "Your Login attempt is failed ");
		
		endApplication();

	}

}
