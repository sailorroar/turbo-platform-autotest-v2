package ru.cbgr.qa.turbo.property.components;

/**
 * Константы для навигации по основным меню.
 * @author Evgeny Gribanov
 * @link egribanov@cbgr.ru
 * @since 08.07.2022 10:28
 */
public enum MenuButton {
  // основная навигация
  Header("Header", "HeaderFrame"),
  Hamburger("Заходим в основное меню - Бутерброд", "main-menu-button"),
  TestPlatformComponent("Tecт компонентов платформы", "main-menu_item_Module"),
  TestingPlatformComponents("Тестирование компонентов платформы", "main-menu_item_ATMPanelsNativeWebPanel_Test"),

  // категории компонентов
  ComCtrl("ComCtrl", "main-menu_item_OpenNWTestComCtrl"),
  InfoBoardCtrl("InfoBoardCtrl", "main-menu_item_OpenNWTestInfoBoardCtrl"),
  CtrlJs("InfoBoardCtrl", "main-menu_item_OpenNWTestComCtrlJs"),
  AutotestExample("AutotestExample", "main-menu_item_Group1"),
  ICardForm("ICardForm", "main-menu_item_OpenNWTestExamplesICardForm");

  public final String formName;
  public final String dataTestId;

  // ! возврат data-testid обязателен, по нему происходят переходы по формам
  @Override
  public String toString() {
    return formName;
  }

  MenuButton(String formName, String dataTestId) {
    this.formName = formName;
    this.dataTestId = dataTestId;
  }

  public String getFormName() {
    return formName;
  }
}
