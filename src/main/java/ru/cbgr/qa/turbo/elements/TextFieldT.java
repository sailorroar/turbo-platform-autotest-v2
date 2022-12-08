package ru.cbgr.qa.turbo.elements;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.interactions.Actions;
import ru.cbgr.qa.turbo.helpers.WaitHelper;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import static ru.cbgr.qa.turbo.driver.WebDriverSetup.getDriverInstance;

@Slf4j
public class TextFieldT extends HtmlElement {

    public TextFieldT clickT() {
        Allure.step("Клик на текстовое поле " + getName());
        WaitHelper.elementToBeClickable(getWrappedElement());
        getWrappedElement().click();
        log.info("Клик на текстовое поле -> ");
        return this;
    }

    public TextFieldT sendKeysT(String text) {
        Allure.step("Ввод '" + text + "' в текстовое поле " + getName());
        getWrappedElement().sendKeys(text);
        log.info("Ввод текста " + text + " в текстовое поле -> ");
        return this;
    }
}
