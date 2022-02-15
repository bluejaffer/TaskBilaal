package org.base;

import org.openqa.selenium.WebElement;

public class HotelBaseClass {
	public static void main(String[] args) throws Exception {
		BaseClass baseClass=new BaseClass();
		BaseClass.getDriver();
		BaseClass.loadUrl("http://adactinhotelapp.com/");
		BaseClass.maximize();
		
		BaseClass.sleep(2000);
		
		WebElement txtUser = baseClass.findLocatorById("username");
		String userName = baseClass.getData("Datas", 1, 0);
		baseClass.insertData(txtUser, userName);
		WebElement txtPass = baseClass.findLocatorById("password");
		String passWord = baseClass.getData("Datas", 1, 1);
		baseClass.insertData(txtPass, passWord);
		WebElement btnClick = baseClass.findLocatorById("login");
		baseClass.click(btnClick);
		
		BaseClass.sleep(5000);
		
		WebElement dDnLocation = baseClass.findLocatorById("location");
		baseClass.selectOptionByIndex(dDnLocation, 1);
		WebElement dDnHotel = baseClass.findLocatorById("hotels");
		baseClass.selectOptionByIndex(dDnHotel, 1);
		WebElement dDnRoomType = baseClass.findLocatorById("room_type");
		baseClass.selectOptionByIndex(dDnRoomType, 1);
		WebElement dDnRoomNos = baseClass.findLocatorById("room_nos");
		baseClass.selectOptionByIndex(dDnRoomNos, 1);
		WebElement dDnAdultRoom = baseClass.findLocatorById("adult_room");
		baseClass.selectOptionByIndex(dDnAdultRoom, 1);
		WebElement dDnChildRoom = baseClass.findLocatorById("child_room");
		baseClass.selectOptionByIndex(dDnChildRoom, 1);
		WebElement btnSubmit = baseClass.findLocatorById("Submit");
		baseClass.click(btnSubmit);
		
		BaseClass.sleep(5000);
		
		
		WebElement clkChechBox = baseClass.findLocatorById("radiobutton_0");
		baseClass.click(clkChechBox);
		WebElement btnContinue = baseClass.findLocatorById("continue");
		baseClass.click(btnContinue);
		
		BaseClass.sleep(5000);
		
		
		WebElement txtFirstName = baseClass.findLocatorById("first_name");
		String firstName = baseClass.getData("Datas", 1,4 );
		baseClass.insertData(txtFirstName, firstName);
		WebElement txtLastName = baseClass.findLocatorById("last_name");
		String lastName = baseClass.getData("Datas", 1, 5);
		baseClass.insertData(txtLastName, lastName);
		WebElement txtAddress = baseClass.findLocatorById("address");
		String address = baseClass.getData("Datas", 1, 6);
		baseClass.insertData(txtAddress, address);
		WebElement txtCVV = baseClass.findLocatorById("cc_num");
		String ccNum = baseClass.getData("Datas", 1, 7);
		baseClass.insertData(txtCVV, ccNum);
		WebElement dDnCCType = baseClass.findLocatorById("cc_type");
		baseClass.selectOptionByIndex(dDnCCType, 1);
		WebElement dDnCCExpMonth = baseClass.findLocatorById("cc_exp_month");
		baseClass.selectOptionByIndex(dDnCCExpMonth, 5);
		WebElement dDnCCExpYear = baseClass.findLocatorById("cc_exp_year");
		baseClass.selectOptionByIndex(dDnCCExpYear, 12);
		WebElement txtCCCvvNo = baseClass.findLocatorById("cc_cvv");
		String CCCvvNo = baseClass.getData("Datas", 1, 8);
		baseClass.insertData(txtCCCvvNo, CCCvvNo);
		WebElement btnBook = baseClass.findLocatorById("book_now");
		baseClass.click(btnBook);
		
		BaseClass.sleep(5000);
		
		
		WebElement txtOrderNo = baseClass.findLocatorById("order_no");
		String OrderNo = baseClass.getAttributeValue(txtOrderNo);
		System.out.println(OrderNo);
		baseClass.writeData("Datas", 1, 9, OrderNo);
		
		}

	}
	
