package com.rmqa.seleniumdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverTest {

	public static void main(String[] args) {
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectpath is: " + projectPath);
		String driverPath = projectPath + "/drivers/geckodriver.exe";

		System.setProperty("webdriver.gecko.driver", driverPath);
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.selenium.dev/");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();
	}

}
