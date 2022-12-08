package pages;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.cbgr.qa.turbo.driver.WebDriverSetup;
import ru.cbgr.qa.turbo.elements.ButtonT;
import ru.cbgr.qa.turbo.elements.CheckBoxT;
import ru.cbgr.qa.turbo.elements.TextFieldT;
import ru.cbgr.qa.turbo.property.turbo.StandAddress;
import ru.cbgr.qa.turbo.service.Attachment;
import ru.cbgr.qa.turbo.service.TurboNavigation;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.util.List;

import static base.TestBase.setUpDriver;

@Slf4j
public class LoginPage extends WebDriverSetup {

    @Name("Поле логин")
    @FindBy(xpath = "//*[@data-testid='user']")
    public TextFieldT loginTextField;

    @Name("Кнопка вход")
    @CacheLookup
    @FindBy(xpath = "//*[@data-testid='button_caption']")
    public ButtonT enterButton;

    @Name("Чек бокс отключить")
    @FindBy(xpath = "//input[contains(@type,'checkbox')]")
    public CheckBoxT disableUserCheckBox;

    @FindBy(xpath = "//span[contains(@data-testid,'button_caption') and contains(text(),'Готово')]")
    public ButtonT chooseUserRoleButton;

    /**
     * Фабрика для иницализации элементов на странице
     * */
    public LoginPage() {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(getDriverInstance())), this);
    }

    public static void clickToLoginInAuthPage(String LOGIN) {
        LoginPage loginPage = new LoginPage();

        loginPage.loginTextField
                .clickT()
                .sendKeysT(LOGIN);

        loginPage.enterButton
                .clickT();

        while (TurboNavigation.isMaskClickable()) {}

        if (isElementFoundDisplayedEnabled(By.xpath("//*/div[contains(text(),'Отключить пользователя и продолжить')]"))) {

            loginPage.disableUserCheckBox
                    .enableCheckBox("Отключить пользователя и продолжить");

            loginPage.enterButton
                    .clickT();
            while (TurboNavigation.isMaskClickable()) {}
        }

//        loginPage.chooseUserRoleButton
//                .click("Кнопка \"Готово\"");
    }

    /** Если элемент отображается и чекбокс не нажат, вернуть true, иначе false */
    private static boolean isElementFoundDisplayedEnabled(By by) {
        try {
            List<WebElement> e = getDriverInstance().findElements(by);
            return !e.isEmpty() && e.get(e.size() - 1).isDisplayed() && e.get(e.size() - 1).isEnabled();
        } catch (Exception ignored) {}
        return false;
    }

    @Step("Проверка что вход в систему произведен")
    public static void checkLoginInSystem() {
        String currentUrl = getDriverInstance().getCurrentUrl();
        // если драйвер отсутствует запустить заново
        if (getDriverInstance() == null) setUpDriver();
        else getDriverInstance().navigate().refresh();
        // !! без этой проверки страница не открывается
        if (!currentUrl.contains("/workspace")) login();
    }

    @Step("Вход в систему")
    protected static void login() {
        log.info("СОБЫТИЕ: LOGIN FROM ENV* -> " + USER);
        getDriverInstance().get(StandAddress.getStandUrl(STAND));
        Attachment.getAllureEnvironment();
        clickToLoginInAuthPage(USER);
    }

}
