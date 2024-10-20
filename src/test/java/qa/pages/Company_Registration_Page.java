package qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Company_Registration_Page extends Basepage{

	public Company_Registration_Page(WebDriver driver) {
		super(driver);
	
	}


@FindBy(xpath = "//input[@name='companyName']")
WebElement Companyname;
@FindBy(xpath="//input[@name='companyWebsite']")
WebElement Website;
@FindBy(xpath="//textarea[@name='address']")
WebElement Address;
@FindBy(xpath="//input[@id='react-select-2-input'][1]")
WebElement Country;
@FindBy(xpath="//input[@id='react-select-3-input']")
WebElement State;
@FindBy(xpath="//input[@name=\"city\"]")
WebElement City;
@FindBy(xpath="//input[@name=\"zipCode\"]")
WebElement zipcode;
@FindBy(xpath="//input[@name=\"numberOfEmployees\"]")
WebElement CompanySize;
@FindBy(xpath="//input[@name=\"companyTaxName\"]")
WebElement Cotaxname;
@FindBy(xpath="//input[@name='companyTaxNumber']")
WebElement Cotaxnumber;
@FindBy(xpath="//button[@type='submit']")
WebElement submitbutton;

	public void addcompany()throws Throwable {
		Companyname.sendKeys(Basepage.generateRandomProductName());
		Website.sendKeys("www.google.com");
		Address.sendKeys("FC16 film city sector 16a noida");
		Country.sendKeys("India");
		Thread.sleep(4000);
		Country.sendKeys(Keys.ENTER);
		State.sendKeys("UTTAR PRADESH");
		Thread.sleep(4000);
		State.sendKeys(Keys.ENTER);
		City.sendKeys("Noida");
		zipcode.sendKeys("201301s");
		CompanySize.sendKeys("100");
		Cotaxname.sendKeys("Custome duty");
		Cotaxnumber.sendKeys("12345VXNDJ1244");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
		submitbutton.click();
		
	}
	
}
