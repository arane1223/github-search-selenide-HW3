package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchSelenideWikiTest {

    @Test
    void SearchWikiTest() {

        //- Откройте страницу Selenide в Github
        open("https://github.com");
        $(".search-input").click();
        $("#query-builder-test").setValue("selenide").pressEnter();
        $("[href='/selenide/selenide']").click();

        // - Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();

        // - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-body").shouldHave(text("Soft assertions"));

        // - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $("#wiki-body").$(byText("Soft assertions")).click();
        $("#repo-content-pjax-container").shouldHave(text("Using JUnit5"));
        $("#repo-content-pjax-container").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})"));
    }

}

