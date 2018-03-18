package com.w2a.archBatch2.TestCases;

import org.testng.annotations.Test;

import com.w2a.archBatch2.PageObjects.FacebookHomepage;
import com.w2a.archBatch2.PageObjects.FacebookLandingPage;
import com.w2a.archBatch2.setUp.TestSetUp;

public class TestCase1 extends TestSetUp {

	
	@Test
	public void tc_03()
	{
	//	System.out.println("tc_03");
		FacebookLandingPage landingPage= new FacebookLandingPage().open();
		FacebookHomepage homePage=landingPage.doLoginWithValidCredentials("ddfg", "sdfsdf");
		
	}
}
