package com.uiFramework.companyName.projectName.helper.wait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;

public class WaitHelper {
	
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(WaitHelper.class);
	
	public WaitHelper(WebDriver driver)
	{
		this.driver=driver;
	}
	
	/**
	 * This is ImplicitWait Method
	 * @param timeout
	 * @param unit
	 */
	public void setImplicitWait(long timeout, TimeUnit unit)
	{
		log.info("Implict wait has been set to : "+timeout);
		driver.manage().timeouts().implicitlyWait(timeout, unit);
		
	}
	
	/**
	 * This will help us get WebDriver Wait
	 * @param timeOutInSeconds
	 * @param pollingEveryInMilliSec
	 * @return
	 */
	private WebDriverWait getWait(int timeOutInSeconds, int pollingEveryInMilliSec)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.pollingEvery(Duration.ofMillis(pollingEveryInMilliSec));
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		
		return wait;
	}
	
	/**
	 * This method will make sure your element is visible
	 * @param element
	 * @param timeOutInSeconds
	 * @param pollingEveryInMilliSec
	 */
	
	public void WaitForElementVisibleWithPollingTime(WebElement element, int timeOutInSeconds, int pollingEveryInMilliSec)
	{
		log.info("Waiting for :" +element.toString()+" for :"+ timeOutInSeconds+" seconds");
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMilliSec);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("Element is visible now");
	}
	
	/**
	 * This method is make sure your element is clickable
	 * @param element
	 * @param timeOutInSeconds
	 * @param pollingEveryInMilliSec
	 */
	
	public void WaitForElementClickable(WebElement element, int timeOutInSeconds, int pollingEveryInMilliSec)
	{
		log.info("Waiting for :" +element.toString()+" for :"+ timeOutInSeconds+" seconds");
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMilliSec);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		log.info("Element is clickable now");
	}
	
	/**
	 * This method will make sure invisibility of element
	 * @param element
	 * @param timeOutInSeconds
	 * @param pollingEveryInMilliSec
	 * @return
	 */
	
	public boolean WaitForElementNotPresent(WebElement element, int timeOutInSeconds, int pollingEveryInMilliSec)
	{
		log.info("Waiting for :" +element.toString()+" for :"+ timeOutInSeconds+" seconds");
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMilliSec);
		boolean status = wait.until(ExpectedConditions.invisibilityOf(element));
		log.info("Element is visiable now");
		return status;		
	}
	
	/**
	 * This method will wait for frame and switch to i.t
	 * @param element
	 * @param timeOutInSeconds
	 * @param pollingEveryInMilliSec
	 */
	
	public void WaitForFrameToBeAvailable(WebElement element, int timeOutInSeconds, int pollingEveryInMilliSec)
	{
		log.info("Waiting for :" +element.toString()+" for :"+ timeOutInSeconds+" seconds");
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMilliSec);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		log.info("frame is available and switched");	
	}
	
	/**
	 * This method will give FluentWait Object
	 * @param timeOutInSeconds
	 * @param pollingEveryInMilliSec
	 * @return
	 */
	public Wait<WebDriver> getFluentWait(int timeOutInSeconds, int pollingEveryInMilliSec)
	{
		Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(100)).
				pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		
		return fwait;
	}
	
	/**
	 * This method is used to FluentWait for Element
	 * @param element
	 * @param timeOutInSeconds
	 * @param pollingEveryInMilliSec
	 * @return
	 */
	
	public WebElement waitForElement(WebElement element, int timeOutInSeconds, int pollingEveryInMilliSec)
	{
		Wait<WebDriver> fwait = getFluentWait(timeOutInSeconds, pollingEveryInMilliSec);
		fwait.until(ExpectedConditions.visibilityOf(element));
		return element;		
	}
	
	/**
	 * This method is use to page load
	 * @param timeout
	 * @param unit
	 */
	
	public void pageLoadTime(long timeout, TimeUnit unit)
	{
		log.info("waiting for page to load for :"+unit);
		driver.manage().timeouts().pageLoadTimeout(timeout,unit);
		log.info("Page is loaded");
		
	}
}
