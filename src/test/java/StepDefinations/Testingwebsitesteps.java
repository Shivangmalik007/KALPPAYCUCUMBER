package StepDefinations;

import org.junit.Assert;

import Factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import qa.pages.App_overviewpage;
import qa.pages.Basepage;
import qa.pages.Settingpage;
import qa.pages.Testingwebsite;

public class Testingwebsitesteps {
Testingwebsite tweb;
Settingpage stng;
App_overviewpage apover;
@Given("user navigates to testingwebsite")
public void user_navigates_to_testingwebsite() {
    tweb=new Testingwebsite(BaseClass.getDriver());
    tweb.openwebsite();
}
@When("user enter valid details")
public void user_enter_valid_details() {
	stng=new Settingpage(BaseClass.getDriver());
    stng.enterpublicapikey();
    stng.entersecretapikey();
    apover=new App_overviewpage(BaseClass.getDriver());
    apover.enterappid();
    
}
@When("select environment as {string}")
public void select_environment_as(String string) {
    tweb.selectenvironment();
}
@When("clicks on submit button")
public void clicks_on_submit_button() {
    tweb.clickonsubmitbutton();
}
@Then("it should redirect to the product page")
public void it_should_redirect_to_the_product_page() {
   Assert.assertTrue(tweb.isredirecttocheckoutpage());
}
@When("user select the product")
public void user_select_the_product() {
    tweb.selectproductandcurrency();
}
@When("user select payment method")
public void user_select_payment_method() {
   tweb.selectpaymentmode();
   tweb.clickonpaybutton();
   
}
@When("click on checkout button")
public void click_on_checkout_button()  {
    tweb.clickoncheckoutbutton();
}
@When("complete the transaction")
public void complete_the_transaction() throws InterruptedException {
	tweb.completenetbankingpayment();
}
@Then("it should redirect to the transaction status screen")
public void it_should_redirect_to_the_transaction_status_screen() {
    Assert.assertTrue(tweb.istransactioncheckoutexist());
}
@When("user select currency {string}")
public void user_select_currency(String string) {
  tweb.selectcurrency(string);
}
@Then("it should display error message related to the step4")
public void it_should_display_error_message_related_to_the_step() {
    String actual=tweb.isdomainalertpresent();
    Assert.assertEquals(actual,"Domain Restriction Step not completed yet!");
}
@Then("it should display error message realted to the invalid domain")
public void it_should_display_error_message_realted_to_the_invalid_domain() {
    String actual=tweb.getinvaliddomainerror();
    Assert.assertEquals(actual,"Access denied from this origin");
}
}
