package test_framework;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.net.URL;
import java.util.List;

//自动化领域建模
public class BasePage {
    public void click(){

    }

    public void find(){

    }

    public void send(){

    }

    public void getText(){

    }
    public  void run(){

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
