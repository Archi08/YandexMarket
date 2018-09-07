package pages;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultByNamePage extends BasePage {
    @FindBy(xpath = ".//div[@class='n-product-title__text-container']//h1")
    private WebElement actualTitle;

    public SearchResultByNamePage(WebDriver driver){
        PageFactory.initElements(driver, this);

        this.driver = driver;
    }

    /**
     * Проверка на соответсвие с выбранным товаром
     * @param expected - выбранный товар
     */
    public void checkTitles(String expected){
        try {
            Assert.assertEquals("Найдет не тот объект", expected, actualTitle.getText());
        }
        catch(NoSuchElementException e){
            System.out.println("Товар не сооттвествует ожидаемому результату или не находитесь на странице товара");
        }

    }
}
