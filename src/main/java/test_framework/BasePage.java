package test_framework;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

//自动化领域建模
public class BasePage {
    public void click(HashMap<String, Object> map){
        System.out.println("click");
        System.out.println(map);
    }

    public void sendkeys(HashMap<String, Object> map){

    }

    public void action(HashMap<String, Object> map){

    }

    public void find(){

    }

    public void send(){

    }

    public void getText(){

    }
    public  void run(UIauto auto){
        auto.steps.stream().forEach(m ->{
//            if(m.keySet().contains("click")){
//                click((HashMap<String,Object>) m.get("click"));
//            }

            if(m.containsKey("click")){
                HashMap<String ,Object> by =(HashMap<String ,Object>) m.get("click");
                click(by);
            }
            if (m.containsKey("sendkeys")){
                sendkeys(m);
            }
            if (m.containsKey("action")){
                action(m);
            }

        });

    }

    public UIauto load(String path){
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        UIauto auto=null;
        try {
            auto=mapper.readValue(
                BasePage.class.getResourceAsStream(path),
                UIauto.class
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return auto;
    }

}
