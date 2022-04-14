package com.rmqa.seleniumdemo.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchPage {

	WebDriver driver;
	String xpath = "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input";
	By searcInput = By.xpath(xpath);
	By searchButton =  By.name("btnK");

	public GoogleSearchPage(WebDriver driver) {
		this.driver = driver;
		driver.get("https://www.google.com/");
	}

	public void searchText() {
		driver.findElement(searcInput).sendKeys("selenium java");
	}

	public void clickButton() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.findElement(searchButton).click();
//		WebDriverWait wait = new WebDriverWait(driver, 30);
//		wait.until(ExpectedConditions.elementToBeClickable(By.name("btnK"))).click();
	}

	public void closeBrowser() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();
	}

}
