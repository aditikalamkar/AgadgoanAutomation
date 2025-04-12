package stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.PagesBase;
import pages.LoginPage;

public class LoginStepDef extends PagesBase {

    @Given("I am on the OpenCart login page")
    public void i_am_on_the_open_cart_login_page() {
        driver.get("http://localhost:4200/login");
        loginPage = new LoginPage(driver);
    }

    @Given("I have entered a valid username and password")
    public void i_have_entered_a_valid_username_and_password() {
    	waitUntil(3000);
        loginPage.login("aditi@gmail.com", "aditi123");

    }

    @Given("I have entered invalid {string} and {string}")
    public void i_have_entered_invalid_and(String username, String password) {
    	waitUntil(3000);
    	if(!password.equalsIgnoreCase("invalidPassword"))
    	username = generateRandomEmailID();
        loginPage.enterEmail(username);
        loginPage.enterPassword(password);
    }

   

	@When("I click on the login button")
    public void i_click_on_the_login_button() {
    	waitUntil(3000);
        loginPage.clickLoginButton();
    }



    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
    	waitUntil(3000);
        Assert.assertTrue(loginPage.checkLogoutLink());
    }


    @Then("I should see an error message indicating {string}")
    public void i_should_see_an_error_message_indicating(String errorMessage) {
        // Assert that an error message is displayed on the page matching the expected error message
    	waitUntil(3000);
    	Assert.assertTrue(loginPage.getAlertText().isDisplayed());
    	String actualMessage = loginPage.getAlertText().getText();
    	if(actualMessage.equalsIgnoreCase(errorMessage))
    	{
    		System.out.println("Test Passed");
    	}
    	else
    	{
    		Assert.fail();
    	}
    }

    @When("I click on the \"Forgotten Password\" link")
    public void i_click_on_the_forgotten_password_link() {
    	waitUntil(3000);
    	loginPage.clickForgottenPasswordLink();
    }

    @Then("I should be redirected to the password reset page")
    public void i_should_be_redirected_to_the_password_reset_page() {
        // Assert that the current URL contains the password reset page route
        Assert.assertTrue(loginPage.getForgotPwdPageUrl().contains("account/forgotten"));
    }
    
    @When("I search a product {string}")
	public void i_search_a_product(String productName) {
    	loginPage.enterProduct(productName);
    	loginPage.clickSearch();
		waitUntil(3000);
		loginPage.selectAddProduct();
	}
    
    
}



