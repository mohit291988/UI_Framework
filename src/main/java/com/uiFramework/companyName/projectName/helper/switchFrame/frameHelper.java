package com.uiFramework.companyName.projectName.helper.switchFrame;

import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;

public class frameHelper {
	
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(frameHelper.class);
	
	public frameHelper(WebDriver driver)
	{
		this.driver = driver;
	}
	
	/**
	 * This method will switchToFrame based on Index
	 * @param frameIndex
	 */
	public void switchToFrame(int frameIndex)
	{
		driver.switchTo().frame(frameIndex);
		log.info("Switched to :"+frameIndex+ "frame");
	}
	
	/**
	 * This method will switchToFrame based on Frame Name
	 * @param frameName
	 */
	
	public void switchToFrame(String frameName)
	{
		driver.switchTo().frame(frameName);
		log.info("Switched to :"+frameName+ "frame");
	}
	
	/**
	 * This method will switchToFrame based on frame webElement
	 * @param element
	 */
	
	public void switchToFrame(WebElement element)
	{
		driver.switchTo().frame(element);
		log.info("Switched to :"+element+ "frame");
	}
	
	
	
	

}
