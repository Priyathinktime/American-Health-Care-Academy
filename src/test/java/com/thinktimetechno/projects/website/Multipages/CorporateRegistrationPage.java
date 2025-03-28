package com.thinktimetechno.projects.website.Multipages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.thinktimetechno.keywords.WebUI;

public class CorporateRegistrationPage {

	public void Group_Registration_page_validation() {

		WebUI.verifyPageTitleContains("Dashboard | Groupadmin - American Health Care Academy");
	}

	public void error_validation(String error) {

		String error_message = WebUI
				.waitForElementVisible(
						By.xpath("//form[@id='form_groupdiscount']/descendant::div[@id='error_message_dv2']"))
				.getText();
		Assert.assertEquals(error_message, error);
		System.out.println(error_message);
	}

	public void exiting_account_validation(String error) {

		String error_message = WebUI
				.waitForElementVisible(
						By.xpath("(//form[@id='form_groupdiscount']/descendant::div[@class='error_msg'])[2]"))
				.getText();
		Assert.assertEquals(error_message, error);
		System.out.println(error_message);
	}

	public void click_register() throws InterruptedException {

		WebUI.waitForElementVisible(By.xpath("//button[@id='select_course']")).click();
	}

	public void click_terms_conditions() {
		WebUI.clickElement(By.xpath("//input[@id='opt_in_button']"));

	}

	public void enter_registration_details(String firstName, String lastname, String companyname, String phonenumber,
			String emailaddress, String createpassword, String confirmpassword) {
		String dateTime = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
		String emailAddress = emailaddress.replace("john.doe", "john.doe" + dateTime);

		String Companyname = companyname.replace("Thinktime", "Thinktime" + dateTime);

		WebUI.setText(By.xpath("//input[@id='first_name']"), firstName);
		WebUI.setText(By.xpath("//input[@id='last_name']"), lastname);
		WebUI.setText(By.xpath("//input[@id='company']"), Companyname);
		WebUI.setText(By.xpath("//input[@id='phone_number']"), phonenumber);
		WebUI.setText(By.xpath("//input[@id='email_address']"), emailAddress);
		WebUI.setText(By.xpath("//input[@id='password-cop']"), createpassword);
		WebUI.setText(By.xpath("//input[@id='password2-cop']"), confirmpassword);

	}

	public void enter_existing_registration_detail(String firstName, String lastname, String companyname,
			String phonenumber, String emailaddress, String createpassword, String confirmpassword) {

		WebUI.setText(By.xpath("//input[@id='first_name']"), firstName);
		WebUI.setText(By.xpath("//input[@id='last_name']"), lastname);
		WebUI.setText(By.xpath("//input[@id='company']"), companyname);
		WebUI.setText(By.xpath("//input[@id='phone_number']"), phonenumber);
		WebUI.setText(By.xpath("//input[@id='email_address']"), emailaddress);
		WebUI.setText(By.xpath("//input[@id='password-cop']"), createpassword);
		WebUI.setText(By.xpath("//input[@id='password2-cop']"), confirmpassword);

	}

}
