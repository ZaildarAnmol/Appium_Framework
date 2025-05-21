package test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

public class BaseTest {
    public static AppiumDriver driver;

    public void getDriver(String platformType) {
        if (platformType == "android") {
            UiAutomator2Options uio = new UiAutomator2Options();
            driver = new AndroidDriver(uio);
        } else if(platformType == "ios") {
            XCUITestOptions ios = new XCUITestOptions();

            driver = new IOSDriver(ios);
        }
    }
}

