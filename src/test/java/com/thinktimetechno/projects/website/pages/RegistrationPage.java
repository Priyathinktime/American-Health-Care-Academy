package com.thinktimetechno.projects.website.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.thinktimetechno.driver.DriverManager;
import com.thinktimetechno.keywords.WebUI;

public class RegistrationPage {

	public void Registration_page_validation() {

		Assert.assertTrue(WebUI.verifyPageTitleContains("Register - American Health Care Academy"));

	}

	public void error_validation(String error) throws InterruptedException {
		WebElement firstNameField = WebUI.getWebElement(By.name("first_name"));
		firstNameField.clear();
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("arguments[0].dispatchEvent(new Event('blur'));", firstNameField);
		WebElement formElement = WebUI.getWebElement(By.tagName("form"));
		js.executeScript("arguments[0].submit();", formElement);
		WebElement errorElement = WebUI
				.waitForElementVisible(By.xpath("//div[text()='* Please enter your first name']"));
		String error_message = errorElement.getText();
		Assert.assertEquals(error_message, error);
		System.out.println("Error message captured successfully: " + error_message);
	}

	public void click_register_now() {
		WebUI.clickElement(By.id("register-button"));
	}

	public void click_terms_conditions() {
		WebUI.clickElement(By.xpath("//input[@id='opt_in_button']"));

	}

	public void enter_registration_details(String firstName, String lastname, String phonenumber, String emailaddress,
			String username, String password, String confirmpassword) {
		WebUI.setText(By.xpath("//input[@id='first_name']"), firstName);
		WebUI.setText(By.xpath("//input[@id='last_name']"), lastname);
		WebUI.setText(By.xpath("//input[@id='phone_number']"), phonenumber);
		WebUI.setText(By.xpath("//input[@id='email_address']"), emailaddress);
		WebUI.setText(By.xpath("//input[@id='username']"), username);
		WebUI.setText(By.xpath("//input[@id='password']"), password);
		WebUI.setText(By.xpath("//input[@id='confirm_password']"), confirmpassword);

	}

	public void enter_registration_detail(String firstName, String lastname, String phonenumber, String emailaddress,
			String username, String password, String confirmpassword) throws InterruptedException {
		String dateTime = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
		String emailAddress = emailaddress.replace("john.doe", "john.doe" + dateTime);

		String Username = username.replace("johndoe", "johndoe" + dateTime);

		WebUI.setText(By.xpath("//input[@id='first_name']"), firstName);

		WebUI.getJsExecutor().executeScript("document.getElementById('first_name').blur();");

		WebUI.setText(By.xpath("//input[@id='last_name']"), lastname);

		WebUI.setText(By.xpath("//input[@id='phone_number']"), phonenumber);

		WebUI.setText(By.xpath("//input[@id='email_address']"), emailAddress);

		WebUI.setText(By.xpath("//input[@id='username']"), Username);
		WebUI.setText(By.xpath("//input[@id='password']"), password);
		WebUI.setText(By.xpath("//input[@id='confirm_password']"), confirmpassword);
	}

	public void error_validation() throws InterruptedException {
		WebElement firstNameField = WebUI.getWebElement(By.name("first_name"));

		String fieldValue = firstNameField.getAttribute("value");

		if (fieldValue == null || fieldValue.trim().isEmpty()) {
			System.out.println("=== The First Name field is empty ===");
		} else {
			System.out.println("=== The First Name field contains: === " + fieldValue);
		}
	}

	public void error_validation_existing_account() {
		String PageTitle = WebUI.getPageTitle();
		Assert.assertEquals(PageTitle, "Register - American Health Care Academy");
	}

	public void enter_existing_registration_details(String firstName, String lastname, String phonenumber,
			String emailaddress, String username, String password, String confirmpassword) {

		WebUI.setText(By.xpath("//input[@id='first_name']"), firstName);
		WebUI.setText(By.xpath("//input[@id='last_name']"), lastname);
		WebUI.setText(By.xpath("//input[@id='phone_number']"), phonenumber);
		WebUI.setText(By.xpath("//input[@id='email_address']"), emailaddress);
		WebUI.setText(By.xpath("//input[@id='username']"), username);
		WebUI.setText(By.xpath("//input[@id='password']"), password);
		WebUI.setText(By.xpath("//input[@id='confirm_password']"), confirmpassword);

	}
}
