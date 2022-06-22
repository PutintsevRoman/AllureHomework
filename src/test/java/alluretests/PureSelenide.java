package alluretests;


import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PureSelenide extends TestBase{

   @Test
    public void cleanTest(){

        open("https://github.com");
       $("[name=q]").setValue(SEARCH_TEXT).pressEnter();
       $("ul.repo-list").$$("li").first().find(withText(SEARCH_TEXT)).click();
       $("ul.UnderlineNav-body").$$("li").get(1).find(withText(ISSUE_TEXT)).parent().click();
       $("#issue_"+ISSUE_NUM).shouldBe(Condition.visible);
   }

}
