package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackDriver;
import drivers.EmulatorMobileDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {
    public static String deviceHost = System.getProperty("deviceHost");

    @BeforeAll
    public static void setup() {
        if (deviceHost == null) {
            deviceHost = "emulator";
        }

        switch (deviceHost) {
            case "emulator":
                Configuration.browser = EmulatorMobileDriver.class.getName();
                break;
            case "browserstack":
                Configuration.browser = BrowserstackDriver.class.getName();
                break;
        }
        Configuration.browserSize = null;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void afterEach() {
        String sessionId = sessionId().toString();

        Attach.pageSource();

        closeWebDriver();

        if (deviceHost.equals("browserstack")) {
            Attach.addVideo(sessionId);
        }
    }
}