package com.rmqa.seleniumdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleChromeTest {

	public static void main(String[] args) {
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectpath is: " + projectPath);
		String driverPath = projectPath + "/drivers/chromedriver.exe";

		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();
	}

}
