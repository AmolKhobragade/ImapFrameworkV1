package com.Imap.TestCases;

import org.testng.annotations.Test;

import com.Imap.base.BaseClass;
import com.Imap.pageObjects.LoginPage;

public class TC_LoginTestCase_001 extends BaseClass
{

	@Test
	public void logintest()
	{
		
		logger.info("Imap login page is launched");
		driver.manage().window().maximize();
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(globalid);
		logger.info("Entering global id");
		lp.setPassword(loginpassword);
		logger.info("Entering password");
		lp.clickLogin();
		logger.info("Clicking on the login button");
		
	}
	
	
}
