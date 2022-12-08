package ru.cbgr.qa.turbo.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.cbgr.qa.turbo.property.turbo.StandAddress;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Настройки запуска вебдрайвера
 */

@Slf4j
public class WebDriverSetup {

    // переменные окружения, указываются при вызове через командную строку или во кладке maven
    // для более удобной отладки и работе с разных пользований
    /** стенд из mvn -Dstand= или из Jenkins */
    public static final String STAND = System.getProperty("stand", "test");
    /** юзер из mvn -Duser= или из Jenkins */
    public static final String USER = System.getProperty("user", "ltest47");

    /** Единственный экземпляр драйвера, реализует паттерн синглетон */
    protected static RemoteWebDriver remoteWebDriver;

    /** Получение уже созданного экземпляра вебдрайвера.
     * Если нужно обратиться к драйверу, используем этот метод (TestBase.getDriverInstance) */
    public static RemoteWebDriver getDriverInstance() {
        return remoteWebDriver;
    }


    /**
     * Драйвер для локального запуска
     * @return экземпляр настроенного драйвера
     */
    public static RemoteWebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> chromePrefs = new HashMap<>();

        // сохранение скачанных файлов в target/downloads, может пригодиться для проверки скачанных файлов
        chromePrefs.put("download.default_directory", "target");
        chromePrefs.put("download.prompt_for_download", false);

        options.addArguments("--incognito");
        options.setExperimentalOption("prefs", chromePrefs);
        return new ChromeDriver(options);
    }

    /**
     * Драйвер для удаленного запуска Google Chrome. Настроен для использования с Selenoid.
     * @param REMOTE_TYPE переменная для указания средства удаленного запуска
     * @return экземпляр настроенного драйвера
     * @throws MalformedURLException неверный формат url
     */
    public static RemoteWebDriver getRemoteChromeDriver(String REMOTE_TYPE) throws MalformedURLException {
        WebDriverManager.chromedriver().setup();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("screenResolution", "1920x1080x24");

        if (REMOTE_TYPE.equalsIgnoreCase("selenoid")) {
            return new RemoteWebDriver(new URL(StandAddress.REMOTE_SELENOID.getRemoteUrl() +"/wd/hub"), capabilities);
        } else {
            return new RemoteWebDriver(new URL(StandAddress.REMOTE_GRID.getRemoteUrl() +"/wd/hub"), capabilities);
        }
    }
}
