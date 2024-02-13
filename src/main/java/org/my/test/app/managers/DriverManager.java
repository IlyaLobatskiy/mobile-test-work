package org.my.test.app.managers;

import io.appium.java_client.android.AndroidDriver;
import org.my.test.app.utils.PropConst;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Класс построен на основе паттерна синглтон.
 * Создает единственный экземпляр драйвера.
 */

public class DriverManager {

    private WebDriver driver = null;
    private static DriverManager INSTANCE = null;
    private final TestPropManager testPropManager = TestPropManager.getTestPropManager();

    private DriverManager() {
    }

    public static DriverManager getDriverManager() {
        if (INSTANCE == null) {
            INSTANCE = new DriverManager();
        }
        return INSTANCE;
    }

    private URL getUrl() {

        try {
            return new URL(testPropManager
                    .getProperty(PropConst.BASE_URL));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }


    public WebDriver getDriver() {
        if (driver == null) {

            DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setCapability("platformName", testPropManager.getProperty(PropConst.PLATFORM_NAME));
            capabilities.setCapability("appium:deviceName", testPropManager.getProperty(PropConst.DEVICE_NAME));
            capabilities.setCapability("appium:automationName", testPropManager.getProperty(PropConst.AUTOMATION_NAME));
            capabilities.setCapability("appium:platformVersion", testPropManager.getProperty(PropConst.PLATFORM_VERSION));
            capabilities.setCapability("appium:appPackage", testPropManager.getProperty(PropConst.APP_PACKAGE));
            capabilities.setCapability("appium:appActivity", testPropManager.getProperty(PropConst.APP_ACTIVITY));
            capabilities.setCapability("appium:app", testPropManager.getProperty(PropConst.APP));
            capabilities.setCapability("appium:fullReset", Boolean.parseBoolean(testPropManager.getProperty(PropConst.FULL_RESET)));

            driver = new AndroidDriver(getUrl(), capabilities);

        }

        return driver;
    }

    public void quitDriver() {
        driver.quit();
    }
}
