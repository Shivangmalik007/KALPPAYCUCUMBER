package qa.pages;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.util.Assert;

import io.cucumber.java.Before;

public class Homepage extends Basepage {

	public Homepage(WebDriver driver) {
		super(driver);
	
	}
@FindBy(xpath="//a[@href='/settings']")
WebElement setting;
@FindBy(xpath="//span[@class='selected-title']")
WebElement appdropdown;
public void selectDate() {
LocalDate currentDate = LocalDate.now();
int currentDay = currentDate.getDayOfMonth();
String xpath = String.format("//div[text()='%d' and contains(@class, 'react-datepicker__day')]", currentDay);
WebElement dateElement = driver.findElement(By.xpath(xpath));
dateElement.click();
}
@FindBy(xpath="//button[@class='chart-toggle-button2 mode-toggle ']")
WebElement perpaymentmode;

@FindBy(css=".react-datepicker__input-container")
WebElement datefilter;
@FindBy(xpath="//button[normalize-space()='Done']")
WebElement done;
@FindBy(xpath="//div[@class='dropdown-menu show']")
WebElement drpdwn;
@FindBy(xpath="//div[@class='row']/div[1]//p[@class='card-title']")
WebElement nooftransactioncard;
@FindBy(xpath="//div[@class='row']/div[1]//p[@class='card-amount']")
WebElement Nooftransactionamount;
@FindBy(xpath="//div[@class='row']/div[2]//p[@class='card-title']")
WebElement todaytransactioncard;
@FindBy(xpath="//div[@class='row']/div[2]//p[@class='card-amount']")
WebElement todaytransactionamount;
@FindBy(xpath="//h3[@class='charts-card-title pi-card-title']")
WebElement paymentstatuscard;
@FindBy(xpath="//div[@class='chart-tab-button-wrapper']//button[1]")
WebElement perpaymentgatewaybutton;
@FindBy(xpath="//div[@class='chart-tab-button-wrapper']//button[2]")
WebElement perpaymentmodebutton;
@FindBy(xpath="//button[@class='apply-btn-wrapper button-wrapper false']")
WebElement datefilterdonebutton;
@FindBy(xpath="//input[@type='text']")
WebElement selecteddaterange;
@FindBy(xpath="//div[@class='custom-select__placeholder css-ai9vpl-placeholder']")
WebElement daysfilter;
@FindBy(xpath="//div[@class='custom-select__menu-list css-qr46ko']/div")
List<WebElement> daysdropdown;
@FindBy(xpath="//div[@class='custom-select__menu-list css-qr46ko']/div[1]")
WebElement past7days;
@FindBy(xpath="//div[@class='custom-select__menu-list css-qr46ko']/div[2]")
WebElement past30days;
@FindBy(xpath="//button[@class='clear-filter-btn-wrapper button-wrapper undefined']")
WebElement datefilterclearbutton;
@FindBy(xpath="//div[@class='custom-select__single-value css-1dimb5e-singleValue']")
WebElement daysfilterafterclear;
@FindBy(xpath="//button[@class='env-switch-button']")
WebElement testandliveswitch;
public void dateselection() throws Throwable{
	datefilter.click();
	Thread.sleep(2000);
	selectDate();
	selectDate();
	done.click();
	datefilter.click();
	verifydateselection();
 }
public void verifydateselection() {
	LocalDate currentDate = LocalDate.now();
	int currentDay = currentDate.getDayOfMonth();
	String xpath = String.format("//div[text()='%d' and contains(@class, 'react-datepicker__day')]", currentDay);
	System.out.print(xpath);
	WebElement dateElement = driver.findElement(By.xpath(xpath));
	String ariaSelected = dateElement.getAttribute("aria-selected");
    
}
public void redirecttosettingspage() {
	setting.click();
	}
public void appfilter() throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    Actions actions = new Actions(driver);

