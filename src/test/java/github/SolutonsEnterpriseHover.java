package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SolutonsEnterpriseHover {
    //На главной странице GitHub выберите: Меню -> Solutions -> Enterprize (с помощью команды hover для Solutions). Убедитесь, что загрузилась нужная страница (например, что заголовок: "The AI-powered developer platform.").
    @Test
    void hoverTest() {
        open("https://github.com/");
        $(byText("Solutions")).hover();
        $(byText("Enterprises")).click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform"));
    }
}
