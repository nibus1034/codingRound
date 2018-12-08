package reusableLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class ReusableLibrary {

	// method to check whether element is present or not in a page
	public boolean isElementPresent(WebDriver driver, By by) {
		try {

			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	// method to set driver path according to platform
	public void setDriverPath() {
//	        if (PlatformUtil.isMac()) {
//	            System.setProperty("webdriver.chrome.driver", "chromedriver");
//	        }
//	        if (PlatformUtil.isWindows()) {
//	            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//	        }
//	        if (PlatformUtil.isLinux()) {
//	            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
//	        }

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

	}

	// method for halting the execution in between
	public void waitFor(int durationInMilliSeconds) {
		try {
			Thread.sleep(durationInMilliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
