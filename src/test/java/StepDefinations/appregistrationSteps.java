package StepDefinations;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import Factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import qa.pages.App_overviewpage;

public class appregistrationSteps {
	App_overviewpage apover;
	WebDriver driver;
	
	@When("user clicks on registeranapp button")
	public void user_clicks_on_registeranapp_button() {
		apover=new App_overviewpage(BaseClass.getDriver());
	    apover.clickonregister_app_button_button();
	}

	@Then("user should redirect to the register an app screen")
	public void user_should_redirect_to_the_register_an_app_screen() {
	   Boolean Target=apover.redirecttoregisteranapppage();
	   Assert.assertEquals(Target, true);
	}
	@When("user enter the all valid details")
	public void user_enter_the_all_valid_details() throws Throwable {
		apover.applicationname();
		apover.addapplication();
	}
	

	@When("user clicks on submit button")
	public void user_clicks_on_submit_button() {
	    apover.clickonsubmitbutton();
	}

	@Then("application should be added")
	public void application_should_be_added() {
	    Boolean Target=apover.successmessage();
	    Assert.assertEquals(Target,true);
	}

	@Then("user redirect to the appoverview page")
	public void user_redirect_to_the_appoverview_page() {
		
	    Boolean Target=apover.isappregistrationbuttonexist();
	    Assert.assertEquals(Target,true);
	}
	@When("user enter the invalid details")
	public void user_enter_the_invalid_details() throws Throwable {
	   apover.addapplicationinvaliddata();
	}
	@Then("it should display inline error")
	public void it_should_display_inline_error() {
	    String actual=apover.geterrormessage();
	    Assert.assertEquals(actual, "Invalid city name");
	}
	@Then("add app button should be disable")
	public void add_app_button_should_be_disable() {
	    Boolean Target=apover.isdisabledaddbutton();
	    Assert.assertEquals(Target,true);
	}

	@Then("user should able to see the app table")
	public void user_should_able_to_see_the_app_table() {
		apover=new App_overviewpage(BaseClass.getDriver());
		Boolean Target= apover.istablexist();
	   Assert.assertEquals(Target,true);
	}

	@Then("table should contain the below fields")
	public void table_should_contain_the_below_fields(io.cucumber.datatable.DataTable dataTable) {
		List<String> fields = dataTable.asList();
		List<String> actualFields =apover.tablecontainheading();
		for (String expectedField : fields) {
	        Assert.assertTrue("Expected field '" + expectedField + "' is not present in the table headings",
	                          actualFields.contains(expectedField));
	    }
	}
	@When("user clicks on next page number")
	public void user_clicks_on_next_page_number() throws Throwable {
		
		apover=new App_overviewpage(BaseClass.getDriver());
	    apover.verifypagination();
	}
	@Then("it should redirects to the next page")
	public void it_should_redirects_to_the_next_page() {
	   Boolean Target=apover.istablexist();
	   Assert.assertEquals(Target,true);
	}
	@When("user enter appname as {string} in serach bar")
	public void user_enter_appname_as_in_serach_bar(String string) throws Throwable {
		apover=new App_overviewpage(BaseClass.getDriver());
	    apover.enterappname(string);
	    Thread.sleep(4000);
	}
	@Then("it should display the data of {string} app")
	public void it_should_display_the_data_of_particular_app(String Expectedname) {
	    String Actualname=apover.getappname();
	    Assert.assertEquals(Actualname,Expectedname);
	}
	@When("user clicks on toggle button form app list")
	public void user_clicks_on_toggle_button_form_app_list() throws Throwable {
		apover=new App_overviewpage(BaseClass.getDriver());
		apover.clickontooglebutton();
	}

	@Then("it should display alert realted to disable an app")
	public void it_should_display_alert_realted_to_disable_an_app() {
	    Boolean Target=apover.alertispresent();
	    Assert.assertEquals(Target,true);
	}

	@When("user clicks on disable button form alert")
	public void user_clicks_on_disable_button_form_alert() {
	    apover.clickondisablebutton();
	}
	@Then("it should display app disable message")
	public void it_should_display_app_disable_message() {
	   String actual=apover.appdisablemessage();
	   Assert.assertEquals(actual, "App Disabled");
	}
	@Then("app should be disabled")
	public void app_should_be_disabled() {
	   String Target=apover.isappdisabled();
	   Assert.assertEquals(Target,"disable");
	}

@Then("it should display app enable message")
public void it_should_display_app_enable_message() {
	String actual=apover.appdisablemessage();
	   Assert.assertEquals(actual, "App Enabled");
}
@Then("app should be enabled")
public void app_should_be_enabled() {
	String Target=apover.isappenabled();
	   Assert.assertEquals(Target,"enable");  
}

@When("user clicks on edit button")
public void user_clicks_on_edit_button() {
   apover.clickoneditbutton(); 
}
@Then("it should be disabled")
public void it_should_be_disabled() {
   Boolean Target= apover.editbuttondisable();
   Assert.assertEquals(Target, false);
}
@When("user clicks on app name")
public void user_clicks_on_app_name() {
    apover.clickonappname();
}
@Then("user should not redirect to the app home page")
public void user_should_not_redirect_to_the_app_home_page() {
    Boolean Target=apover.appredirectionisdisable();
    Assert.assertEquals(Target, true);
}
@When("user clicks on appname from the applist")
public void user_clicks_on_appname_from_the_applist() throws Throwable {
	apover=new App_overviewpage(BaseClass.getDriver());
   apover.clickonappname();
}
@Then("it should redirects to the application home page")
public void it_should_redirects_to_the_application_home_page() {
    String actual=apover.appredirectiontohomepage();
    Assert.assertEquals(actual,"App Overview");
}

@When("user clicks on DEMO from the applist")
public void user_clicks_on_demo_from_the_applist() throws Throwable {
	apover=new App_overviewpage(BaseClass.getDriver());
	apover.enterappname("DEMO");
	//Thread.sleep(2000);
   //apover.clickonappname();
}
@When("user clicks on registered appname from the applist")
public void user_clicks_on_registered_appname_from_the_applist() {
	
    apover.searchanwapp();
    apover.clickonappname();
}
@When("user clicks on addedapplication appname from the applist")
public void user_clicks_on_addedapplication_appname_from_the_applist() {
	
    apover.searchregisteredapp();
}
@Then("the user should be redirected to the Appoverview Page")
public void the_user_should_be_redirected_to_the_appoverview_page() {
    apover=new App_overviewpage(BaseClass.getDriver());
    Boolean Target=apover.isappregistrationbuttonexist();
    Assert.assertEquals(Target, true);
}
}
