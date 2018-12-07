
//import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest {

    WebDriver driver;
    
    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

        setDriverPath();
       driver = new ChromeDriver();
        driver.get("https://www.cleartrip.com/");
        waitFor(2000);
        WebDriverWait wait=new WebDriverWait(driver,20);
        

        driver.findElement(By.linkText("Your trips")).click();
        driver.findElement(By.id("SignIn")).click();

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

    private void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
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


}
