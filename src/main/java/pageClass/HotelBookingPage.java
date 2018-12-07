package pageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelBookingPage {

	WebDriver driver;

	@FindBy(linkText = "Hotels")
	public WebElement hotelLink;

	@FindBy(id = "Tags")
	public WebElement localityTextBox;

	@FindBy(id = "SearchHotelsButton")
	public WebElement searchButton;

	@FindBy(id = "ui-id-1")
	public WebElement locationDropdown;

	@FindBy(id = "travellersOnhome")
	public WebElement travellerSelection;

	@FindBy(xpath = "(//div[@id='ui-datepicker-div']//tbody//following::td/a)[1]")
	public WebElement dateSelecion;

	@FindBy(className = "searchSummary")
	public WebElement searchSummary;

	public HotelBookingPage(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

}
