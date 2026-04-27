package com.typicode.jsonplaceholder;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

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
}
