package org.tasking;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.greenscart.in");
		Thread.sleep(3000);
		WebElement btnRegister = driver.findElement(By.xpath("//input[@class='form-control-1']"));
		btnRegister.click();

		WebElement dDnMonth = driver.findElement(By.id("month"));

		Select select = new Select(dDnMonth);
		List<WebElement> list = select.getOptions();
		
		File file = new File("C:\\Users\\ADMIN\\Documents\\Bilala\\newsheet.xlsx");
		Workbook workbook =new XSSFWorkbook();
		Sheet sheet = workbook.createSheet();
		
		for (int i = 0; i < list.size(); i++) {
			WebElement element = list.get(i);
			String text = element.getText();
			Row row = sheet.createRow(i);
			Cell cell = row.createCell(0);
			cell.setCellValue(text);
			System.out.println(text);
			
			}
			FileOutputStream o = new FileOutputStream(file);
			workbook.write(o);
			System.out.println("completed");

		driver.close();



	}

}

