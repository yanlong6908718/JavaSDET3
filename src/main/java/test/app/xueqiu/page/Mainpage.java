package test.app.xueqiu.page;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
public class Mainpage {
    /*elements:
       评论框下次再说：com.xueqiu.android:id/tv_left  立即评价：com.xueqiu.android:id/tv_right
       搜索取消：com.xueqiu.android:id/action_close
       自选股列表：com.xueqiu.android:id/portfolio_stockName
       编辑自选股id：com.xueqiu.android:id/edit_group
       全选resource-id：com.xueqiu.android:id/check_all
       删除按钮id：com.xueqiu.android:id/cancel_follow
       进入列表resource-id：com.xueqiu.android:id/tab_icon
       * */
    private AndroidDriver driver;
    public Mainpage()throws MalformedURLException {
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


    public SearchPage toSearchpage(){
        MobileElement el2 = (MobileElement) driver.findElementById("com.xueqiu.android:id/home_search");
        el2.click();
        return new SearchPage(driver);
    }

   public StockPage toStockpage(){
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TabHost/android.widget.LinearLayout/android.widget.TabWidget/android.widget.RelativeLayout[2]")).click();
        return new StockPage(driver);
    }

}
