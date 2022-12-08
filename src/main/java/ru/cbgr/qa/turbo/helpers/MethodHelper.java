package ru.cbgr.qa.turbo.helpers;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.cbgr.qa.turbo.service.TurboNavigation;

import static ru.cbgr.qa.turbo.driver.WebDriverSetup.getDriverInstance;

@Slf4j
public class MethodHelper {

    // получение значения атрибута {searchedAttribute}
    public static String getElementCssProperty(By elementLocator, String searchedAttribute) {
        while (TurboNavigation.isMaskClickable()) {}
        WaitHelper.presenceOfElementLocated(elementLocator);
        WaitHelper.elementToBeClickable(elementLocator);
        return getDriverInstance().findElement(elementLocator).getCssValue(searchedAttribute);
    }

    // получение значения атрибута {searchedAttribute}
    public static boolean isCssPropertyEmpty(By elementLocator, String searchedAttribute) {
        while (TurboNavigation.isMaskClickable()) {}
        WaitHelper.presenceOfElementLocated(elementLocator);
        WaitHelper.elementToBeClickable(elementLocator);
//        log.info(getDriverInstance().findElement(elementLocator).getCssValue(searchedAttribute));
        return getDriverInstance().findElement(elementLocator).getCssValue(searchedAttribute).isEmpty();
    }

    // получение значения атрибута {searchedAttribute}
    public static String getElementAttributeProperty(By elementLocator, String searchedAttribute) {
        while (TurboNavigation.isMaskClickable()) {}
        WaitHelper.presenceOfElementLocated(elementLocator);
        WaitHelper.elementToBeClickable(elementLocator);
        return getDriverInstance().findElement(elementLocator).getAttribute(searchedAttribute);
    }

    // Получаем текст из инф. поля
    public static String getElementTextValue(String locatorInfo) {
        while (TurboNavigation.isMaskClickable()) {}
        WaitHelper.presenceOfElementLocated(By.xpath(locatorInfo));
        WaitHelper.elementToBeClickable(locatorInfo);
        return getDriverInstance().findElement(By.xpath(locatorInfo)).getText();
    }

    // Получаем текст из инф. поля
    public static String getElementTextValue(By locatorInfo) {
        while (TurboNavigation.isMaskClickable()) {}
        WaitHelper.presenceOfElementLocated(locatorInfo);
        WaitHelper.elementToBeClickable(locatorInfo);
        return getDriverInstance().findElement(locatorInfo).getText();
    }

    // Получить количество элементов
    public static int getNumberOfElements(String locator) {
        while (TurboNavigation.isMaskClickable()) {}
        WaitHelper.presenceOfElementLocated(By.xpath(locator));
        return getDriverInstance().findElements(By.xpath(locator)).size();
    }

    // получить вебэлемент по локатору
    public static WebElement getWebElement(String locator) {
        return getDriverInstance().findElement(By.xpath(locator));
    }

    /** Получить высоту элемента
     * @param locator - локатор элемента
     * @return значение высоты в int */
    public static int getHeightOfElement(By locator) {
        return getDriverInstance().findElement(locator).getRect().getHeight();
    }

    public static int getCSSValueAsInt(By locator, String CSS) {
        String getElementHeightAsString = MethodHelper.getElementCssProperty(locator, CSS);
//        log.info("Значение атрибута " + CSS + ": " + getElementHeightAsString);
        return Integer.parseInt(getElementHeightAsString.replaceAll("[^0-9]",""));
    }
}
