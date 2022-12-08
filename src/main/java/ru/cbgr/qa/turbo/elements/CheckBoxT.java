package ru.cbgr.qa.turbo.elements;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Slf4j
public class CheckBoxT extends HtmlElement {

    @Step("Поставить галочку в чек бокс '{name}'")
    public CheckBoxT enableCheckBox(String name) {
        if(checkboxValidation() == 0) {
            getWrappedElement().click();
            log.info("Поставить галочку в чек бокс " + name);
            return this;
        }else if(checkboxValidation() == 1) {
            return this;
        } else {
            return this;
        }
    }

    @Step("Убрать галочку из чек бокса '{name}'")
    public CheckBoxT disableCheckBox(String name) {
        if(checkboxValidation() == 0) {
            return this;
        }else if(checkboxValidation() == 1) {
            getWrappedElement().click();
            log.info("Убрать галочку из чек бокса " + name);
            return this;
        } else {
            return this;
        }
    }

    public int checkboxValidation() {
        if(getWrappedElement().getAttribute("data-is-checked").equalsIgnoreCase("false")) {
            return 0;
        } else if (getWrappedElement().getAttribute("data-is-checked").equalsIgnoreCase("true")) {
            return 1;
        } else {
            return 2;
        }
    }

}
