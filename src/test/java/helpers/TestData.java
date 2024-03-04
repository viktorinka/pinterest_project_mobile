package helpers;

import config.AuthConfig;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;
import static org.aeonbits.owner.ConfigFactory.create;

public class TestData {
    private static final AuthConfig authConfig = create(AuthConfig.class, System.getProperties());

    final public static String email = authConfig.email(),
            password = authConfig.password();

    public void successfulAuth() {
        step("successfulAuth", () -> {
            $(id("com.pinterest:id/email_address")).sendKeys(email);
            $(id("com.pinterest:id/continue_email_bt")).click();
            $(id("com.pinterest:id/password")).sendKeys(TestData.password);
            $(id("com.pinterest:id/login_bt")).click();
        });
    }
}


