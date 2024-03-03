package core;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetRequest {
    //Returns response by given path
    public static Response getResponse(String path) {
        return given().get(path);
    }

    //Returns response
    public static Response getResponse() {
        return given().get();
    }

}
