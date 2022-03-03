package configs;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:mobile.properties")
public interface LocalMobileConfig extends Config {

    @Config.Key("platform.name")
    String platformName();

    @Config.Key("device.name")
    String deviceName();

    @Config.Key("os.version")
    String osVersion();
}
