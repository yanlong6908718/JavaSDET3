package test.app.xueqiu.page;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchPage {
    /*elements:
    评论框下次再说：com.xueqiu.android:id/tv_left  立即评价：com.xueqiu.android:id/tv_right
    搜索取消：com.xueqiu.android:id/action_close
    自选股列表：com.xueqiu.android:id/portfolio_stockName
    编辑自选股id：com.xueqiu.android:id/edit_group
    全选resource-id：com.xueqiu.android:id/check_all
    删除按钮id：com.xueqiu.android:id/cancel_follow

    * */

    private AndroidDriver driver;
    private By nameLocator=By.id("name");
    public SearchPage(AndroidDriver driver) {
        this.driver=driver;
    }

    public SearchPage search(String keyword){
        MobileElement el3 = (MobileElement) driver.findElementById("com.xueqiu.android:id/search_input_text");
        el3.sendKeys(keyword);
        return this;
    }
    public double getPrice(){

        MobileElement el4 = (MobileElement) driver.findElement(nameLocator);
        el4.click();
        return Double.valueOf(driver.findElement(By.id("current_price")).getText());
    }
    public List<String> getSearchList(){
        List<String> namelist=new ArrayList<>();
        for(Object element:driver.findElements(nameLocator)){
            namelist.add(((WebElement)element).getText());
        }

        return namelist;
    }
}
