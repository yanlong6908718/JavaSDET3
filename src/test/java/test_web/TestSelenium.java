package test_web;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

public class TestSelenium {
    WebDriver driver;
    TestSelenium ts;

    @Test
    public void testSelenium() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
        //利用chromedriver控制chrome
        Proxy proxy = new Proxy();  //复用浏览器需要设置代理！！！！
        driver = new ChromeDriver(options);
        driver.get("https://work.weixin.qq.com/wework_admin/frame");

//        saveCookie(driver);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(driver.manage().getCookies());
        driver.manage().deleteAllCookies();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        loadCookie(driver);
        driver.get("https://work.weixin.qq.com/wework_admin/frame");
//        try {
//            FileReader fileReader = new FileReader("cookie.txt");
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                StringTokenizer tokenizer = new StringTokenizer(line, ";");
//                String name = tokenizer.nextToken();
//                String value = tokenizer.nextToken();
//                String domain = tokenizer.nextToken();
//                String path = tokenizer.nextToken();
//                Date expiry = null;
//                String dt = tokenizer.nextToken();
//                if (!dt.equals("null")) {
//                    SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
//                    //把 string 转换成 date
//                    expiry = sdf.parse(dt);
//                }
//                //把 string 转换成 boolean
//                boolean isSecure = Boolean.parseBoolean(tokenizer.nextToken());
//                Cookie cookie = new Cookie(name, value, domain, path, expiry, isSecure);
//                driver.manage().addCookie(cookie);
//                Thread.sleep(5000);
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        driver.get("https://work.weixin.qq.com/wework_admin/frame");

//        try {
//            Thread.sleep(15000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(driver.manage().getCookies());
//        try {
//            File file = new File("cookie.txt");
////            FileOutputStream os =new FileOutputStream(file);
//            FileWriter fileWriter = new FileWriter(file);
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//            for (Cookie cookie : driver.manage().getCookies()) {
//                bufferedWriter.write(cookie.getName() + ';' +
//                        cookie.getValue() + ";" +
//                        cookie.getDomain() + ";" +
//                        cookie.getPath() + ";" +
//                        cookie.getExpiry() + ";" +
//                        cookie.isSecure());
//                bufferedWriter.newLine();
//            }
//            bufferedWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        driver.close();

    }
    public static void loadCookie(WebDriver driver) {
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

    public static void saveCookie(WebDriver driver) {
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


}
