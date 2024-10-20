package qa.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Transactionpage extends Basepage {

	public Transactionpage(WebDriver driver) {
		super(driver);
	}
@FindBy(xpath="//tr[1]/td[8]/div/div")
WebElement Transactionstatus;
@FindBy(xpath="//a[@href='/transactions']")
WebElement transactionsidemenu;
@FindBy(xpath="//*[@id=\"root\"]/div/div/h1")
WebElement transactionstatus;
@FindBy(xpath="//tr/td[8]/div/div")
List<WebElement> alltransactionstatus;
@FindBy(xpath="//div[@class='custom-select__menu-list css-qr46ko']/div[text()='Success']")
WebElement filtervalue;
@FindBy(xpath="//div[@class='custom-select__placeholder css-ai9vpl-placeholder']")
WebElement statusfilter;
@FindBy(xpath="//th")
List<WebElement>tableheading;
public void clickontransaction() {
	Set<String>Windows=driver.getWindowHandles();
	String currentwindowhandle=driver.getWindowHandle();
	for(String windownhandle:Windows) {
	if(!windownhandle.equals(currentwindowhandle)) {
		driver.switchTo().window(windownhandle);
	}
	}
	driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div")).click();
	transactionsidemenu.click();
}
public String gettransactionstatus() {
	return Transactionstatus.getText();
}
public String gettransactionstatusfromwebsite() {
	Set<String>Windows=driver.getWindowHandles();
	String currentwindowhandle=driver.getWindowHandle();
	for(String windownhandle:Windows) {
	if(!windownhandle.equals(currentwindowhandle)) {
		driver.switchTo().window(windownhandle);
	}
	}
	return transactionstatus.getText();
}
public List<String> getstatusofalltransaction(){
	List<String>orignalstatus=new ArrayList<>();
	for(WebElement status:alltransactionstatus) {
		orignalstatus.add(status.getText());
	}
	return orignalstatus;
}
public void Select_status_filter(String status) throws Throwable {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(statusfilter));
	statusfilter.click();
	WebElement statusvalue=driver.findElement(By.xpath("//div[@class='custom-select__menu-list css-qr46ko']/div[text()='"+status+"']"));
	WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait1.until(ExpectedConditions.elementToBeClickable(statusvalue));
	statusvalue.click();
	Thread.sleep(2000);	
}
public void click_on_TransactionHistory() {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(transactionsidemenu));
	transactionsidemenu.click();
}
public List<String> gettableheading(){
	List<String> heading=new ArrayList<>();
	for(WebElement actualheading:tableheading) {
		heading.add(actualheading.getText());
	}
	return heading;
}
}