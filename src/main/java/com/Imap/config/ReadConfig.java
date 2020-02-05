package com.Imap.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	public ReadConfig()
	{
	
	File src = new File("./Configuration/config.properties");
	
	try
	{
		FileInputStream fis = new FileInputStream(src);
		pro=new Properties();
		pro.load(fis);
	}
	catch(Exception e)
	{
		System.out.println("Exception is "+e.getMessage());
	}
}
	public String getApplicationurl()
	{
		String url = pro.getProperty("baseurl");
		return url;
	}
	
	public String getGlobalid()
	{
		String username = pro.getProperty("globalid");
		return username;
	}
	
	public String getpassword()
	{
		String pass = pro.getProperty("loginpassword");
		return pass;
	}
	
	public String getchromepath()
	{
		String chrome = pro.getProperty("chromepath");
		return chrome;
	}
	
	
	
	}
