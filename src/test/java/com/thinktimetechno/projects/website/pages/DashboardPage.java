package com.thinktimetechno.projects.website.pages;

import org.testng.Assert;

import com.thinktimetechno.keywords.WebUI;



public class DashboardPage {

	
	public void verifyDashboardPageDisplays() throws InterruptedException {
		WebUI.waitForPageLoaded();
		Assert.assertEquals(WebUI.getPageTitle(),"Welcome - American Health Care Academy");
	}
	public void verify_DashboardPageDisplays() throws InterruptedException {
		WebUI.waitForPageLoaded();
		Assert.assertEquals(WebUI.getPageTitle(),"Dashboard - American Health Care Academy");
	}


}
