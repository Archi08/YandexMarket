package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class FilterResultPage extends BasePage {

    @FindBy(xpath = ".//div[contains(@class, 'layout__col i-bem layout__col_search-results_normal')]")
    public WebElement ElementsNumberCells;

    @FindBy(xpath = ".//div[contains(@class, 'n-filter-applied-results metrika b-zone')]")
    public WebElement allResults;

    @FindBy(xpath = ".//input[@id='header-search']")
    public WebElement SearchField;

    @FindBy(xpath = ".//span[@class='search2__button']")
    public WebElement SearchButton;

    static String productTypePart;
    static String firstResultName;


    public FilterResultPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public FilterResultPage checkElementsNumber(int expectedNumber){
        int productNumber = ElementsNumberCells.findElements(By.xpath(".//div[contains(@class, 'n-snippet-" + productTypePart + "2 i-bem b-zone')]")).size();
        Assert.assertEquals("Количество отображаемых товаров не равно ожидаемому количеству", expectedNumber, productNumber);
        return this;
    }

    public SearchResultByNamePage searchingModel(){
        //11. Запомнить первый элемент в списке.
        firstResultName = allResults.findElement(By.xpath(".//div[contains(@class, 'n-snippet-" + productTypePart + "2__title')]/a")).getAttribute("title");
        SearchField.click();
        SearchField.clear();
        SearchField.sendKeys(firstResultName);
        SearchButton.click();
        return new SearchResultByNamePage(driver);
    }

    public FilterResultPage checkObjectType(String productType){
        if(productType.equals("Телевизоры"))
            productTypePart = "card";
        else //наушники
            productTypePart = "cell";
        return this;
    }




}
