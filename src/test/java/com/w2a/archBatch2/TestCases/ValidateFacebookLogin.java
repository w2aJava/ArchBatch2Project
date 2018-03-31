package com.w2a.archBatch2.TestCases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.w2a.archBatch2.PageObjects.FacebookHomepage;
import com.w2a.archBatch2.PageObjects.FacebookLandingPage;
import com.w2a.archBatch2.TestUtils.TestUtils;
import com.w2a.archBatch2.setUp.TestSetUp;

public class ValidateFacebookLogin extends TestSetUp {
	
	@Test(dataProviderClass=TestUtils.class,dataProvider="dp")
	public void validateFBLoginWIthValidCred(Hashtable<String, String> data)
	{
		
		assignAuthor("Rahul");
		assignCategory("Sanity");
	//	assignCategory("Regression");
		//System.out.println("validateFBLoginWIthValidCredentials");
		FacebookLandingPage landingPage= new FacebookLandingPage().open();
		//System.out.println(data);
		FacebookHomepage homePage=landingPage.doLoginWithValidCredentials(data.get("username"), data.get("password"));
		
	}
	
	/*@Test(dataProviderClass=TestUtils.class,dataProvider="dp")
	public void tc_02(Hashtable<String, String> data)
	{
		//System.out.println("tc_02");
		FacebookLandingPage landingPage= new FacebookLandingPage().open();
		FacebookHomepage homePage=landingPage.doLoginWithValidCredentials(data.get("username"), data.get("password"));
		
	}
*/
}
