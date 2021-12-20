package com.uiFramework.companyName.projectName.helper.select;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.LinkedList;
import java.util.List;

import com.uiFramework.companyName.projectName.helper.assertion.VerificationHelper;
import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;

public class DropDownHelper {
	
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(VerificationHelper.class);
	
	public DropDownHelper(WebDriver driver)
	{
		this.driver = driver;
		log.info("DropDown Object is created");
	}
	
	public void selectUsingValue(WebElement element, String value)
	{
		Select select = new Select(element);
		log.info("Select Using Value and value is : "+value);
		select.selectByValue(value);
	}
	
	public void selectUsingIndex(WebElement element, int value)
	{
		Select select = new Select(element);
		log.info("Select Using Index and Index value is : "+value);
		select.selectByIndex(value);
	}
	
	public void selectUsingVisibleElement(WebElement element, String visibletext)
	{
		Select select = new Select(element);
		log.info("Select Using visible text : "+visibletext);
		select.selectByVisibleText(visibletext);
	}
	
	public void deSelectUsingValue(WebElement element, String value)
	{
		Select select = new Select(element);
		log.info("Deselect Using Value and value is : "+value);
		select.deselectByValue(value);
	}
	
	public void deSelectUsingIndex(WebElement element, int value)
	{
		Select select = new Select(element);
		log.info("Deselect Using Index and Index value is : "+value);
		select.deselectByIndex(value);
	}
	
	public void deSelectUsingVisibleElement(WebElement element, String visibletext)
	{
		Select select = new Select(element);
		log.info("Deselect Using visible text : "+visibletext);
		select.deselectByVisibleText(visibletext);
	}
	
	public List<String> getAllDropDownData(WebElement element)
	{
		Select select = new Select(element);
		List<WebElement> elementlist = select.getOptions();
		List<String> valuelist = new LinkedList<String>();
		
		for(WebElement ele : elementlist)
		{
			log.info(ele.getText());
			valuelist.add(ele.getText());
		}
		return valuelist;
		
		
	}
	
}
	