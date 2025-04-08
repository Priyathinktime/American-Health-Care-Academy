package com.thinktimetechno.projects.website.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.thinktimetechno.driver.DriverManager;
import com.thinktimetechno.keywords.WebUI;

public class DashboardPage {

	public void verifyDashboardPageDisplays() {
		Assert.assertTrue(WebUI.verifyPageTitleContains("Welcome - American Health Care Academy"));
	}

	public void verifyContinuousEducationPageDisplays() {
		Assert.assertTrue(WebUI.verifyPageTitleContains("Lifetime | Register - American Health Care Academy"));
	}

	public void verifyhandkitPageDisplays() {
		Assert.assertTrue(WebUI.verifyPageTitleContains("Hands On | Register - American Health Care Academy"));
	}

	public void verify_DashboardPageDisplays() {
		Assert.assertTrue(WebUI.verifyPageTitleContains("Dashboard - American Health Care Academy"));
	}

	public void verify_notDashboardPageDisplays() {

		Assert.assertNotEquals(WebUI.getPageTitle(), "Dashboard - American Health Care Academy");

	}



	public void verify_course_tab() {
		WebElement courseselection = WebUI
				.waitForElementVisible(By.xpath("(//h3[contains(text(),'Please Select The Course Below For ')])[1]"));
		String courseselectiontext = courseselection.getText();

		Assert.assertEquals(courseselectiontext, "Please Select The Course Below For Doctor / Physicians");
	}


	public void verify_coursePageDisplays() {
		Assert.assertTrue(WebUI.verifyPageTitleContains("CPR - Introduction - American Health Care Academy"));
	}

	public void select_course(String course) {
		WebUI.clickElement(By.xpath("(//a[contains(text(),'" + course + "')])[1]"));
	}

	public void i_click_accept() throws InterruptedException {
		WebUI.clickElementWithJs(By.xpath("//a[@id='lifetimeAccept']"));
//		Thread.sleep(5000);

	}

	public void click_i_accept_button() throws InterruptedException {
		WebUI.clickElementWithJs(By.xpath("//a[@id='hands_on_accept_btn']"));
//		Thread.sleep(20000);

	}

	public void verify_thankyouPageAndCloseOtherTabs() throws InterruptedException {

	    WebDriver driver = DriverManager.getDriver();
	    String thankYouUrlKeyword = "/thankyou";
	    String thankYouWindow = null;

	    int waitTimeInSeconds = 10;
	    int elapsed = 0;

	    // Wait loop for thank you tab to load
	    while (elapsed < waitTimeInSeconds) {
	        Set<String> allWindows = driver.getWindowHandles();

	        for (String window : allWindows) {
	            driver.switchTo().window(window);
	            String currentUrl = driver.getCurrentUrl();
	            System.out.println("Checking URL: " + currentUrl);
	            if (currentUrl.contains(thankYouUrlKeyword)) {
	                thankYouWindow = window;
	                break;
	            }
	        }

	        if (thankYouWindow != null) break;

	        Thread.sleep(1000);
	        elapsed++;
	    }

	    // Fail if thank you tab never found
	    Assert.assertNotNull(thankYouWindow, "Thank You tab not found! URLs checked: " +
	        driver.getWindowHandles().stream()
	            .map(w -> {
	                driver.switchTo().window(w);
	                return driver.getCurrentUrl();
	            }).toList());

	    // Close all other tabs
	    Set<String> allWindows = driver.getWindowHandles();
	    for (String window : allWindows) {
	        if (!window.equals(thankYouWindow)) {
	            driver.switchTo().window(window);
	            driver.close();
	        }
	    }

	    // Switch to thank you tab
	    driver.switchTo().window(thankYouWindow);

	    // Final assertion
	    WebElement congratsmsg = WebUI.waitForElementVisible(
	        By.xpath("//h3[normalize-space()='Congrats! You can now download your certification']"));
	    String congrats = congratsmsg.getText();
	    Assert.assertEquals(congrats, "Congrats! You can now download your certification");
	    
	     Thread.sleep(5000);
	}


}
