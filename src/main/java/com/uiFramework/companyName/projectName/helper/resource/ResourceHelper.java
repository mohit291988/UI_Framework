package com.uiFramework.companyName.projectName.helper.resource;

import org.apache.log4j.Logger;

import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;

public class ResourceHelper {
	
	public static String getResourcePath(String path)
	{	
		Logger log = LoggerHelper.getLogger(ResourceHelper.class);
		
		log.info("resource path:"+System.getProperty("user.dir")+"/"+path);
		String basePath = System.getProperty("user.dir");
		System.out.println(basePath +"/" +path);
		return basePath +"/" +path;

	}
	
}
