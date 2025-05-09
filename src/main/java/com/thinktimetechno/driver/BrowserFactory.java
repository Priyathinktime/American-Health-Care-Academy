/*
 * Copyright (c) 2022.
 * Automation Framework Selenium - Anh Tester
 */

package com.thinktimetechno.driver;

import static java.lang.Boolean.TRUE;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;
import com.thinktimetechno.constants.FrameworkConstants;
import com.thinktimetechno.exceptions.HeadlessNotSupportedException;

public enum BrowserFactory {
	CHROME {
	    @Override
	    public WebDriver createDriver() {
	        return new ChromeDriver(getOptions());
	    }

	    @Override
	    public ChromeOptions getOptions() {
	        ChromeOptions options = new ChromeOptions();

	        // Custom download path (project directory)
	        String projectPath = System.getProperty("user.dir");
	        String downloadFilepath = projectPath + "\\src\\test\\resources\\Downloads";

	        // Ensure the folder exists
//	        File folder = new File(downloadFilepath);
//	        if (!folder.exists()) {
//	            folder.mkdirs();
//	        }

	        // Chrome preferences
	        Map<String, Object> prefs = new HashMap<>();
	        prefs.put("download.default_directory", downloadFilepath);
	        prefs.put("download.prompt_for_download", false);
	        prefs.put("profile.default_content_setting_values.notifications", 2);
	        prefs.put("credentials_enable_service", false);
	        prefs.put("profile.password_manager_enabled", false);

	        options.setExperimentalOption("prefs", prefs);
	        options.addArguments("--disable-extensions");
	        options.addArguments("--disable-infobars");
	        options.addArguments("--disable-notifications");
	        options.addArguments("--remote-allow-origins=*");

	        if (Boolean.parseBoolean(FrameworkConstants.HEADLESS)) {
	            options.addArguments("--headless=new");
	            options.addArguments("window-size=1800,900");
	        }

	        return options;
	    }
	}
, FIREFOX {
        @Override
        public WebDriver createDriver() {
            //WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();

            return new FirefoxDriver(getOptions());
        }

        @Override
        public FirefoxOptions getOptions() {
            FirefoxOptions options = new FirefoxOptions();
            if (Boolean.valueOf(FrameworkConstants.HEADLESS) == true) {
                options.addArguments("--headless");
                options.addArguments("window-size=1800,900");
            }

            return options;
        }
    }, EDGE {
        @Override
        public WebDriver createDriver() {
            //WebDriverManager.getInstance(DriverManagerType.EDGE).setup();

            return new EdgeDriver(getOptions());
        }

        @Override
        public EdgeOptions getOptions() {
            EdgeOptions options = new EdgeOptions();
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("profile.default_content_setting_values.notifications", 2);
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            prefs.put("autofill.profile_enabled", false);
            options.setExperimentalOption("prefs", prefs);
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-notifications");
            options.addArguments("--remote-allow-origins=*");

            if (Boolean.valueOf(FrameworkConstants.HEADLESS) == true) {
                options.addArguments("--headless=new");
                options.addArguments("window-size=1800,900");
            }

            return options;
        }
    }, SAFARI {
        @Override
        public WebDriver createDriver() {
            //WebDriverManager.getInstance(DriverManagerType.SAFARI).setup();

            return new SafariDriver(getOptions());
        }

        @Override
        public SafariOptions getOptions() {
            SafariOptions options = new SafariOptions();
            options.setAutomaticInspection(false);

            if (TRUE.equals(Boolean.valueOf(FrameworkConstants.HEADLESS)))
                throw new HeadlessNotSupportedException(options.getBrowserName());

            return options;
        }
    };

    private static final String START_MAXIMIZED = "--start-maximized";

    public abstract WebDriver createDriver();

    public abstract MutableCapabilities getOptions();
}
