package StepDefinations;

import java.util.List;

import org.junit.Assert;

import Factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import qa.pages.App_overviewpage;
import qa.pages.Transactionpage;

public class transactionstep {
Transactionpage tp;
App_overviewpage apover;
@When("user go the transaction screen")
public void user_go_the_transaction_screen() {
    tp=new Transactionpage(BaseClass.getDriver());
    //String actual=tp.gettransactionstatusfromwebsite();
    tp.clickontransaction();
}
@Then("it should display the transaction with same status as on transaction screen")
public void it_should_display_the_transaction_with_same_status_as_on_transaction_screen() {
  String expected=tp.gettransactionstatus();
  String actual=tp.gettransactionstatusfromwebsite();
  String status=actual.split(" ")[2];
  Assert.assertEquals(status,expected);
}
@When("user clicks on transaction from side menu")
public void user_clicks_on_transaction_from_side_menu() {
	tp=new Transactionpage(BaseClass.getDriver());
	tp.click_on_TransactionHistory();
}
@When("select transaction filter as {string}")
public void select_transaction_filter_as(String string) throws Throwable {
  tp.Select_status_filter(string);
}
@Then("it should display {string} transactions only")
public void it_should_display_transactions_only(String string) {
	List<String> actualStatuses = tp.getstatusofalltransaction();
	for(String status:actualStatuses) {
		Assert.assertEquals(status,string);
	}
}

@Then("it should display transaction table and contain below fileds")
public void it_should_display_transaction_table_and_contain_below_fileds(io.cucumber.datatable.DataTable dataTable) {
   List<String>heading=dataTable.asList();
   List<String>Actualheading=tp.gettableheading();
   System.out.println(Actualheading);
   System.out.println(heading);
   for(int i=0;i<heading.size();i++) {
	   Assert.assertEquals(heading.get(i),Actualheading.get(i));
   }
}
}
