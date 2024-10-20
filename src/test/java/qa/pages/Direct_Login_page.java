package qa.pages;

import java.nio.channels.InterruptedByTimeoutException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Direct_Login_page extends Basepage {

    public Direct_Login_page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}



	// Login Page locators 
    @FindBy(xpath = "//input[@placeholder='Enter Your Email']")
    public static WebElement Email;
    
    @FindBy(xpath="(//input[@placeholder='Enter Password'])[1]")
    public static WebElement Password;
    
    @FindBy(xpath="//button[normalize-space()='Sign In']")
    public static WebElement Login_button;
    
    @FindBy(xpath="//a[normalize-space()='Forgot Password?']")
    public static WebElement forgot_password__page_link;



    // Method for Direct Login with hardcoded credentials
    public void Direct_lLogin() throws InterruptedByTimeoutException { 
        // Hardcoded email and password
        String hardcodedEmail = "XWBTa53@gmail.com";
        String hardcodedPassword = "GNLYt06@";
        
        // Enter the email
        Email.sendKeys(hardcodedEmail);
       
        // Enter the password
        Password.sendKeys(hardcodedPassword);
        WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
        mywait.until(ExpectedConditions.elementToBeClickable(Login_button));
        // Click on the Sign In button
        Login_button.click();
        
        // You can add additional actions here if needed, like waiting for page load, etc.
    }
}
