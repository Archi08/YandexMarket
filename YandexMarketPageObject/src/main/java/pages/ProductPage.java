package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ProductPage extends BasePage {

    @FindBy(xpath = ".//button[@class='button button_theme_normal button_arrow_down button_size_s select__button i-bem button_js_inited']")
    private WebElement advancedSearchButton;

    @FindBy(xpath = ".//span[text()='Показывать по 12']")
    private WebElement wb;

    @FindBy(xpath = ".//input[@name='Цена от']")
    private WebElement priceField;

    @FindBy(xpath = ".//input[@id='header-search']")
    private WebElement searchField;

    @FindBy(xpath = ".//span[@class='search2__button']")
    private WebElement searchButton;

    @FindBy(xpath = ".//select[@class='select__control']")
    private WebElement select;

    @FindBy(xpath = ".//div[@class='n-snippet-cell2__title']/a")
    private List<WebElement> list1;

    @FindBy(xpath = ".//div[@class='n-snippet-card2__title']/a")
    private List<WebElement> list2;

    private Map<String, List<WebElement>> map = new HashMap<>();

    private String firstResultName;

    public String getFirstResultName() {
        return firstResultName;
    }

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    /**
     * Выбрать сортировку отображения
     */
    public void selectAdvancedPage() {
        advancedSearchButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOf(wb));
        wb.click();

    }

    /**
     * Указать цену
     * @param initialPrice - цена
     */
    public void selectPriceBounds(String initialPrice) {
        priceField.click();
        priceField.clear();
        priceField.sendKeys(initialPrice);
    }

    /**
     * Выбрать марку товара
     * @param name - Марка товара
     */
    public void setManufacrtur(String name) {
        driver.findElement(By.xpath(String.format(".//span[text()='%s']", name))).click();
    }

    /**
     * Проверка количества элементов на странице
     * @param expectedNumber - количество элементов
     * @param option - вид товара (Наушники или Телевизор)
     */
    public void checkElementsNumber(int expectedNumber, String option) {
        map.put("Наушники", list1);
        map.put("Телевизоры", list2);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(d -> map.get(option).size() == 12);
        int productNumber = map.get(option).size();
        Assert.assertEquals("Количество отображаемых товаров не равно ожидаемому количеству", expectedNumber, productNumber);

    }

    public void setFirstResultName(String firstResultName) {
        this.firstResultName = firstResultName;
    }

    /**
     * Выбор первого товара и его поиск
     * @param option - вид товара (Наушники или Телевизор)
     */
    public void searchingModel(String option) {
        String firstResultName = map.get(option).get(0).getAttribute("title");
        this.setFirstResultName(firstResultName);
        searchField.click();
        searchField.clear();
        searchField.sendKeys(firstResultName);
        searchField.sendKeys();
        searchButton.click();
    }

}
