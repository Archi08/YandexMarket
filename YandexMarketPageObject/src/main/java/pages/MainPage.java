package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * Выбрать раздел из меню
     * @param itemName - название раздела(Маркет)
     */
    public void selectMenuItem(String itemName) {
        driver.findElement(By.xpath(".//a[contains(text(), '" + itemName + "')]")).click();
    }
}
