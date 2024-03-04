package config;
import org.aeonbits.owner.Config;
@Config.Sources(
        "classpath:browserstack.properties"
)
public interface BrowserstackConfig extends Config {

    @Key("browserstack.user")
    String getUser();

    @Key("browserstack.key")
    String getKey();

    @Key("appUrl")
    @DefaultValue("bs://b4f275c5f321e50dd29506be10a4c8f85b983d35")
    String getAppUrl();

    @Key("device")
    @DefaultValue("Google Pixel 4")
    String getDevice();

    @Key("os_version")
    @DefaultValue("11.0")
    String getOsVersion();

    @Key("remoteUrl")
    @DefaultValue("https://hub.browserstack.com/wd/hub")
    String getRemoteUrl();
}