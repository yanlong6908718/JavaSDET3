package test_framework;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasePageTest {
    private static BasePage basepage;
    @BeforeAll
    static void befforeAll() {
        basepage= new BasePage();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void click() {
    }

    @Test
    void find() {
    }

    @Test
    void send() {
    }

    @Test
    void getText() {
    }

    @Test
    void run() {
    }

    @Test
    void load() {
//        String path=this.getClass().getResource("D:\\workspace\\JavaSDET3\\src\\main\\resources\\uiauto\\uiauto.yaml").getPath();
//        System.out.println(path);
        UIauto auto=basepage.load("/uiauto/uiauto.yaml");
        ObjectMapper mapper= new ObjectMapper();
        try {
            System.out.println(mapper.writeValueAsString(auto));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}