package com.uiFramework.companyName.projectName.helper.javaScript;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;

public class JavaScriptHelper {
	
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(JavaScriptHelper.class);
	
	public JavaScriptHelper(WebDriver driver)
	{
		this.driver = driver;
		log.info("JavaScript has been initialised");
	}
	
	public Object executeScript(String script)
	{
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		return exe.executeScript(script);
	}
	
	/**
	 * This method will execute java script with multiple arguments 
	 * @param script
	 * @param args
	 * @return
	 */
	

	public Object executeScript(String script, Object...args)
	{
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		return exe.executeScript(script,args);
	}
	
	/**
	 * This method will scroll till element
	 * @param element
	 */
	
	public void scrollToElement(WebElement element)
	{
		log.info("scroll to webelement");
		executeScript("window.scrollTo(argument[0],argument[1])",element.getLocation().x,element.getLocation().y);
	}
	
	/**
	 * Scroll Till Element and Click
	 * @param element
	 */

	public void scrollToElementAndClick	(WebElement element)
	{
		log.info("scroll to webelement and click");
		scrollToElement(element);
		element.click();
		log.info("element is clicked :"+element.toString());
	}
	
	/**
	 * This method to scroll to view
	 * @param element
	 */
	
	public void scrollIntoView(WebElement element)
	{
		log.info("scroll till view element");
		executeScript("argument[0],scrollIntoView()",element);
	}


	/**
	 * This method to scroll to view and click on element
	 * @param element
	 */
	
	public void scrollIntoViewAndClick(WebElement element)
	{
		scrollIntoView(element);
		element.click();
		log.info("view element is clicked");
	}
	
	/**
	 * this method will scroll down vertically
	 * @param element
	 */
	
	public void scrollDownVertically(WebElement element)
	{
		log.info("scrolling down vertically");
		executeScript("window.scrollTo(0,document.body.scrollHeight");
	}
	
	/**
	 * this method will scroll up vertically
	 * @param element
	 */
	
	public void scrollUpVertically(WebElement element)
	{
		log.info("scrolling up vertically");
		executeScript("window.scrollTo(0,-document.body.scrollHeight");
	}
	
	/**
	 * This method will scroll till given pixel (e.g. 1500)
	 * @param pixel
	 */
	
	public void scrollDownByPixel(int pixel)
	{
		executeScript("window.scrollBY(0,"+pixel+")");
	}
	
	public void scrollUpByPixel(int pixel)
	{
		executeScript("window.scrollBY(0,-"+pixel+")");
	}

	/**
	 * This method will zoom increase by 100%
	 */
	public void zoomInBy100Percentage()
	{
		executeScript("document.body.style='100%'");
	}
	
	public void zoomInBy60Percentage()
	{
		executeScript("document.body.style='60%'");
	}
	
	public void clickElement(WebElement element)
	{
		executeScript("argument[o].click();", element);
	}
	
}
