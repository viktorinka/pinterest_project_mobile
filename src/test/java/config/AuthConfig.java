package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:auth.properties"
})

public interface AuthConfig extends Config {
    @Key("email")
    String email();

    @Key("password")
    String password();
}
