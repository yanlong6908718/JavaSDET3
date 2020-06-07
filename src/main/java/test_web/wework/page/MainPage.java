package test_web.wework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class MainPage extends BasePage{

    public MainPage() {
        super();
//        System.setProperty("webdriver.gecko.driver", "/Users/seveniruby/ke/java_3/selenium/drivers/geckodriver");

        String url = "https://work.weixin.qq.com/wework_admin/frame";
//        FirefoxDriver driver=new FirefoxDriver();
        driver.get(url);
        driver.manage().deleteAllCookies();

        //todo: 改成从文件读取

        driver.manage().addCookie(new Cookie("wwrtx.sid", "02hlx0WXpVh2ZztCiIJBeTuCnmev4BfIp-FduzQK_G2NfBfdaf3Het1O0uBnNs35"));
        driver.manage().addCookie(new Cookie("wwrtx.d2st", "a5487463"));
        driver.manage().addCookie(new Cookie("wwrtx.sid", "02hlx0WXpVh2ZztCiIJBeaMdFlfh6nMuPOEQTlBFiLjID0x_vARfF_N489O2rAhJ"));
        driver.manage().addCookie(new Cookie("wwrtx.d2st", "a5487463"));
        // wwrtx.vst 其他地点登陆会更新？
        driver.manage().addCookie(new Cookie("wwrtx.vst", "tiF8TP0KcFzLMiNG8Ym1mnKo0XGg9_KJHY9alx4NBq8vZmoZvIz81yqw_XITb6L1-jHrENXBnQyGPFnVALijZh5gjknN_jBOdJOuaAUJG8LFWA933_2EIarxH7SKPhJKO8FpUw-YP_LeRWNdLQMHEog8WekuAhV-Ir55OD63hjZ2-aEGnQHKk0S5Kf5EqTvacbRYzMXiCJj8kEeUR9S8Hk6nJ9PWg5jL-QdJIcdWH4wzqQb_efnxGbDvljYefEKIK4Sdju0eyNvotCxfm952dg"));
        driver.manage().addCookie(new Cookie("wwrtx.vid.i18n_lan", "1688851965426755"));
        driver.manage().addCookie(new Cookie("wxpay.vid", "1688851965426755"));
        driver.manage().addCookie(new Cookie("wxpay.corpid", "1970325124070292"));
        driver.manage().addCookie(new Cookie("wwrtx.logined", "true"));
        driver.manage().addCookie(new Cookie("_gid", "GA1.2.921619848.1591432230"));
        driver.manage().addCookie(new Cookie("ww_rtkey", "8252170436"));
        driver.manage().addCookie(new Cookie("Hm_lpvt_9364e629af24cb52acc78b43e8c9f77d", "1591437995"));
        driver.manage().addCookie(new Cookie("wwrtx.refid", "4226465975182730"));
        driver.manage().addCookie(new Cookie("wwrtx.ltype", "1"));
        driver.manage().addCookie(new Cookie("Hm_lvt_9364e629af24cb52acc78b43e8c9f77d", "1591108754,1591198781,1591432229"));
        driver.manage().addCookie(new Cookie("wwrtx.ref", "true"));
        driver.manage().addCookie(new Cookie("wwrtx.logined", "direct"));
        driver.manage().addCookie(new Cookie("pac_uid", "0_1c66335ec0e11"));
        driver.manage().addCookie(new Cookie("aq_base_sid", "Gk5IEa7QWlyFUQYnXyLsG9r8QabXX9SZ"));
        driver.manage().addCookie(new Cookie("_ga", "GA1.2.1079772318.1591108759"));
        driver.manage().addCookie(new Cookie("XWINDEXGREY", "0"));
        driver.manage().addCookie(new Cookie("wwrtx.i18n_lan", "zh"));        driver.manage().addCookie(new Cookie("wwrtx.vid.i18n_lan", "1688851965426755"));
        driver.manage().addCookie(new Cookie("wxpay.vid", "1688851965426755"));
        driver.manage().addCookie(new Cookie("wxpay.corpid", "1970325124070292"));
        driver.manage().addCookie(new Cookie("wwrtx.logined", "true"));
        driver.manage().addCookie(new Cookie("_gid", "GA1.2.921619848.1591432230"));
        driver.manage().addCookie(new Cookie("ww_rtkey", "8252170436"));
        driver.manage().addCookie(new Cookie("Hm_lpvt_9364e629af24cb52acc78b43e8c9f77d", "1591437995"));
        driver.manage().addCookie(new Cookie("wwrtx.refid", "4226465975182730"));
        driver.manage().addCookie(new Cookie("wwrtx.ltype", "1"));
        driver.manage().addCookie(new Cookie("Hm_lvt_9364e629af24cb52acc78b43e8c9f77d", "1591108754,1591198781,1591432229"));
        driver.manage().addCookie(new Cookie("wwrtx.ref", "true"));
        driver.manage().addCookie(new Cookie("wwrtx.logined", "direct"));
        driver.manage().addCookie(new Cookie("pac_uid", "0_1c66335ec0e11"));
        driver.manage().addCookie(new Cookie("aq_base_sid", "Gk5IEa7QWlyFUQYnXyLsG9r8QabXX9SZ"));
        driver.manage().addCookie(new Cookie("_ga", "GA1.2.1079772318.1591108759"));
        driver.manage().addCookie(new Cookie("XWINDEXGREY", "0"));
        driver.manage().addCookie(new Cookie("wwrtx.i18n_lan", "zh"));

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
