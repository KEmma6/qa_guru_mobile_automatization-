package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    public static URL getBrowserstackUrl() {
        try {
            return new URL("http://hub.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        desiredCapabilities.setCapability("browserstack.user", "emmaemma4");
        desiredCapabilities.setCapability("browserstack.key", "bnMmMKgR4jNSBtp8LXjo");

        desiredCapabilities.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");

        desiredCapabilities.setCapability("device", "Google Pixel 3");
        desiredCapabilities.setCapability("os_version", "9.0");

        desiredCapabilities.setCapability("project", "First Java Project");
        desiredCapabilities.setCapability("build", "browserstack-build-1");
        desiredCapabilities.setCapability("name", "first_test");

        return new AndroidDriver(getBrowserstackUrl(), desiredCapabilities);
    }

}