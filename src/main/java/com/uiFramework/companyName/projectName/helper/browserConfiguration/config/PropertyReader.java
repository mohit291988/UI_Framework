package com.uiFramework.companyName.projectName.helper.browserConfiguration.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.uiFramework.companyName.projectName.helper.browserConfiguration.BrowserType;
import com.uiFramework.companyName.projectName.helper.resource.ResourceHelper;

public class PropertyReader implements ConfigReader{
	
	private static FileInputStream file;
	public static Properties OR;
	
	public PropertyReader() 
	{
		String filePath = ResourceHelper.getResourcePath("src/main/resources/configFile/config.properties");
		try {
			file = new FileInputStream(new File(filePath));
			OR = new Properties();
			OR.load(file);
			
			filePath = ResourceHelper.getResourcePath("src/main/resources/configFile/config1.properties");
			file = new FileInputStream(new File(filePath));
			OR = new Properties();
			OR.load(file);
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getImplicitWait() {
		// TODO Auto-generated method stub
		return Integer.parseInt(OR.getProperty("implictwait"));
	}

	public int getEmplicitWait() {
		// TODO Auto-generated method stub
		return Integer.parseInt(OR.getProperty("explicitwait"));
	}

	public int getPageLoadWait() {
		// TODO Auto-generated method stub
		return Integer.parseInt(OR.getProperty("pageloadtime"));
	}

	
	public BrowserType getBrowserType() {
		return BrowserType.valueOf(OR.getProperty("browsertype"));
	}

}
