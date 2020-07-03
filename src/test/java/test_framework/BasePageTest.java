package test_framework;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasePageTest {
    static BasePage basepage;
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
        UIauto auto=basepage.load(this.getClass().getResource("D:\\workspace\\JavaSDET3\\src\\main\\resources\\uiauto\\uiauto.yaml").getPath());
        ObjectMapper mapper= new ObjectMapper();
        try {
            System.out.println(mapper.writeValueAsString(auto));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}