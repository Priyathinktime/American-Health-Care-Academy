package com.thinktimetechno.projects.website.Multipages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.thinktimetechno.keywords.WebUI;

public class CorporateLoginPage {
	private By inputEmail = By.xpath("//input[@id='email']");
	private By inputPassword = By.xpath("//input[@id='password']");
	private By buttonLogin = By.xpath("//input[@value='Login']");

	public CorporateDashboardPage loginMulti(String email, String password) {
		WebUI.setText(inputEmail, email);
		WebUI.setText(inputPassword, password);
		WebUI.clickElement(buttonLogin);
		return new CorporateDashboardPage();
	}

	public void goupuser_login_page_validation() {
		String PageTitle = WebUI.getPageTitle();
		Assert.assertEquals(PageTitle, "Login | Groupadmin - American Health Care Academy");
	}

	public void success_message_validation(String success) {

		WebElement sucessElement = WebUI
				.waitForElementVisible(By.xpath("//form[@id='Resetform']//div[@class='redText']"));
		String success1 = sucessElement.getText();

		Assert.assertEquals(success1, success);
	}

	public void Corporate_login_details(String email, String password) {
		WebUI.setText(inputEmail, email);
		WebUI.setText(inputPassword, password);

	}

	public void enter_group_username(String username) {

		WebUI.setText(By.xpath("//input[@placeholder='Username/Email']"), username);
	}

	public void click_login() {

		WebUI.clickElement(By.xpath("//input[@id='select_course']"));

	}

	public void error_message_validation(String error) {
		WebElement errorElement = WebUI.waitForElementVisible(By.xpath(
				"//div[@id='register_box']//p[contains(text(),'Your email / password combination is invalid.')]"));
		String error1 = errorElement.getText();
		Assert.assertEquals(error1, error);
	}

	public void click_reset_button() {
		WebUI.clickElement(By.xpath("//p[@class='cop-link-register']//a[normalize-space()='Click Here to Reset']"));
	}

	public void Group_Resetpassword_page_validation() {
		WebUI.waitForPageLoaded();
		String PageTitle = WebUI.getTextElement(By.xpath("//h2[@class='title-corporate-login']"));
		Assert.assertEquals(PageTitle, "Corporate Forgot Password");
	}

}
