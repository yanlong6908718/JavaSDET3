package test_web.wework;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestWeWork {
    @Test
    void chrome(){

        String url="https://work.weixin.qq.com/wework_admin/frame";
//        FirefoxDriver driver=new FirefoxDriver();
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
        Proxy proxy = new Proxy();  //复用浏览器需要设置代理！！！！
        ChromeDriver driver=new ChromeDriver(options);
        driver.get(url);
        System.out.println(driver.manage().getCookies());
        System.out.println("*************************************");
        driver.manage().deleteAllCookies();

        driver.manage().addCookie(new Cookie("wwrtx.sid", "02hlx0WXpVh2ZztCiIJBeQ0MQzz9fZIQlx8ielHWU9DxyM9_zWwRBJ_zACLHO690"));
        driver.manage().addCookie(new Cookie("wwrtx.d2st", "a4040958"));
        // wwrtx.vst 其他地点登陆会更新？只要更新此值？
        driver.manage().addCookie(new Cookie("wwrtx.vst", "-8EpAf3G1CJafwiMVg5mODrsa96LThMheBdMum7ULFMz6DjFU6ixoHFf9InmUPHPMeDD0ns_E0Ib1p66AnhY-8VUYcGVdrI5vsBK8QVvnQHExGq2SsddUg--ntYnYCFRfRCMadxmfooJLBaKUORbSNG7AyjmyMIxKK1qKILRGsswyQUrAnUO_W8l0mSedgKOBcl7LwihxjIDz1Wo_Qr6kRP-UaoHwideNjGlVuzB-Y8CAUVHOpCTaAJ9jAiODUERuunYApJJCZMobX4DonvFuA"));
        driver.manage().addCookie(new Cookie("wwrtx.vid.i18n_lan", "1688851965426755"));
        driver.manage().addCookie(new Cookie("wxpay.vid", "1688851965426755"));
        driver.manage().addCookie(new Cookie("wxpay.corpid", "1970325124070292"));
        driver.manage().addCookie(new Cookie("wwrtx.logined", "true"));
        driver.manage().addCookie(new Cookie("_gid", "GA1.2.2124626530.1591584095"));
        driver.manage().addCookie(new Cookie("ww_rtkey", "6277251008"));
        driver.manage().addCookie(new Cookie("Hm_lpvt_9364e629af24cb52acc78b43e8c9f77d", "1591437995"));
        driver.manage().addCookie(new Cookie("wwrtx.refid", "3708976912481540"));
        driver.manage().addCookie(new Cookie("wwrtx.ltype", "1"));
        driver.manage().addCookie(new Cookie("Hm_lvt_9364e629af24cb52acc78b43e8c9f77d", "1591108754,1591198781,1591432229"));
        driver.manage().addCookie(new Cookie("wwrtx.ref", "sites"));
        driver.manage().addCookie(new Cookie("pac_uid", "0_1c66335ec0e11"));
        driver.manage().addCookie(new Cookie("aq_base_sid", "QrJih6IpbQAEzOG9wRqwvao37aEliWSZ"));
        driver.manage().addCookie(new Cookie("_ga", "GA1.2.633767832.1591584095"));
        driver.manage().addCookie(new Cookie("XWINDEXGREY", "0"));
        driver.manage().addCookie(new Cookie("wwrtx.i18n_lan", "zh"));
        driver.manage().addCookie(new Cookie("_gat", "1"));

                System.out.println(driver.manage().getCookies());
        driver.get(url);

    }
}
