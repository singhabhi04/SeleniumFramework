package com.tmb.utils;

import java.util.Base64;

public final class DecodeUtils {
	
	private DecodeUtils() {
		
	}
	public static String getDecodedString(String encodedString) {
		return  new String(	Base64.getDecoder().decode(encodedString.getBytes()));
		
	}
	
	public static String getEncodedString(String decodedString) {
		return Base64.getEncoder().encodeToString("admin123".getBytes());
		
	}

}
