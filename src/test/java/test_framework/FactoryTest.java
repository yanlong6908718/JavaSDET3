package test_framework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FactoryTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void create() {
        BasePage web= UiautoFactory.create("web");
       UIauto auto= web.load("/uiauto/webauto.yaml");
       web.run(auto);
    }
}