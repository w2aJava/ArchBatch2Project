package com.w2a.archBatch2.TestUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.w2a.archBatch2.setUp.TestSetUp;


public class TestUtils extends TestSetUp {
	
	
	public static String screenshotPath;
	public static String screenshotName;

	@DataProvider(name = "dp")
	public Object[][] getData(Method method) {
		String sheetName = method.getName();
		int rowCount = excel.getRowCount(sheetName);// 2
		int columnCOunt = excel.getColumnCount(sheetName);// 2

		Object[][] data = new Object[rowCount - 1][1];
		Hashtable<String, String> table = null;
		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
			table = new Hashtable<String, String>();
			for (int cellNum = 0; cellNum < columnCOunt; cellNum++) {
				table.put(excel.getCellData(sheetName, cellNum, 1), excel.getCellData(sheetName, cellNum, rowNum));
				System.out.println("Hashtable-->" + table);
				data[rowNum - 2][0] = table;

			}
		}

		System.out.println("Data-->" + data);
		return data;
	}

	/*
	 * @DataProvider(name="dp") public Object[][] getData(Method m) {
	 * 
	 * int rows =
	 * excel.getRowCount(configProperty.getProperty("testSheetName"));
	 * System.out.println("Total rows are : " + rows);
	 * 
	 * String testName = m.getName();
	 * 
	 * // Find the test case start row
	 * 
	 * int testCaseRowNum = 1;
	 * 
	 * for (testCaseRowNum = 1; testCaseRowNum <= rows; testCaseRowNum++) {
	 * 
	 * String testCaseName =
	 * excel.getCellData(configProperty.getProperty("testSheetName"), 0,
	 * testCaseRowNum);
	 * 
	 * if (testCaseName.equalsIgnoreCase(testName)) break;
	 * 
	 * }
	 * 
	 * System.out.println("Test case starts from row num: " + testCaseRowNum);
	 * 
	 * // Checking total rows in test case
	 * 
	 * int dataStartRowNum = testCaseRowNum + 2;
	 * 
	 * int testRows = 0; while
	 * (!excel.getCellData(configProperty.getProperty("testSheetName"), 0,
	 * dataStartRowNum + testRows).equals("")) {
	 * 
	 * testRows++; }
	 * 
	 * System.out.println("Total rows of data are : " + testRows);
	 * 
	 * // Checking total cols in test case
	 * 
	 * int colStartColNum = testCaseRowNum + 1; int testCols = 0;
	 * 
	 * while (!excel.getCellData(configProperty.getProperty("testSheetName"),
	 * testCols, colStartColNum).equals("")) {
	 * 
	 * testCols++;
	 * 
	 * }
	 * 
	 * System.out.println("Total cols are : " + testCols);
	 * 
	 * // Printing data
	 * 
	 * Object[][] data = new Object[testRows][1];
	 * 
	 * int i = 0; for (int rNum = dataStartRowNum; rNum < (dataStartRowNum +
	 * testRows); rNum++) {
	 * 
	 * Hashtable<String, String> table = new Hashtable<String, String>();
	 * 
	 * for (int cNum = 0; cNum < testCols; cNum++) {
	 * 
	 * // System.out.println(excel.getCellData(Constants.DATA_SHEET, // cNum,
	 * rNum)); String colName =
	 * excel.getCellData(configProperty.getProperty("testSheetName"), cNum,
	 * colStartColNum); String testData =
	 * excel.getCellData(configProperty.getProperty("testSheetName"), cNum,
	 * rNum);
	 * 
	 * 
	 * table.put(colName, testData);
	 * 
	 * }
	 * 
	 * data[i][0] = table; i++;
	 * 
	 * }
	 * 
	 * return data; }
	 */

	public static void captureScreenshot() throws IOException {

		screenshotPath = "./Screenshots/";
		File scrFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".png";

		FileUtils.copyFile(scrFile, new File(screenshotPath + screenshotName));

	}

}
