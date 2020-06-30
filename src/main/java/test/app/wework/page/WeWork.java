package test.app.wework.page;

import org.openqa.selenium.By;

public class WeWork extends BasePage{
    public WeWork(){
        super("com.tencent.wework",".launch.LaunchSplashActivity");
    }

    public SchedulePage  toSchedulePage(){
        click(By.xpath("//*[@text='日程']"));
        return new SchedulePage(driver);

    }
}
