package com.training.SeleniumJan22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

public class TestCase01 extends TestUtils {

	public static void main(String[] args) throws InterruptedException {

		extentReports("test-output/TC 01.html","TC 01");
		startApplication();
		launchURL("https://login.salesforce.com/");
		wait(30);

		WebElement username = findElement(1,"username");
		enterText(username, "krithika@oracle.com");
		logger.log(LogStatus.PASS, " Username Entered");

		WebElement password = findElement(1,"password");
		//enterText(username, "");
		if(password.getText()!=null)
		{
			password.clear();
		}
		logger.log(LogStatus.PASS, " No Password is Entered");
		
		WebElement login = findElement(1,"Login");
		clickButton(login);
		
		WebElement errorMessage = findElement(3,"#error");		
		logger.log(LogStatus.PASS, "Error message 'please enter your username' displayed");

		endApplication();
		
	}

}
