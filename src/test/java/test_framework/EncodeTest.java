package test_framework;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class EncodeTest {
    @Test
    void ceshiren(){
        given().get("https://ceshiren.com/categories.json")
                .then().log().all().body("category_list.categories[0].name",equalTo("霍格沃兹测试学院公众号"));

    }

    @Test
    void ceshiren_row(){
        given().filter((req,res,ctx)->{
            return ctx.next(req,res);
        })
                .get("https://ceshiren.com/categories.json")
                .then().body("category_list.categories[0].name",equalTo("霍格沃兹测试学院公众号"));

    }

}
