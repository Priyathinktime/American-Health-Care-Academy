package com.thinktimetechno.projects.website.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
//		Thread.sleep(10000);
	}

}
