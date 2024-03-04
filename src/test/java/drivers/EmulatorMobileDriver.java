package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.EmulatorConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;

public class EmulatorMobileDriver implements WebDriverProvider {

    public static EmulatorConfig emulatorConfig = ConfigFactory.create(EmulatorConfig.class, System.getProperties());

    public static URL getAppiumServerUrl() {
        try {
            return new URL(emulatorConfig.serverUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);

        options.setAutomationName(ANDROID_UIAUTOMATOR2)

                .setPlatformName(ANDROID)
                .setDeviceName(emulatorConfig.getDeviceName())
                .setPlatformVersion(emulatorConfig.getPlatformVersion())
                .setApp(getApk().getAbsolutePath())
                .setAppPackage(emulatorConfig.appPackage())
                .setAppActivity(emulatorConfig.appActivity());


        return new AndroidDriver(getAppiumServerUrl(), options);
    }

    private File getApk() {
        return new File("src/test/resources/apps/pinterest-12-7-0.apk");
    }
}
