package test_framework_service;


import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


class ApiObjectModelTest {
    public static ApiObjectModel api;
    @BeforeAll
    static void beforeAll(){
        try {
            api=ApiObjectModel.load("src/main/resources/test_framework_service/wework_api.yaml");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Test
    void load() {
        assertThat(api.name,equalTo("wework"));
    }

    @Test
    void run() {
       Response response =api.methods.get("get_token").run();
        response.then().statusCode(200);
    }
}