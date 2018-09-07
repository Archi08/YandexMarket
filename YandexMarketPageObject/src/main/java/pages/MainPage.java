package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {
    @FindBy(xpath = ".//div[@class='home-arrow__tabs']")
    WebElement menuItem;

    @FindBy(xpath = ".//title[text()='Яндекс']")
    WebElement nameTitle;

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        waitUntilElementIsVisible(nameTitle);
    }

    public void selectMenuItem(String itemName){
        menuItem.findElement(By.xpath(".//a[contains(text(), '" + itemName + "')]")).click();
    }
}
