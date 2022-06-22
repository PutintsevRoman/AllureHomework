package alluretests;

import org.junit.jupiter.api.Test;

public class PageObjectTest extends TestBase{

    @Test
    public void objectTest(){

        WebSteps webSteps = new WebSteps();

        webSteps.openMainPage();
        webSteps.startSearch();
        webSteps.checkResult();
        webSteps.pageIssue();
        webSteps.checkNumber();
        webSteps.takeScreenshot();
    }
}