    // Click the dropdown to make it visible
    WebElement appDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='selected-title']")));
    appDropdown.click();
    
    // Wait for the dropdown items to be visible
    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("a.dropdown-item")));

    // Perform actions to navigate the dropdown
    actions.sendKeys(Keys.ARROW_DOWN).perform();
    actions.sendKeys(Keys.ENTER).perform();
    Thread.sleep(1000);
    // Retrieve the expected value after selection
    String expectedValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".selected-title"))).getText();
    WebElement appDropdown1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='selected-title']")));
    appDropdown1.click();
    // Re-locate dropdown items
    List<WebElement> dropdownItems = driver.findElements(By.cssSelector("a.dropdown-item"));
    boolean valueFound = false;
    
    // Iterate through the items and compare text
    for (WebElement item : dropdownItems) {
        String actualValue = item.getText();
        System.out.println(actualValue);
        if (actualValue.equals(expectedValue)) {
            valueFound = true;
            break;
        }
    }

    // Assert that the expected value was found in the dropdown
    
}
public List<String>cards(){
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(nooftransactioncard));
	String total=nooftransactioncard.getText();
	String today=todaytransactioncard.getText();
	String status=paymentstatuscard.getText();
	List<String>cardslist=new ArrayList<>();
	cardslist.add(total);
	cardslist.add(today);
	cardslist.add(status);
	return cardslist;
}
public boolean showingperpaymentgateway() {
	return perpaymentgatewaybutton.getAttribute("class").contains("active");
}
public void clickonperpaymentmode() {
	perpaymentmodebutton.click();
}
public boolean isactivegperpaymentmode() {
	return perpaymentmodebutton.getAttribute("class").contains("active");

}


public void startDate(LocalDate date) throws Throwable {
    int dayOfMonth = date.getDayOfMonth();
    String monthYear = date.format(DateTimeFormatter.ofPattern("MMMM yyyy"));
    navigateTobeforeMonth(monthYear);
    String xpath = String.format("//div[text()='%d' and contains(@class, 'react-datepicker__day')]", dayOfMonth);
    WebElement dateElement = driver.findElement(By.xpath(xpath));
    dateElement.click();
    
}

public void navigateTobeforeMonth(String monthYear) throws Throwable {
    while (true) {
    	
        WebElement currentMonth = driver.findElement(By.xpath("//div[@class='react-datepicker__header ']/div[1]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.elementToBeClickable(currentMonth));
        Thread.sleep(4000);
        if (currentMonth.getText().equals(monthYear)) {
            break;
        }
        WebElement previousButton = driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--previous']"));
        previousButton.click();
    }
}
public void clickondonebutton() throws Throwable {
	Thread.sleep(2000);
	datefilterdonebutton.click();
}
public String getselecteddate() {
	return selecteddaterange.getAttribute("value");
}
public void clickondatefilter() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(Nooftransactionamount));
	datefilter.click();
}
public void endDate(LocalDate date) throws Throwable {
    int dayOfMonth = date.getDayOfMonth();
    String monthYear = date.format(DateTimeFormatter.ofPattern("MMMM yyyy"));
    navigateTonextMonth(monthYear);
    String xpath = String.format("//div[text()='%d' and contains(@class, 'react-datepicker__day')]", dayOfMonth);
    WebElement dateElement = driver.findElement(By.xpath(xpath));
    dateElement.click();
    
}

public void navigateTonextMonth(String monthYear) {
    while (true) {
    	
        WebElement currentMonth = driver.findElement(By.xpath("//div[@class='react-datepicker__current-month']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.elementToBeClickable(currentMonth));
        if (currentMonth.getText().equals(monthYear)) {
            break;
        }
        WebElement nextButton = driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--next']"));
        nextButton.click();
    }
}
public void clickondaysfilter() {
	daysfilter.click();
}
public List<String>daysfilter(){
	List<String> pastdaystext=new ArrayList<>();
	for(WebElement pastdays:daysdropdown) {
		pastdaystext.add(pastdays.getText());
		
	}
	return pastdaystext;
}
public void clickonpast7days() {
	past7days.click();
}
public String verifytheamoutonbehalfofdatefilter() throws Throwable {
	Thread.sleep(4000);
	return Nooftransactionamount.getText();
	}
public void clickonpast30days() {
	past30days.click();
}
public void clickonclearbutton() {
	datefilterclearbutton.click();
}
public void clickondaysfilterafterclear() {
	daysfilterafterclear.click();
}

public void clickonsetting() throws Throwable {
	setting.click();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(testandliveswitch));
	if(testandliveswitch.getText().equals("Switch to Test")){
		System.out.println(testandliveswitch.getText());
		testandliveswitch.click();
		System.out.println(testandliveswitch.getText());
	}
	
}
}