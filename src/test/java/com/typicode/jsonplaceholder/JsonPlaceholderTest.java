package com.typicode.jsonplaceholder;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class JsonPlaceholderTest {
    private final String API_HOME = "https://jsonplaceholder.typicode.com";

    @Test
    public void testGetPosts() {
        final String POSTS_URL = API_HOME + "/posts";

        given()
        .when()
            .get(POSTS_URL)
        .then()
            .statusCode(200)
            .log().all();
    }

    @Test
    public void testGetPosts1(){
        final String POSTS1_URL = API_HOME +"/posts/1";

        given()
        .when()
                .get(POSTS1_URL)
                .then()
                .statusCode(200);
    }

    @Test
    public void testPatch(){
        final String PATCH_API = API_HOME +"/posts/1";
        final String body  = "{\n" +
                "    \"title\":\"new data\"\n" +
                "}";

        given()
                .header("Content-type", "application/json, charset=UTF-8")
                .body(body)
                .when()
                .patch(PATCH_API)
                .then()
                .statusCode(200)
                .body("title", equalTo("new data"));
    }
}
