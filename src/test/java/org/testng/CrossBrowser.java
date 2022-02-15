package org.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowser {
	WebDriver driver;
	@Parameters({"browser"})
	@Test
	private void tc01(String name) {
		if(name.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			WebDriver driver	=new ChromeDriver();
			driver.get("https://www.fb.com/");
			driver.manage().window().maximize();
		}else if (name.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			WebDriver driver	=new EdgeDriver();
			driver.get("https://www.amazon.in/");
			driver.manage().window().maximize();
			
		}
	}

}
