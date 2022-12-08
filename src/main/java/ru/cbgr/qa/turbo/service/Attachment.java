package ru.cbgr.qa.turbo.service;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.cbgr.qa.turbo.helpers.MethodHelper;
import ru.cbgr.qa.turbo.property.turbo.StandAddress;

import java.nio.charset.StandardCharsets;

import static ru.cbgr.qa.turbo.driver.WebDriverSetup.STAND;
import static ru.cbgr.qa.turbo.driver.WebDriverSetup.USER;
import static ru.cbgr.qa.turbo.driver.WebDriverSetup.getDriverInstance;
import static ru.cbgr.qa.turbo.service.AllureEnvironmentWriter.allureEnvironmentWriter;

@SuppressWarnings("UnusedReturnValue")
public class Attachment {
    /** прикрепляет текстовое сообщение в отчет */
    @io.qameta.allure.Attachment(value = "{attachName}", type = "text/plain")
    public static String attachAsText(String attachName, String message) {
        return message;
    }

    /** прикрепляет скриншот в отчет */
    @io.qameta.allure.Attachment(value = "{attachName}", type = "image/png")
    public static byte[] attachScreenshot(String attachName) {
        return ((TakesScreenshot) getDriverInstance()).getScreenshotAs(OutputType.BYTES);
    }

    /** прикрепляет исходный код страницы в отчет */
    @io.qameta.allure.Attachment(value = "Page source", type = "text/html")
    public static byte[] attachPageSource() {
        return getDriverInstance().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    /** прикрепляет окружение в отчет */
    public static void getAllureEnvironment() {
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", getDriverInstance().getCapabilities().getBrowserName().toUpperCase())
                        .put("Version", getDriverInstance().getCapabilities().getBrowserVersion())
                        .put("Stand", STAND.toUpperCase())
                        .put("Stand URL", StandAddress.getStandUrl(STAND))
                        .put("Stand VERSION", MethodHelper.getElementTextValue(By.xpath("//div[contains(@class,'version')]")))
                        .put("User", USER.toUpperCase())
                        .build());
    }
}
