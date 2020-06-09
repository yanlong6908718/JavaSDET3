package test_web.wework.page;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactPageTest {
    MainPage main;
    ContactPage ca;
    @Test
    void adddepatment() {
        try {
            main=new MainPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
        main.toContact().adddepatment();
    }
}