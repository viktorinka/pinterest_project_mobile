package tests;

import com.codeborne.selenide.Condition;
import helpers.TestData;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.className;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.xpath;

@Epic("Mobile")
@Feature("Home Actions Page")
public class HomeActionsTests extends TestBase {
    TestData testData = new TestData();

    @Test
    @DisplayName("Search profile")
    void searchProfileTest() {
        testData.successfulAuth();
        step("Set value and search profile", () -> {
            $(accessibilityId("Search, Tab")).shouldBe(visible, Duration.ofSeconds(6)).click();
            $(AppiumBy.id("com.pinterest:id/search_tv")).click();
            $(AppiumBy.id("com.pinterest:id/view_search_bar_input")).sendKeys("kitty");
            $(xpath("//android.widget.LinearLayout[@content-desc=\"User profile for Hello Kitty, hellokitty\"]/android.widget.LinearLayout")).click();
        });

        step("Verify page", () -> {
            $(AppiumBy.id("com.pinterest:id/username_view")).shouldHave(text("hellokitty"));
            $(AppiumBy.id("com.pinterest:id/full_name")).shouldHave(text("Hello Kitty"));
        });
    }

    @Test
    @DisplayName("Add like reaction")
    void addLikeReactionTest() {
        testData.successfulAuth();
        step("Open pin", () ->
                $(AppiumBy.id("com.pinterest:id/simple_exoplayer_view")).shouldBe(visible, Duration.ofSeconds(5)).click());

        step("Click like pin", () -> {
            $(accessibilityId("Comments")).click();
            $(accessibilityId("Add comment reaction")).shouldBe(visible).click();
        });

        step("Verify like reaction", () ->
                $(accessibilityId("Love")).shouldBe(Condition.visible));
    }

    @Test
    @DisplayName("Update feed")
    void updateFeedTest() {

        final String[] oldState = {null};
        final String[] newState = {null};

        testData.successfulAuth();

        step("Old state feed", () -> {
            oldState[0] = $$(className("android.view.View")).first().shouldBe(visible).getAttribute("content-desc");
        });

        step("Click update feed", () ->
                $(accessibilityId("Home, Tab")).click());

        step("New state feed", () -> {
            newState[0] = $$(className("android.view.View")).first().shouldBe(visible).getAttribute("content-desc");
        });

        step("Verify feed", () ->
                Assertions.assertNotEquals(oldState, newState));
    }
}