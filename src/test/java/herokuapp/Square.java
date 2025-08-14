package herokuapp;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

class Square {

    //- Откройте https://the-internet.herokuapp.com/drag_and_drop
    @BeforeAll
    static void openPage() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
    }

    @Test
    void dropingSquaresWithActions() {
        // - Перенесите прямоугольник А на место В
        actions()
                .moveToElement($("#column-a"))
                .clickAndHold()
                .moveToElement($("#column-b"))
                .release()
                .perform();
        // - Проверьте, что прямоугольники действительно поменялись
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
        Selenide.refresh();
    }

    // - В Selenide есть команда $(element).dragAndDrop($(to-element)), проверьте работает ли тест, если использовать её вместо actions()
    @Test
    void dropingSquaresWithDragAndDrop () {
        $("#column-a").dragAndDropTo($("#column-b"));
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
        Selenide.refresh();
    }
}
