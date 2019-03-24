package com.training.SeleniumJan22;

import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

public class TestCase03 extends TestUtils{

	public static void main(String[] args) throws InterruptedException {


		extentReports("test-output/TC 03.html","TC 03");
		startApplication();
		launchURL("https://login.salesforce.com/");
		wait(30);

		WebElement username = findElement(1,"username");
		enterText(username, "krithika@oracle.com");
		logger.log(LogStatus.PASS, " Username Entered");

		WebElement password = findElement(1,"password");
		enterText(password, "aarav143");
		logger.log(LogStatus.PASS, " Password Entered");

		WebElement rememberMe = findElement(1,"rememberUn");
		clickButton(rememberMe);
		logger.log(LogStatus.PASS, "Remember Me is checked");

		WebElement login = findElement(1,"Login");
		clickButton(login);
		logger.log(LogStatus.PASS, "User is logged into the page");

		//Hover Over
		WebElement user = findElement(3,"#userNavLabel");
		getAction(user);
		logger.log(LogStatus.PASS, "Action performed on UserMenu");

		//Dropdown
		WebElement dropdown = findElement(2,"//div[@title='User menu for krithika Sakthi']//div[@class='menuButtonButton']");
		clickButton(dropdown);
		wait(40);
		logger.log(LogStatus.PASS, "UserMenu Dropdown Selected");

		WebElement logOut = findElement(2,"//a[@title='Logout']");
		clickButton(logOut);
		logger.log(LogStatus.PASS, "Logged Out of the Page");

		endApplication();

	}

}
