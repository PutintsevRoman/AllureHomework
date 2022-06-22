package alluretests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;


public class TestBase {

    public String SEARCH_TEXT = "allure2";
    public String ISSUE_TEXT = "Issues";
    public String ISSUE_NUM = "1682";

    @BeforeAll
    static void conf() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.browserSize = "1366x768";
        Configuration.browserPosition = "00x00";
    }

}
