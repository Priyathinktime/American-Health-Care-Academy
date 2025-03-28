package com.thinktimetechno.projects.website.pages;

import org.testng.Assert;

import com.thinktimetechno.keywords.WebUI;

public class DashboardPage {

	public void verifyDashboardPageDisplays() throws InterruptedException {

		Assert.assertTrue(WebUI.verifyPageTitleContains("Welcome - American Health Care Academy"));
	}

	public void verify_DashboardPageDisplays() throws InterruptedException {

		Assert.assertTrue(WebUI.verifyPageTitleContains("Dashboard - American Health Care Academy"));
	}

}
