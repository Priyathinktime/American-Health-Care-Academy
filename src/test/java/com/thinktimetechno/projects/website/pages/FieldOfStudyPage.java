package com.thinktimetechno.projects.website.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.thinktimetechno.keywords.WebUI;

public class FieldOfStudyPage {

	public void verify_fieldofstudytab() {
		WebElement fieldofstudy = WebUI.waitForElementVisible(By.xpath("(//h3[contains(text(),'Are you a Healthcare Provider? ')])[1]"));
		String fieldofstudytext = fieldofstudy.getText();
System.out.println(fieldofstudytext);
		Assert.assertEquals(fieldofstudytext, "Are You A Healthcare Provider?");
	}
	public void select_healthcare_provider(String page) {
		WebUI.clickElementWithJs(By.xpath("//div/a[contains(text(),'" + page + "')]"));
	}
}
