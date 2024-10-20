package qa.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.util.Assert;

import Factory.BaseClass;
import io.cucumber.java.Before;

public class App_overviewpage extends Basepage{

	public App_overviewpage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//div//div//div[3]//input")
	WebElement websiteappid;
@FindBy(xpath="//button[@class='overview-register-btn button-wrapper undefined']")
WebElement registerappbutton;
@FindBy(xpath="//input[@name='search']")
WebElement searchbar;
@FindBy(xpath="//tbody/tr[1]/td[1]//span[@role='button']")
WebElement appid;
@FindBy(xpath="//tbody/tr[1]/td[2]/div")
WebElement appname;
@FindBy(xpath="//input[@id='file-upload']")
WebElement browserbutton;
@FindBy(xpath="//input[@name='name']")
WebElement name;
@FindBy(xpath="//input[@name='domain']")
WebElement domain;
@FindBy(xpath="//img[@class='post-icon']")
WebElement ibutton;
@FindBy(xpath="//input[@placeholder='xyz@abc.com']")
WebElement email;
@FindBy(xpath="//textarea[@placeholder='Select Address']")
WebElement address;
@FindBy(xpath="//input[@placeholder='Mobile (Optional)']")
WebElement mobile;
@FindBy(xpath="//div[@id='country']//input[@role='combobox']")
WebElement country;
@FindBy(xpath="//div[@id='state']//input[@role='combobox']")
WebElement state;
@FindBy(xpath="//input[@name='city']")
WebElement city;
@FindBy(xpath="//input[@placeholder='00 00 00']")
WebElement zipcode;
@FindBy(xpath="//input[@name='taxName']")
WebElement taxname;
@FindBy(xpath="//input[@name='taxNumber']")
WebElement taxnumber;
@FindBy(xpath="//button[@class='register-app-cancel-btn button-wrapper undefined']")
WebElement cancelbutton;
@FindBy(xpath="//button[@type='submit']")
WebElement submitbutton;
@FindBy(xpath="//tbody/tr[1]/td[5]/div[1]/button[1]")
WebElement editbutton;
@FindBy(xpath="//p[@class='register-app-title']")
WebElement registerapptitle;
@FindBy(xpath="//p[1]")
WebElement registermessage;
@FindBy(xpath="//span[@class='error-wrapper']")
WebElement cityerrormessage;
@FindBy(xpath="//table[@class='table']")
WebElement apptable;
@FindBy(xpath="//thead//th")
List<WebElement> tableheading;
@FindBy(xpath="//ul[@class='pagination']/li")
List<WebElement>pagination;
@FindBy(xpath="//tbody/tr[1]/td[5]/div[1]/div[1]/label[1]/span[1]")
WebElement tooglebutton;
@FindBy(xpath="//button[normalize-space()='Disable']")
WebElement disablebutton;
@FindBy(xpath="//tbody/tr[1]/td[5]/div[1]/div[1]/div[1]")
WebElement disableclass;
@FindBy(xpath="//p")
WebElement message;
@FindBy(xpath="//div[@class='modal-content']")
WebElement Alert;
@FindBy(xpath="//a[1]//span[@class='sidebar-items sidebar-items-expanded']")
WebElement homepagesidemenu;
@FindBy(xpath="//div[@class='title']")
WebElement Homepage;
@FindBy(xpath="//div[@class=' css-qr46ko']//div[1]")
WebElement indiavalue;
@FindBy(xpath="//div[@class=' css-qr46ko']/div[1]")
WebElement uttarpradeshvalue;
String appliname;
public static String Applicationname;
 public String applicationname() {
	 appliname= Basepage.randomeString();
	 return appliname;
 }

public void addapplication() throws Throwable {
	//registerappbutton.click();
	browserbutton.sendKeys("C:\\Users\\Shivang.Malik\\Downloads\\image-20240704-062255.png");
	Thread.sleep(5000);
	name.sendKeys(appliname);
	//domain.sendKeys("netlify.app");
	email.sendKeys(Basepage.randomemail());
	address.sendKeys("FC-19 film city noida");
	mobile.sendKeys(Basepage.randommobilenumber());
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", cancelbutton);
	Thread.sleep(2000);
	WebDriverWait mywait1=new WebDriverWait(driver,Duration.ofSeconds(15));
	country.sendKeys("India");
	//mywait1.until(ExpectedConditions.visibilityOf(indiavalue));
	Thread.sleep(2000);
    country.sendKeys(Keys.ENTER);
	state.sendKeys("Uttar pradesh");
	mywait1.until(ExpectedConditions.elementToBeClickable(uttarpradeshvalue));
	Thread.sleep(4000);
	state.sendKeys(Keys.ENTER);
	city.sendKeys("Noida");
	zipcode.sendKeys("201301");
	taxname.sendKeys("Custom duty");
	taxnumber.sendKeys(Basepage.randomAlphaNumeric());
	
	//submitbutton.click();
	
}
public void appidredirection() {
	appid.click();
}
public void serach() throws InterruptedException {
	searchbar.sendKeys(appliname);
	Thread.sleep(2000);
	String name=appname.getText();
	//Assert.assertEquals(name.toUpperCase(), applicationname.toUpperCase());
}
public String  getappname() {
 return(appname.getText());
	
}
public String getserachtext() {
	return(searchbar.getText());
}
public void editapp() throws InterruptedException {
	editbutton.click();
	Thread.sleep(2000);
	name.sendKeys(Basepage.randomeString());
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	Thread.sleep(2000);
	submitbutton.click();
}
public Boolean isappregistrationbuttonexist() {
	WebDriverWait mywait1=new WebDriverWait(driver,Duration.ofSeconds(10));
	mywait1.until(ExpectedConditions.elementToBeClickable(registerappbutton));
	return registerappbutton.isDisplayed();
}
public void clickonregister_app_button_button() {
	registerappbutton.click();
}
public Boolean redirecttoregisteranapppage() {
	WebDriverWait mywait1=new WebDriverWait(driver,Duration.ofSeconds(10));
	mywait1.until(ExpectedConditions.visibilityOf(registerapptitle));
	return registerapptitle.isDisplayed();
	
}
public void clickonsubmitbutton() {
	submitbutton.click();
}
public Boolean successmessage() {
	return registermessage.isDisplayed();
	
}
public Boolean isredirecttoappoverviewpage() {
	WebDriverWait mywait1=new WebDriverWait(driver,Duration.ofSeconds(10));
	mywait1.until(ExpectedConditions.visibilityOf(registerappbutton));
	return registerappbutton.isDisplayed();
}
public void addapplicationinvaliddata() throws Throwable {
	//registerappbutton.click();
	browserbutton.sendKeys("C:\\Users\\Shivang.Malik\\Downloads\\image-20240704-062255.png");
	Thread.sleep(5000);
	name.sendKeys(appliname);
	//domain.sendKeys("netlify.app");
	email.sendKeys(Basepage.randomemail());
	address.sendKeys("FC-19 film city noida");
	mobile.sendKeys(Basepage.randommobilenumber());
	country.sendKeys("India");
	Thread.sleep(4000);
	country.sendKeys(Keys.ENTER);
	state.sendKeys("Uttar pradesh");
	Thread.sleep(4000);
	state.sendKeys(Keys.ENTER);
	city.sendKeys("1234");
	zipcode.sendKeys("201301");
	taxname.sendKeys("Custom duty");
	taxnumber.sendKeys(Basepage.randomAlphaNumeric());
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	Thread.sleep(2000);
}
public String geterrormessage() {
	return cityerrormessage.getText();
}
public Boolean isdisabledaddbutton() {
	return submitbutton.isEnabled();
}
public Boolean istablexist() {
	return apptable.isDisplayed();
}
public List<String> tablecontainheading() {
	List<String> headingtext=new ArrayList<>();
	for(WebElement heading:tableheading) {
		headingtext.add(heading.getText());
	}
return headingtext;
}
public void verifypagination() throws Throwable {
	WebDriverWait mywait1=new WebDriverWait(driver,Duration.ofSeconds(10));
	mywait1.until(ExpectedConditions.visibilityOfAllElements(pagination));
	JavascriptExecutor js = (JavascriptExecutor) BaseClass.getDriver();
	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	Thread.sleep(2000);
 for (WebElement pageItem : pagination) {
		         if (pageItem.getAttribute("class").contains("page-item") && !pageItem.getAttribute("class").contains("active")) {
		            pageItem.click();
		             WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
		            mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table']"))); 
		            System.out.println("Navigated to: " + driver.getCurrentUrl());
		            //pagination = driver.findElements(By.xpath("//ul[@class='pagination']/li"));
		        }
		    }
	}
public void enterappname(String appnames) {
	searchbar.sendKeys(appnames);
	WebDriverWait mywait1=new WebDriverWait(driver,Duration.ofSeconds(10));
	mywait1.until(ExpectedConditions.textToBePresentInElement(appname, appnames.toUpperCase()));
	appname.click();
}
public void clickontooglebutton() throws Throwable {
	tooglebutton.click();
	//Thread.sleep(2000);
}
public Boolean alertispresent() {
	WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
	mywait.until(ExpectedConditions.visibilityOf(Alert));
	return Alert.isDisplayed();
}
public void clickondisablebutton() {
	disablebutton.click();
	
}
public String isappdisabled() {
	WebDriverWait mywait1=new WebDriverWait(driver,Duration.ofSeconds(10));
	mywait1.until(ExpectedConditions.attributeContains(disableclass, "class", "disable"));
	return disableclass.getAttribute("class");
	
}
public String appdisablemessage() {
	String text=message.getText();
	WebDriverWait mywait1=new WebDriverWait(driver,Duration.ofSeconds(10));
	mywait1.until(ExpectedConditions.invisibilityOf(message));
	return text;
}
public Boolean editbuttondisable() {
	WebDriverWait mywait1=new WebDriverWait(driver,Duration.ofSeconds(10));
	mywait1.until(ExpectedConditions.attributeToBeNotEmpty(editbutton, "disabled"));
	return editbutton.isEnabled();
}
public void clickoneditbutton() {
	editbutton.click();
}
public Boolean appredirectionisdisable() {
	return registerappbutton.isDisplayed();
}
public void clickonappname() {
	//WebDriverWait mywait1=new WebDriverWait(driver,Duration.ofSeconds(10));
	//mywait1.until(ExpectedConditions.elementToBeClickable(appname));
	WebDriverWait mywait1=new WebDriverWait(driver,Duration.ofSeconds(10));
	mywait1.until(ExpectedConditions.textToBePresentInElement(appname, appliname.toUpperCase()));
	Applicationname=appname.getText();
	System.out.println(Applicationname);
	appname.click();
}
public String appredirectiontohomepage() {
	return Homepage.getText();
}
public String isappenabled() {
	WebDriverWait mywait1=new WebDriverWait(driver,Duration.ofSeconds(10));
	mywait1.until(ExpectedConditions.attributeContains(disableclass, "class", "enable"));
	return disableclass.getAttribute("class");
}

public void searchanwapp() {
	searchbar.sendKeys(appliname);
}

public void searchregisteredapp() {
	searchbar.sendKeys(Applicationname);
	WebDriverWait mywait1=new WebDriverWait(driver,Duration.ofSeconds(10));
	mywait1.until(ExpectedConditions.textToBePresentInElement(appname, Applicationname.toUpperCase()));
	appname.click();
	
}
public void enterappid() {
	Set<String>Windows=driver.getWindowHandles();
	String currentwindowhandle=driver.getWindowHandle();
	for(String windownhandle:Windows) {
	if(!windownhandle.equals(currentwindowhandle)) {
		driver.switchTo().window(windownhandle);
	}
	}
	driver.findElement(By.xpath("//div[@class='logo-container pointer']")).click();
	searchbar.sendKeys(Applicationname);
	WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
	mywait.until(ExpectedConditions.textToBePresentInElement(appname, Applicationname.toUpperCase()));
	String appid=driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div/div/span")).getText();
	driver.switchTo().window(currentwindowhandle);
	websiteappid.sendKeys(appid);
	
}

}
