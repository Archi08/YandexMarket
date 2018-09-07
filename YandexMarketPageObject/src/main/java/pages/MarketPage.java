package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MarketPage extends BasePage {
    @FindBy(xpath = ".//ul[contains(@class, 'topmenu__list')]")
    WebElement menuItem;

    public MarketPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ElectronicsPage selectMenuItem(String itemName){
        menuItem.findElement(By.xpath(".//a[contains(text(), '" + itemName + "')]")).click();
        return new ElectronicsPage(driver);
    }
}
