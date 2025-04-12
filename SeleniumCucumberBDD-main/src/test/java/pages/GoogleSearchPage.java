package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class GoogleSearchPage {

    private WebDriver driver;


    @FindBy(how = How.XPATH, using = "//*[@id='APjFqb']")
    private WebElement inputText;


    @FindBy(how = How.XPATH, using = "//input[@value='Google Search']")
    private WebElement searchButton;



    @FindBy(how = How.XPATH, using = "//div[text() = 'Accept all']")
    private WebElement acceptAllButton;

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterTextIntoSearchInput(String keywords) {
        inputText.sendKeys(keywords);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickAcceptAllButton() {
        acceptAllButton.click();
    }


    public Boolean verifySearchResults(String keywords) {
        return driver.getPageSource().contains(keywords);
    }
}