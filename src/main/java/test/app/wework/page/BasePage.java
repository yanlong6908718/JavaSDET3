package test.app.wework.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.plaf.basic.BasicDesktopIconUI;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public static final int TIME_OUT_IN_SECONDS = 30;
    AppiumDriver<MobileElement> driver;
    WebDriverWait wait;
    String packageName;
    String ActivityName;

    public BasePage(AppiumDriver<MobileElement> driver) {

        this.driver = driver;
        wait=new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

    }

    public BasePage(String packagename,String ActivityName){
        this.packageName=packagename;
        this.ActivityName=ActivityName;
        StartApp(this.packageName,this.ActivityName);
    }


    public void StartApp(String packagename, String ActivityName) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("deviceName", "127.0.0.1:7555");
        desiredCapabilities.setCapability("appPackage", packagename);
        desiredCapabilities.setCapability("appActivity", ActivityName);
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
        wait=new WebDriverWait(driver, TIME_OUT_IN_SECONDS);//3
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

    public MobileElement find(String text){
        return driver.findElement(byText(text));
    }

    public By byText(String text){
        return By.xpath("//*[@text='"+ text +"']");
    }

    public void click(By by){
        //todo: 异常处理
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();
    }

    public void sendKeys(By by, String content){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        driver.findElement(by).sendKeys(content);
    }

}
