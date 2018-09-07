import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;

import java.util.Properties;

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
    public void yandexMarketHeadphonesTest() {
        new MainPage(driver).selectMenuItem("Маркет");
//                .selectMenuItem("Электроника")
//                .chooseCategory("Наушники")
//                .selectAdvancedPage()
//                .selectPriceBounds("5000")
//                .setManufacturer("Beats")
//                .pushAccept()
//                .checkObjectType("Наушники")
//                .checkElementsNumber(22)
//                .searchingModel()
//                .checkTitles();
//    }

//    @Test
//    public void yandexMarketTVTest() {
//        new MainPage(driver).selectMenuItem("Маркет")
//                .selectMenuItem("Электроника")
//                .chooseCategory("Телевизоры")
//                .selectAdvancedPage()
//                .selectPriceBounds("20000")
//                .setManufacturer("Samsung")
//                .setManufacturer("LG")
//                .pushAccept()
//                .checkObjectType("Телевизоры")
//                .checkElementsNumber(48).
//                searchingModel()
//                .checkTitles();
    }
}
