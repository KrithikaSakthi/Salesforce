package com.training.SeleniumJan22;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.LogStatus;

public class TestCase05 extends TestUtils{

	public static void main(String[] args) throws InterruptedException {
		
		extentReports("test-output/TC 05.html","TC 05");
		startApplication();
		launchURL("https://login.salesforce.com/");
		wait(30);
		
		WebElement username = findElement(1,"username");
		enterText(username, "krithika@oracle.com");
		logger.log(LogStatus.PASS, "Username Entered");
		
		WebElement password = findElement(1,"password");
		enterText(password, "aarav143");
		logger.log(LogStatus.PASS, "Password Entered");
		
		WebElement login = findElement(1,"Login");
		clickButton(login);
		logger.log(LogStatus.PASS, "Logged in to the Page");
		
		//Hover Over
		WebElement user = findElement(3,"#userNavLabel");
		getAction(user);
		logger.log(LogStatus.PASS, "Action performed on UserMenu");
		
		
		//Dropdown
		WebElement dropdown = findElement(2,"//div[@title='User menu for krithika Sakthi']//div[@class='menuButtonButton']");
		clickButton(dropdown);
		wait(40);
		logger.log(LogStatus.PASS, "UserMenu Dropdown Selected");
		
		endApplication();


	}

}
