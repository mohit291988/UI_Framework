package com.uiFramework.companyName.projectName.helper.window;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;

public class windowHelper {
	
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(windowHelper.class);
	
	public windowHelper(WebDriver driver)
	{
		this.driver = driver;
	}
	
	/**
	 * This method will help to move to Parent Window
	 */
	public void switchToParentWindow()
	{
		log.info("switching to parent window...");
		driver.switchTo().defaultContent();
		log.info("Switched to Parent Window Successfully");
	}
	
	/**
	 * This method will help to switch to child window
	 * @param index
	 */
	
	public void switchToWindow(int index)
	{
		Set<String> windows = driver.getWindowHandles();
		int i = 1;
		for(String window : windows)
		{
			if(i == index)
			{
				log.info("Switched to :"+index+ "window");
				driver.switchTo().window(window);
			}
			else
			{
				i++;
			}
			
		}
	}
	
	/** This method will close all child window and switch to main window
	 * 
	 */
	
	public void closeAllTabsAndSwitchToMainWindow()
	{
		Set<String> windows = driver.getWindowHandles();
		String mainWindow =driver.getWindowHandle();
		
		for(String window : windows)
		{
			if(!window.equalsIgnoreCase(mainWindow))
			{
				driver.close();
			}
						
		}
		log.info("switched to main window");
		driver.switchTo().window(mainWindow);
		
	}
	
	/**
	 * This method will use for navigation back
	 */
	
	public void navigateBack()
	{
		log.info("Navigation Back");
		driver.navigate().back();
		
	}
	
	/**
	 * This method will use for navigation forward
	 */
	
	public void navigateForward()
	{
		log.info("Navigation Forward");
		driver.navigate().forward();
				
	}


}
