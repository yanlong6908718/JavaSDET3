package test.app.wework.page;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SchedulePageTest {
    private static WeWork we;

    @BeforeAll
    static void beforeAll(){
        we = new WeWork();
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void 添加() {
        assertTrue(we.toSchedulePage().添加("打卡",null).获取今天日程(null).contains("打卡"));
    }

    @Test
    void 获取今天日程() {
    }
}