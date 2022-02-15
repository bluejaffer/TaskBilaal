package org.hotelpom;

import org.base.BaseClass;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Execution extends BaseClass {
	@BeforeClass
	public static void beforeClass() {
		getDriver();
		loadUrl("http://adactinhotelapp.com/");
		maximize();
	}
	
	@AfterClass
	public static void afterClass() {
		//quit();
	}
	@Test
	public void searchHotels() throws Exception {
		//Login
		LoginPage loginPage	= new LoginPage();
		String userName = getData("Datas", 1, 0);
		String password = getData("Datas", 1, 1);
		loginPage.login(userName, password);
		//Search Hotel
		SearchHotelPage searchHotel= new SearchHotelPage();
		String location = getData("Datas", 1, 2);
		String roomType = getData("Datas", 1, 3);
		String noOfRooms = getData("Datas", 1, 4);
		String checkInDate = getData("Datas", 1, 5);
		String checkOutDate = getData("Datas", 1, 6);
		String adultPerRoom = getData("Datas", 1, 7);
		String childPerRoom = getData("Datas", 1, 8);
		searchHotel.searchHotelPage(location, roomType, noOfRooms, checkInDate, checkOutDate, adultPerRoom, childPerRoom);;
		//Select Hotel
		SelectHotelPage selectHotel	=new SelectHotelPage();
		selectHotel.selectHotelPage();
		//Book Hotel
		BookHotelPage bookHotel= new BookHotelPage();
		String firstName = getData("Datas", 1	, 9);
		String lastname = getData("Datas", 1	, 10);
		String address = getData("Datas", 1	, 11);
		String ccNo = getData("Datas", 1	, 12);
		String ccType = getData("Datas", 1	, 13);
		String ccExpMonth = getData("Datas", 1	, 14);
		
		String cvvNo = getData("Datas", 1	, 16);
		bookHotel.bookHotelPage(firstName, lastname, address, ccNo, ccType, ccExpMonth, 9, cvvNo);
		implicitWait(10);
		//Booking Confirmation
		BookingConfirmation bookingConfirmation= new BookingConfirmation();
		bookingConfirmation.bookingConfirmation();
		
	}
	@Before
	public void beforeMethod() throws Exception {
		screenShot("C:\\Users\\ADMIN\\eclipse-workspace\\Task\\src\\Files\\ScreenshotBefore.png");
	}
	@After
	public void afterMethod() throws Exception {
		screenShot("C:\\Users\\ADMIN\\eclipse-workspace\\Task\\src\\Files\\Screenshotafter.png");
	}
	@Test
	public void cancelBooking() throws Exception {
		//Cancel Booking
				CancelBookingPage cancelBookingPage= new CancelBookingPage();
				cancelBookingPage.cancelBooking();
	}

}
