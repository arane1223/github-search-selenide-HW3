package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchSelenideWikiTest {
//переменная, содержащая искомый код на GitHub
    public String codeExample = """
            @ExtendWith({SoftAssertsExtension.class})
            class Tests {
              @Test
              void test() {
                Configuration.assertionMode = SOFT;
                open("page.html");
            
                $("#first").should(visible).click();
                $("#second").should(visible).click();
              }
            }
            """;

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
        $("#repo-content-pjax-container").shouldHave(text("Using JUnit5")); //изначальная проверка по заголовку
        $("#repo-content-pjax-container").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})")); //правка, проверка по первой строчке кода
        $("#repo-content-pjax-container").shouldHave(text(codeExample)); //правка, проверка по переменной, содержащей весь код
    }

}

