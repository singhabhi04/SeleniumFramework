package com.tmb.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.tmb.FrameworkExceptions.InvalidPathForPropertyFileException;
import com.tmb.FrameworkExceptions.PropertiesFileUsageExceptions;
import com.tmb.constants.FrameworkConstants;
import com.tmb.enums.ConfigProperties;

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
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim()); // remove the
																										// trailing and
																										// leading
																										// spaces
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);

		}

	}

	public static String getValue(ConfigProperties key) {

		if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			throw new PropertiesFileUsageExceptions("Property name " + key + " is not available in config.properties");
		}
		return CONFIGMAP.get(key.name().toLowerCase());

	}
}
