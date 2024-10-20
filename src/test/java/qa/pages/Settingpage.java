package qa.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class Settingpage extends Basepage {

	public Settingpage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//input[@id='publicKey']")
	WebElement publickey;
	@FindBy(xpath="//div//div//div[2]//input")
	WebElement secretkey;
@FindBy(xpath="//ul/li[1]/button")
WebElement Generateapikeybutton;
@FindBy(xpath="//ul/li[2]/button")
WebElement paymentgatewaybutton;
@FindBy(xpath="//button[@class='add-gateway-btn-sec big-font button-wrapper undefined']")
WebElement addgatewaybutton;
@FindBy(xpath="//div[normalize-space()='Rupeess']")
WebElement inrcurrency;
@FindBy(xpath="//div[@class='custom-select__control css-1glc60u-control']")
WebElement currencydrpdwn;
@FindBy(xpath="//div[normalize-space()='RAZORPAY']")
WebElement razorpay;
@FindBy(xpath="//div[@class='custom-select__placeholder css-ai9vpl-placeholder']")
WebElement gatewaydrpdwn;
@FindBy(xpath="//input[@name='Key Id']")
WebElement keyid;
@FindBy(xpath="//input[@name='Key Secret']")
WebElement keysecret;
@FindBy(xpath="//label[normalize-space()='NET BANKING']")
WebElement netbanking;
@FindBy(xpath="//label[normalize-space()='DEBIT CARD']")
WebElement debitcard;
@FindBy(xpath="//button[@type='submit']")
WebElement submitbutton;
@FindBy(xpath="//button[@class='btn-done button-wrapper false']")
WebElement step2done;
@FindBy(xpath="//div/div/div[2]/div[2]/div[4]/form/div[1]/div[2]/div[2]/div[1]/input")
WebElement secret;
@FindBy(xpath="//button[@class='border-0 bg-transparent']")
WebElement editbutton;
@FindBy(xpath="//div[@class='npm-integration']/div/div[2]/button[2]")
WebElement step3done;
@FindBy(xpath="//button[text()='Regenerate Key']")
WebElement regeneratekey;
@FindBy(xpath="//button[@class='back-icon']")
WebElement backbutton;
@FindBy(xpath="//button[@class='add-gateway-btn']")
WebElement addgateway;
@FindBy(xpath="//div[normalize-space()='CASHFREE']")
WebElement cashfree;
@FindBy(xpath="//input[@name='Client Id']")
WebElement clientid;
@FindBy(xpath="//input[@name='Client Secret']")
WebElement clientsecret;
@FindBy(xpath="//ul/li[1]/div[2]/span")
WebElement credentailstep;
@FindBy(xpath="//ul/li[2]/div[2]/span")
WebElement webhookstep;
@FindBy(xpath="//span[normalize-space()='IN-VERIFY']")
List<WebElement> stepstatus;
@FindBy(xpath="//button[@class='generate-btn button-wrapper undefined']")
WebElement generatekeybutton;
@FindBy(xpath="//div[@class='d-flex flex-column w-100']/div[1]/div/div[2]")
WebElement publicapikey;
@FindBy(xpath="//div[@class='d-flex flex-column w-100']/div[2]/div/div[2]")
WebElement secretapikey;
@FindBy(xpath="//ul/li[3]/button")
WebElement Domain;
@FindBy(xpath="//input[@name='domain']")
WebElement Domainfiled;
@FindBy(xpath="//button[@class='generate-btn button-wrapper undefined'][1]")
WebElement Domainsavebutton;
@FindBy(xpath="//button[@type='submit']")
WebElement step4markasdone;
@FindBy(xpath="//div[@class='d-flex flex-column gap-1 flex-wrap']/div/div[2]/div/div[2]")
WebElement cashfreegatewaystatus;
@FindBy(xpath="//div[@class='custom-toast-container toast-exit-active toast-success']")
WebElement Domainsucessmessage;
@FindBy(xpath="//button[@class='env-switch-button']")
WebElement testandliveswitch;
@FindBy(xpath="//button[@class='border-0 bg-transparent']")
WebElement Domaineditbutton;
WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(30));
JavascriptExecutor js = (JavascriptExecutor) driver;
public void addrazorpay() throws Throwable {
	paymentgatewaybutton.click();
	mywait.until(ExpectedConditions.elementToBeClickable(addgatewaybutton));
	addgatewaybutton.click();
	currencydrpdwn.click();
	inrcurrency.click();
	gatewaydrpdwn.click();
	razorpay.click();
	keyid.sendKeys("rzp_test_MajUteVOpT0mWx");
	keysecret.sendKeys("bEzc7ziLt6MlV85rLjhZ7wJ1");
	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	Thread.sleep(2000);
	netbanking.click();
	debitcard.click();
	mywait.until(ExpectedConditions.elementToBeClickable(submitbutton));
	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	Thread.sleep(2000);
	mywait.until(ExpectedConditions.elementToBeClickable(submitbutton));
	submitbutton.click();
	step2done.click();
	mywait.until(ExpectedConditions.visibilityOf(step3done));
	step3done.click();
	backbutton.click();
}

public void editgatewaystep2() {
	paymentgatewaybutton.click();
	editbutton.click();
	String appid=secretkey.getText();
	step2done.click();
}
public void editgatewaystep3() {
	paymentgatewaybutton.click();
	editbutton.click();
	step3done.click();
}

