package ru.cbgr.qa.turbo.property.components;

/**
 * @author Evgeny Gribanov
 * @link egribanov@cbgr.ru
 * @since 08.07.2022 10:14
 */
public enum InfoBoardCtrl {

    // InfoBoard.Ctrl
    JKanban("JKanban", "NWTestInfoboardCtrl_FrmJKanban"),
    JscGant("JscGant", "NWTestInfoboardCtrl_FrmJscGantt"),
    JDiagram("JDiagram", "NWTestComCtrlJs_FrmJDiagram");

    public final String formName;
    public final String dataTestId;

    // ! возврат data-testid обязателен, по нему происходят переходы по формам
    @Override
    public String toString() {
        return formName;
    }

    InfoBoardCtrl(String formName, String dataTestId) {
        this.formName = formName;
        this.dataTestId = dataTestId;
    }

    public String getFormName() {
        return formName;
    }
}
