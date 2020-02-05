package com.Imap.base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.Imap.config.ReadConfig;
import com.aventstack.extentreports.utils.FileUtil;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();
	public String baseurl=readconfig.getApplicationurl();
	public String globalid=readconfig.getGlobalid();
	public String loginpassword=readconfig.getpassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String browse)
	{
		 logger = Logger.getLogger("Imap");
		    PropertyConfigurator.configure("C:\\Users\\ckhobra\\Desktop\\Imap_Automation_Framework\\"
		    + "JenkinsGitDemoProject\\GitJenkinsDemoProject\\src\\main\\java\\com\\Imap\\config\\log4j.properties");
		
		if(browse.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",readconfig.getchromepath());
	    driver = new ChromeDriver();
		}
		else if(browse.equals("firefox"))
		{
			System.out.println("Firefox driver is not configured"
					+ "Add firefox driver and then add above code");
		}
		else if(browse.equals("ie"))
		{
			System.out.println("IE driver is not configured"
					+ "Add IE driver and then add above code");
		}
		driver.get(baseurl);
	   
	}
	
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	
	public void capturescreen(WebDriver driver,String tname)
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+ "/Screenshots/" +tname+".png");
		
			try
			{
				FileUtils.copyFile(source,target);
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		
	    System.out.println("Screenshot taken");
	
	}
	
}
