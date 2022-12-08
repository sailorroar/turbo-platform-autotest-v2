package ru.cbgr.qa.turbo.property.components;

public enum ICardFileExample {

    I_CARD_FILE_EXAMPLE("CardFile", "NWTestExamples_CardFileExampleProps");

    public final String formName;
    public final String dataTestId;

    /** ! возврат data-testid обязателен, по нему происходят переходы по формам  */
    @Override
    public String toString() {
        return dataTestId;
    }

    ICardFileExample(String formName, String dataTestId) {
        this.formName = formName;
        this.dataTestId = dataTestId;
    }
}
