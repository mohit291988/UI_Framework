package com.uiFramework.companyName.projectName.helper.browserConfiguration.config;

import com.uiFramework.companyName.projectName.helper.browserConfiguration.BrowserType;

public interface ConfigReader {
	
	public int getImplicitWait();
	public int getEmplicitWait();
	public int getPageLoadWait();
	public BrowserType getBrowserType();

	

}
