package org.base;

import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static void getDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	public static void loadUrl(String data) {
		driver.get(data);
	}
	public static void maximize() {
		driver.manage().window().maximize();
	}
	public static void sleep(int duration) throws Exception {
		Thread.sleep(duration);
	}
	
	public void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	public WebElement findLocatorById(String attributeValue) {
		WebElement element = driver.findElement(By.id(attributeValue));
		return element;
	}
	public WebElement findLocatorByName(String attributeValue) {
		WebElement element = driver.findElement(By.name(attributeValue));
		return element;
	}
	public WebElement findLocatorByClassName(String attributeValue) {
		WebElement element = driver.findElement(By.className(attributeValue));
		return element;
	}
	public WebElement findLocatorByXpath(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}
	public void insertData(WebElement element, String data) {
		element.sendKeys(data);
	}
	public void click(WebElement element) {
		element.click();
	}
	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}
	public String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	public String getText(WebElement element) {
		String text = element.getText();
		return text;
	}
	//99%
	public String getAttributeValue(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}
	//1%
	public String getAttributeValue(WebElement element, String attributeName) {
		String attribute = element.getAttribute(attributeName);
		return attribute;
	}
	public void selectOptionByText(WebElement element, String data) {
		Select select = new Select(element);
		select.selectByVisibleText(data);
	}
	public void selectOptionByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	public void selectOptionByAttribute(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	public void typeJs(WebElement element, String data) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value','" +data+"')", element);
		}

	public void clickJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", element);
		}
	public void moveToElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
	}
	public void rightClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}
	public void dragAndDrop(WebElement source, WebElement target) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target).perform();
	}
	
	public void okAlert() {
		Alert a = driver.switchTo().alert();
		a.accept();
	}
	public void dismissAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	public void closeCurrentWindow() {
		driver.close();
	}
	public static void quit() {
		driver.quit();
	}
	public void switchToFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}
	public void switchToFrameByText(String data) {
		driver.switchTo().frame(data);
	}
	public void getDefaultWindowInFrames() {
		driver.switchTo().defaultContent();
	}
	public void navigateTo(String url) {
		driver.navigate().to(url);
	}
	public void navigateBack() {
		driver.navigate().back();
	}
	public void navigateForward() {
		driver.navigate().forward();
	}
	public void navigateRefresh() {
		driver.navigate().refresh();
	}
	public boolean isDisplayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		return displayed;
	}
	public boolean isSelected(WebElement element) {
		boolean selected = element.isSelected();
		return selected;
	}
	public boolean isEnabled(WebElement element) {
		boolean enabled = element.isEnabled();
		return enabled;	
	}
	public boolean isMultiple(WebElement element) {
		Select select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;
	}
	public void deSelectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);
	}
	public void deSelectByValue(WebElement element, String data) {
		Select select = new Select(element);
		select.deselectByValue(data);
	}
	public void deSelectByVisibleText(WebElement element, String data) {
		Select select = new Select(element);
		select.deselectByVisibleText(data);		
	}
	public void deSelectAll(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
	}
	
	public int lenght(String s) {
		int length = s.length();
		return length;
	}
	public boolean equalsTo(String s1, String s2) {
		boolean equals = s1.equals(s2);
		return equals;
	}
	public boolean equalsIgnoreCase(String s1, String s2) {
		boolean equalsIgnoreCase = s1.equalsIgnoreCase(s2);
		return equalsIgnoreCase;
	}
	public boolean contains(String s1, String s2) {
		boolean contains = s1.contains(s2);
		return contains;
	}
	public boolean startsWith(String s1, String s2) {
		boolean startsWith = s1.startsWith(s2);
		return startsWith;
	}
	public boolean endsWith(String s1, String s2) {
		boolean endsWith = s1.endsWith(s2);
		return endsWith;
	}
	public boolean isEmpty(String s) {
		boolean empty = s.isEmpty();
		return empty;
	}
	public boolean createFolder(File f) {
		boolean mkdir = f.mkdir();
		return mkdir;
	}
	public boolean createFolders(File f) {
		boolean mkdirs = f.mkdirs();
		return mkdirs;
	}
	public boolean createFile(File f) throws IOException {
		boolean newFile = f.createNewFile();
		return newFile;
	}
	public boolean canRead(File f) {
		boolean canRead = f.canRead();
		return canRead;
	}
	public boolean canWrite(File f) {
		boolean canWrite = f.canWrite();
		return canWrite;
	}
	public boolean canExecute(File f) {
		boolean canExecute = f.canExecute();
		return canExecute;
	}
	public void robotPaste(WebElement element) throws Exception {
		Robot rob = new Robot();
		rob.keyPress(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_V);
		rob.keyRelease(KeyEvent.VK_CONTROL);
		rob.keyRelease(KeyEvent.VK_V);
		
	}
	public void robotCopy(WebElement element) throws Exception {
		Robot rob = new Robot();
		rob.keyPress(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_C);
		rob.keyRelease(KeyEvent.VK_CONTROL);
		rob.keyRelease(KeyEvent.VK_C);
	}
	public boolean exists(File f) {
		boolean exists = f.exists();
		return exists;
	}
	public void doubleClick(WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	public void screenShot(String locationPath) throws Exception {
		TakesScreenshot screenshot= (TakesScreenshot) driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		File des = new File(locationPath);
		FileUtils.copyFile(src, des);
	}
	public String getData(String sheetName, int rowNo, int cellNo) throws Exception {
		
		String res= null;
		
		File file = new File("C:\\Users\\ADMIN\\eclipse-workspace\\Task\\src\\Excel\\hotelDatas.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		CellType cellType = cell.getCellType();
		switch(cellType) {
		case STRING:
			res = cell.getStringCellValue();
			
			break;
				
		case NUMERIC:
			if(DateUtil.isCellDateFormatted(cell)) {
				
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
				res = dateFormat.format(dateCellValue);
			}
			else {
				double numericCellValue = cell.getNumericCellValue();
				BigDecimal valueOf = BigDecimal.valueOf(numericCellValue);
				
				res = valueOf.toString();
			}
			break;
			default:
				break;
			}
		FileOutputStream stream = new FileOutputStream(file);
		workbook.write(stream);
		return res;
	}
	
	public void writeData(String sheetName, int rowNo, int cellNo, String data) throws Exception {
		File file = new File("C:\\Users\\ADMIN\\eclipse-workspace\\Task\\src\\Excel\\hotelDatas.xlsx");
		FileInputStream inputstream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(inputstream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.createCell(cellNo);
		cell.setCellValue(data);
		FileOutputStream stream = new FileOutputStream(file);
		workbook.write(stream);
	}
	
	
	
	
	
	
	
	
	
	
}
