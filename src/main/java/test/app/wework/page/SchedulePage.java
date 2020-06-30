package test.app.wework.page;

import com.fasterxml.jackson.databind.ser.Serializers;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SchedulePage extends BasePage {
    private By taskName=By.id("b58");
    private By save = byText("保存");
    private By taskList=By.id("gr5");
    private By add=By.id("h9p");

    public SchedulePage(AppiumDriver<MobileElement> driver){
        super(driver);
    }


    public SchedulePage 添加(String name, String time){
        click(add);
        sendKeys(taskName,name);
        click(save);
        return this;
    }

    public List<String> 获取今天日程(String day){
        if(day!=null){
            //todo:riqi
        }

        return driver.findElements(taskList).stream().map(x->x.getText()).collect(Collectors.toList());
    }

}
