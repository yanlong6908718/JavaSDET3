package test_framework;

import test.app.wework.page.AppBasePage;
import test_web.wework.page.WebBasePage;

public class UiautoFactory {
    public static BasePage create(String driverName){
        if(driverName=="web"|| driverName=="selenium"){
            return new WebBasePage();
        }if(driverName=="web"|| driverName=="selenium"){
            return new AppBasePage();
        }
        if(driverName=="uiautomator"){
//            return new AppBasePage();
        }if(driverName=="atx"){
//            return new AppBasePage();
        }if(driverName=="macaca"){
//            return new AppBasePage();
        }
        return null;
    }
}
