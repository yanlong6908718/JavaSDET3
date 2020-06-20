package test_app;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import sun.applet.Main;
import test.app.xueqiu.page.Mainpage;
import test.app.xueqiu.page.SearchPage;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.*;

class SearchPageTest {
    static Mainpage mainpage;
    static SearchPage searchpage;
    @BeforeAll
    static void beforeAll() throws MalformedURLException {
        mainpage = new Mainpage();
        searchpage=mainpage.toSearchpage();
    }

    @Test
    public void maintest(){
        mainpage.toSearchpage();
    }
    @ParameterizedTest
    @CsvSource({   "alibaba,阿里巴巴","jd,京东" })
    void search(String keyword,String name) {
        assertEquals(searchpage.search(keyword).getSearchList().get(0),name);
    }

    @Test
    void getPrice() {
        assertTrue(searchpage.search("alibaba").getPrice()>200);
    }

    @ParameterizedTest
    @DisplayName("添加自选股")
    @ValueSource(strings={"京东","宁德时代","拼多多"})
    void addStockTest(String name){
        searchpage.search(name).clickaddStock();
    }

}