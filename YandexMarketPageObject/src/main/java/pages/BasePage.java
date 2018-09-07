package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;

    public void waitUntilElementIsVisible (WebElement el, int sec){
        WebDriverWait wait = new WebDriverWait(driver, sec);
        wait.until(ExpectedConditions.visibilityOf(el));
    }

    /**
     * Нажать кнопку
     * @param webElement - элемент на который нужно нажать
     */
    public void clickButton(WebElement webElement) {
        webElement.click();
    }

}
