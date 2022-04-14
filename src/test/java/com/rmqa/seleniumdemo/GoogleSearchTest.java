package com.rmqa.seleniumdemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

	public static void main(String[] args) {
		String projectPath = System.getProperty("user.dir");
		String driverPath = projectPath + "/drivers/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
//		driver.findElement(By.name("q")).sendKeys("selenium java");
//		driver.findElement(By.id("q")).sendKeys("selenium java");
//		driver.findElement(By.cssSelector("body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf > div.RNNXgb > div > div.a4bIc > input")).sendKeys("selenium java");
		String xpath = "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input";
		driver.findElement(By.xpath(xpath)).sendKeys("selenium java");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
//		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		driver.findElement(By.name("btnK")).click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();
	}
}
