package alluretests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps extends TestBase {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Вводим данные allure2 и переходим к поиску")
    public void startSearch() {
        $("[name=q]").setValue(SEARCH_TEXT).pressEnter();
    }

    @Step("Среди полученных результатов, выбираем первый и проверяем," +
            " что он соотвествует allure2  и переходим в репозиторий")
    public void checkResult() {
        $("ul.repo-list").$$("li").first().find(withText(SEARCH_TEXT)).click();
    }

    @Step("Переходим в Issues")
    public void pageIssue() {
        $("ul.UnderlineNav-body").$$("li").get(1).find(withText(ISSUE_TEXT)).parent().click();
    }

    @Step("Проверяем, наличие на странице Issue с номером 1682")
    public void checkNumber() {
        $("#issue_" + ISSUE_NUM).shouldBe(Condition.visible);
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
