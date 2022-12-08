package ru.cbgr.qa.turbo.helpers;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import ru.cbgr.qa.turbo.driver.WebDriverSetup;
import ru.cbgr.qa.turbo.property.components.MenuButton;
import ru.cbgr.qa.turbo.service.TurboNavigation;

import static org.testng.Assert.assertTrue;
import static ru.cbgr.qa.turbo.driver.WebDriverSetup.getDriverInstance;
import static ru.cbgr.qa.turbo.service.TurboNavigation.isMaskClickable;

public class NavigateT {
    private static final String FORM_NAME_LOCATOR = "//*[contains(@data-name,'%s')]";
    private static final String FORM_MAIN_LOCATOR = "//*[@data-testid='%s']";


    public static class OpenForm {

        @Step("Переход по разделам меню до формы")
        public static void ComCtrl(final Enum<?> formLocators) {
            NavigateT.openTurboPage(MenuButton.Hamburger);
            NavigateT.openTurboPage(MenuButton.TestPlatformComponent);
            NavigateT.openTurboPage(MenuButton.TestingPlatformComponents);
            NavigateT.openTurboPage(MenuButton.ComCtrl);
            NavigateT.getForm(formLocators);
            getDriverInstance()
                    .findElement(By.xpath("//*[@data-testid='HeaderFrame']"))
                    .click();
        }

        @Step("Переход по разделам меню до формы")
        public static void InfoBoardCtrl(final Enum<?> formLocators) {
            NavigateT.openTurboPage(MenuButton.Hamburger);
            NavigateT.openTurboPage(MenuButton.TestPlatformComponent);
            NavigateT.openTurboPage(MenuButton.TestingPlatformComponents);
            NavigateT.openTurboPage(MenuButton.InfoBoardCtrl);
            NavigateT.getForm(formLocators);
            getDriverInstance()
                    .findElement(By.xpath("//*[@data-testid='HeaderFrame']"))
                    .click();
        }

        @Step("Переход по разделам меню до формы")
        public static void CtrlJs(final Enum<?> formLocators) {
            NavigateT.openTurboPage(MenuButton.Hamburger);
            NavigateT.openTurboPage(MenuButton.TestPlatformComponent);
            NavigateT.openTurboPage(MenuButton.TestingPlatformComponents);
            NavigateT.openTurboPage(MenuButton.CtrlJs);
            NavigateT.getForm(formLocators);
            getDriverInstance()
                    .findElement(By.xpath("//*[@data-testid='HeaderFrame']"))
                    .click();
        }

        @Step("Переход по разделам меню до формы")
        public static void AutotestExample(final Enum<?> formLocators) {
            NavigateT.openTurboPage(MenuButton.Hamburger);
            NavigateT.openTurboPage(MenuButton.TestPlatformComponent);
            NavigateT.openTurboPage(MenuButton.TestingPlatformComponents);
            NavigateT.openTurboPage(MenuButton.AutotestExample);
            NavigateT.getForm(formLocators);
            getDriverInstance()
                    .findElement(By.xpath("//*[@data-testid='HeaderFrame']"))
                    .click();
        }

        @Step("Переход по разделам меню до формы")
        public static void ICardForm(final Enum<?> formLocators) {
            NavigateT.openTurboPage(MenuButton.Hamburger);
            NavigateT.openTurboPage(MenuButton.TestPlatformComponent);
            NavigateT.openTurboPage(MenuButton.TestingPlatformComponents);
            NavigateT.openTurboPage(MenuButton.ICardForm);
            NavigateT.getForm(formLocators);
            getDriverInstance()
                    .findElement(By.xpath("//*[@data-testid='HeaderFrame']"))
                    .click();
        }
    }

    public static void openTurboPage(MenuButton formLocators) {
        String locator = String.format(FORM_MAIN_LOCATOR, formLocators.dataTestId);
        while (isMaskClickable()) {
        }
        if (getDriverInstance().findElement(By.xpath(locator)).isDisplayed()) {
            Actions act = new Actions(getDriverInstance());
            act.moveToElement(getDriverInstance().findElement(By.xpath(locator))).build().perform();
        }
        WaitHelper.elementToBeClickable(locator);
        getDriverInstance().findElement(By.xpath(locator)).click();
    }

    public static void getForm(final Enum<?> dataTestId) {
        String locator = String.format(FORM_NAME_LOCATOR, dataTestId.toString());
        while (isMaskClickable()) {
        }
        if (!getDriverInstance().findElement(By.xpath(locator)).isDisplayed()) {
            Actions act = new Actions(getDriverInstance());
            act.moveToElement(getDriverInstance().findElement(By.xpath(locator))).build().perform();
        }
        WaitHelper.elementToBeClickable(locator);
        getDriverInstance().findElement(By.xpath(locator)).click();
    }

    @Step("переход на вкладку {locatorTab}")
    public static void getTab(String locatorTab) {
        while (isMaskClickable()) {
        }
        if (!getDriverInstance().findElement(By.xpath(locatorTab)).isDisplayed()) {
            Actions act = new Actions(getDriverInstance());
            act.moveToElement(getDriverInstance().findElement(By.xpath(locatorTab))).build().perform();
        }
        WaitHelper.elementToBeClickable(locatorTab);
        boolean isPresent = TurboNavigation.isElementPresent(By.xpath(locatorTab));
        assertTrue(isPresent, "Отсутствует вкладка" + locatorTab);
        getDriverInstance().findElement(By.xpath(locatorTab)).click();
    }

}
