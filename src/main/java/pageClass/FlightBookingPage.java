package pageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//class for Flight booking page elements
public class FlightBookingPage {

	WebDriver driver;

	@FindBy(id = "OneWay")
	public WebElement oneWayRadioBtn;

	@FindBy(id = "FromTag")
	public WebElement fromCity;

	@FindBy(id = "ToTag")
	public WebElement toCity;

	@FindBy(id = "ui-id-1")
	public WebElement originDropdown;

	@FindBy(id = "ui-id-2")
	public WebElement destinationDropdown;

	@FindBy(id = "SearchBtn")
	public WebElement searchBtn;

	@FindBy(xpath = "//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a")
	public WebElement datePicker;

	public FlightBookingPage(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
}
