package ru.cbgr.qa.turbo.elements;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import ru.cbgr.qa.turbo.helpers.WaitHelper;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Slf4j
public class ButtonT extends HtmlElement {

    public ButtonT clickT() {
        Allure.step("Клик на кнопку " + getName());
        WaitHelper.elementToBeClickable(getWrappedElement());
        getWrappedElement().click();
        log.info("Клик на кнопку -> ");
        return this;
    }
}
