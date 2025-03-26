package com.thinktimetechno.projects.website.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.thinktimetechno.keywords.WebUI;

public class LoginPage {
	 private By inputEmail = By.xpath("//input[@id='username']");
	    private By inputPassword = By.xpath("//input[@id='password']");
	    private By buttonLogin = By.xpath("//input[@value='Login']");
	
public DashboardPage loginsingle(String email,String password) {
	WebUI.setText(inputEmail, email);
    WebUI.setText(inputPassword, password);
    WebUI.clickElement(buttonLogin);
    return new DashboardPage();
}

public void click_register() {
	 WebUI.clickElement(By.xpath("//a[text()='Register Here']"));
	
}
public void login_page_validation(){
	String PageTitle= WebUI.getPageTitle();
	Assert.assertEquals(PageTitle, "Login | User - American Health Care Academy");
}
public void click_login() {
	 WebUI.clickElement(By.xpath("//input[@value='Login']"));
	 WebUI.waitForPageLoaded();
	
}
public void enter_valid_login_details( String username, String password) {

	WebUI.setText(By.xpath("//input[@id='username']"), username);
	WebUI.setText(By.xpath("//input[@id='password']"), password);
}

public void enter_invalid_login_details( String username, String password) {

	WebUI.setText(By.xpath("//input[@id='username']"), username);
	WebUI.setText(By.xpath("//input[@id='password']"), password);
}

public void error_message_validation( String error) {
	 WebElement errorElement = WebUI.waitForElementVisible(By.xpath("//div[@class='whiteText']"));
	 String error1= errorElement.getText();
	
Assert.assertEquals(error1, error);
}
public void click_reset() {
	 WebUI.clickElement(By.xpath("//a[text()='Click Here to Reset']"));	
}
public void enter_username( String username) {

	WebUI.setText(By.xpath("//input[@placeholder='Username/Email']"), username);
}
public void click_Send_Instructions() {
	 WebUI.clickElement(By.xpath("//input[@value='Send Instructions']"));	
}
public void success_message_validation( String success) {
	 WebElement sucessElement = WebUI.waitForElementVisible(By.xpath("(//div[@class='msg_successfully'])[1]"));
	 String success1= sucessElement.getText();
	
Assert.assertEquals(success1, success);
}

public void Resetpassword_page_validation(){
	WebUI.waitForPageLoaded();
	String PageTitle= WebUI.getTextElement(By.xpath("//div[@id='forgot_password_wrapper']/child::h4"));
	Assert.assertEquals(PageTitle, "Forgot your password?");
}

}
