package com.uiFramework.companyName.projectName.testScript;

import org.testng.annotations.Test;

import com.uiFramework.companyName.projectName.helper.assertion.AssertionHelper;
import com.uiFramework.companyName.projectName.testBase.testBase;

public class Test2 extends testBase{
	
	@Test
	public void testLogin()
	{
		AssertionHelper.makeTrue();
	}
	
	@Test
	public void testLogin1()
	{
		AssertionHelper.makeFalse();
	}
	
	@Test
	public void testLogin2()
	{
		AssertionHelper.makeTrue();
	}
	
	@Test
	public void testLogin3()
	{
		AssertionHelper.makeFalse();
	}


	
}
