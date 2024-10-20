package qa.pages;

import java.time.Duration;
import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Testingwebsite extends Basepage {

	public Testingwebsite(WebDriver driver) {
		super(driver);
	}
@FindBy(xpath="//input[@id='publicKey']")
WebElement publickey;
@FindBy(xpath="//div//div//div[2]//input")
WebElement secrekey;
@FindBy(xpath="//div//div//div[3]//input")
WebElement appid;
@FindBy(xpath="//*[@id='root']/div/form/div[4]/select/option[3]")
WebElement env;
@FindBy(xpath="//button[@type='submit']")
WebElement submitbutton;
@FindBy(xpath="//select[@id='currency']/option[text()='Rupeess']")
WebElement inrcurrency;
@FindBy(xpath="//div[@class='cards-container']/div[1]/div")
WebElement productA;
@FindBy(xpath="//img[@alt='Net Banking']")
WebElement netbanking;
@FindBy(xpath="//button[@class='checkout-button']")
WebElement checkout;
@FindBy(xpath="//div[@class='button-10 statussel outline danger']")
WebElement failedbutton;
@FindBy(xpath="//*[@id=\"root\"]/div/div/h1")
WebElement transactionstatus;
@FindBy(xpath="//a[@class='p-12 flex justify-between align-center cursor-pointer remove-underline ']")
WebElement debitcardcshfree;
@FindBy(xpath="//div[@class='plain-card']/div[1]")
WebElement kotakcard;
@FindBy(xpath="//div[@class='ml-24 my-16']//input")
WebElement cvv;
@FindBy(xpath="//button[@class=' btn  primary  svelte-22h05l']")
WebElement Proceedtopay;
@FindBy(xpath="//button[@class=' btn mr-8 tertiary  svelte-22h05l']")
WebElement redirecttobanksite;
@FindBy(xpath="//*[@id=\"root\"]/div/div/div[3]/select/option[5]")
WebElement debitcard;
@FindBy(xpath="//div[@class='savedcards-container cursor-pointer mt-12 mb-20 p-24 svelte-1essp9l']")
WebElement logincard;
@FindBy(xpath="//div[@class='otpContainer svelte-14s5tb5']")
WebElement otp;
@FindBy(xpath="//h1")
WebElement checkoutpage;
@FindBy(xpath="//h1")
WebElement transactioncheckout;
@FindBy(xpath="//div[@class='Toastify__toast-body']")
WebElement domainrestrictionalert;
@FindBy(xpath="//button")
WebElement paybutton;
@FindBy(xpath="//div[@class='Toastify__toast-icon Toastify--animate-icon Toastify__zoom-enter']")
WebElement invaliddomainerror;
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
public void loginonapp() {
	driver.get("https://payapp-testing.netlify.app/");
	publickey.sendKeys("kspay_test_34ae68a0fd6fa60f032587a9");
	secrekey.sendKeys("d9c6590a0b2f0266b56b5adfe91cf4d1bdf3a974a405e362af16cba869eea3c3");
	appid.sendKeys("ap_8cqLUV8Ga");
	env.click();
	submitbutton.click();
}

public void cashfreesucessnetbanking() throws Throwable {
	inrcurrency.click();
	productA.click();
	netbanking.click();
	checkout.click();
	WebElement netbanking=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='p-12 flex justify-between align-center cursor-pointer remove-underline ']")));
	netbanking.click();
	//driver.findElement(By.xpath("//button[normalize-space()='Open Cashfree Checkout']")).click();
	//driver.findElement(By.xpath("//a[@class='p-12 flex justify-between align-center cursor-pointer remove-underline ']")).click();
	driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div[2]/div[2]")).click();
	driver.findElement(By.xpath("//button[@class=' btn  primary  svelte-22h05l']")).click();
	Thread.sleep(4000);
	driver.findElement(By.xpath("//input[@id='basic-otp']")).sendKeys("111000");
	driver.findElement(By.xpath("//div[@class='button-10 statussel outline success']")).click();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement submitbutton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='successForm']")));
	submitbutton.click();
	Thread.sleep(4000);
	String actual=transactionstatus.getText();
	Assert.assertEquals(actual, "Transaction is SUCCESS !");
}
public void cashfreefailednetbanking() throws Throwable {
	inrcurrency.click();
	productA.click();
	netbanking.click();
	checkout.click();
	driver.findElement(By.xpath("//a[@class='p-12 flex justify-between align-center cursor-pointer remove-underline ']")).click();
	driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div[2]/div[2]")).click();
	driver.findElement(By.xpath("//button[@class=' btn  primary  svelte-22h05l']")).click();
	Thread.sleep(4000);
	driver.findElement(By.xpath("//input[@id='basic-otp']")).sendKeys("111000");
	driver.findElement(By.xpath("//div[@class='button-10 statussel outline danger']")).click();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement submitbutton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='successForm']")));
	submitbutton.click();
	Thread.sleep(4000);
	String actual=transactionstatus.getText();
	Assert.assertEquals(actual, "Transaction is FAILED !");
}
public void cashfreesucessdebitcard() throws Throwable {
	inrcurrency.click();
	productA.click();
	debitcard.click();
	checkout.click();
	debitcardcshfree.click();
	logincard.click();
	Thread.sleep(4000);
	otp.sendKeys("111000");
	kotakcard.click();
	cvv.sendKeys("123");
	Proceedtopay.click();
	redirecttobanksite.click();
	Thread.sleep(4000);
	driver.findElement(By.xpath("//input[@id='basic-otp']")).sendKeys("111000");
	driver.findElement(By.xpath("//div[@class='button-10 statussel outline success']")).click();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement submitbutton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='successForm']")));
	submitbutton.click();
	Thread.sleep(4000);
	String actual=transactionstatus.getText();
	Assert.assertEquals(actual, "Transaction is SUCCESS !");
}
public void openwebsite() {
	driver.switchTo().newWindow(WindowType.TAB);
	driver.get("https://payapp-testing.netlify.app/");

}
public void enterdetails(String key) {
	publickey.sendKeys(key);
}
public void selectenvironment() {
	env.click();
}
public void clickonsubmitbutton() {
	submitbutton.click();
}
public Boolean isredirecttocheckoutpage() {
	return checkoutpage.isDisplayed();
}
public void selectproductandcurrency() {
	inrcurrency.click();
	productA.click();
}
public void selectpaymentmode() {
	netbanking.click();
}
public void completenetbankingpayment() throws InterruptedException {
	WebElement netbanking=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='p-12 flex justify-between align-center cursor-pointer remove-underline ']")));
	netbanking.click();
	//driver.findElement(By.xpath("//button[normalize-space()='Open Cashfree Checkout']")).click();
	//driver.findElement(By.xpath("//a[@class='p-12 flex justify-between align-center cursor-pointer remove-underline ']")).click();
	driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div[2]/div[2]")).click();
	driver.findElement(By.xpath("//button[@class=' btn  primary  svelte-22h05l']")).click();
	Thread.sleep(4000);
	driver.findElement(By.xpath("//input[@id='basic-otp']")).sendKeys("111000");
	driver.findElement(By.xpath("//div[@class='button-10 statussel outline success']")).click();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	Thread.sleep(2000);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement submitbutton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='successForm']")));
	submitbutton.click();
	wait.until(ExpectedConditions.visibilityOf(transactionstatus));
	String actual=transactionstatus.getText();
	Assert.assertEquals(actual, "Transaction is SUCCESS !");	
}
public void clickoncheckoutbutton() {
	checkout.click();
}
public Boolean istransactioncheckoutexist() {
	return transactioncheckout.isDisplayed();
	
}
public void selectcurrency(String currency) {
	WebElement selectcurrency=driver.findElement(By.xpath("//select[@id='currency']/option[text()='"+currency+"']"));
	selectcurrency.click();
	
}
public String isdomainalertpresent() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(domainrestrictionalert));
	return domainrestrictionalert.getText();
}
public void clickonpaybutton() {
	paybutton.click();
}
public String getinvaliddomainerror() {
	return invaliddomainerror.getText();
}
}
