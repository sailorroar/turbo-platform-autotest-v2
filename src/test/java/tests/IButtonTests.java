package tests;

import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import pages.ComCtrl.IButtonPage;
import ru.cbgr.qa.turbo.helpers.NavigateT;
import ru.cbgr.qa.turbo.property.components.ComCtrl;
import ru.cbgr.qa.turbo.service.RetryAnalyzer;

public class IButtonTests extends TestBase {

    IButtonPage iButtonPage = new IButtonPage();

    @Story("Открытие формы IButton")
    @Description("Открытие формы IButton")
    @Test(retryAnalyzer = RetryAnalyzer.class, groups = {"10.5"})
    public void aOpenIButton() {
        NavigateT.OpenForm.ComCtrl(ComCtrl.IButton);
    }


}
