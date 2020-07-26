package test_framework_service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class ApiObjectModel {
    public String name;
    public HashMap<String, ApiobjectMethodModel> methods;

    public static ApiObjectModel load(String path) throws IOException {
        ObjectMapper objectmapper=new ObjectMapper(new YAMLFactory());

            return objectmapper.readValue(new File(path),ApiObjectModel.class);

    }

    public void run(ApiobjectMethodModel method){
            method.run();
    }

}
