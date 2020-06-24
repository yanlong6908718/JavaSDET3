package test.app.xueqiu.page;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BasePage {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    public BasePage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public BasePage() {
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

        URL remoteUrl = null;
        try {
            remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait=new WebDriverWait(driver, 10);//3
        /*使用androidstudio要加显示等待不然加载较慢会出问题
        显示等待见帖子
        session-overwrite 复用session防止初始化报错
        * */
    }

    public void quit() {
        driver.quit();
    }

    public MobileElement find(By by){
       return driver.findElement(by);
    }


    public void click(By by){
        //todo: 异常处理
//        wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }

    public void sendKeys(By by, String content){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        driver.findElement(by).sendKeys(content);
    }

}
