package pages.ComCtrl;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.cbgr.qa.turbo.driver.WebDriverSetup;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class IButtonPage extends WebDriverSetup {

    @FindBy(xpath = "//*[@data-testid='SwitchButton']")
    private Button stickyButton;

    public IButtonPage() {
        PageFactory
                .initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(getDriverInstance())), this);
    }



}
