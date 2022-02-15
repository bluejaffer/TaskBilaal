package org.hotelpom;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookHotelPage extends BaseClass {
	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(id="first_name")
	private WebElement txtFirstName;
	@FindBy(id="last_name")
	private WebElement txtLastName;
	@FindBy(id="address")
	private WebElement txtAddress;
	@FindBy(id="cc_num")
	private WebElement txtCcNo;
	@FindBy(id="cc_type")
	private WebElement dDnCCType;
	@FindBy(id="cc_exp_month")
	private WebElement dDnCCExpMonth;
	@FindBy(id="cc_exp_year")
	private WebElement dDnCCExpYear;
	@FindBy(id="cc_cvv")
	private WebElement txtCCCvvNo;
	@FindBy(id="book_now")
	private WebElement btnBook;
	public WebElement getTxtFirstName() {
		return txtFirstName;
	}
	public WebElement getTxtLastName() {
		return txtLastName;
	}
	public WebElement getTxtAddress() {
		return txtAddress;
	}
	public WebElement getTxtCcNo() {
		return txtCcNo;
	}
	public WebElement getdDnCCType() {
		return dDnCCType;
	}
	public WebElement getdDnCCExpMonth() {
		return dDnCCExpMonth;
	}
	public WebElement getdDnCCExpYear() {
		return dDnCCExpYear;
	}
	public WebElement getTxtCCCvvNo() {
		return txtCCCvvNo;
	}
	public WebElement getBtnBook() {
		return btnBook;
	}
	public void bookHotelPage(String firstName, String lastname ,
			String address ,String ccNo , String ccType,
			String ccExpMonth, int ccExpYear ,String cvvNo) {
		insertData(getTxtFirstName(), firstName);
		insertData(getTxtLastName(), lastname);
		insertData(getTxtAddress(), address);
		insertData(getTxtCcNo(), ccNo);
		selectOptionByText(getdDnCCType(), ccType);
		selectOptionByText(getdDnCCExpMonth(), ccExpMonth);
		//selectOptionByText(getdDnCCExpYear(), ccExpYear);
		selectOptionByIndex(getdDnCCExpYear(), ccExpYear );
		insertData(getTxtCCCvvNo(), cvvNo);
		click(getBtnBook());
		
	}
	
	
	

}
