package com.uiFramework.companyName.projectName.helper.assertion;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;

public class AssertionHelper {
	
	private static Logger log = LoggerHelper.getLogger(VerificationHelper.class);
	
	
	public static void verifyText(String s1, String s2)
	{
		log.info("verifying test"+s1+"with"+s2);
		Assert.assertEquals(s1, s2);
	}

	public static void makeTrue()
	{
		log.info("making script PASS");
		Assert.assertTrue(true);
	}
	
	public static void makeFalse()
	{
		log.info("making script FAIL");
		Assert.assertTrue(false);
	}
	
	public static void makeFalse(String message)
	{
		log.info("making script PASS" + message);
		Assert.assertTrue(false, message);	
	}
	
	public static void verifyTrue(boolean status)
	{
		
		Assert.assertTrue(status);	
	}
	
	public static void verifyfalse(boolean status)
	{
		Assert.assertFalse(status);	
	}
	
	public static void verifyNullObject(String s1)
	{
		log.info("Verify object is null");
		Assert.assertNull(s1);
	}
	
	public static void verifyNotNullObject(String s1)
	{
		log.info("Verify object is not null");
		Assert.assertNotNull(s1);
	}
	
	
}
