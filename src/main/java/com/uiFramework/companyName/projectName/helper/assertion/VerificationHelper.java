package com.uiFramework.companyName.projectName.helper.assertion;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;

public class VerificationHelper {
	
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(VerificationHelper.class);
	
	public VerificationHelper(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public boolean isDisplayed(WebElement element)
	{
		try
		{
			element.isDisplayed();
			log.info("element is present"+element.getText());
			return true;
		}
		
		catch (Exception e)
		{
			log.error("element is not present"+e.getCause());
			return false;
		}
		
	}
	
	public boolean isNotDisplayed(WebElement element)
	{
		try
		{
			element.isDisplayed();
			log.info("element is present"+element.getText());
			return false;
		}
		
		catch (Exception e)
		{
			log.error("element is not present");
			return true;
		}
		
	}
	
	public String getText(WebElement element)
	{
		if(null == element)
		{
			log.info("Webelement is null");
			return null;
		}
		boolean status = isDisplayed(element);
		if (status)
		{
			log.info("element text is "+element.getText());
			return element.getText();
		}
		else
		{
			return null;	
		}
			
		
	}
}
