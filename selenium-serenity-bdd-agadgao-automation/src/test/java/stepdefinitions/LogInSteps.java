package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepImplementation.LogInImpl;

public class LogInSteps extends LogInImpl {

	@Given("{string} is valid Devotee user")
	public void is_valid_Devotee_user(String customerType) {
		devoteeData.put("customerType", customerType);
	}


	@When("user logins with credential from {string}")
	public void user_logins_with_credential_from(String testCaseID, DataTable dataTable) {
		devoteeData.put("moduleName", "Login");
		devoteeData = logInWithUser(devoteeData, testCaseID, dataTable);
	}

	@Then("login is {string} with {string}")
	public void login_is_with(String result, String outcome) {
		validateScenario(devoteeData, result, outcome);
	}

	@When("user want to reset password")
	public void user_want_to_reset_password() {

	}

	@Then("user should have provision to reset password")
	public void user_should_have_provision_to_reset_password() {

	}

	@When("user opt for reset pasword")
	public void user_opt_for_reset_pasword() {

	}

	@Then("reset password email should get trigger to users registered emailID")
	public void reset_password_email_should_get_trigger_to_users_registered_emailID() {

	}

}