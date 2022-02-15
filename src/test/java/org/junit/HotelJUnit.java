package org.junit;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;

public class HotelJUnit extends BaseClass {
	
	@BeforeClass
	public static void beforeClass() {
		getDriver();
		loadUrl("http://adactinhotelapp.com/");
		maximize();
	}
	@AfterClass
	public static void afterClass() {
		quit();
	}
	@Before
	public void beforeMethod() {
		long start = System.currentTimeMillis();
		System.out.println(start);
	}
	@After
	public void afterMethod() {
		long end = System.currentTimeMillis();
		System.out.println(end);
	}
	@Test
	public void test1() throws Exception {
		WebElement txtUser = findLocatorById("username");
		String userName = getData("Datas", 1, 0);
		insertData(txtUser, userName);
		String name = txtUser.getAttribute("value");
		Assert.assertEquals("verify name", userName, name);
		
		WebElement txtPass = findLocatorById("password");
		String password = getData("Datas", 1, 1);
		insertData(txtPass, password);
		String pass = txtPass.getAttribute("value");
		Assert.assertEquals("verify pass", password, pass);
		
		WebElement btnClick = findLocatorById("login");
		click(btnClick);
		
		WebElement txtSearchHotel = findLocatorByXpath("//td[text()='Search Hotel ']");
		String searchHotel = getText(txtSearchHotel);
		String schHotel = getData("Datas", 1, 10);
		boolean containsHotel = searchHotel.contains(schHotel);
		Assert.assertTrue("successfully moved to Search page", containsHotel);
		
		
		WebElement dDnLocation = findLocatorById("location");
		selectOptionByIndex(dDnLocation, 1);
		WebElement dDnHotel = findLocatorById("hotels");
		selectOptionByIndex(dDnHotel, 1);
		WebElement dDnRoomType = findLocatorById("room_type");
		selectOptionByIndex(dDnRoomType, 1);
		WebElement dDnRoomNos = findLocatorById("room_nos");
		selectOptionByIndex(dDnRoomNos, 1);
		WebElement dDnAdultRoom = findLocatorById("adult_room");
		selectOptionByIndex(dDnAdultRoom, 1);
		WebElement dDnChildRoom = findLocatorById("child_room");
		selectOptionByIndex(dDnChildRoom, 1);
		WebElement btnSubmit = findLocatorById("Submit");
		click(btnSubmit);
		
		sleep(2000);
		
		WebElement txtSelectHotel = findLocatorByXpath("//td[text()='Select Hotel ']");
		String selectHotel = getText(txtSelectHotel);
		String selHotel = getData("Datas", 1, 11);
		boolean containsSelHotel = selectHotel.contains(selHotel);
		Assert.assertTrue("successfully moved to Select page"	, containsSelHotel);
		
		WebElement clkChechBox = findLocatorById("radiobutton_0");
		click(clkChechBox);
		WebElement btnContinue = findLocatorById("continue");
		click(btnContinue);
		
		sleep(2000);
		
		WebElement txtBookHotel = findLocatorByXpath("//td[text()='Book A Hotel ']");
		String bookHotel = getText(txtBookHotel);
		String bookAHotel = getData("Datas", 1, 12);
		boolean containsBookHotel = bookHotel.contains(bookAHotel);
		Assert.assertTrue("successfully moved to Select page"	, containsBookHotel);
		
		
		WebElement txtFirstName = findLocatorById("first_name");
		String firstName = getData("Datas", 1,4 );
		insertData(txtFirstName, firstName);
		WebElement txtLastName = findLocatorById("last_name");
		String lastName = getData("Datas", 1, 5);
		insertData(txtLastName, lastName);
		WebElement txtAddress = findLocatorById("address");
		String address = getData("Datas", 1, 6);
		insertData(txtAddress, address);
		WebElement txtCcNo = findLocatorById("cc_num");
		String ccNum = getData("Datas", 1, 7);
		insertData(txtCcNo, ccNum);
		WebElement dDnCCType = findLocatorById("cc_type");
		selectOptionByIndex(dDnCCType, 1);
		WebElement dDnCCExpMonth = findLocatorById("dDnCCType");
		selectOptionByIndex(dDnCCExpMonth, 5);
		WebElement dDnCCExpYear = findLocatorById("cc_exp_year");
		selectOptionByIndex(dDnCCExpYear, 12);
		WebElement txtCCCvvNo = findLocatorById("cc_cvv");
		String CCCvvNo = getData("Datas", 1, 8);
		insertData(txtCCCvvNo, CCCvvNo);
		WebElement btnBook = findLocatorById("book_now");
		click(btnBook);
		
		implicitWait(30);
		
		
		WebElement txtBookingCnfrm = findLocatorByXpath("//td[text()='Booking Confirmation ']");
		String bookCnfrm = getText(txtBookingCnfrm);
		String bookingCon = getData("Datas", 1, 13);
		boolean containsBooking = bookCnfrm.contains(bookingCon);
		Assert.assertTrue("successfully moved to Select page"	, containsBooking);
		
		WebElement txtOrderNo =findLocatorById("order_no");
		String OrderNo = getAttributeValue(txtOrderNo);
		System.out.println(OrderNo);
		writeData("Datas", 1, 9, OrderNo);
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
}
