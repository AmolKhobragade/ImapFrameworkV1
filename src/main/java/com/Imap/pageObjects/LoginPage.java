package com.Imap.pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Imap.base.BaseClass;

public class LoginPage extends BaseClass {

	WebDriver ldriver;
	
	public LoginPage (WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//input[@ng-model='LoginData.UserCredentials.UserName']")
	WebElement txtGlobalid; 
	
	@FindBy(xpath="//input[@ng-model='LoginData.UserCredentials.Password']")
	WebElement txtPassword; 
	
	@FindBy(id="btnLogin")
	WebElement btnLogin; 
	
	public void setUserName(String uname)
	{
		txtGlobalid.sendKeys(uname);
	}
	
	public void setPassword(String pname)
	{
		txtPassword.sendKeys(pname);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
}
