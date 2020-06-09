package test_web.wework.page;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainPageTest {
    MainPage main;
    @Test
    void toContact() throws Exception {
        main=new MainPage();
        main.toContact();
    }
}