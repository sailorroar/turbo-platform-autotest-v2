package ru.cbgr.qa.turbo.service;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.cbgr.qa.turbo.helpers.WaitHelper;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.time.Duration;

import static ru.cbgr.qa.turbo.driver.WebDriverSetup.getDriverInstance;

public class TurboNavigation {

    public TurboNavigation(WebDriver driver) {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }

    private static final String CLOSE_TAB_BUTTON_LOCATOR = "//*/span[@data-testid='tab-bar__tab-icon']";
    public static final String INDICATOR_LOCATOR = "//*[@id='indicator']/div";
    public static final String LEFT_ARROW_LOCATOR = "//*[@data-testid='button' and @data-nav='prev']";

    // отсутствие маски на элементе, нужна перед взаимодействиями с элементами и ассертами
    // маска присутствует во время обновления состояния элемента
    public static boolean isMaskClickable() {
        return isClickable(By.xpath(INDICATOR_LOCATOR));
    }

    public static boolean isClickable(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriverInstance(), Duration.ofSeconds(1), Duration.ofMillis(50));
            wait.until(ExpectedConditions.elementToBeClickable(by));
            return true;
        } catch (Exception ignore) {
            return false;
        }
    }

    @Step("Нажимать на стрелочку (в лево) в вверхнем левом углу на уровне открытых табов до её исчезновения")
    public static void clickLeftArrow() {
        while (isClickable(By.xpath(LEFT_ARROW_LOCATOR))) {
            WaitHelper.elementToBeClickable(LEFT_ARROW_LOCATOR);
            getDriverInstance().findElement(By.xpath(LEFT_ARROW_LOCATOR)).click();
        }
    }

    @Step("Закрыть все открытые табы")
    public static void clickWhileCloseTab() {
        while (isElementPresent(By.xpath(CLOSE_TAB_BUTTON_LOCATOR))) {
            clickLeftArrow();
            WaitHelper.elementToBeClickable(By.xpath(CLOSE_TAB_BUTTON_LOCATOR));
            getDriverInstance().findElement(By.xpath(CLOSE_TAB_BUTTON_LOCATOR)).click();
        }
    }

    public static boolean isElementPresent(By by) {
        try {
            while (isMaskClickable()) {}
            getDriverInstance().findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
