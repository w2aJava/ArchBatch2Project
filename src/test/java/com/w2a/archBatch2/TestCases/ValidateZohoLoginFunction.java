package com.w2a.archBatch2.TestCases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.archBatch2.PageObjects.ZohoHomePage;
import com.w2a.archBatch2.PageObjects.ZohoLandingPage;
import com.w2a.archBatch2.PageObjects.ZohoSignInPage;
import com.w2a.archBatch2.TestUtils.TestUtils;
import com.w2a.archBatch2.setUp.TestSetUp;

public class ValidateZohoLoginFunction extends TestSetUp{

	@Test(dataProviderClass = TestUtils.class, dataProvider = "dp")
	public void validateLoginWithValidCred(Hashtable<String, String> data) {
		assignAuthor("Rahul Jha");
		assignCategory("Sanity");
		assignCategory("Regression");
		ZohoLandingPage zohoLandingPage = new ZohoLandingPage().open();
		ZohoSignInPage zohoSignInPage = zohoLandingPage.clickOnLoginButton();

		ZohoHomePage zohoHomePage = zohoSignInPage.validateLoginWithValidCred(data.get("userEmail"), data.get("password"));
		Assert.assertTrue(zohoHomePage.crm.isDisplayed());
	}

	@Test(dataProviderClass = TestUtils.class, dataProvider = "dp")
	public void validateLoginWithInValidPwd(Hashtable<String, String> data) {
		assignAuthor("Rahul Jha");
		assignCategory("Regression");
		ZohoLandingPage zohoLandingPage = new ZohoLandingPage().open();
		ZohoSignInPage zohoSignInPage = zohoLandingPage.clickOnLoginButton();

		zohoSignInPage = zohoSignInPage.validateLoginWithInValidCred(data.get("userEmail"), data.get("password"));
		Assert.assertTrue(zohoSignInPage.invalidPasswordErrorMsg.isDisplayed());
	}

}
