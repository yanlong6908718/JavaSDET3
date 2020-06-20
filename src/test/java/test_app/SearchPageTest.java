package test_app;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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


}