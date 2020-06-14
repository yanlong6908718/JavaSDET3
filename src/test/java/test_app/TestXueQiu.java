package test_app;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

public class TestXueQiu {

    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("deviceName", "127.0.0.1:7555");
        desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
        desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
        desiredCapabilities.setCapability("noReset", "true");
        desiredCapabilities.setCapability("skipDeviceInitialization", "true");
        desiredCapabilities.setCapability("skipLogcatCapture", "true");
        desiredCapabilities.setCapability("skipServerInstallation", "true");
//        desiredCapabilities.setCapability("dontStopAppOnReset", "true");  //复用app，不杀掉

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void sampleTest() {
//        List<MobileElement> els1 = (MobileElement) driver.findElementsById("com.xueqiu.android:id/action_close");
//        List<MobileElement> els2 = (MobileElement) driver.findElementsById("\t\ncom.xueqiu.android:id/action_close");
//        List<MobileElement> els3 = (MobileElement) driver.findElementsById("com.xueqiu.android:id/search_input_text");
//        List<MobileElement> els4 = (MobileElement) driver.findElementsById("com.xueqiu.android:id/action_close");
//        List<MobileElement> els5 = (MobileElement) driver.findElementsById("com.xueqiu.android:id/action_close");
        MobileElement el2 = (MobileElement) driver.findElementById("com.xueqiu.android:id/home_search");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementById("com.xueqiu.android:id/search_input_text");
        el3.sendKeys("阿里巴巴");
        MobileElement el4 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]");
        el4.click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}


