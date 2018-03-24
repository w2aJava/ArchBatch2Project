package com.w2a.archBatch2.TestCases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.w2a.archBatch2.PageObjects.FacebookHomepage;
import com.w2a.archBatch2.PageObjects.FacebookLandingPage;
import com.w2a.archBatch2.TestUtils.TestUtils;
import com.w2a.archBatch2.setUp.TestSetUp;

public class TestCase1 extends TestSetUp {

	
	@Test(dataProviderClass=TestUtils.class,dataProvider="dp")
	public void tc_03(Hashtable<String, String> data)
	{
	//	System.out.println("tc_03");
		FacebookLandingPage landingPage= new FacebookLandingPage().open();
		FacebookHomepage homePage=landingPage.doLoginWithValidCredentials(data.get("username"), data.get("password"));
		
	}
}
