package com.uiFramework.companyName.projectName.helper.resource;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;

public class ResourceHelper {

	public static String getResourcePath(String path) {
        String basePath = System.getProperty("user.dir");
        System.out.println(basePath +"/"+ path);
		return basePath +"/"+ path;
	}
}