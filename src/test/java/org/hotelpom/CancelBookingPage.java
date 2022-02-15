package org.hotelpom;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CancelBookingPage extends BaseClass {
	public CancelBookingPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id= "order_id_text")
	private WebElement txtOrderId;
	@FindBy(id= "search_hotel_id")
	private WebElement btnGo;
	@FindBy(name= "ids[]")
	private WebElement btnCheckBox;
	@FindBy(name= "cancelall")
	private WebElement btnCancel;
	public WebElement getTxtOrderId() {
		return txtOrderId;
	}
	public WebElement getBtnGo() {
		return btnGo;
	}
	public WebElement getBtnCheckBox() {
		return btnCheckBox;
	}
	public WebElement getBtnCancel() {
		return btnCancel;
	}
	public void cancelBooking() throws Exception {
		String orderIdNo = getData("Datas", 1, 18);
		insertData(getTxtOrderId(), orderIdNo);
		click(getBtnGo());
		click(getBtnCheckBox());
		click(getBtnCancel());
		okAlert();
	}
	
	
	
	
}
