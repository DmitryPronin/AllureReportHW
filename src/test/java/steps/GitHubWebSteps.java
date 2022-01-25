package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHubWebSteps {

    @Step("Открыть главную страницу")
    public void openMainPage(){
        open("https://github.com");
    }

    @Step("Найти репозиторий")
    public void searchForRepository(String repository){
        $(".header-search-input").setValue(repository).pressEnter();
    }

    @Step("кликнуть на ссылку репозитория")
    public void openRepositoryPage(String repository){
        $(By.linkText(repository)).click();
    }

    @Step("кликнуть на таб Issues")
    public void openIssuesTab(){
        $(By.partialLinkText("Isues")).click();
    }

    @Step("Проверить видимость")
    public void checkVisibilityOfNumberIssue(){
        $(withText("#68")).shouldHave(visible);
    }
}
