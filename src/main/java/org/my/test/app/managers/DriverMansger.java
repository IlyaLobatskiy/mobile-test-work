package org.my.test.app.managers;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverMansger {

    private WebDriver driver = null;

    private static DriverMansger INSTANCE = null;
    private final TestPropManager testPropManager = TestPropManager.getTestPropManager();

    private DriverMansger(){
    }

    public static DriverMansger getDriverManager(){
        if(INSTANCE == null){
            INSTANCE = new DriverMansger();
        }
        return INSTANCE;
    }

    private URL getUrl(){

        try {
            return new URL(testPropManager.getProperty("base.url"));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }

    public WebDriver getDriver() {
        if (driver == null){
            DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("appium:deviceName", "emulator-5554");
            capabilities.setCapability("appium:automationName", "UiAutomator2");
            capabilities.setCapability("appium:platformVersion", "11");
            capabilities.setCapability("appium:appPackage", "com.example.login");
            capabilities.setCapability("appium:appActivity", ".ui.login.LoginActivity");
            capabilities.setCapability("appium:app", "C:/Users/lobatskiy.i/qwe/src/main/resources/app/login.apk");
            capabilities.setCapability("appium:fullReset", true);

            driver = new AndroidDriver(getUrl(), capabilities);

        }

        return driver;
    }

    public void quitDriver(){
        driver.quit();
    }
}
