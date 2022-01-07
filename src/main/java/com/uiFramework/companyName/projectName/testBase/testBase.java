package com.uiFramework.companyName.projectName.testBase;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.uiFramework.companyName.projectName.helper.browserConfiguration.BrowserType;
import com.uiFramework.companyName.projectName.helper.browserConfiguration.ChromeBrowser;
import com.uiFramework.companyName.projectName.helper.browserConfiguration.FirefoxBrowser;
import com.uiFramework.companyName.projectName.helper.browserConfiguration.config.ConfigReader;
import com.uiFramework.companyName.projectName.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.companyName.projectName.helper.browserConfiguration.config.PropertyReader;
import com.uiFramework.companyName.projectName.helper.wait.WaitHelper;
import com.uiFramework.companyName.projectName.utils.ExtentManager;

public class testBase {
	
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public WebDriver driver;
	
		
	@BeforeSuite
	public void beforeSuite()
	{
		extent = ExtentManager.getInstance();
	}
	
	@BeforeTest
	public void beforetest()
	{
		ObjectReader.Reader = new PropertyReader();
	}
	
	@BeforeClass
	public void beforeClass()
	{
		test = extent.createTest(getClass().getName());		
	}
	
	@BeforeMethod
	public void beforeMethod(Method method)
	{
		test.log(Status.INFO, method.getName());
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result)
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			test.log(Status.FAIL,result.getThrowable());
		}
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.PASS,result.getName()+"  - is PASS");
		}
		else if(result.getStatus() == ITestResult.SKIP)
		{
			test.log(Status.SKIP,result.getThrowable());
		}
		
		extent.flush();
	}	
	
	public WebDriver getBrowserObject(BrowserType btype) throws Exception
	{
		try
		{
			switch(btype)
			{
			case Chrome:
				ChromeBrowser chrome = ChromeBrowser.class.newInstance();
				ChromeOptions option = chrome.getChromeOptions();
				chrome.getChromeDriver(option);
			
			case Firefox:
				FirefoxBrowser firefox = new FirefoxBrowser();
				FirefoxOptions options = firefox.getFirefoxOptions();
				firefox.getFirefoxDriver(options);	
				
			default:
				throw new Exception("driver not found : +btype.name()");
			}
			
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public void setupDriver(BrowserType btype) throws Exception
	{
		driver = getBrowserObject(btype);
		WaitHelper wait = new WaitHelper(driver);
		wait.setImplicitWait(ObjectReader.Reader.getEmplicitWait(), TimeUnit.SECONDS);
		wait.pageLoadTime(ObjectReader.Reader.getPageLoadWait(), TimeUnit.SECONDS);
		driver.manage().window().maximize();		
	}
	
	public String captureScreenshot(String fileName)
	{
		if(driver == null)
		{
			return null;
		}
		
		if(fileName == "")
		{
			fileName = "blank";
		}
		
		File destFile = null;
		Calender calender = Calender.getInstance();
		
		
		return fileName;
		
	}

}
