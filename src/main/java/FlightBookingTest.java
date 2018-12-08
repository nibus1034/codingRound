
//import com.sun.javafx.PlatformUtil;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageClass.FlightBookingPage;
import reusableLibrary.ReusableLibrary;

public class FlightBookingTest extends ReusableLibrary {

	WebDriver driver;
	FlightBookingPage flightBookingPage;

	@BeforeTest(description = "method to setup Chrome browser and open app url")
	public void setupApplication() {
		setDriverPath();
		driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
		driver.manage().window().maximize();

	}

	@Test(description = "Method to book a one way journey")
	public void bookTicketOneWayJourney() {

		flightBookingPage = new FlightBookingPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		waitFor(2000);
		flightBookingPage.oneWayRadioBtn.click();
		flightBookingPage.fromCity.clear();
		flightBookingPage.fromCity.click();
		flightBookingPage.fromCity.sendKeys("Bangalore");

		// wait for the auto complete options to appear for the origin
		waitFor(2000);
		wait.until(ExpectedConditions.visibilityOf(flightBookingPage.originDropdown));
		// select the first item from the origin auto complete list
		List<WebElement> originOptions = flightBookingPage.originDropdown.findElements(By.tagName("li"));
		originOptions.get(0).click();

		flightBookingPage.toCity.clear();
		flightBookingPage.toCity.click();
		flightBookingPage.toCity.sendKeys("Delhi");

		// wait for the auto complete options to appear for the destination
		waitFor(2000);
		wait.until(ExpectedConditions.visibilityOf(flightBookingPage.destinationDropdown));
		// select the first item from the destination auto complete list
		List<WebElement> destinationOptions = flightBookingPage.destinationDropdown.findElements(By.tagName("li"));
		destinationOptions.get(0).click();

		flightBookingPage.datePicker.click();
		// all fields filled in. Now click on search
		flightBookingPage.searchBtn.click();

		waitFor(5000);
		// verify that result appears for the provided journey search
		Assert.assertTrue(isElementPresent(driver, By.className("searchSummary")));

	}

	@AfterTest(description = "method to close the browser")
	public void closeApplication() {

		// close the browser
		driver.quit();

	}

}
