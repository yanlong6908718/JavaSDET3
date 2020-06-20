package test.app.xueqiu.page;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class StockPage {
    private AndroidDriver driver;
    private SearchPage searchpage;
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
        }
        return this;
    }

    public StockPage toSearchpage(){
        driver.findElement(By.id("com.xueqiu.android:id/action_search")).click();

        return this;
    }

    public String getButtenText(){
//        driver.findElement();
        return "buttentest";
    }

    public void addStock(String name){
        searchpage=new SearchPage(driver);
        searchpage.search(name).clickaddStock();


    }


}
