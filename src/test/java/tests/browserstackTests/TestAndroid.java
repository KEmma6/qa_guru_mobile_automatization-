package tests.browserstackTests;

import com.codeborne.selenide.Condition;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Test;
import tests.local.TestBase;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class TestAndroid extends TestBase {

    @Test
    public void testWikiLoginPage(){

        step("Открыть меню", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/menu_overflow_button")).click()
        );

        step("Нажать на логин", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/explore_overflow_account_name")).click()
        );

        step("Проверяем, что текст лого виден", () -> {
            $(MobileBy.xpath("//*[@text='Log in to Wikipedia']")).should(Condition.visible);
          });

        step("Проверяем текст кнопки", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/login_button")).shouldHave(Condition.text("Log in"));
        });
    }
}
