package com.rmqa.seleniumdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.rmqa.seleniumdemo.page.GoogleSearchPage;

public class GoogleSearchPageTest {

	public static void main(String[] args) {

		googleSearch();
	}

	public static void googleSearch() {
		String projectPath = System.getProperty("user.dir");
		String driverPath = projectPath + "/drivers/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();

		GoogleSearchPage page = new GoogleSearchPage(driver);
		page.searchText();
		page.clickButton();
		page.closeBrowser();

	}
}
