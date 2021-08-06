package com.tmb.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.tmb.FrameworkExceptions.FrameworkException;
import com.tmb.FrameworkExceptions.InvalidPathForExcelException;
import com.tmb.constants.FrameworkConstants;

public final class ExcelUtils {
	private ExcelUtils() {

	}

	public static List<Map<String, String>> getTestDetails(String sheetName) {
		List<Map<String, String>> list = null;

		try (FileInputStream fis = new FileInputStream(FrameworkConstants.getTESTSCRIPTEXCELPATH())) {

			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			Map<String, String> map = null;

			int rowCount = sheet.getLastRowNum();
			int ColCount = sheet.getRow(0).getLastCellNum();

			list = new ArrayList<>();
			for (int i = 1; i <= rowCount; i++) {
				map = new HashMap<>();
				for (int j = 0; j < ColCount; j++) {

					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key, value);
				}
				list.add(map);
			}

		} catch (FileNotFoundException e) {

			throw new InvalidPathForExcelException("Excel File you trying to read is not found");
		} catch (IOException e) {

			throw new FrameworkException("Some io exception happened  while reading excel file");
		}

		return list;

	}
}
