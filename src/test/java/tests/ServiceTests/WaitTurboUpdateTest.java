package tests.ServiceTests;

import base.TestBase;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.cbgr.qa.turbo.helpers.WaitHelper;
import ru.cbgr.qa.turbo.service.ErrorTestListener;

@Listeners(ErrorTestListener.class)
@Feature("WaitUpdate")
@Story("Ожидание завершения обновления турбо")
public class WaitTurboUpdateTest extends TestBase {
    static Logger log = LoggerFactory.getLogger(WaitTurboUpdateTest.class);

    @Test(groups = {"10.5"})
    public void waitTurboUpdate() {
        log.info("Задкржка перед выполнением тестов, ожидание завершения обновления (для Jenkins)");
        WaitHelper.littleWait(60000);
    }
}
