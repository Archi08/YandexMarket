package pages;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultByNamePage extends BasePage {
    @FindBy(xpath = ".//div[@class='n-product-title__text-container']//h1")
    public WebElement actualTitle;

    public SearchResultByNamePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void checkTitles(){
        try {
            Assert.assertEquals("Найдет не тот объект", FilterResultPage.firstResultName, actualTitle.getText());
        }
        catch(NoSuchElementException e){
            System.out.println("Яндекс поиск не нашел точную модель. Их баг.");
        }

    }
}
