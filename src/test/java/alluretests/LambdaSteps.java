package alluretests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaSteps extends TestBase {

    @Test
    public void lambdaSteps() {
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });

        step("Вводим данные " + SEARCH_TEXT + " и переходим к поиску", () -> {
            $("[name=q]").setValue(SEARCH_TEXT).pressEnter();
        });

        step("Среди полученных результатов, выбираем первый и проверяем," +
                " что он соотвествует " + SEARCH_TEXT + " и переходим в репозиторий", () -> {
            $("ul.repo-list").$$("li").first().find(withText(SEARCH_TEXT)).click();
        });

        step("Переходим в " + ISSUE_TEXT, () -> {
            $("ul.UnderlineNav-body").$$("li").get(1).find(withText(ISSUE_TEXT)).parent().click();
        });

        step("Проверяем, наличие на странице Issue с номером " + ISSUE_NUM, () -> {
            $("#issue_" + ISSUE_NUM).shouldBe(Condition.visible);
        });
    }
}
