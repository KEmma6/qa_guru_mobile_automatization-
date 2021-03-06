package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:mobile.properties")
public interface MobileConfig extends Config {

    @Key("login")
    String login();

    @Key("password")
    String password();

    @Key("os.versionBS")
    String osVersion();

    @Key("devise")
    String devise();

    @Key("app.browserStack")
    String appBrowserStack();
}

