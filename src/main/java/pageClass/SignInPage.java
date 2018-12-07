package pageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

	WebDriver driver;

	@FindBy(linkText = "Your trips")
	public WebElement yourTripLink;

	@FindBy(id = "SignIn")
	public WebElement signInBtn;

	@FindBy(id = "signInButton")
	public WebElement signInBtnFrame;

	@FindBy(id = "errors1")
	public WebElement errorMsg;

	public SignInPage(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

}
