package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.GoogleSearchPage;
import pages.PagesBase;

public class GoogleSearchStepDef extends PagesBase {

    @Given("I am on the google search page")
    public void i_am_on_the_google_search_page() throws InterruptedException {
        driver.get("https://www.google.com/");
        googleSearchPage = new GoogleSearchPage(driver);
//        googleSearchPage.clickAcceptAllButton();
    }

    @Given("I have entered valid {string}")
    public void i_have_entered_valid(String keywords) {
        googleSearchPage.enterTextIntoSearchInput(keywords);
    }

    @When("I click google search button")
    public void i_hit_enter_button() {
        googleSearchPage.clickSearchButton();
    }

    @Then("I should see an search results appeared indicating {string} in it")
    public void i_should_see_an_search_results_appeared_indicating_in_it(String keywords) {
        Assert.assertTrue(googleSearchPage.verifySearchResults(keywords));
    }
}
