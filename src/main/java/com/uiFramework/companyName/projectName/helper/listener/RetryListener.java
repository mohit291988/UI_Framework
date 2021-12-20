package com.uiFramework.companyName.projectName.helper.listener;

import java.lang.reflect.Constructor;
import org.testng.IRetryAnalyzer;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class RetryListener implements IAnnotationTransformer{

	public void transform(ITestAnnotation arg0,	Class arg1, Constructor arg2, Method arg3)
	{
		IRetryAnalyzer retry = arg0.getRetryAnalyzer();
		
	}
}