package com.rmqa.seleniumdemo;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.rmqa.seleniumdemo.config.PropertyUtil;

public class GoogleSearchTestWithTestNG {

	static WebDriver driver;
	By searchLink = By.className("gb_d");

	@BeforeTest
	public static void setUp() {
		
		String browserName = PropertyUtil.getProperties();
		if (browserName.equalsIgnoreCase("chrome")) {
			String driverPath = System.getProperty("user.dir") + "/drivers/chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			String driverPath = System.getProperty("user.dir") + "/drivers/geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", driverPath);
			driver = new FirefoxDriver();
		}

		driver.get("https://www.google.com/");
	}

	@Test
	public void searchTitle() {
		String title = driver.getTitle();
		System.out.println("title is: " + title);
		assertTrue(title.contains("Google"));
	}

	@Test
	public void searchText() {
		String expectedText = "Gmail";
		String actualText = driver.findElement(searchLink).getText();
		assertEquals(expectedText, actualText);
	}

	@AfterTest
	public static void closeBrowser() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();
	}
}
