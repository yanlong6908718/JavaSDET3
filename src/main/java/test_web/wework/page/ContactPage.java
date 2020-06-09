package test_web.wework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

public class ContactPage extends BasePage {
    By addMember=By.linkText("添加成员");
    By username=By.name("username");
    By delete=By.linkText("删除");
    By addOther=By.cssSelector("i.member_colLeft_top_addBtn");

    public ContactPage(RemoteWebDriver driver) {
        super(driver);
    }

    public ContactPage adddepatment(){
        click(addOther);
        click(By.cssSelector("a.js_create_party"));
        String js="window.scrollTo(0,0)";
        driver.executeScript(js);
        sendKeys(By.name("name"),"depatment2");
        click(By.xpath("//div[@id='__dialog__MNDialog__']/div/div[2]/div/form/div[3]/a"));
        click(By.xpath("(//a[contains(text(),'longlongtest')])[2]"));
        click(By.xpath("//a[contains(text(),'确定')]"));
        return this;
    };

    public ContactPage deletedepatment(){
        click(By.xpath("//a[contains(text(),'depatment2')]"));
        click(By.xpath("//a[contains(text(),'depatment2')]/span"));
        click(By.xpath("//a[contains(text(),'删除')]"));
//        click(By.cssSelector("li.vakata-context-hover > a"));
//        click(By.xpath("//a[contains(text(),'确定')]"));
        return this;
    }

    public ContactPage addMember(String username, String acctid, String mobile) {
        //todo:
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        new WebDriverWait(MainPage.driver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.visibilityOfElementLocated(addMember));
//        //todo: 就算可点击，仍然有一定的概率是点击不成功的
//        new WebDriverWait(MainPage.driver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.elementToBeClickable(addMember));


        while(driver.findElements(this.username).size()==0){
            click(addMember);
        }

//        driver.findElement(this.username).sendKeys(username);
//        driver.findElement(By.name("acctid")).sendKeys(acctid);
//        driver.findElement(By.name("mobile")).sendKeys(mobile);
//        driver.findElement(By.cssSelector(".js_btn_save")).click();
        sendKeys(this.username, username);
        sendKeys(By.name("acctid"), acctid);
        sendKeys(By.name("mobile"), mobile);
        click(By.cssSelector(".js_btn_save"));
        return this;
    }

    public ContactPage search(String keyword){
        sendKeys(By.id("memberSearchInput"), keyword);
//        driver.findElement(By.id("memberSearchInput")).sendKeys(keyword);
//        new WebDriverWait(driver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.elementToBeClickable(delete));
        return this;
    }

    public String getUserName(){
        return driver.findElement(By.cssSelector(".member_display_cover_detail_name")).getText();
    }

    public ContactPage delete(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(delete);
        click(By.linkText("确认"));
        click(By.id("clearMemberSearchInput"));
//        driver.findElement(delete).click();
//        driver.findElement(By.linkText("确认")).click();
//        driver.findElement(By.id("clearMemberSearchInput")).click();
        return this;

    }

    public ContactPage importFromFile(URL path){
        //todo:
        System.out.println(path.getPath().toString());

        String path_utf="";
        try {
            path_utf=URLDecoder.decode(path.getFile(), "UTF-8");
            System.out.println(path_utf);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        click(By.cssSelector(".ww_operationBar:nth-child(1) .ww_btn_PartDropdown_left"));
        click(By.linkText("文件导入"));
//        click(By.name("file"));
//        sendKeys(By.name("file"), "C:\\fakepath\\通讯录批量导入模板.xlsx");
        upload(By.name("file"), "I:/DATA/Workspace/JavaSDET3/target/classes/importfile.xlsx");  //todo 改成动态获取绝对路径
//        driver.findElement(By.name("file")).sendKeys("/Users/seveniruby/projects/Java3/src/main/resources/通讯录批量导入模板.xlsx");
//        sendKeys(By.name("file"), "C:\\fakepath\\通讯录批量导入模板.xlsx");
        click(By.linkText("确认导入"));
        click(By.linkText("前往查看"));

        return this;
    }
}
