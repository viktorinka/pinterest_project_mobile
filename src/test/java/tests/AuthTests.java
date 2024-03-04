package tests;

import com.codeborne.selenide.Condition;
import helpers.TestData;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static io.appium.java_client.AppiumBy.xpath;
import static io.qameta.allure.Allure.step;

@Epic("Mobile")
@Feature("Auth Page")
public class AuthTests extends TestBase {

    @Tag("browserstack")
    @Test
    @DisplayName("Successful authorization")
    void successfulAuthTest() {
        step("Field email", () -> {
            $(id("com.pinterest:id/email_address")).sendKeys(TestData.email);
            $(id("com.pinterest:id/continue_email_bt")).click();
            $(id("com.pinterest:id/password")).sendKeys(TestData.password);
            $(id("com.pinterest:id/login_bt")).click();
        });

        step("Verify avatar", () ->
                $(id("com.pinterest:id/profile_menu_view")).shouldBe(Condition.visible));
    }

    @Tag("browserstack")
    @Test
    @DisplayName("Unsuccessful authorization with empty email")
    void authWithEmptyEmail() {
        step("Click continue button", () ->
                $(id("com.pinterest:id/continue_email_bt")).click());

        step("Verify error", () ->
                $(xpath("//android.widget.TextView[@text='Please enter your email']"))
                        .shouldHave(text("Please enter your email")));
    }

    @Test
    @DisplayName("Unsuccessful authorization with empty password")
    void authWithEmptyPassword() {
        step("Field only email", () -> {
            $(id("com.pinterest:id/email_address")).sendKeys(TestData.email);
            $(id("com.pinterest:id/continue_email_bt")).click();
            $(id("com.pinterest:id/login_bt")).click();
        });

        step("Verify error", () ->
                $(id("com.pinterest:id/system_message")).shouldHave(text("Please enter password")));
    }
}