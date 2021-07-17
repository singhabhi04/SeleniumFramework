package com.tmb.utils;

import java.io.FileInputStream;
import java.util.Objects;
import java.util.Properties;

public final class ReadPropertyFile {
	
	private ReadPropertyFile() {
		
	}
	
	public static String getValue(String key) throws Exception
	{
		String value="";
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config/config.properties");
		prop.load(file);
		value =prop.getProperty(key);
		if(Objects.isNull(value)) {
			throw new Exception("Property name "+key+" is not available in config.properties");
		}
		return value ;
		
	}
}


