package com.training.SeleniumJan22;

import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

public class TestCase02 extends TestUtils {

	public static void main(String[] args) throws InterruptedException {
		
		extentReports("test-output/TC 02.html","TC 02");
		startApplication();
		launchURL("https://login.salesforce.com/");
		wait(30);
		
		WebElement username = findElement(1,"username");
		enterText(username, "krithika@oracle.com");
		logger.log(LogStatus.PASS, " Username Entered");
		
		WebElement password = findElement(1,"password");
		enterText(password, "aarav143");
		logger.log(LogStatus.PASS, " Password Entered");
		
		WebElement login = findElement(1,"Login");
		clickButton(login);
		logger.log(LogStatus.PASS, "User is logged into the page");
		
		endApplication();

	}

}
