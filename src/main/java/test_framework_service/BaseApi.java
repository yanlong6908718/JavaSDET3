package test_framework_service;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseApi {
    List<ApiObjectModel> apis=new ArrayList<>();
    public void load(String dir){
        Arrays.stream(new File(dir).list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                //todo:filter
                return true;
            }
        })).forEach(path-> {
            try {
                apis.add(ApiObjectModel.load(dir+"/"+path));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
    public void run(String name,String action){
        apis.stream().filter(api->api.name.equals(name)).forEach(api->{api.methods.get(action).run();
    });

    }

}
