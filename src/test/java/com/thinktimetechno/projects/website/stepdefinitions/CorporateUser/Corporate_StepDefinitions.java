package com.thinktimetechno.projects.website.stepdefinitions.CorporateUser;

import java.util.Map;
import com.thinktimetechno.hooks.TestContext;
import com.thinktimetechno.keywords.WebUI;
import com.thinktimetechno.projects.website.Multipages.CorporateDashboardPage;
import com.thinktimetechno.projects.website.Multipages.CorporateLoginPage;
import com.thinktimetechno.projects.website.Multipages.CorporateRegistrationPage;
import com.thinktimetechno.projects.website.Multipages.CorporateResetPasswordPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Corporate_StepDefinitions {

	private CorporateDashboardPage corporatedashboardPage;
	private CorporateLoginPage corporateloginPage;
	private CorporateRegistrationPage corporateregistrationPage;
	private CorporateResetPasswordPage corporateresetpasswordPage;

	public Corporate_StepDefinitions(TestContext testContext) {
		corporatedashboardPage = testContext.getCorporateDashboardPage();
		corporateloginPage = testContext.getCorporateLoginPage();
		corporateregistrationPage = testContext.getCorporateRegistrationPage();
		corporateresetpasswordPage = testContext.getCorporateResetPasswordPage();
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
		corporatedashboardPage.verifyDashboardPageDisplays();
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
		corporateresetpasswordPage.Group_Resetpassword_page_validation();
	}

	@Then("GroupUser should see the message as {string}")
	public void group_user_should_see_the_message_as(String string) {
		corporateresetpasswordPage.success_message_validation(string);
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
