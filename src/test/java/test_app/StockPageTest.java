package test_app;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import test.app.xueqiu.page.Mainpage;
import test.app.xueqiu.page.StockPage;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.*;

class StockPageTest {
    static Mainpage main;
    static StockPage stockpage;
    @BeforeAll
    static void beforell() throws MalformedURLException {
        main=new Mainpage();
        stockpage=main.toStockpage();
    }

    @Test
    @DisplayName("删除自选股")
    void deleteMyStockTest(){
        String s=stockpage.ClearList().getoneclictButtenText();
        assertEquals(s,"一键添加自选");
    }

    @ParameterizedTest
    @DisplayName("添加自选股")
    @ValueSource(strings={"京东","宁德时代","拼多多"})
    void addMyStockTest(String name){
        assertEquals(stockpage.toSearchpage().addStock(name).searchCloes().getMyStockNameText(),name);
    }

    @AfterEach
    public void afterEach(){
//        stockpage.toMainpage();
    }




}