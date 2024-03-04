package config;
import org.aeonbits.owner.Config;

@Config.Sources(
        "classpath:emulator.properties"
)
public interface EmulatorConfig extends Config {

    @Config.Key("deviceName")
    @Config.DefaultValue("Pixel_3a_API_34_extension_level_7_x86_64")
    String getDeviceName();

    @Config.Key("platformVersion")
    @Config.DefaultValue("12.0")
    String getPlatformVersion();

    @Config.Key("appPackage")
    @Config.DefaultValue("com.pinterest")
    String appPackage();

    @Config.Key("appActivity")
    @Config.DefaultValue("com.pinterest.activity.PinterestActivity")
    String appActivity();

    @Config.Key("serverUrl")
    @Config.DefaultValue("http://localhost:4723/wd/hub")
    String serverUrl();
}
