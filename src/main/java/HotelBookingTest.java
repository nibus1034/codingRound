
//import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageClass.HotelBookingPage;
import reusableLibrary.ReusableLibrary;

public class HotelBookingTest extends ReusableLibrary {

	WebDriver driver;
	HotelBookingPage hotelBookingPage;

	@BeforeTest(description = "method to setup Chrome browser and open app url")
	public void setupApplication() {
		setDriverPath();
		driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
		driver.manage().window().maximize();

	}

	@Test(description = "method to search for Hotels")
	public void searchHotels() {

		try {

			hotelBookingPage = new HotelBookingPage(driver);
			waitFor(3001);

			WebDriverWait wait = new WebDriverWait(driver, 30);
			hotelBookingPage.hotelLink.click();

			hotelBookingPage.localityTextBox.click();
			hotelBookingPage.localityTextBox.sendKeys("Indiranagar, Bangalore");
			wait.until(ExpectedConditions.visibilityOf(hotelBookingPage.locationDropdown));
			hotelBookingPage.localityTextBox.sendKeys(Keys.TAB);

			hotelBookingPage.dateSelecion.click();
			waitFor(1001);
			hotelBookingPage.dateSelecion.click();

			new Select(hotelBookingPage.travellerSelection).selectByVisibleText("1 room, 2 adults");
			hotelBookingPage.searchButton.click();

			waitFor(5000);
			wait.until(ExpectedConditions.visibilityOf(hotelBookingPage.searchSummary));
			// verify that result appears for the provided journey search
			Assert.assertTrue(isElementPresent(driver, By.className("searchSummary")));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@AfterTest(description = "method to close the browser")
	public void closeApplication() {
		driver.quit();
	}

}
