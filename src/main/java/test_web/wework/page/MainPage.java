package test_web.wework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class MainPage extends BasePage{

    public MainPage() throws Exception {
        super();

        String url = "https://work.weixin.qq.com/wework_admin/frame";

        driver.get(url);
        driver.manage().deleteAllCookies();

        //todo: 改成从文件读取
        Thread.sleep(3000);
//        saveCookie(driver);  // 每次测试前先使用saveCookie，过程中扫码登陆
        loadCookie(driver);     //获取到cookie当天使用不会过期
        System.out.println(driver.manage().getCookies());
        driver.get(url);

    }

    public ContactPage toContact() {
        //todo:
        click(By.cssSelector("#menu_contacts"));
        return new ContactPage(driver);
    }

}
