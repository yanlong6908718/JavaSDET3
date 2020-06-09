package test_web.wework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

public class BasePage {
    RemoteWebDriver driver;
    WebDriverWait wait;
    ChromeOptions options;

    public BasePage() {
        options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
        Proxy proxy = new Proxy();  //复用浏览器需要设置代理！！！！
        driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public BasePage(RemoteWebDriver driver) {
        this.driver = driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));

    }


    public void quit() {
        driver.quit();
    }


    public void click(By by){
        //todo: 异常处理
        wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }

    public void sendKeys(By by, String content){
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        driver.findElement(by).sendKeys(content);
    }

    public void upload(By by, String path){
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        driver.findElement(by).sendKeys(path);
    }

    public static void saveCookie(RemoteWebDriver driver) {
        //每次只取一条cookie进行处理
        try {
            Thread.sleep(10000);
            File file = new File("cookie.txt");
//            FileOutputStream os =new FileOutputStream(file);
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Cookie cookie : driver.manage().getCookies()) {
                bufferedWriter.write(cookie.getName() + ';' +
                        cookie.getValue() + ";" +
                        cookie.getDomain() + ";" +
                        cookie.getPath() + ";" +
                        cookie.getExpiry() + ";" +
                        cookie.isSecure());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void loadCookie(RemoteWebDriver driver) {
        try {
            FileReader fileReader = new FileReader("cookie.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, ";");
                String name = tokenizer.nextToken();
                String value = tokenizer.nextToken();
                String domain = tokenizer.nextToken();
                String path = tokenizer.nextToken();
                Date expiry = null;
                String dt = tokenizer.nextToken();
                if (!dt.equals("null")) {
                    SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
                    //把 string 转换成 date
                    expiry = sdf.parse(dt);
                }
                //把 string 转换成 boolean
                boolean isSecure = Boolean.parseBoolean(tokenizer.nextToken());
                Cookie cookie = new Cookie(name, value, domain, path, expiry, isSecure);
                driver.manage().addCookie(cookie);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
