package com.onebi.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static com.onebi.utils.WebDriverType.*;
import static java.io.File.separator;
import static com.onebi.utils.ConfigHelper.*;

public class WebDriverProvider {
	
	private static WebDriver driver;
	
	public static void initialize() {
		
		String browser = "chrome";
		
		switch(browser) {
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", glueString(getProjectLocation(), separator, CHROME.getDriverLocation()));
			driver = new ChromeDriver();
			break;
		}
		
		driver.navigate().refresh();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	public static WebDriver get() {
		return driver;
	}
	
	public static void quit() {
		
		if(driver != null) {
		
			driver.quit();
			driver = null;
		}
	}
}
