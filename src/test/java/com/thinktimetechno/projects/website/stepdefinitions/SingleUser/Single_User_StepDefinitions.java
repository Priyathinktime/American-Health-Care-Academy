package com.thinktimetechno.projects.website.stepdefinitions.SingleUser;

import java.util.Map;

import com.thinktimetechno.hooks.TestContext;
import com.thinktimetechno.keywords.WebUI;
import com.thinktimetechno.projects.website.pages.DashboardPage;
import com.thinktimetechno.projects.website.pages.LoginPage;
import com.thinktimetechno.projects.website.pages.RegistrationPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Single_User_StepDefinitions {

	private DashboardPage dashboardPage;
	private LoginPage loginPage;
	private RegistrationPage registrationPage;
	
	public Single_User_StepDefinitions(TestContext testContext) {
		dashboardPage=testContext.getDashboardPage();
		loginPage=testContext.getLoginPage();
		registrationPage=testContext.getRegistrationPage();
	}

	@Given("User navigate to {string} for SingleUser registration")
	public void user_navigate_to_for_single_user_registration(String url){
		WebUI.getURL(url);
	}

	@Given("User is on the registration page")
	public void user_is_on_the_registration_page() {
		registrationPage.Registration_page_validation();
	}

	@When("User agrees to the Terms and Privacy Policy")
	public void user_agrees_to_the_terms_and_privacy_policy() {
		registrationPage.click_terms_conditions();
	}
	
	@When("User enters the following valid registration details with leaving one mandatory field blank")
	public void user_enters_the_following_valid_registration_details_with_leaving_one_mandatory_field_blank(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	    Map<String, String> data = dataTable.asMap(String.class, String.class);
	    String firstName = data.get("First Name");
	    String lastName = data.get("Last Name");
	    String phoneNumber = data.get("Phone Number");
	    String emailAddress = data.get("Email Address");
	    String username = data.get("Username");
	    String password = data.get("Password");
	    String confirmPassword = data.get("Confirm Password");
	    registrationPage.enter_registration_detail("",lastName,phoneNumber,emailAddress,username,password,confirmPassword);
	  
	
	}

	@When("User clicks on the Register Now button")
	public void user_clicks_on_the_register_now_button() {
		registrationPage.click_register_now();
	}

	@Then("User should redirected to the dashboard page")
	public void user_should_redirected_to_the_dashboard_page()  throws InterruptedException {
		dashboardPage.verifyDashboardPageDisplays();
	}
	
	@Then("User should see an error message above the Username input box stating {string}")
	public void user_should_see_an_error_message_above_the_username_input_box_stating(String error) throws InterruptedException {
		
		registrationPage.error_validation(error);
	}
	@Then("User should not be navigated to the dashboard page")
	public void user_should_not_be_navigated_to_the_dashboard_page() {
		registrationPage.Registration_page_validation();
	}
	@Given("User navigates to the login page {string}")
	public void user_navigates_to_the_login_page(String url) {
	WebUI.getURL(url);
	}
	@When("User clicks on the Register Here link")
	public void user_clicks_on_the_register_here_link() {
		loginPage.click_register();
	}
	@Then("User should be redirected to the registration page")
	public void user_should_be_redirected_to_the_registration_page() {
		registrationPage.Registration_page_validation();
	}

@Given("User is on the login page")
public void user_is_on_the_login_page() {
	loginPage.login_page_validation();
}
@When("User enters valid login credentials:")
public void user_enters_valid_login_credentials(io.cucumber.datatable.DataTable dataTable) {
	   Map<String, String> data = dataTable.asMap(String.class, String.class);
	    String username = data.get("Username");
	    String password = data.get("Password"); 
	    loginPage.enter_valid_login_details(username, password);
}


@When("User enters invalid login credentials:")
public void user_enters_invalid_login_credentials(io.cucumber.datatable.DataTable dataTable) {
	   Map<String, String> data = dataTable.asMap(String.class, String.class);
	    String username = data.get("Username");
	    String password = data.get("Password");
	    loginPage.enter_invalid_login_details(username, password);
}

@Then("User should see an error message {string}")
public void user_should_see_an_error_message(String error) {
	loginPage.error_message_validation(error);
}
@When("User clicks on the Login button")
public void user_clicks_on_the_login_button() {
	loginPage.click_login();
}

@When("User clicks on Click Here to Reset")
public void user_clicks_on() {
	loginPage.click_reset();
}
@When("User enter the Username\\/Email as {string}")
public void user_enter_the_username_email_as(String username) {
	loginPage.enter_username(username);
}
@When("User hit the Send Instructions")
public void user_hit_the_send_instructions() {
	loginPage.click_Send_Instructions();
}
@Then("User should see the message {string}")
public void user_should_see_the_message(String success) {
	loginPage.success_message_validation(success);
}

@Then("User should redirected to the Reset Password page")
public void user_should_redirected_to_the_reset_password_page() {
	loginPage.Resetpassword_page_validation();}
@Then("User should redirected to the dashboard")
public void user_should_redirected_to_the_dashboard() throws InterruptedException {
	dashboardPage.verify_DashboardPageDisplays();
}
@Then("User should redirected to the dashboard Page")
public void the_user_should_redirected_to_the_dashboard() throws InterruptedException {
	
dashboardPage.verifyDashboardPageDisplays();
}

@Then("User should see an error message")
public void user_should_see_an_error_message() throws InterruptedException {
	registrationPage.error_validation();
}
@When("User enters the following valid registration details:")
public void user_enters_the_following_valid_registration_details(DataTable dataTable) throws InterruptedException {

    Map<String, String> data = dataTable.asMap(String.class, String.class);

    String firstName = data.get("First Name");
    String lastName = data.get("Last Name");
    String phoneNumber = data.get("Phone Number");
    String emailAddress = data.get("Email Address");
    String username = data.get("Username");
    String password = data.get("Password");
    String confirmPassword = data.get("Confirm Password");
    registrationPage.enter_registration_detail(firstName,lastName,phoneNumber,emailAddress,username,password,confirmPassword);
  
}
@When("User enters the following valid existing registration details:")
public void user_enters_the_following_valid_existing_registration_details(io.cucumber.datatable.DataTable dataTable) {
    
	  Map<String, String> data = dataTable.asMap(String.class, String.class);

	    String firstName = data.get("First Name");
	    String lastName = data.get("Last Name");
	    String phoneNumber = data.get("Phone Number");
	    String username = data.get("Username");
	    String emailAddress = data.get("Email Address"); 
	    String password = data.get("Password");
	    String confirmPassword = data.get("Confirm Password");
       
	    registrationPage.enter_existing_registration_details(firstName,lastName,phoneNumber,emailAddress ,username,password,confirmPassword);
}
@Then("User should see an existing account error message")
public void user_should_see_existing_account_an_error_message() {
	System.out.println("This User Already Exit! Please Register with different email!");
	registrationPage.error_validation_existing_account();
	
}

}

