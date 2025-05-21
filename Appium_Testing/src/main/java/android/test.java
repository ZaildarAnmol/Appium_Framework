package android;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

public class test {
    public static void main(String[] args) throws MalformedURLException {

        UiAutomator2Options uio = new UiAutomator2Options();
        uio.setApp("/Users/anmolsingh/Downloads/Solodroid_E-CommerceApp Demo_3.2.0.apk");
        uio.setPlatformVersion ("13");
        uio.setPlatformName("android");
        uio. setDeviceName ("adb-R58N348JWCX-EDPOfe._adb-tls-connect._tcp.");
        URL url = new URL("http://127.0.0.1:4723");

        AndroidDriver driver = new AndroidDriver(url, uio);
        System.out.println("App launched");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(AppiumBy
                .xpath("(//android.widget.TextView[@resource-id='com.solodroid.solomerce:id/productname'])[1]")).click();
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH,"0");
        Sequence s = new Sequence(finger,0);
        s.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), 884,1160))
                .addAction (finger.createPointerDown(0))
                .addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), 50,1160))
                .addAction(finger.createPointerUp(0));
        driver.perform(Arrays.asList(s));
    }
}
