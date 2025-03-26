package com.thinktimetechno.hooks;

import com.thinktimetechno.driver.DriverManager;
import com.thinktimetechno.driver.TargetFactory;
import com.thinktimetechno.projects.website.Multipages.CorporateDashboardPage;
import com.thinktimetechno.projects.website.Multipages.CorporateLoginPage;
import com.thinktimetechno.projects.website.Multipages.CorporateRegistrationPage;

import com.thinktimetechno.projects.website.pages.DashboardPage;

import com.thinktimetechno.projects.website.pages.LoginPage;

import com.thinktimetechno.projects.website.pages.RegistrationPage;
import com.thinktimetechno.utils.LogUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;

public class TestContext {

	private WebDriver driver;

	public TestContext() {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		driver = ThreadGuard.protect(new TargetFactory().createInstance());
		driver.manage().window().maximize();
		DriverManager.setDriver(driver);
		LogUtils.info("Driver in TestContext: " + getDriver());
	}


	private DashboardPage dashboardPage;
	private LoginPage loginPage;
	private RegistrationPage registrationPage;
	private CorporateDashboardPage corporatedashboardPage;
	private CorporateLoginPage corporateloginPage;
	private CorporateRegistrationPage corporateregistrationPage;

	public WebDriver getDriver() {
		return DriverManager.getDriver();
	}
	
	public CorporateRegistrationPage getCorporateRegistrationPage() {
		if (corporateregistrationPage == null) {
			corporateregistrationPage = new CorporateRegistrationPage();
		}
		return corporateregistrationPage;
	}

	public CorporateLoginPage getCorporateLoginPage() {
		if (corporateloginPage == null) {
			corporateloginPage = new CorporateLoginPage();
		}
		return corporateloginPage;
	}


	public CorporateDashboardPage getCorporateDashboardPage() {
		if (corporatedashboardPage == null) {
			corporatedashboardPage = new CorporateDashboardPage();
		}
		return corporatedashboardPage;
	}
	public RegistrationPage getRegistrationPage() {
		if (registrationPage == null) {
			registrationPage = new RegistrationPage();
		}
		return registrationPage;
	}

	public LoginPage getLoginPage() {
		if (loginPage == null) {
			loginPage = new LoginPage();
		}
		return loginPage;
	}


	public DashboardPage getDashboardPage() {
		if (dashboardPage == null) {
			dashboardPage = new DashboardPage();
		}
		return dashboardPage;
	}



	
}
