package pages;

import utils.Hooks;
import utils.ReusableMethods;

import org.openqa.selenium.WebDriver;

public class PagesBase extends ReusableMethods{
    protected WebDriver driver = Hooks.GetDriver();
    protected LoginPage loginPage;
    protected GoogleSearchPage googleSearchPage;
    protected ECartPage eCartPage;
}
