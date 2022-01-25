import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import steps.GitHubWebSteps;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class SelenideGitHubStepTest {
    private static final String SEARCH_REPOSITORY = "eroshenkoam/allure-example";


    @Test
    void checkIssuesTest(){
        step("Открыть главную страницу", () -> open("https://github.com"));

        step("Найти репозиторий " + SEARCH_REPOSITORY + " и нажать Enter", () ->{
            $(".header-search-input").setValue(SEARCH_REPOSITORY).pressEnter();
        });

        step("кликнуть на ссылку репозитория", () -> {
            $(By.linkText(SEARCH_REPOSITORY)).click();
        });

        step("кликнуть на \"Issues\"", () -> {
            $(By.partialLinkText("Isues")).click();
        });

        step("Проверить наличие на странице №68", () -> {
            $(withText("#68")).shouldHave(visible);
        });
    }

    @Test
    void checkIssueTestWithAnnotationsSteps(){
        GitHubWebSteps gitHubWebSteps = new GitHubWebSteps();
        gitHubWebSteps.openMainPage();
        gitHubWebSteps.searchForRepository(SEARCH_REPOSITORY);
        gitHubWebSteps.openRepositoryPage(SEARCH_REPOSITORY);
        gitHubWebSteps.openIssuesTab();
        gitHubWebSteps.checkVisibilityOfNumberIssue();
    }

}
