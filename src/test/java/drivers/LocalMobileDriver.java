package drivers;

import com.codeborne.selenide.WebDriverProvider;
import configs.LocalMobileConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static utils.FileUtils.getAbsolutePath;

public class LocalMobileDriver implements WebDriverProvider {

    LocalMobileConfig mobileConfig = ConfigFactory.create(LocalMobileConfig.class, System.getProperties());

    public static URL getBrowserstackUrl() {
        try {
            return new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        desiredCapabilities.setCapability("platformName", mobileConfig.platformName());
        desiredCapabilities.setCapability("deviceName", mobileConfig.deviceName());
      //  desiredCapabilities.setCapability("deviceName", "RFCR90ZMNQP");
        desiredCapabilities.setCapability("version", mobileConfig.osVersion());
        desiredCapabilities.setCapability("locale", "en");
        desiredCapabilities.setCapability("language", "en");
        desiredCapabilities.setCapability("appPackage", "org.wikipedia.alpha");
        desiredCapabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
        desiredCapabilities.setCapability("app",
                getAbsolutePath("src/test/resources/wiki_apk/app-alpha-universal-release.apk"));

        return new AndroidDriver(getBrowserstackUrl(), desiredCapabilities);
    }

}
