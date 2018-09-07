package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElectronicsPage extends BasePage {
    @FindBy(xpath = ".//div[contains(@class, 'layout-grid__col layout-grid__col_width_2')]")
    WebElement menuItem;

    public ElectronicsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ProductPage chooseCategory(String product){
        menuItem.findElement(By.xpath(".//div[@class='catalog-menu__list']/a[contains(text(), '" + product + "')]")).click();
        return new ProductPage(driver);
    }


}
