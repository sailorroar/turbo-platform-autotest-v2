package ru.cbgr.qa.turbo.helpers;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.cbgr.qa.turbo.driver.WebDriverSetup;

import java.time.Duration;

import static ru.cbgr.qa.turbo.driver.WebDriverSetup.getDriverInstance;

@Slf4j
public class WaitHelper {

    protected static WebDriverWait wait;

    /** Установка таймаута ожидания и интервал опроса */
    public static void initWait(Duration timeOut, Duration sleep) {
        wait = new WebDriverWait(getDriverInstance(), timeOut, sleep);
    }

    /** Ожидание наличия элемента по локатору */
    public static void presenceOfElementLocated(By webElement) {
        wait.until(ExpectedConditions.presenceOfElementLocated(webElement));
    }

    /** Ожидание появления текста в элементе */
    public static void presenceOfTextInElement(WebElement webElement, String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(webElement, text));
    }

    /** Ожидание появления текста в элементе */
    public static boolean isPresenceOfTextInElement(By locator, String text) {
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    /** Ожидание кликабельности элемента по локатору */
    public static void elementToBeClickable(By webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    /** Ожидание кликабельности элемента по локатору */
    public static void elementToBeClickable(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    /** Ожидание кликабельности элемента по локатору */
    public static void elementToBeClickable(String locator) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }

    /** Ожидание видимости элемента */
    public static void visibilityOfElement(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    /** Ожидание видимости элемента по локатору */
    public static void visibilityOfElementLocated(By webElement) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(webElement));
    }

    /** Ожидание видимости элемента по локатору */
    public static void visibilityOfAllElementLocated(By webElement) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(webElement));
    }

    public static boolean isElementDisplayed(By webElement) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(webElement)).isDisplayed();
    }

    public static boolean isInvisibilityOfElement(By webElement) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(webElement));
    }

    public static boolean isAttributeContainsText(By webElement, String attribute, String text) {
        return wait.until(ExpectedConditions.attributeContains(webElement, attribute, text));
    }


    public static void littleWait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException  e) {
//            log.error("Явно указанное ожидание завершилось аварийно!");
        }
    }
}
