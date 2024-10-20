package StepDefinations;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import Factory.BaseClass;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import qa.pages.App_overviewpage;
import qa.pages.Homepage;
import qa.pages.Settingpage;


public class Settingsstep {
	App_overviewpage apover;
	WebDriver driver;
	Settingpage stng;
	Homepage hp;
	

	
	@When("user clicks on settings form side menu")
	public void user_clicks_on_settings_form_side_menu() throws Throwable {
		hp=new Homepage(BaseClass.getDriver());
	    hp.clickonsetting();
	}
	
	@Then("it should redirects to the generate api keys section")
	public void it_should_redirects_to_the_generate_api_keys_section() {
		stng=new Settingpage(BaseClass.getDriver());
	    String actualvalue=stng.isgenrateapikeyselected();
	    Assert.assertEquals(actualvalue,"true");
	
	}
	@When("user clicks on paymentgatewaysettings")
	public void user_clicks_on_paymentgatewaysettings() {
	    stng.clickonpaymentgateway();
	}
	@Then("it should redirects to the add gateway screen")
	public void it_should_redirects_to_the_add_gateway_screen() {
	    Boolean actual=stng.ispaymentgatewayselected();
	    Assert.assertTrue(actual);
	}
	@When("user click on add gateway button")
	public void user_click_on_add_gateway_button() {
	   stng.clickonaddgateway();
	}
	@Then("it should redirects to the step1 screen")
	public void it_should_redirects_to_the_step1_screen() {
	    String actual=stng.iscredentailstepexist();
	    Assert.assertEquals(actual.trim(),"step-number active-number");
	}
	@When("user select currency as {string}")
	public void user_select_currency_as(String string) {
	   stng.selectcurrency(string);
	}
	@When("user select gateway as {string}")
	public void user_select_gateway_as(String string) {
	    stng.selectgateway(string);
	}
	@When("user enter details in below fileds")
	public void user_enter_details_in_below_fileds(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		stng.enterclientid(dataMap.get("Client Id"));
		stng.entersecretkey(dataMap.get("Client Secret"));
	}
	@When("user select payment methods")
	public void user_select_payment_methods() throws Throwable {
	    stng.selectpaymentmethod();
	}
	@When("click on submit button")
	public void click_on_submit_button() throws Throwable {
	    stng.clickonsubmitbutton();
	}
	@Then("it should redirect to the step {int}")
	public void it_should_redirect_to_the_step(Integer int1) {
	    String actual=stng.iswebhookstepexist();
	    Assert.assertEquals(actual.trim(),"step-number active-number");
	}
	@When("user enter click on mark as done button")
	public void user_enter_click_on_mark_as_done_button() {
	    stng.clickonsteo2markasdone();
	}
	@When("user click on mark as done button")
	public void user_click_on_mark_as_done_button() throws InterruptedException {
	    stng.clickonstep3markasdone();
	}
	@Then("status of the all three steps should be mark as inverification")
	public void status_of_the_all_three_steps_should_be_mark_as_inverification() throws InterruptedException {
		List<String> statuses = stng.verifythestatus();
	    String expectedStatus = "IN-VERIFY";
	    for (String status : statuses) {
	        Assert.assertEquals("Step status mismatch!", expectedStatus, status);
	    }
	    
	    System.out.println("All steps are marked as 'inverification'");
	}  
	@When("user clicks on generate api key button")
	public void user_clicks_on_generate_api_key_button() {
	   stng.clickongeneratekey();
	}
	@When("user clicks on regenerate api key button")
	public void user_clicks_on_regenerate_api_key_button() {
	   stng.clickonrengenerateapikey();
	}
	@When("clicks on domain")
	public void clicks_on_domain() {
	    stng.clickondomain();
	}
	@When("user enter domain {string}")
	public void user_enter_domain(String string) {
	   stng.enterdomain(string);
	}
	@When("clicks on save button")
	public void clicks_on_save_button() throws Throwable {
	    stng.clickondomainsavebutton();
	}
	@When("clicks on edit button form cashfree gateway")
	public void clicks_on_edit_button_form_cashfree_gateway() {
	    stng.clickoneditbutton();
	}
	@Then("step4 contains domain as {string}")
	public void step_contains_domain_as(String domain) {
	   String actual=stng.isdomainexist();
	   Assert.assertEquals(actual, domain);
	}
	@When("user clicks on mark as done button")
	public void user_clicks_on_mark_as_done_button() throws InterruptedException {
	    stng.clickonstep4markasdone();
	}
	@Then("it should redirect to the APIkeyscreen")
	public void it_should_redirect_to_the_paymentgatewayscreen() {
	   String actualvalue=stng.isgenrateapikeyselected();
	   Assert.assertEquals(actualvalue,"true");
	}
	@Then("status of the gateway should be verified")
	public void status_of_the_gateway_should_be_verified() {
	    String actual=stng.getgatewaystatus();
	    Assert.assertEquals(actual,"Verified");
	}
	@When("click on edit button form domain")
	public void click_on_edit_button_form_domain() {
	    stng.clickondomaineditbutton();
	}
	@When("clicks on generate api section")
	public void click_on_generate_api_section() {
	    stng.clickongenerateapisection();
	}
	}
