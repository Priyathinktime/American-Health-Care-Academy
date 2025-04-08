package com.thinktimetechno.projects.website.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.thinktimetechno.keywords.WebUI;

public class PaymentPage {

	public void verify_paymentPageDisplays() {

		WebElement payment = WebUI.waitForElementVisible(By.xpath("(//h3[contains(text(),'Payment Information')])[1]"));
		String paymenttext = payment.getText();

		Assert.assertEquals(paymenttext, "Payment Information");
	}

	public void select_download_card() {
		WebUI.clickElementWithJs(By.xpath("//div[contains(text(),'Continue To Download Card')]"));
	}

	public void payment_details(String fullname, String cardnumber, String expirationmonth, String expirationyear,
			String cvv) {

		WebUI.setText(By.xpath("//input[@id='nameoncard']"), fullname);
		WebUI.setText(By.xpath("//input[@id='creditcardnumber']"), cardnumber);
		WebUI.setText(By.xpath("//input[@id='expirationmonth']"), expirationmonth);
		WebUI.setText(By.xpath("//input[@id='expirationyear']"), expirationyear);
		WebUI.setText(By.xpath("//input[@id='cvvcode']"), cvv);

	}

	public void click_next_button() throws InterruptedException {
		WebUI.clickElementWithJs(By.xpath("(//button[contains(text(),'NEXT')])[1]"));
//		Thread.sleep(10000);
	}

}
