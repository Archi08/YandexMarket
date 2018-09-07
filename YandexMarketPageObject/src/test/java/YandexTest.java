import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;


import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class YandexTest {
    private WebDriver driver;
    private static Properties properties = TestProperties.getInstance().getProperties();

    @Before //Чтобы определить код, который должен выполнятся перед каждым тестом
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();// на весь экран
        //2. Зайти на yandex.ru.
        driver.get(properties.getProperty("app.url"));
    }

    @After //Чтобы определить код, который должен выполнятся после каждого теста
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void yandexMarketHeadphonesTest() throws InterruptedException {
        new MainPage(driver).selectMenuItem("Маркет");
        ElectronicsPage electronicsPage = new ElectronicsPage(driver);
        electronicsPage.clickButton(electronicsPage.getAcceptButton());
        electronicsPage.chooseCategory("Электроника", "Наушники");
        ProductPage productPage = new ProductPage(driver);
        productPage.selectAdvancedPage();
        productPage.selectPriceBounds("5000");
        productPage.setManufacrtur("Beats");
        productPage.checkElementsNumber(12, "Наушники");
        productPage.searchingModel("Наушники");
        new SearchResultByNamePage(driver).checkTitles(productPage.getFirstResultName());


    }

    @Test
    public void yandexMarketTVTest() {
        new MainPage(driver).selectMenuItem("Маркет");
        new ElectronicsPage(driver).chooseCategory("Электроника", "Телевизоры");
        ProductPage productPage = new ProductPage(driver);
        productPage.selectAdvancedPage();
        productPage.selectPriceBounds("20000");
        productPage.setManufacrtur("Samsung");
        productPage.setManufacrtur("LG");
        productPage.checkElementsNumber(12, "Телевизоры");
        productPage.searchingModel("Телевизоры");
        new SearchResultByNamePage(driver).checkTitles(productPage.getFirstResultName());
    }
}
