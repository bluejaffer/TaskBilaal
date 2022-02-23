package org.tasking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tasking {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://mrdoob.com/projects/chromeexperiments/google-space/");
		WebElement element = driver.findElement(By.xpath("https://mrdoob.com/projects/chromeexperiments/google-space/"));
		element.click();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
