package com.w2a.archBatch2.TestCases;

import org.testng.annotations.Test;

import com.w2a.archBatch2.PageObjects.FacebookHomepage;
import com.w2a.archBatch2.PageObjects.FacebookLandingPage;
import com.w2a.archBatch2.setUp.TestSetUp;

public class ValidateFacebookLogin extends TestSetUp {
	
	@Test
	public void validateFBLoginWIthValidCredentials()
	{
		//System.out.println("validateFBLoginWIthValidCredentials");
		FacebookLandingPage landingPage= new FacebookLandingPage().open();
		FacebookHomepage homePage=landingPage.doLoginWithValidCredentials("ddfg", "sdfsdf");
		
	}
	
	@Test
	public void tc_02()
	{
		//System.out.println("tc_02");
		FacebookLandingPage landingPage= new FacebookLandingPage().open();
		FacebookHomepage homePage=landingPage.doLoginWithValidCredentials("ddfg", "sdfsdf");
		
	}

}
