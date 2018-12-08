
//import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageClass.SignInPage;
import reusableLibrary.ReusableLibrary;

public class SignInTest extends ReusableLibrary {

	WebDriver driver;

	SignInPage signInPage;

	@BeforeTest(description = "method to setup Chrome browser and open app url ")
	public void setupApplication() {
		setDriverPath();
		driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
		driver.manage().window().maximize();

	}

	@Test(description = "method to try to Sign In without filling any details & get error msg")
	public void signInWithoutDetails() {
		signInPage = new SignInPage(driver);
		waitFor(2000);
		WebDriverWait wait = new WebDriverWait(driver, 20);

		signInPage.yourTripLink.click();
		signInPage.signInBtn.click();

		waitFor(5000);
		driver.switchTo().frame(1);
		waitFor(3000);
		signInPage.signInBtnFrame.click();

		String errors1 = signInPage.errorMsg.getText();
		Assert.assertTrue(errors1.contains("There were errors in your submission"));
		waitFor(4000);
		driver.switchTo().defaultContent();

	}

	@AfterTest(description = "method to close the browser")
	public void closeApplication() {
		driver.quit();

	}

}
