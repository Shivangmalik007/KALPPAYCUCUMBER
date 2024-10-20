package qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_page extends Basepage 
{
	public Login_page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	// Login Page locators 
	
	@FindBy(xpath = "//input[@placeholder='Enter Your Email']")
	public static WebElement Email;
	
	@FindBy(xpath="(//input[@placeholder='Enter Password'])[1]")
	public static WebElement Password;
	
	@FindBy(xpath="//button[@class='btn-wrap button-wrapper false']")
	public WebElement Login_button;
	
	@FindBy(xpath="//a[normalize-space()='Forgot Password?']")
	public static WebElement forgot_password__page_link;
	@FindBy(xpath="//p[normalize-space()='Invalid Credentials. Check and re-enter valid credentials.']")
	WebElement errormessage;
	
	// Initializing the Page Objects:
	
	
	public void Login_Positive() throws InterruptedException{
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$");
		Thread.sleep(10000);
		//Email.sendKeys(Signup.email);
		//Password.sendKeys(Signup.pwd);
		//System.out.println(Signup.email);
		//System.out.println(Signup.pwd);
//		Login_button.click();
		Thread.sleep(4000);
		Login_button.click();
		
	    
	}
public void Enteremailandpassword(String username,String pwd) {
	Email.sendKeys(username);
	Password.sendKeys(pwd);
}
public void clickonloginbutton() throws Throwable {
	WebDriverWait mywait1=new WebDriverWait(driver,Duration.ofSeconds(10));
	mywait1.until(ExpectedConditions.elementToBeClickable(Login_button));
	Thread.sleep(6000);
	Login_button.click();
}
public String geterrormessage() {
	WebDriverWait mywait1=new WebDriverWait(driver,Duration.ofSeconds(10));
	mywait1.until(ExpectedConditions.visibilityOf(errormessage));
	return errormessage.getText();
	
}
}
