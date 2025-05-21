package android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AppiumDemo {

    AppiumDriverLocalService service;

    @BeforeTest
    public void startUp() {
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress ("127.0.0.1").usingPort (4723).build();
        service.start();
    }

    @AfterTest
    public void stop() {
        service.stop();
    }

    @Test
    public void launchApp() throws MalformedURLException {
        UiAutomator2Options uio = new UiAutomator2Options();
        uio.setAppActivity("'.activities.MainActivity");
        uio.setAppPackage("com.solodroid.solomerce");
        uio.setPlatformVersion("14");
        uio.setPlatformName("android");
        uio.setDeviceName("emulator-5554");
        URL url = new URL("http://127.0.0.1:4723");

        AndroidDriver driver = new AndroidDriver(url, uio);
        System.out.println("App launched");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
}
