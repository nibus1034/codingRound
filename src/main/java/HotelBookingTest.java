
//import com.sun.javafx.PlatformUtil;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HotelBookingTest {

    WebDriver driver;
    //= new ChromeDriver();

    @FindBy(linkText = "Hotels")
    private WebElement hotelLink;

    @FindBy(id = "Tags")
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

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

    }

}
