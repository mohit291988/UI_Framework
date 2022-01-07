package com.uiFramework.companyName.projectName.helper.listener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;



public class Transfomer implements IAnnotationTransformer {
	
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) 
    
    {
        annotation.setRetryAnalyzer(Retry.class);
    }
}