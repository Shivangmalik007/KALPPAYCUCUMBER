package StepDefinations;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import qa.pages.App_overviewpage;
import qa.pages.Homepage;
import qa.pages.Login_page;

public class loginsteps {
	WebDriver driver;
	Login_page lp;
	App_overviewpage apover;
	
	@Given("the user navigates to login page")
	public void the_user_navigates_to_login_page() {
		lp=new Login_page(BaseClass.getDriver());
	}

	@When("user enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String string, String string2) {
	    lp.Enteremailandpassword(string, string2);
	}

	@When("the user clicks on the Login button")
	public void the_user_clicks_on_the_login_button() throws Throwable {
		
	   lp.clickonloginbutton();
	   
	  
	}

	
	@Then("it should display error message")
	public void it_should_display_error_message() {
	  String actual=lp.geterrormessage();
	  Assert.assertEquals(actual,"Invalid Credentials. Check and re-enter valid credentials.");
	}
}
