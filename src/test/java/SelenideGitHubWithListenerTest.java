import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideGitHubWithListenerTest extends BaseTest{

    @Test
    void checkIssuesTest(){
        open("https://github.com");

        $(".header-search-input").setValue("eroshenkoam/allure-example").pressEnter();
        $(By.linkText("eroshenkoam/allure-example")).click();
        $(By.partialLinkText("Isues")).click();

        $(withText("#68")).shouldHave(visible);
    }

}
