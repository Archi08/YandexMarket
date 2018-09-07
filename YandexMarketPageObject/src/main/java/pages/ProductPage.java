package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage {

    @FindBy(xpath = ".//div[@class='n-filter-panel-aside__show-more']/a")
    public WebElement advancedSearchButton;

    public ProductPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public FiltersPage selectAdvancedPage(){
        advancedSearchButton.click();
        return new FiltersPage(driver);
    }



}
