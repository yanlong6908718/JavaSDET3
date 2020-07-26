package test_framework;

import org.junit.jupiter.api.Test;

public class WebTest {
    @Test
    void classic(){
        BasePage web=UiautoFactory.create("web");
        UIauto uIauto=web.load("/uiauto/webauto.yaml");
        web.run(uIauto);
    }
}
