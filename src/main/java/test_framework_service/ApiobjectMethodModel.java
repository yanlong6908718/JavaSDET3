package test_framework_service;

import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class ApiobjectMethodModel {
    public String method="get";
    public String url;
    public HashMap<String,Object> query;
    public String save;
    public HashMap<String,Object> json;
    public String post;
    public String get;


    public Response run() {
        return given().log().all().queryParams(query).request(method,url).then().log().all().extract().response();
    }
}
