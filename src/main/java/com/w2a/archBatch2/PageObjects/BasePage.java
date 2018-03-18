package com.w2a.archBatch2.PageObjects;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.w2a.archBatch2.TestUtils.DriverManager;
import com.w2a.archBatch2.setUp.TestSetUp;




public abstract class BasePage<T> extends TestSetUp{
	//WebDriver driver;

	public int driverTimeOut = 20;

	public T openPage(Class<T> clazz) {
		T page = null;
		//page = PageFactory.initElements(driver, clazz);
		AjaxElementLocatorFactory ajaxLocatorFactory=new AjaxElementLocatorFactory(DriverManager.getDriver(), 20);
		page=PageFactory.initElements(DriverManager.getDriver(), clazz);
		PageFactory.initElements(ajaxLocatorFactory, page);

		ExpectedCondition pageLoadCondition = ((BasePage) page).getPageLoadCondition();
		waitForPageLoad(pageLoadCondition);
		return page;
	}

	public abstract ExpectedCondition getPageLoadCondition();

	public void waitForPageLoad(ExpectedCondition pageLoadCondition) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), driverTimeOut);
		wait.until(pageLoadCondition);
	}
}
