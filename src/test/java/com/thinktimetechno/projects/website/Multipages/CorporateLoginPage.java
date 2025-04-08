package com.thinktimetechno.projects.website.Multipages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.thinktimetechno.keywords.WebUI;

public class CorporateLoginPage {

	public void goupuser_login_page_validation() {
		String PageTitle = WebUI.getPageTitle();
		Assert.assertEquals(PageTitle, "Login | Groupadmin - American Health Care Academy");
	}

	public void Corporate_login_details(String email, String password) {
		WebUI.setText(By.xpath("//input[@id='email']"), email);
		WebUI.setText(By.xpath("//input[@id='password']"), password);

	}

	public void enter_group_username(String username) {

		WebUI.setText(By.xpath("//input[@placeholder='Username/Email']"), username);
	}

	public void click_login() {

		WebUI.clickElement(By.xpath("//input[@id='select_course']"));

	}

	public void send_instruction() {

		WebUI.clickElement(By.xpath("(//input[@id='select_course'])[1]"));

	}

	public void error_message_validation(String error) {

		String error1 = WebUI.getTextElement(By.xpath(
				"//div[@id='register_box']//p[contains(text(),'Your email / password combination is invalid.')]"));

		Assert.assertEquals(error1, error);
	}

	public void click_reset_button() {
		WebUI.clickElement(By.xpath("//p[@class='cop-link-register']//a[normalize-space()='Click Here to Reset']"));
	}

	public void enter_groupuser_email(String username) {

		WebUI.setText(By.xpath("(//input[@id='email'])[2]"), username);
	}

}
