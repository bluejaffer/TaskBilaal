package org.hotelpom;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotelPage extends BaseClass {
	public SelectHotelPage() {
		PageFactory.initElements(driver, this);

	}
	
	
	@FindBy(id="radiobutton_1")
	private WebElement clkHotel;
	@FindBy(id="continue")
	private WebElement btnContinue;
	public WebElement getClkHotel() {
		return clkHotel;
	}
	public WebElement getBtnContinue() {
		return btnContinue;
	}
	
	public void selectHotelPage() {
		click(getClkHotel());
		click(getBtnContinue());
		
	}	
}
