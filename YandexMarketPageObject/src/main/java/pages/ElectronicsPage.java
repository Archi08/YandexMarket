package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElectronicsPage extends BasePage {

    @FindBy(xpath = ".//span[text()='Да, спасибо']/parent::span")
    private WebElement acceptButton;


    public ElectronicsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * Выбрать категорию и вид товара
     * @param category - категория (Электроника)
     * @param product - вид (Наушники или Телевизор)
     */
    public void chooseCategory(String category, String product) {
        Actions action = new Actions(driver);
        WebElement webElement = driver.findElement(By.xpath(String.format(".//li[@data-department='%s']/a", category)));
        WebElement webElement1 = driver.findElement(By.xpath(String.format(".//a[@class='link topmenu__subitem' and text()='%s']", product)));

        new WebDriverWait(driver, 60).ignoring(Exception.class)
                .until(d -> {
                    action.moveToElement(webElement).perform();
                    webElement1.click();
                    return true;
                });

    }

    public WebElement getAcceptButton() {
        return acceptButton;
    }
}
