package ru.cbgr.qa.turbo.property.components;

/**
 * Константы для открытия форм в разделе Com. Ctrl.
 * @author Evgeny Gribanov
 * @link egribanov@cbgr.ru
 * @since 08.07.2022 10:28
 */
public enum ComCtrl {

    // Com.Ctrl
    Header("Header", "HeaderFrame"),
    IBox("IBox", "NWTestComCtrl_FrmIBox"),
    IButton("IButton", "NWTestComCtrl_FrmIButton"),
    IChart("IChart", "NWTestComCtrl_FrmIChart"),
    ICheckBox("ICheckBox", "NWTestComCtrl_FrmICheckBox"),
    IClassesTree("IClassesTree", "NWTestComCtrl_FrmIClassesTree"),
    IColorEdit("IColorEdit", "NWTestComCtrl_FrmIColorEdit"),
    IColumnsGroup("IColumnsGroup", "NWTestComCtrl_FrmIColumnsGroup"),
    IEdit("IEdit", "NWTestComCtrl_FrmIEdit"),
    IEditEx("IEditEx", "NWTestComCtrl_FrmIEditEx"),
    IFrame("IFrame", "NWTestComCtrl_FrmIFrame"),
    IGroup("IGroup", "NWTestComCtrl_FrmIGroup"),
    IHeader("IHeader", "NWTestComCtrl_FrmIHeader"),
    IJSControlIE("IJSControl", "NWTestComCtrl_FrmIJSControl"),
    IJSControlEdge("IJSControl (Edge)", "NWTestComCtrl_FrmIJSControl_Edge"),
    IJumpButton("IJumpButton", "NWTestComCtrl_FrmIJumpButton"),
    IListButton("IListButton", "NWTestComCtrl_FrmIListButton"),
    IListEdit("IListEdit", "NWTestComCtrl_FrmIListEdit"),
    IPicture("IPicture", "NWTestComCtrl_FrmIPicture"),
    IStatic("IStatic", "NWTestComCtrl_FrmIStatic"),
    IComponentTree("IComponentTree", "NWTestComCtrl_FrmIComponentTree"),
    IBrowser("IBrowser", "NWTestComCtrl_FrmIBrowser"),
    IPasswordEdit("IPasswordEdit", "NWTestComCtrl_FrmIPasswordEdit"),
    IGrid("IGrid", "NWTestComCtrl_FrmIGrid"),
    INode("INode", "NWTestComCtrl_FrmINode"),
    ITable("ITable", "NWTestComCtrl_FrmITable"),
    IReportFrame("IReportFrame", "NWTestComCtrl_FrmIReportFrame"),
    IAxis("Chart.IAxis", "NWTestComCtrl_FrmIAxis"),
    IPopupMenu("IPopupMenu", "NWTestComCtrl_FrmIPopupMenu"),
    ICardTree("ICardTree", "NWTestComCtrl_FrmICardTree"),
    ICardFile("ICardFile", "NWTestComCtrl_FrmICardFile");

    public final String formName;
    public final String dataTestId;

    // ! возврат data-testid обязателен, по нему происходят переходы по формам
    @Override
    public String toString() {
        return formName;
    }

    ComCtrl(String formName, String dataTestId) {
        this.formName = formName;
        this.dataTestId = dataTestId;
    }

    public String getFormName() {
        return formName;
    }

}
