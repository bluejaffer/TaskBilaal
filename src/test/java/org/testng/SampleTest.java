package org.testng;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTest {
		WebDriver driver;
	@BeforeClass
	private void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://adactinhotelapp.com/");
	}
	@BeforeMethod
	private void beforeMethod() {
		Date date = new Date();
		System.out.println(date);
	}
	@Parameters({"username","password"})
	@Test
	private void tc01(String s, String s1) {
		WebElement txtUserName = driver.findElement(By.id("username"));
		txtUserName.sendKeys(s);
		WebElement txtPassword = driver.findElement(By.id("password"));
		txtPassword.sendKeys(s1);
		WebElement btnLogin = driver.findElement(By.id("login"));
		btnLogin.click();
	}
	
//	@Test
//	private void tc02() {
//		WebElement txtSearchHotel = driver.findElement(By.xpath("//td[text()='Search Hotel ']"));
//		
//	}
//	@Test
//	private void tc03l() {
//		System.out.println("method 3");
//	}
	@AfterMethod
	private void afterMethod() {
		Date date = new Date();
		System.out.println(date);	
	}
	@AfterClass
	private void afterClass() {
		System.out.println("After Class");
	}
	
	
	
	
}
