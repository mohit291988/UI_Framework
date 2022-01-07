package com.uiFramework.companyName.projectName.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
private static ExtentReports extent;
	
	public static ExtentReports getInstance(){
		if(extent == null){
			
			return createInstance("test-output/extent.html");
			//String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			//return createInstance("test-output/extent"+timeStamp+".html");
		}
		else
		{
			return extent;
		}
	}
	
	public static ExtentReports createInstance(String fileName){
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(fileName);
		reporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		reporter.config().setChartVisibilityOnOpen(true);
		reporter.config().setTheme(Theme.STANDARD);
		reporter.config().setDocumentTitle(fileName);
		reporter.config().setEncoding("utf-8");
		reporter.config().setReportName("Automation Report");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
	}

}
