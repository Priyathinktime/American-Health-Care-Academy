package com.thinktimetechno.projects.website.pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.thinktimetechno.keywords.WebUI;

public class CourseSelectionPage {

	public void verify_coursePageDisplays() {
		Assert.assertTrue(WebUI.verifyPageTitleContains("CPR - Introduction - American Health Care Academy"));
	}

	public void select_course(String course) {
		WebUI.clickElement(By.xpath("(//a[contains(text(),'" + course + "')])[1]"));
	}
}
