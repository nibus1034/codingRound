
//import com.sun.javafx.PlatformUtil;
<<<<<<< HEAD
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
=======
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
>>>>>>> edc52dda0ae2d93f009ce44466b6b71e1a1df283
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
<<<<<<< HEAD
=======
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.WebDriverEventListener;
>>>>>>> edc52dda0ae2d93f009ce44466b6b71e1a1df283
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageClass.HotelBookingPage;
import reusableLibrary.ReusableLibrary;

<<<<<<< HEAD
public class HotelBookingTest extends ReusableLibrary {
=======
    WebDriver driver;
    //= new ChromeDriver();
>>>>>>> edc52dda0ae2d93f009ce44466b6b71e1a1df283

	WebDriver driver;
	HotelBookingPage hotelBookingPage;

	@BeforeTest(description = "method to setup Chrome browser and open app url")
	public void setupApplication() {
		setDriverPath();
		driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
		driver.manage().window().maximize();

	}

<<<<<<< HEAD
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
=======
    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;
    
    
    @BeforeTest
    public void setupApplication() {
    	  setDriverPath();
          driver = new ChromeDriver();
          driver.get("https://www.cleartrip.com/");
          driver.manage().window().maximize();
    	
    }

    @Test
    public void shouldBeAbleToSearchForHotels() {
//        setDriverPath();
//
//        driver.get("https://www.cleartrip.com/");
  try {
    	waitFor(3001);
    	PageFactory.initElements(driver, this);//to create webelements
    	
    	WebDriverWait wait=new WebDriverWait(driver, 30);
        hotelLink.click();

        localityTextBox.click();        
        localityTextBox.sendKeys("Indiranagar, Bangalore");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-1")));
        localityTextBox.sendKeys(Keys.TAB);
        
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-1")));
//        
//        List<WebElement> destinationOptions = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
//        destinationOptions.get(0).click();
        
        driver.findElement(By.xpath("(//div[@id='ui-datepicker-div']//tbody//following::td/a)[1]")).click();
         waitFor(1001);
        driver.findElement(By.xpath("(//div[@id='ui-datepicker-div']//tbody//following::td/a)[1]")).click();
        
        new Select(travellerSelection).selectByVisibleText("1 room, 2 adults");
        searchButton.click();
        
        waitFor(5000);
        //verify that result appears for the provided journey search
        Assert.assertTrue(isElementPresent(By.className("searchSummary")));

        
  }
  catch(Exception e) {
	  e.printStackTrace();
  }
     //   driver.quit();

    }
    
    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

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
    
    private void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
    
    @AfterTest
    public void closeApplication() {

        //close the browser
        driver.quit();
>>>>>>> edc52dda0ae2d93f009ce44466b6b71e1a1df283

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@AfterTest(description = "method to close the browser")
	public void closeApplication() {
		driver.quit();
	}

}
