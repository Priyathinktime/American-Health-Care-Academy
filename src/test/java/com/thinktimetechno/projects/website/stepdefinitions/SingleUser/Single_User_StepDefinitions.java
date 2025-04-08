package com.thinktimetechno.projects.website.stepdefinitions.SingleUser;

import java.util.Map;

import com.thinktimetechno.hooks.TestContext;
import com.thinktimetechno.keywords.WebUI;
import com.thinktimetechno.projects.website.pages.BillingPage;
import com.thinktimetechno.projects.website.pages.CourseSelectionPage;
import com.thinktimetechno.projects.website.pages.DashboardPage;
import com.thinktimetechno.projects.website.pages.FieldOfStudyPage;
import com.thinktimetechno.projects.website.pages.LoginPage;
import com.thinktimetechno.projects.website.pages.PaymentPage;
import com.thinktimetechno.projects.website.pages.QuizPage;
import com.thinktimetechno.projects.website.pages.RegistrationPage;
import com.thinktimetechno.projects.website.pages.ResetPasswordPage;
import com.thinktimetechno.projects.website.pages.TypeOfProfessionPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Single_User_StepDefinitions {

	private DashboardPage dashboardPage;
	private LoginPage loginPage;
	private RegistrationPage registrationPage;
	private ResetPasswordPage resetpasswordPage;
	private FieldOfStudyPage fieldOfStudyPage;
	private TypeOfProfessionPage typeOfProfessionPage;
	private CourseSelectionPage courseSelectionPage;
	private QuizPage quizpage;
	private PaymentPage paymentPage;
	private BillingPage billingPage;

	public Single_User_StepDefinitions(TestContext testContext) {
		dashboardPage = testContext.getDashboardPage();
		loginPage = testContext.getLoginPage();
		registrationPage = testContext.getRegistrationPage();
		resetpasswordPage = testContext.getResetPasswordPage();
		fieldOfStudyPage = testContext.getFieldOfStudyPage();
		typeOfProfessionPage = testContext.getTypeOfProfessionPage();
		courseSelectionPage = testContext.getCourseSelectionPage();
		quizpage = testContext.getQuizPage();
		paymentPage = testContext.getPaymentPage();
		billingPage = testContext.getBillingPage();
	}

	@Given("User navigate to {string} for SingleUser registration")
	public void user_navigate_to_for_single_user_registration(String url) {
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
	public void user_enters_the_following_valid_registration_details_with_leaving_one_mandatory_field_blank(
			io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		Map<String, String> data = dataTable.asMap(String.class, String.class);
		String firstName = data.get("First Name");
		String lastName = data.get("Last Name");
		String phoneNumber = data.get("Phone Number");
		String emailAddress = data.get("Email Address");
		String username = data.get("Username");
		String password = data.get("Password");
		String confirmPassword = data.get("Confirm Password");
		registrationPage.enter_registration_detail("", lastName, phoneNumber, emailAddress, username, password,
				confirmPassword);

	}

	@When("User clicks on the Register Now button")
	public void user_clicks_on_the_register_now_button() {
		registrationPage.click_register_now();
	}

	@Then("User should redirected to the dashboard page")
	public void user_should_redirected_to_the_dashboard_page() throws InterruptedException {
		dashboardPage.verifyDashboardPageDisplays();
	}

	@Then("User should see an error message above the Username input box stating {string}")
	public void user_should_see_an_error_message_above_the_username_input_box_stating(String error)
			throws InterruptedException {

		registrationPage.error_validation(error);
	}

	@Then("User should not be navigated to the dashboard page")
	public void user_should_not_be_navigated_to_the_dashboard_page() {
		dashboardPage.verify_notDashboardPageDisplays();

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
		resetpasswordPage.enter_username(username);
	}

	@When("User hit the Send Instructions")
	public void user_hit_the_send_instructions() {
		resetpasswordPage.click_Send_Instructions();
	}

	@Then("User should see the message {string}")
	public void user_should_see_the_message(String success) {
		resetpasswordPage.success_message_validation(success);
	}

	@Then("User should redirected to the Reset Password page")
	public void user_should_redirected_to_the_reset_password_page() {
		resetpasswordPage.Resetpassword_page_validation();
	}

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
		registrationPage.enter_registration_detail(firstName, lastName, phoneNumber, emailAddress, username, password,
				confirmPassword);

	}

	@When("User enters the following valid existing registration details:")
	public void user_enters_the_following_valid_existing_registration_details(
			io.cucumber.datatable.DataTable dataTable) {

		Map<String, String> data = dataTable.asMap(String.class, String.class);

		String firstName = data.get("First Name");
		String lastName = data.get("Last Name");
		String phoneNumber = data.get("Phone Number");
		String username = data.get("Username");
		String emailAddress = data.get("Email Address");
		String password = data.get("Password");
		String confirmPassword = data.get("Confirm Password");

		registrationPage.enter_existing_registration_details(firstName, lastName, phoneNumber, emailAddress, username,
				password, confirmPassword);
	}

	@Then("User should see an existing account error message")
	public void user_should_see_existing_account_an_error_message() {

		registrationPage.error_validation_existing_account();
	}

	@Then("User is on the Are you a Healthcare Provider? page")
	public void user_is_on_the_page() throws InterruptedException {
		fieldOfStudyPage.verify_fieldofstudytab();
	}

	@When("User selects {string}")
	public void user_selects(String page) {
		fieldOfStudyPage.select_healthcare_provider(page);
	}

	@Then("User should be navigated to the Please choose your profession page")
	public void user_should_be_navigated_to_the_profession_page() throws InterruptedException {
		typeOfProfessionPage.verify_typeofprofessiontab();
	}

	@Then("User should be navigated to the Course Selection page")
	public void user_should_be_navigated_to_the_course_page() throws InterruptedException {
		dashboardPage.verify_course_tab();
	}

	@When("User selects the profession as {string}")
	public void user_selects_the_profession_as(String profession) {
		typeOfProfessionPage.select_profession(profession);
	}

	@When("User selects the course as {string}")
	public void user_selects_the_course_as(String course) {
		courseSelectionPage.select_course(course);
	}

	@Then("User lands on the Course Page")
	public void user_lands_on_the() throws InterruptedException {
		courseSelectionPage.verify_coursePageDisplays();
	}

	@Then("User lands on the Quiz Page")
	public void user_lands_on_the_() throws InterruptedException {
		quizpage.verify_quizPageDisplays();
	}

	@When("User taps on the Take Quiz button")
	public void user_taps_on_the_button() {
		quizpage.click_quiz_button();
	}

	@When("User attends all the {int} questions")
	public void user_attends_all_the_questions(Integer int1) throws InterruptedException {
		quizpage.question_and_answer();
	}

	@When("User taps on the Submit Quiz button")
	public void user_taps_on() throws InterruptedException {
		quizpage.submitQuiz();

	}

	@Then("User lands on the Quiz Success Page")
	public void user_quiz_lands_on_the_() throws InterruptedException {
		quizpage.verify_successquizPageDisplays();
	}

	@When("User taps on Continue to Download Card")
	public void user_taps_on_download_card() throws InterruptedException {
		paymentPage.select_download_card();

	}

	@Then("User lands on the Payment Page")
	public void user_land_on_payement_page() throws InterruptedException {
		paymentPage.verify_paymentPageDisplays();
	}

	@When("User enters the following payment card details:")
	public void user_enters_the_following_payment_card_details(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String> data = dataTable.asMap(String.class, String.class);

		String fullName = data.get("Full Name");
		String cardnumber = data.get("Card Number");
		String expirationmonth = data.get("Expiration Month");
		String expirationyear = data.get("Expiration Year");
		String cvv = data.get("CVV");
		paymentPage.payment_details(fullName, cardnumber, expirationmonth, expirationyear, cvv);

	}

	@When("User taps on Next button")
	public void user_taps_on_next_button() throws InterruptedException {
		paymentPage.click_next_button();
	}

	@Then("User lands on the Billing and Shipping Address Page")
	public void user_lands_on_the_billing_and_shipping_address_page() {
		billingPage.verify_billingPageDisplays();
	}

	@When("User enters the following shipping and billing details:")
	public void user_enters_the_following_shipping_and_billing_details(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String> data = dataTable.asMap(String.class, String.class);

		String FirstName = data.get("First Name");
		String LastName = data.get("Last Name");
		String Address = data.get("Address Line 1");
		String city = data.get("City");
		String state = data.get("State");
		String zipcode = data.get("Zip Code");
		String country = data.get("Country");
		billingPage.billing_details(FirstName, LastName, Address, city, state, zipcode, country);

	}

	@When("User taps on the Same as Billing Address radio button")
	public void user_taps_on_the_same_as_billing_address_radio_button() {
		billingPage.click_sameasbilling_button();
	}

	@When("User taps on the Submit Payment button")
	public void user_taps_on_submit_payment_button() throws InterruptedException {
		billingPage.click_submitbilling_button();
	}

	@When("User taps on I Accept")
	public void user_taps_on_the_I_accept() throws InterruptedException {
		dashboardPage.i_click_accept();

	}

	@When("User taps on the I Accept button")
	public void user_taps_on_the_I_accept_button() throws InterruptedException {
		dashboardPage.click_i_accept_button();
	}

	@Then("User lands on the Continuous Education Credits and Course Renewal Page")
	public void user_lands_on_the_continuous_education_credits_and_course_renewal_page() {
		dashboardPage.verifyContinuousEducationPageDisplays();
	}

	@Then("User lands on the Hands-on Kit Page")
	public void user_lands_on_the_continuous_education_credits_and_course_renewal() {
		dashboardPage.verifyhandkitPageDisplays();
	}

	@Then("User lands on the Congratulations Page")
	public void user_land_on_congratulation_page() throws InterruptedException {
		dashboardPage.verify_thankyouPageAndCloseOtherTabs();
//		dashboardPage.verify_thankyouDisplays1();
	}

}
