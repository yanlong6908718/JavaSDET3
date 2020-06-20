package test.app.xueqiu.page;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class StockPage {
    private AndroidDriver driver;
    private SearchPage searchpage;
    private By oneclict=By.id("com.xueqiu.android:id/subscribe");
    private  By MyStockName=By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView");
    public StockPage(AndroidDriver driver) {
        this.driver=driver;
    }

    public boolean IsAppear(By by){
        if (driver.findElements(by).size()>0){
            return true;
        }else {
            return false;
        }

    }

    public StockPage ClearList(){
        if (IsAppear(By.id("com.xueqiu.android:id/portfolio_stockName"))){
            driver.findElement(By.id("com.xueqiu.android:id/edit_group")).click();
            driver.findElement(By.id("com.xueqiu.android:id/check_all")).click();
            driver.findElement(By.id("com.xueqiu.android:id/cancel_follow")).click();
            driver.findElement(By.id("com.xueqiu.android:id/tv_right")).click();
            driver.findElement(By.id("com.xueqiu.android:id/action_close")).click();
            return this;
        }else{
            return this;
        }

    }

    public StockPage toSearchpage(){
        driver.findElement(By.id("com.xueqiu.android:id/action_search")).click();
        return this;
    }

    public StockPage searchCloes(){
        driver.findElement(By.id("com.xueqiu.android:id/action_close")).click();
        return this;
    }

    public String getoneclictButtenText(){
        return driver.findElement(oneclict).getText();
    }
    public String getMyStockNameText(){
        return driver.findElement(MyStockName).getText();
    }

    public StockPage addStock(String name){
        searchpage =new SearchPage(driver);
        this.searchpage.search(name).clickaddStock();
        return this;
    }


}
