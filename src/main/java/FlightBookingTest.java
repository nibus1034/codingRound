
//import com.sun.javafx.PlatformUtil;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
<<<<<<< HEAD
=======
import org.openqa.selenium.support.ui.Select;
>>>>>>> edc52dda0ae2d93f009ce44466b6b71e1a1df283
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

<<<<<<< HEAD
import pageClass.FlightBookingPage;
import reusableLibrary.ReusableLibrary;
=======
import java.util.List;

public class FlightBookingTest {

    WebDriver driver;
    
    @BeforeTest
    public void setupApplication() {
    	  setDriverPath();
          driver = new ChromeDriver();
          driver.get("https://www.cleartrip.com/");
          driver.manage().window().maximize();
    	
    }

    @Test
    public void testThatResultsAppearForAOneWayJourney() {

//        setDriverPath();
//        driver = new ChromeDriver();
//        driver.get("https://www.cleartrip.com/");
        
        WebDriverWait wait=new WebDriverWait(driver, 20);
        waitFor(2000);
        driver.findElement(By.id("OneWay")).click();

        //creating webelement for referencing easily
        WebElement fromCity=driver.findElement(By.id("FromTag"));
        
        fromCity.clear();
        fromCity.click();
        fromCity.sendKeys("Bangalore");
>>>>>>> edc52dda0ae2d93f009ce44466b6b71e1a1df283

public class FlightBookingTest extends ReusableLibrary {

<<<<<<< HEAD
	WebDriver driver;
	FlightBookingPage flightBookingPage;

	@BeforeTest(description = "method to setup Chrome browser and open app url")
	public void setupApplication() {
		setDriverPath();
		driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
		driver.manage().window().maximize();
=======
        waitFor(2000); 
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-1")));
        List<WebElement> originOptions = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
        originOptions.get(0).click();

        WebElement toCity=  driver.findElement(By.id("ToTag"));
        toCity.clear();
        toCity.click();
        toCity.sendKeys("Delhi");
>>>>>>> edc52dda0ae2d93f009ce44466b6b71e1a1df283

	}

<<<<<<< HEAD
	@Test(description = "Method to book a one way journey")
	public void bookTicketOneWayJourney() {
=======
        waitFor(2000);
        //select the first item from the destination auto complete list
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-2")));
        
        List<WebElement> destinationOptions = driver.findElement(By.id("ui-id-2")).findElements(By.tagName("li"));
        destinationOptions.get(0).click();
>>>>>>> edc52dda0ae2d93f009ce44466b6b71e1a1df283

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

<<<<<<< HEAD
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
=======
    }
    
    
    @AfterTest
    public void closeApplication() {

        //close the browser
        driver.quit();

    }
    
>>>>>>> edc52dda0ae2d93f009ce44466b6b71e1a1df283

	}

	@AfterTest(description = "method to close the browser")
	public void closeApplication() {

		// close the browser
		driver.quit();

<<<<<<< HEAD
	}

=======
    private void setDriverPath() {
//        if (PlatformUtil.isMac()) {
//            System.setProperty("webdriver.chrome.driver", "chromedriver");
//        }
//        if (PlatformUtil.isWindows()) {
//            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//        }
//        if (PlatformUtil.isLinux()) {
//            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
//        }
    	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }
>>>>>>> edc52dda0ae2d93f009ce44466b6b71e1a1df283
}
