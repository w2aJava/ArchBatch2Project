package com.w2a.archBatch2.CustomListeners;

import java.io.IOException;
import java.util.Arrays;

import org.omg.IOP.ExceptionDetailMessage;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.w2a.archBatch2.TestUtils.TestUtils;
import com.w2a.archBatch2.setUp.TestSetUp;

public class CustomeListerners extends TestSetUp implements ITestListener, ISuiteListener {

	public void onFinish(ISuite arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ISuite arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		
		try {
			TestUtils.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String excepionMessage=Arrays.toString(arg0.getThrowable().getStackTrace());
		testCaseLogger.get().fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
				+ "</font>" + "</b >" + "</summary>" +excepionMessage.replaceAll(",", "<br>")+"</details>"+" \n");
		
		try {

			testCaseLogger.get().fail("<b>" + "<font color=" + "red>" + "ScreenShot of failure" + "</font>" + "</b>",
					MediaEntityBuilder.createScreenCaptureFromPath(TestUtils.screenshotPath + TestUtils.screenshotName)
							.build());
		} catch (IOException e) {

		}
		
		String failureLogg="This Test case got Failed";
		Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
		testCaseLogger.get().log(Status.FAIL, m);
		
		
	}

	public void onTestSkipped(ITestResult arg0) {
		String methodName=arg0.getMethod().getMethodName();
		String logText="<b>"+"Test Case:- "+ methodName+ " Skipped"+"</b>";		
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		testCaseLogger.get().skip(m);
		//extent.flush();
		
	}

	public void onTestStart(ITestResult arg0) {
		
		String methodName=arg0.getMethod().getMethodName();
		
		
		System.out.println(methodName.split(".").length);
		
		ExtentTest child = parentTest.get().createNode(methodName);
		testCaseLogger.set(child);
		//testCaseLogger.get().log(Status.INFO, "Starting execution of Test Case:- "+methodName);
		testCaseLogger.get().info("<b>"+"Starting execution of Test Case:- "+methodName+ "</b>");
	}

	public void onTestSuccess(ITestResult arg0) {
		
		String methodName=arg0.getMethod().getMethodName();
		String logText="<b>"+"Test Case:- "+ methodName+ " Passed"+"</b>";		
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		testCaseLogger.get().pass(m);
		//extent.flush();
	}
	}


