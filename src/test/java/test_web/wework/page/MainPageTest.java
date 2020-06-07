package test_web.wework.page;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainPageTest {
    static MainPage main;
    @Test
    void toContact() {
        main=new MainPage();
        main.toContact();
    }
}