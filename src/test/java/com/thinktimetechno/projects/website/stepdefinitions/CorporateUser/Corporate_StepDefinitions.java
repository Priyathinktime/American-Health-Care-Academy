package com.thinktimetechno.projects.website.stepdefinitions.CorporateUser;

import java.util.Map;

import com.thinktimetechno.hooks.TestContext;
import com.thinktimetechno.keywords.WebUI;
import com.thinktimetechno.projects.website.Multipages.CorporateDashboardPage;
import com.thinktimetechno.projects.website.Multipages.CorporateLoginPage;
import com.thinktimetechno.projects.website.Multipages.CorporateRegistrationPage;
import com.thinktimetechno.projects.website.pages.DashboardPage;
import com.thinktimetechno.projects.website.pages.LoginPage;
import com.thinktimetechno.projects.website.pages.RegistrationPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Corporate_StepDefinitions {

	private CorporateDashboardPage corporatedashboardPage;
	private CorporateLoginPage corporateloginPage;
	private CorporateRegistrationPage corporateregistrationPage;

	public Corporate_StepDefinitions(TestContext testContext) {
		corporatedashboardPage = testContext.getCorporateDashboardPage();
		corporateloginPage = testContext.getCorporateLoginPage();
		corporateregistrationPage = testContext.getCorporateRegistrationPage();
	}

	@Given("GroupUser navigate to {string} for Group registration")
	public void group_user_navigate_to_for_group_registration(String url) {
		WebUI.getURL(url);
	}

	@When("GroupUser clicks on the Register button")
	public void group_user_clicks_on_the_register_button() throws InterruptedException {
		corporateregistrationPage.click_register();
	}

	@Then("GroupUser should redirected to the Corporate dashboard page")
	public void group_user_should_redirected_to_the_corporate_dashboard_page() {
		corporateregistrationPage.Group_dashboard_page_validation();
	}

	@When("User enters the existing account details:")
	public void user_enters_the_existing_account_details(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String> data = dataTable.asMap(String.class, String.class);

		String firstName = data.get("First Name");
		String lastName = data.get("Last Name");
		String companyName = data.get("Company Name");
		String phoneNumber = data.get("Phone Number");
		String emailAddress = data.get("Email Address");
		String createPassword = data.get("Create Password");
		String confirmPassword = data.get("Confirm Password");
		corporateregistrationPage.enter_existing_registration_detail(firstName, lastName, companyName, phoneNumber,
				emailAddress, createPassword, confirmPassword);

	}

	@When("User enters the Corporate registration details:")
	public void user_enters_the_corporate_registration_details(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String> data = dataTable.asMap(String.class, String.class);

		String firstName = data.get("First Name");
		String lastName = data.get("Last Name");
		String companyName = data.get("Company Name");
		String phoneNumber = data.get("Phone Number");
		String emailAddress = data.get("Email Address");
		String createPassword = data.get("Create Password");
		String confirmPassword = data.get("Confirm Password");
		corporateregistrationPage.enter_registration_details(firstName, lastName, companyName, phoneNumber,
				emailAddress, createPassword, confirmPassword);

	}

	@When("GroupUser enters the group registration details with leaving one mandatory field blank")
	public void groupuser_enters_the_corporate_registration_details(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String> data = dataTable.asMap(String.class, String.class);

		String firstName = data.get("First Name");
		String lastName = data.get("Last Name");
		String companyName = data.get("Company Name");
		String phoneNumber = data.get("Phone Number");
		String emailAddress = data.get("Email Address");
		String createPassword = data.get("Create Password");
		String confirmPassword = data.get("Confirm Password");
		corporateregistrationPage.enter_registration_details_BLANK(firstName, lastName, "", phoneNumber, emailAddress,
				createPassword, confirmPassword);

	}

	@When("GroupUser enters the Corporate registration details:")
	public void group_user_enters_the_corporate_registration_details(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String> data = dataTable.asMap(String.class, String.class);

		String firstName = data.get("First Name");
		String lastName = data.get("Last Name");
		String companyName = data.get("Company Name");
		String phoneNumber = data.get("Phone Number");
		String emailAddress = data.get("Email Address");
		String createPassword = data.get("Create Password");
		String confirmPassword = data.get("Confirm Password");
		corporateregistrationPage.enter_registration_details(firstName, lastName, companyName, phoneNumber,
				emailAddress, createPassword, confirmPassword);

	}

//
//	@When("User enters the group registration details with leaving one mandatory field blank")
//	public void user_enters_the_group_registration_details_with_leaving_one_mandatory_field_blank(io.cucumber.datatable.DataTable dataTable) {
//		  Map<String, String> data = dataTable.asMap(String.class, String.class);
//
//	    String firstName = data.get("First Name");
//	    String lastName = data.get("Last Name");
//	    String companyName = data.get("Company Name");
//	    String phoneNumber = data.get("Phone Number");
//	    String emailAddress = data.get("Email Address");
//	    String createPassword = data.get("Create Password");
//	    String confirmPassword = data.get("Confirm Password");
//	    corporateregistrationPage.enter_registration_details(firstName,lastName,"",phoneNumber,emailAddress,createPassword,confirmPassword  ); 
//	
//	}
//
//	@Then("User should see an error message above the Firstname input box stating {string}")
//	public void user_should_see_an_error_message_above_the_firstname_input_box_stating(String error) {
//		corporateregistrationPage.error_validation(error);
//	}
//	
//	@Then("User should not be navigated to the Corporate dashboard page")
//	public void user_should_not_be_navigated_to_the_corporate_dashboard_page() {
//		corporateregistrationPage.Group_Registration_page_validation();
//	}
//	
//
//	@Given("User is on the GroupUser login page")
//	public void user_is_on_the_group_user_login_page() {
//		corporateloginPage.goupuser_login_page_validation();
//	}
//
//
//	@Then("User should see an error message {string} on the GroupUser login page")
//	public void user_should_see_an_error_message_on_the_group_user_login_page(String error) {
//		corporateloginPage.error_message_validation(error);
//	}
//	@Given("User navigates to the group login page {string}")
//	public void user_navigates_to_the_group_login_page(String url) {
//WebUI.getURL(url);
//	}
//
//	@When("User taps on Click Here to Reset")
//	public void user_taps_on_click_here_to_reset() {
//		corporateloginPage.click_reset_button();
//	}
//	@Then("User should redirected to the Group Reset Password page")
//	public void user_should_redirected_to_the_group_reset_password_page() {
//		corporateloginPage.Group_Resetpassword_page_validation();
//	}
//	@Then("User should see the message as {string}")
//	public void user_should_see_the_message_as(String string) {
//		corporateloginPage.success_message_validation(string);
//	}
//
//	@Then("User should redirected to the GroupUser dashboard page")
//	public void user_should_redirected_to_the_group_user_dashboard_page() {
//		corporatedashboardPage.verifyDashboardPageDisplays();
//	}
//
//	@When("User enters valid login credentials for GroupUser login:")
//	public void user_enters_valid_login_credentials_for_group_user_login(io.cucumber.datatable.DataTable dataTable) {
//	    Map<String, String> data = dataTable.asMap(String.class, String.class);
//
//	    String email= data.get("Email");
//	    String Password = data.get("Password"); 
//	    corporateloginPage.Corporate_login_details(email, Password);
//	}
//	@When("User taps on the Login button")
//	public void user_taps_on_the_login_button() {
//		corporateloginPage.click_login();
//	}
//	
//	@When("User enter the Username\\/Email as {string}")
//	public void user_enter_the_username_email_as(String username) {
//		corporateloginPage.enter_group_username(username);
//
//	}
	@Then("GroupUser should see the missing field error message")
	public void group_user_should_see_the_missing_field_error_message() {
		corporateregistrationPage.error_validation("Please complete the required information highlighted below .");
	}

	@Then("GroupUser should not be navigated to the Corporate dashboard page")
	public void group_user_should_not_be_navigated_to_the_corporate_dashboard_page() {
		corporateregistrationPage.not_group_dashboard_page_validation();
	}

	@Then("GroupUser should redirected to the Group Reset Password page")
	public void group_user_should_redirected_to_the_group_reset_password_page() {
		corporateloginPage.Group_Resetpassword_page_validation();
	}

	@Then("GroupUser should see the message as {string}")
	public void group_user_should_see_the_message_as(String string) {
		corporateloginPage.success_message_validation(string);
	}

	@Given("User navigates to the group login page {string}")
	public void user_navigates_to_the_group_login_page(String url) {
		WebUI.getURL(url);
	}

	@Then("GroupUser should redirected to the GroupUser dashboard page")
	public void group_user_should_redirected_to_the_group_user_dashboard_page() {
		corporatedashboardPage.verifyDashboardPageDisplays();
	}

	@When("GroupUser taps on the Login button")
	public void group_user_taps_on_the_login_button() {
		corporateloginPage.click_login();
	}

	@Then("GroupUser should see an error message {string} on the GroupUser login page")
	public void group_user_should_see_an_error_message_on_the_group_user_login_page(String error) {
		corporateloginPage.error_message_validation(error);
	}

	@When("GroupUser taps on Click Here to Reset")
	public void group_user_taps_on_click_here_to_reset() {
		corporateloginPage.click_reset_button();
	}

	@Then("GroupUser hit the Send Instructions")
	public void group_user_hit_the_send_instructions() {
		corporateloginPage.send_instruction();
	}

	@When("GroupUser enter the Username\\/Email as {string}")
	public void user_enter_the_username_email_as(String username) {
		corporateloginPage.enter_groupuser_email(username);
	}

	@When("GroupUser enters login credentials:")
	public void group_user_enters_login_credentials(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String> data = dataTable.asMap(String.class, String.class);

		String email = data.get("Email");
		String Password = data.get("Password");
		corporateloginPage.Corporate_login_details(email, Password);
	}

	@Then("GroupUser should see the existing account error message")
	public void user_should_see_the_existing_account_error_message() {
		String error_message = "There is already an existing corporate account for this company. Please log in here.";
		corporateregistrationPage.exiting_account_validation(error_message);
	}

}
