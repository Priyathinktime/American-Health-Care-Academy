package com.thinktimetechno.projects.website.Multipages;

import org.testng.Assert;

import com.thinktimetechno.keywords.WebUI;


public class CorporateDashboardPage {

	
	public void verifyDashboardPageDisplays() {
		Assert.assertEquals(WebUI.getPageTitle(),"Dashboard | Groupadmin - American Health Care Academy");
	}


}
