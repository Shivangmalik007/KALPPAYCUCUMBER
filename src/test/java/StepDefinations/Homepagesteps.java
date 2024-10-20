package StepDefinations;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import Factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import qa.pages.App_overviewpage;
import qa.pages.Homepage;
import qa.pages.Login_page;

public class Homepagesteps {
	WebDriver driver;
	Login_page lp;
	App_overviewpage apover;
	Homepage hp;
	@Then("home page contain the below cards")
	public void home_page_contain_the_below_cards(io.cucumber.datatable.DataTable dataTable) {
	hp=new Homepage(BaseClass.getDriver());
		List<String> fields = dataTable.asList();
		List<String> actualFields =hp.cards();
		for (String expectedField : fields) {
	        Assert.assertTrue("Expected field '" + expectedField + "' is not present in the table headings",
	                          actualFields.contains(expectedField));
	    }
	}
	@Then("by default graph is on per payment gateway")
	public void by_default_graph_is_on_per_payment_gateway() {
		hp=new Homepage(BaseClass.getDriver());
	    Boolean Target=hp.showingperpaymentgateway();
	    Assert.assertEquals(Target,true);
	}
	@When("user clicks on per payment mode")
	public void user_clicks_on_per_payment_mode() {
	    hp.clickonperpaymentmode();
	}
	@Then("it should change to per payment mode")
	public void it_should_change_to_per_payment_mode() {
	    Boolean Target=hp.isactivegperpaymentmode();
	    Assert.assertEquals(Target,true);
	}
	@When("user select start date as {string} and end date as {string}")
	public void user_select_start_date_as_and_end_date_as(String startDate, String endDate) throws Throwable {
		hp=new Homepage(BaseClass.getDriver());
		hp.clickondatefilter();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    LocalDate start = LocalDate.parse(startDate, formatter);
	    LocalDate end = LocalDate.parse(endDate, formatter);
	   hp.startDate(start);
	    hp.endDate(end);
	}
	@When("clicks on done button")
	public void clicks_on_done_button() throws Throwable {
	    hp.clickondonebutton();
	    
	}
	@Then("it should display data according to {string}")
	public void it_should_display_data_according_to(String string) {
	    String actual=hp.getselecteddate();
	    Assert.assertEquals(actual,string);
	}
	@When("user clicks on days filter")
	public void user_clicks_on_days_filter() {
		hp=new Homepage(BaseClass.getDriver());
	    hp.clickondaysfilter();
	}
	@Then("it should display dropdown contain below fields")
	public void it_should_display_dropdown_contain_below_fields(io.cucumber.datatable.DataTable dataTable) {
	   List<String>pastdays =dataTable.asList();
	   List<String>actualpastdays=hp.daysfilter();
	   //for(String expecteddays: pastdays) {
		   Assert.assertEquals(pastdays,actualpastdays);
	   //}
	   
	}
	@When("user click on any days filter")
	public void user_click_on_any_days_filter() {
	    //hp.clickonpast7days();
		hp.clickonpast30days();
	}
	@Then("it should display data according to the days")
	public void it_should_display_data_according_to_the_days() throws Throwable {
	String before= hp.verifytheamoutonbehalfofdatefilter();
	hp.clickondatefilter();
	   hp.startDate(LocalDate.now().minusDays(29));
	   hp.endDate(LocalDate.now());
	   Thread.sleep(4000);
	   hp.clickondonebutton();
	  String after= hp.verifytheamoutonbehalfofdatefilter();
	  Assert.assertEquals(before,after);
	}
	@Then("days filter should be removed")
	public void days_filter_should_be_removed() {
	    
	}
	@When("clicks on clear button")
	public void clicks_on_clear_button() {
		hp.clickondatefilter();
	    hp.clickonclearbutton();
	}
	@Then("date filter should be removed")
	public void date_filter_should_be_removed() {
	    String actual=hp.getselecteddate();
	    Assert.assertEquals(actual, "");
	}
	@Then("it should display by default data of past7days")
	public void it_should_display_by_default_data_of_past7days() throws Throwable {
	 String actual= hp.verifytheamoutonbehalfofdatefilter();
	 hp.clickondaysfilterafterclear();
	  hp.clickonpast7days();
	  String expected=hp.verifytheamoutonbehalfofdatefilter();
	  Assert.assertEquals(actual,expected);
	  
	}
}
