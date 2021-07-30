package com.tmb.constants;

import com.tmb.enums.ConfigProperties;
import com.tmb.utils.ReadPropertyFile;

public final class FrameworkConstants {

	private FrameworkConstants() {

	}

	private static final String RESOURCESPATH = System.getProperty("user.dir") + "/src/test/resources";
	private static final String CHROMEDRIVERPATH = RESOURCESPATH + "/executables/chromedriver.exe";
	private static final String CONFIGFILEPATH = RESOURCESPATH + "/config/config.properties";
	private static final int EXPLICITWAITTIME = 10;
	private static final String EXTENTREPORTPATH = System.getProperty("user.dir") + "/extent-test-output";
	private static  String extentReportFilePath="";
	private static final String TESTSCRIPTEXCELPATH =RESOURCESPATH+"/excel/TestScript.xlsx";
	
	

	

	

	public static String getExtentReportFilePath() throws Exception  {
		if(extentReportFilePath.isEmpty()) {
			extentReportFilePath = createReportPath();
		}
		return extentReportFilePath;
	}
 
	private static String createReportPath() throws Exception {
		if (ReadPropertyFile.getValue(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("Yes")) {
			return EXTENTREPORTPATH + "/" + System.currentTimeMillis() + "index.html";
		} else {
			return EXTENTREPORTPATH + "/" + "index.html";
		}

	}

	public static int getExplicitwaittime() {
		return EXPLICITWAITTIME;
	}

	public static String getChromedriverpath() {
		return CHROMEDRIVERPATH;
	}

	public static String getConfigfilepath() {
		return CONFIGFILEPATH;
	}
	
	public static String getTESTSCRIPTEXCELPATH() {
		return TESTSCRIPTEXCELPATH;
	}

}
