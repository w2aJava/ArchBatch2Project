package com.w2a.archBatch2.TestCases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.archBatch2.PageObjects.ZohoHomePage;
import com.w2a.archBatch2.PageObjects.ZohoLandingPage;
import com.w2a.archBatch2.PageObjects.ZohoSignInPage;
import com.w2a.archBatch2.PageObjects.ZohoSignUpPage;
import com.w2a.archBatch2.TestUtils.TestUtils;
import com.w2a.archBatch2.setUp.TestSetUp;

public class ValidateZohoSignupFuntion extends TestSetUp{

	@Test(dataProviderClass = TestUtils.class, dataProvider = "dp")
	public void validateSignupWithValidCred(Hashtable<String, String> data) {
		assignAuthor("Rahul Jha");
		assignCategory("Sanity");
		ZohoLandingPage zohoLandingPage = new ZohoLandingPage().open();
		ZohoSignUpPage zohoSignUpPage = zohoLandingPage.clickOnSignUpButton();

		ZohoHomePage zohoHomePage = zohoSignUpPage.doSingnupWithValidCred(data.get("userEmail"), data.get("password"));
		Assert.assertTrue(zohoHomePage.crm.isDisplayed());
	}
}
