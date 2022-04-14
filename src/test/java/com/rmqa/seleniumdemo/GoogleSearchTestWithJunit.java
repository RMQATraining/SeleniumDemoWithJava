package com.rmqa.seleniumdemo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTestWithJunit {

	static WebDriver driver;
	By searchLink = By.className("gb_d");

	@BeforeClass
	public static void setUp() {
		String driverPath = System.getProperty("user.dir") + "/drivers/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
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

	@AfterClass
	public static void closeBrowser() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();
	}
}
