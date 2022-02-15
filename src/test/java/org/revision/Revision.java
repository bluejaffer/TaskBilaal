package org.revision;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Revision {
	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		WebDriver driver	=new EdgeDriver();
		driver.get("https://www.fb.com/");
		driver.manage().window().maximize();
	}

}
