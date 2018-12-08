
//import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
<<<<<<< HEAD
=======
import org.openqa.selenium.support.ui.ExpectedConditions;
>>>>>>> edc52dda0ae2d93f009ce44466b6b71e1a1df283
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageClass.SignInPage;
import reusableLibrary.ReusableLibrary;

<<<<<<< HEAD
public class SignInTest extends ReusableLibrary {

	WebDriver driver;

	SignInPage signInPage;

	@BeforeTest(description = "method to setup Chrome browser and open app url ")
	public void setupApplication() {
		setDriverPath();
		driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
		driver.manage().window().maximize();
=======
    WebDriver driver;
    
    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

        setDriverPath();
       driver = new ChromeDriver();
        driver.get("https://www.cleartrip.com/");
        waitFor(2000);
        WebDriverWait wait=new WebDriverWait(driver,20);
        
>>>>>>> edc52dda0ae2d93f009ce44466b6b71e1a1df283

	}

<<<<<<< HEAD
	@Test(description = "method to try to Sign In without filling any details & get error msg")
	public void signInWithoutDetails() {
		signInPage = new SignInPage(driver);
		waitFor(2000);
		WebDriverWait wait = new WebDriverWait(driver, 20);

		signInPage.yourTripLink.click();
		signInPage.signInBtn.click();
=======
        waitFor(5000);
       driver.switchTo().frame(1);
      //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInButton")));
        driver.findElement(By.id("signInButton")).click();

        String errors1 = driver.findElement(By.id("errors1")).getText();
        Assert.assertTrue(errors1.contains("There were errors in your submission"));
        waitFor(4000);
        //driver.switchTo().defaultContent();
        
        driver.quit();
    }
>>>>>>> edc52dda0ae2d93f009ce44466b6b71e1a1df283

		waitFor(5000);
		driver.switchTo().frame(1);
		waitFor(3000);
		signInPage.signInBtnFrame.click();

<<<<<<< HEAD
		String errors1 = signInPage.errorMsg.getText();
		Assert.assertTrue(errors1.contains("There were errors in your submission"));
		waitFor(4000);
		driver.switchTo().defaultContent();
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

	@AfterTest(description = "method to close the browser")
	public void closeApplication() {
		driver.quit();

	}

}
