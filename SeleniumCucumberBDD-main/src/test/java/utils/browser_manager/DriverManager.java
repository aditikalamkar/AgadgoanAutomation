package utils.browser_manager;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

    protected WebDriver driver;

    protected abstract void createDriver();

    public void QuitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public WebDriver GetDriver() {

        if (driver == null) {
            createDriver();
        }
        return driver;
    }
}
