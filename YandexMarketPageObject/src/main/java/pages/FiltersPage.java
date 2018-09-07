package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FiltersPage extends BasePage{

    @FindBy(xpath = ".//span[@sign-title='от']//input")
    public WebElement priceField;

    @FindBy(xpath = ".//div[contains(@data-filter-id,'7893318')]")
    public WebElement manufacturer;

    @FindBy(xpath = ".//a[@class='button button_size_l button_theme_pseudo i-bem button_action_show-filtered n-filter-panel-extend__controll-button_size_big button_js_inited']")
    public WebElement accept;



    public FiltersPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public FiltersPage selectPriceBounds(String initialPrice){
        priceField.click();
        priceField.clear();
        priceField.sendKeys(initialPrice);
        return this;
    }

    public FiltersPage setManufacturer(String name){
        manufacturer.findElement(By.xpath(".//label[contains(text(), '" + name + "')]")).click();
        return this;
    }

    public FilterResultPage pushAccept(){
        accept.click();
        return new FilterResultPage(driver);
    }
}