public void addcashfreegateway() throws Throwable {
	mywait.until(ExpectedConditions.elementToBeClickable(addgateway));
	addgateway.click();
	currencydrpdwn.click();
	inrcurrency.click();
	gatewaydrpdwn.click();
	cashfree.click();
	clientid.sendKeys("TEST101174745b697f67b69cc2101fb447471101");
	clientsecret.sendKeys("bEzc7ziLt6MlV85rLjhZ7wJ1cfsk_ma_test_d6de65fcdabd3fb83f1d658c142c1ffb_bf823b8e");
	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	Thread.sleep(2000);
	netbanking.click();
	debitcard.click();
	mywait.until(ExpectedConditions.elementToBeClickable(submitbutton));
	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	Thread.sleep(2000);
	mywait.until(ExpectedConditions.elementToBeClickable(submitbutton));
	submitbutton.click();
	step2done.click();
	mywait.until(ExpectedConditions.visibilityOf(step3done));
	step3done.click();
	backbutton.click();
}
public String isgenrateapikeyselected() {
	return Generateapikeybutton.getAttribute("aria-selected");
}
public void clickonpaymentgateway() {
	paymentgatewaybutton.click();
}
public Boolean ispaymentgatewayselected() {
	return paymentgatewaybutton.isEnabled();
}
public void clickonaddgateway() {
	mywait.until(ExpectedConditions.elementToBeClickable(addgatewaybutton));
	addgatewaybutton.click();
}
public String iscredentailstepexist() {
	return credentailstep.getAttribute("class");
}
public void selectcurrency(String currency) {
	currencydrpdwn.click();
	WebElement inr=driver.findElement(By.xpath("//div[normalize-space()='"+currency+"']"));
	inr.click();
}
public void selectgateway(String gateway) {
	gatewaydrpdwn.click();
	WebElement cashfree=driver.findElement(By.xpath("//div[normalize-space()='"+gateway+"']"));
	cashfree.click();
}
public void enterclientid(String id) {
      clientid.sendKeys(id);
}
public void entersecretkey(String key) {
	clientsecret.sendKeys(key);
}
public void selectpaymentmethod() throws Throwable {
	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	Thread.sleep(2000);
	mywait.until(ExpectedConditions.elementToBeClickable(netbanking));
	netbanking.click();
	debitcard.click();
}
public void clickonsubmitbutton() throws Throwable {
	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	Thread.sleep(2000);
	mywait.until(ExpectedConditions.elementToBeClickable(submitbutton));
	submitbutton.click();
}
public String iswebhookstepexist() {
	mywait.until(ExpectedConditions.attributeContains(webhookstep,"class", "active"));
	return webhookstep.getAttribute("class");
}
public void clickonsteo2markasdone() {
	step2done.click();
}
public void clickonstep3markasdone() throws InterruptedException {
	mywait.until(ExpectedConditions.elementToBeClickable(step3done));
	Thread.sleep(3000);
	step3done.click();
	
}
public List<String> verifythestatus() throws InterruptedException{
	driver.findElement(By.xpath("//button[@class='close-button']")).click();
	//Thread.sleep(2000);
	mywait.until(ExpectedConditions.visibilityOfAllElements(stepstatus));
	List<String> status=new ArrayList<>();
	for(WebElement inverification:stepstatus) {
		String text=inverification.getText();
		status.add(text);
	}
	return status;
}
public void clickongeneratekey() {
	generatekeybutton.click();
}
public void enterpublicapikey() {
	Set<String>Windows=driver.getWindowHandles();
	String currentwindowhandle=driver.getWindowHandle();
	for(String windownhandle:Windows) {
	if(!windownhandle.equals(currentwindowhandle)) {
		driver.switchTo().window(windownhandle);
	}
	}
	String pubapikey= publicapikey.getText();
	driver.switchTo().window(currentwindowhandle);
	publickey.sendKeys(pubapikey);
}
public void entersecretapikey() {
	Set<String>Windows=driver.getWindowHandles();
	String currentwindowhandle=driver.getWindowHandle();
	for(String windownhandle:Windows) {
	if(!windownhandle.equals(currentwindowhandle)) {
		driver.switchTo().window(windownhandle);
	}
	}
	String secret=secretapikey.getText();
	driver.switchTo().window(currentwindowhandle);
	secretkey.sendKeys(secret);
}
public void clickonrengenerateapikey() {
	regeneratekey.click();
}
public void clickondomain() {
	Domain.click();
}
public void enterdomain(String Domain) {
	Domainfiled.sendKeys(Domain);
}
public void clickondomainsavebutton() throws Throwable {
	Domainsavebutton.click();
	mywait.until(ExpectedConditions.visibilityOf(Domainsucessmessage));
	String actual=Domainsucessmessage.getText();
	Assert.assertEquals(actual,"Domain updated successfully.");
	Thread.sleep(10000);
}
public void clickoneditbutton() {
	mywait.until(ExpectedConditions.visibilityOf(editbutton));
	editbutton.click();
}
public void clickonstep4markasdone() throws InterruptedException {
	mywait.until(ExpectedConditions.attributeToBe(Domainfiled, "value","netlify.app"));
	//mywait.until(ExpectedConditions.textToBePresentInElement(Domainfiled, "netifly.app"));
	Thread.sleep(20000);
	step4markasdone.click();
}
public String getgatewaystatus() {
	return cashfreegatewaystatus.getText();
}
public String isdomainexist() {
	mywait.until(ExpectedConditions.visibilityOf(Domainfiled));
	return Domainfiled.getAttribute("value");
}
public void clickondomaineditbutton() {
	Domaineditbutton.click();
}
public void clickongenerateapisection() {
	Generateapikeybutton.click();
}
}