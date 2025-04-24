package com.thinktimetechno.projects.website.pages;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.thinktimetechno.keywords.WebUI;

public class BillingPage {

	public void verify_billingPageDisplays() {
		WebElement billing = WebUI.waitForElementVisible(By.xpath("//span[contains(text(),'Billing Information')]"));
		String billingtext = billing.getText();

		Assert.assertEquals(billingtext, "Billing Information");
	}

	public void verify_cartPageDisplays() {
		WebElement cart = WebUI.waitForElementVisible(By.xpath("(//div[contains(text(),'Your Cart Details')])[1]"));
		String carttext = cart.getText();

		Assert.assertEquals(carttext, "Your Cart Details");
	}

	public void billing_details(String firstname, String lastname, String address, String city, String state,
			String zipcode, String country) {
		WebUI.getWebElement(By.xpath("//input[@id='firstname']")).clear();
		WebUI.setText(By.xpath("//input[@id='firstname']"), firstname);
		WebUI.getWebElement(By.xpath("//input[@id='lastname']")).clear();
		WebUI.setText(By.xpath("//input[@id='lastname']"), lastname);
		WebUI.setText(By.xpath("//input[@id='address']"), address);
		WebUI.setText(By.xpath("//input[@id='city']"), city);
		WebUI.setText(By.xpath("//select[@id='state']"), state);
		WebUI.setText(By.xpath("//input[@id='zipcode']"), zipcode);
		WebUI.setText(By.xpath("//select[@id='country']"), country);

		

	}

	public void click_sameasbilling_button() {
		WebUI.clickElementWithJs(By.xpath("//input[@id='sameasbilling']"));

	}

	public void click_submitbilling_button() throws InterruptedException {
		WebUI.clickElementWithJs(By.xpath("//input[@id='payment_submit_button']"));

	}
	public void verify_handsonkit_PageDisplays() {
		WebElement billing = WebUI.waitForElementVisible(By.xpath("//h2[contains(text(),'Do you need a Blended Hands-on Training?')]"));
		String billingtext = billing.getText();

		Assert.assertEquals(billingtext, "Do you need a Blended Hands-on Training?");
	}
	
	public void selecttime() {

    WebUI.selectOptionByIndex(By.xpath("//select[@id='champ_selected_time']"), 1);

	}
	public void click_PurchaseHandsonTraining_button(){
		WebUI.clickElementWithJs(By.xpath("(//input[@id='purchase_champ_btn'])[1]"));

	}
	
	public void user_selects_date(String dateStr) {
	    // Parse the input string using the expected format: "30 April 2025"
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ENGLISH);
	    LocalDate targetDate = LocalDate.parse(dateStr, formatter);

	    // Skip weekends
	    DayOfWeek dayOfWeek = targetDate.getDayOfWeek();
	    if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
	        System.out.println("Weekend selected, skipping: " + targetDate);
	        return;
	    }

	    // Get target date details
	    String targetMonth = targetDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
	    int targetYear = targetDate.getYear();
	    String targetDay = String.valueOf(targetDate.getDayOfMonth());

	    // Navigate to the correct month and year in the calendar
	    while (true) {
	        String displayedMonth = WebUI.getWebElement(By.className("ui-datepicker-month")).getText();
	        int displayedYear = Integer.parseInt(WebUI.getWebElement(By.className("ui-datepicker-year")).getText());

	        if (displayedMonth.equalsIgnoreCase(targetMonth) && displayedYear == targetYear) {
	            break;
	        } else {
	            WebUI.getWebElement(By.xpath("//a[@title='Next']")).click();
	        }
	    }

	    // Click the correct active day
	    String dayXpath = "//td[not(contains(@class, 'ui-datepicker-unselectable')) and not(contains(@class, 'ui-datepicker-week-end'))]/a[text()='" + targetDay + "']";
	    WebElement activeDate = WebUI.getWebElement(By.xpath(dayXpath));
	    activeDate.click();
	}

	public void selectcardtype(String card) {

		}

}
