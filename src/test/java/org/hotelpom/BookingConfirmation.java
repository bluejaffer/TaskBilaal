package org.hotelpom;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingConfirmation extends BaseClass {
	public BookingConfirmation() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="order_no")
	private WebElement orderId;
	@FindBy(xpath="//a[text()='Booked Itinerary']")
	private WebElement btnItinerary;
	
	
	public WebElement getOrderId() {
		return orderId;
	}


	public WebElement getBtnItinerary() {
		return btnItinerary;
	}


	public void bookingConfirmation() throws Exception {
		
		String orderNo = getAttributeValue(getOrderId());
		writeData("Datas", 1, 18, orderNo);
		System.out.println(orderNo);
		click(getBtnItinerary());
	}
}
