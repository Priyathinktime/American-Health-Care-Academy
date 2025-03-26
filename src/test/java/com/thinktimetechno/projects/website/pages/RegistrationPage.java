package com.thinktimetechno.projects.website.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.thinktimetechno.driver.DriverManager;
import com.thinktimetechno.keywords.WebUI;



public class RegistrationPage {

	public void Registration_page_validation(){
		String PageTitle= WebUI.getPageTitle();
		Assert.assertEquals(PageTitle, "Register - American Health Care Academy");
	}
	public void error_validation(String error) throws InterruptedException {
	    // Locate the first name field that needs validation
	    WebElement firstNameField = WebUI.getWebElement(By.name("first_name"));

	    // Clear the field to leave it blank
	    firstNameField.clear();

	    // Initialize JavaScript Executor
	    JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();

	    // Trigger blur event to simulate moving focus away from the field
	    js.executeScript("arguments[0].dispatchEvent(new Event('blur'));", firstNameField);

	    // Optionally, manually submit the form to trigger validation
	    WebElement formElement = WebUI.getWebElement(By.tagName("form"));
	    js.executeScript("arguments[0].submit();", formElement);

	    // Add a delay to give time for the error to appear
//	    Thread.sleep(2000);

	    // Wait until the error message is visible
	    WebElement errorElement = WebUI.waitForElementVisible(By.xpath("//div[text()='* Please enter your first name']"));

	    // Capture the error message text
	    String error_message = errorElement.getText();
	    
	    // Validate the error message with expected value
	    Assert.assertEquals(error_message, error);

	    // Print the captured error message for debugging
	    System.out.println("Error message captured successfully: " + error_message);
	}
	
	

	public void click_register_now() {
		WebUI.clickElement(By.id("register-button"));}
	
	
		public void click_terms_conditions() {
			WebUI.clickElement(By.xpath("//input[@id='opt_in_button']"));
		
		}
		
		public void enter_registration_details(String firstName,String lastname, String phonenumber, String emailaddress, String username, String password, String confirmpassword  ) {
			WebUI.setText(By.xpath("//input[@id='first_name']"),firstName );
			WebUI.setText(By.xpath("//input[@id='last_name']"), lastname);
			WebUI.setText(By.xpath("//input[@id='phone_number']"),phonenumber);
			WebUI.setText(By.xpath("//input[@id='email_address']"),emailaddress );
			WebUI.setText(By.xpath("//input[@id='username']"), username);
			WebUI.setText(By.xpath("//input[@id='password']"), password);
			WebUI.setText(By.xpath("//input[@id='confirm_password']"), confirmpassword);
			
		}
		public void enter_registration_detail(String firstName,String lastname, String phonenumber, String emailaddress,String username, String password, String confirmpassword  ) {
			String dateTime = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
			String emailAddress = emailaddress.replace("john.doe", "john.doe" + dateTime);
		    
			String Username = username.replace("johndoe", "johndoe"+dateTime);
			
			WebUI.setText(By.xpath("//input[@id='first_name']"),firstName);
			
			WebUI.setText(By.xpath("//input[@id='last_name']"), lastname);
			WebUI.setText(By.xpath("//input[@id='phone_number']"),phonenumber);
            
		    WebUI.setText(By.xpath("//input[@id='email_address']"), emailAddress);

			WebUI.setText(By.xpath("//input[@id='username']"), Username);
			WebUI.setText(By.xpath("//input[@id='password']"), password);
			WebUI.setText(By.xpath("//input[@id='confirm_password']"), confirmpassword);
		}
		public void error_validation() throws InterruptedException {
		    WebElement firstNameField = WebUI.getWebElement(By.name("first_name"));

		    // Get the value of the First Name field
		    String fieldValue = firstNameField.getAttribute("value");

		    if (fieldValue == null || fieldValue.trim().isEmpty()) {
		        System.out.println("=== The First Name field is empty ===");
		    } else {
		        System.out.println("=== The First Name field contains: === " + fieldValue);
		    }
		}
		
		public void error_validation_existing_account() {
			String PageTitle= WebUI.getPageTitle();
			Assert.assertEquals(PageTitle, "Register - American Health Care Academy");
		}
	public void enter_existing_registration_details(String firstName,String lastname, String phonenumber, String emailaddress, String username, String password, String confirmpassword  ) {
			
			WebUI.setText(By.xpath("//input[@id='first_name']"),firstName );
			WebUI.setText(By.xpath("//input[@id='last_name']"), lastname);
			WebUI.setText(By.xpath("//input[@id='phone_number']"),phonenumber);
			WebUI.setText(By.xpath("//input[@id='email_address']"),emailaddress );
			WebUI.setText(By.xpath("//input[@id='username']"), username);
			WebUI.setText(By.xpath("//input[@id='password']"), password);
			WebUI.setText(By.xpath("//input[@id='confirm_password']"), confirmpassword);
			
		}
}
