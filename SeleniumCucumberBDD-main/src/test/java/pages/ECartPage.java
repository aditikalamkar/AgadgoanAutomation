package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;





public class ECartPage {

    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//*[@name=\"search\"]")
    private WebElement searchBox;

    @FindBy(how = How.XPATH, using = "//*[@class='btn btn-default btn-lg']")
    private WebElement searchButton;
    
    @FindBy(how = How.XPATH, using = "//*[@title='HTC Touch HD']")
    private WebElement selectAddProduct;
    

  //*[@title='HTC Touch HD' and @class ='img-thumbnail']
    
    public void selectProduct(String productName)
    {
    	driver.findElement(By.xpath("//*[@title='HTC Touch HD' and @class ='img-thumbnail']")).sendKeys("Your-Name");
    	
    }
	public void enterProduct(String productName) {
			searchBox.sendKeys(productName);
		
	}

	public void selectAddProduct(String productName) {
		driver.findElement(By.xpath("//*[@title='"+productName+ "']")).click();
    	
		//selectAddProduct.click();
		
	}

	public void clickSearch() {
		searchButton.click();
		
	}
	

   
}