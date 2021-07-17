package com.tmb.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.tmb.constants.FrameworkConstants;

public final class ReadPropertyFile {
	

	private static Properties property = new Properties();
	private static final Map<String, String> CONFIGMAP = new HashMap<>();
	
	private ReadPropertyFile() {
		
	}
	static {
		
		try {
			FileInputStream file = new FileInputStream(FrameworkConstants.getConfigfilepath());
			property.load(file);
			for (Map.Entry<Object, Object> entry : property.entrySet()) {
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim()); //remove the trailing and leading spaces
			}
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static String getValue(String key) throws Exception
	{
		
		if(Objects.isNull(key)|| Objects.isNull(CONFIGMAP.get(key))) {
			throw new Exception("Property name "+key+" is not available in config.properties");
		}
		return CONFIGMAP.get(key) ;
		
	}
}


