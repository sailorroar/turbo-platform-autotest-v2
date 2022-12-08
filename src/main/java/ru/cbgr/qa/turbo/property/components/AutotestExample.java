package ru.cbgr.qa.turbo.property.components;

/**
 * Константы для открытия форм в разделе Автотестирование (примеры).
 * @author Evgeny Gribanov
 * @link egribanov@cbgr.ru
 * @since 08.07.2022 10:28
 */
public enum AutotestExample {

    // Автотест (примеры)
    ContextError("ContextError", "NWTestExamples_FrmContextError"),
    DialogsTests("DialogsTests", "NWTestExamples_TestDialogs");//Диалоги

    public final String formName;
    public final String dataTestId;

    /** ! возврат data-testid обязателен, по нему происходят переходы по формам  */
    @Override
    public String toString() {
        return dataTestId;
    }

    AutotestExample(String formName, String dataTestId) {
        this.formName = formName;
        this.dataTestId = dataTestId;
    }

    public String getFormName() {
        return formName;
    }
}
