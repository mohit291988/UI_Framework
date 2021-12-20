package com.uiFramework.companyName.projectName.helper.alert;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import com.uiFramework.companyName.projectName.helper.assertion.VerificationHelper;
import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;

public class AlertHelper {
	
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(VerificationHelper.class);
	
	public AlertHelper(WebDriver driver)
	{
		this.driver = driver;
		log.info("AlertHelper Object is created");
	}
	
	public Alert getAlert()
	{
		log.info("alert test"+driver.switchTo().alert().getText());
		return driver.switchTo().alert();
	}
	
	public void AcceptAlert()
	{
		log.info("Accept Alert is done");
		getAlert().accept();
	}
	
	public void DismissAlert()
	{
		log.info("Dismiss Alert is done");
		getAlert().dismiss();
	}
	
	public String getAlertTest()
	{
		String text = getAlert().getText();
		log.info("alert text"+text);
		return text;
	}
	
	public boolean isAlertPresent( )
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch (NoAlertPresentException e)
		{
			log.info(e.getCause());
			return false;
		}
	}
	
	public boolean acceptAlertIfPresent( )
	{
		if(isAlertPresent())
		{
			AcceptAlert();
		}
		else
		{
			log.info("alert is not present");
		}
	}
	
	public boolean dismissAlertIfPresent( )
	{
		if(isAlertPresent())
		{
			DismissAlert();
		}
		else
		{
			log.info("alert is not present");
		}
	}
	
	public void acceptPrompt()
	{
		if(isAlertPresent())
		{
			Alert alert = getAlert();
			String text;
			alert.sendKeys(text);
			alert.accept();
			log.info("alert text:"+alert.getText());
		}
		else
		{
			log.info("alert is not present");
		}
	}
	
	

}
