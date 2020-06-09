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
//        saveCookie(driver);
        loadCookie(driver);
//        driver.manage().addCookie(new Cookie("wwrtx.sid", "02hlx0WXpVh2ZztCiIJBeQ0MQzz9fZIQlx8ielHWU9DxyM9_zWwRBJ_zACLHO690"));
//        driver.manage().addCookie(new Cookie("wwrtx.d2st", "a4040958"));
//        // wwrtx.vst 其他地点登陆会更新？只要更新此值？
//        driver.manage().addCookie(new Cookie("wwrtx.vst", "GbwU60e5hWk_vWYxOXmWRzTFtGynguLOT3JYz3BGZG0teR7wGZ337scM7wiu3CTJVKRQXxEIEA84sknhyb8WcjZy37PaKeqUFsJJVRShnsKv7oObb0vkOqtgmn5DCKhBiuSOjQk2c1pg0z2W6OgAGZfWVGW9vul6kzuY-L4gc-s1pi-iA1Ras5o8kwf62_e3AJlN3b9YIMX9_REcYKHK-HydCZoyxn4idviL0MO-AwoQWsZtKz3JHL0IAQxzx3mhNSshIUa1fpaNmqN0CYo0WA"));
//        driver.manage().addCookie(new Cookie("wwrtx.vid.i18n_lan", "1688851965426755"));
//        driver.manage().addCookie(new Cookie("wxpay.vid", "1688851965426755"));
//        driver.manage().addCookie(new Cookie("wxpay.corpid", "1970325124070292"));
//        driver.manage().addCookie(new Cookie("wwrtx.logined", "true"));
//        driver.manage().addCookie(new Cookie("_gid", "GA1.2.2124626530.1591584095"));
//        driver.manage().addCookie(new Cookie("ww_rtkey", "6277251008"));
//        driver.manage().addCookie(new Cookie("Hm_lpvt_9364e629af24cb52acc78b43e8c9f77d", "1591437995"));
//        driver.manage().addCookie(new Cookie("wwrtx.refid", "3708976912481540"));
//        driver.manage().addCookie(new Cookie("wwrtx.ltype", "1"));
//        driver.manage().addCookie(new Cookie("Hm_lvt_9364e629af24cb52acc78b43e8c9f77d", "1591108754,1591198781,1591432229"));
//        driver.manage().addCookie(new Cookie("wwrtx.ref", "sites"));
//        driver.manage().addCookie(new Cookie("pac_uid", "0_1c66335ec0e11"));
//        driver.manage().addCookie(new Cookie("aq_base_sid", "QrJih6IpbQAEzOG9wRqwvao37aEliWSZ"));
//        driver.manage().addCookie(new Cookie("_ga", "GA1.2.633767832.1591584095"));
//        driver.manage().addCookie(new Cookie("XWINDEXGREY", "0"));
//        driver.manage().addCookie(new Cookie("wwrtx.i18n_lan", "zh"));
//        driver.manage().addCookie(new Cookie("_gat", "1"));

        System.out.println(driver.manage().getCookies());
        driver.get(url);

    }

    public ContactPage toContact() {
        //todo:
        click(By.cssSelector("#menu_contacts"));
//        driver.findElement(By.cssSelector("#menu_contacts")).click();
        return new ContactPage(driver);
    }

}
