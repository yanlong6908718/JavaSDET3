package test_app;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.app.xueqiu.page.Mainpage;
import test.app.xueqiu.page.StockPage;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.*;

class StockPageTest {
    static Mainpage main;
    static StockPage stockpage;
    @BeforeAll
    static void beforeall() throws MalformedURLException {
        main=new Mainpage();
        stockpage=main.toStockpage();
    }

    @Test
    void maintest(){
        stockpage.ClearList().toSearchpage().addStock("京东");
    }





}