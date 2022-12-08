package base;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import ru.cbgr.qa.turbo.driver.WebDriverSetup;
import ru.cbgr.qa.turbo.helpers.WaitHelper;
import ru.cbgr.qa.turbo.property.turbo.StandAddress;
import ru.cbgr.qa.turbo.service.TurboNavigation;

import java.net.MalformedURLException;
import java.time.Duration;

import static pages.LoginPage.checkLoginInSystem;

@Slf4j
public abstract class TestBase extends WebDriverSetup{

    /** запускать удаленно */
    private static final String isREMOTE = System.getProperty("remote", "false");
    /** запустить на чем */
    private static final String REMOTE_TYPE = System.getProperty("r_type" ,"grid");

    @AfterGroups(groups = {"10.5"})
    public void closeTabAfterTestGroup() {
        TurboNavigation.clickWhileCloseTab();
    }

    /** Закрывает открытые вкладки перед выполнением набора тестов и разворачивает окно в полный экран */
    @BeforeClass(groups = {"10.5"})
    public void prepareBrowserBeforeTests() {
        checkLoginInSystem();
        TurboNavigation.clickWhileCloseTab();
        remoteWebDriver.manage().window().maximize();
    }

    /** Инициализация вебдрайвера при запуске */
    @BeforeSuite(groups = {"10.5"})
    public static void setUpDriver() {
        log.info("СОБЫТИЕ: Адрес стенда: > " + StandAddress.getStandUrl(STAND));
        log.info("СОБЫТИЕ: LOGIN FROM ENV > " + USER);

        if (isREMOTE.equalsIgnoreCase("true")) {
            try {
                remoteWebDriver = WebDriverSetup.getRemoteChromeDriver(REMOTE_TYPE);
                log.info("СОБЫТИЕ: ЗАПУСК УДАЛЕННО > " + isREMOTE);
                log.info("СОБЫТИЕ: СРЕДСВО УДАЛЕННОГО ЗАПУСКА > " + REMOTE_TYPE);
            } catch (MalformedURLException e) {
                log.error("Неверный URL!!!");
            }
        } else {
            remoteWebDriver = WebDriverSetup.getChromeDriver();
            log.info("Запуск тестов на локальной машине!");
        }

        WaitHelper.initWait(Duration.ofSeconds(5), Duration.ofMillis(500));
    }

}
