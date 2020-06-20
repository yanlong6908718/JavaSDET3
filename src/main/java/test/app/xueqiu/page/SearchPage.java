package test.app.xueqiu.page;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchPage {

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
        for(Object element : driver.findElements(nameLocator)){
            namelist.add(((WebElement)element).getText());
        }

        return namelist;
    }

    public SearchPage clickaddStock(){
        for (Object element : driver.findElements(By.xpath("\t\n" +
                "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]"))){
            ((MobileElement)element).click();
        }
        for (Object element : driver.findElements(By.id("com.xueqiu.android:id/follow_btn"))){
            ((MobileElement)element).click();
        }
        return this;
    }


}
