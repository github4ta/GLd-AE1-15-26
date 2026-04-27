package com.typicode.placeholder;

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
    public void testGetPostsByUserId() {
        final String POSTS_URL = API_HOME + "/posts/10";

        given()
                .when()
                    .get(POSTS_URL)
                .then()
                    .statusCode(200)
                .log().all();
    }

    @Test
    public void testGetPostsComments() {
        final String POSTS_URL = API_HOME + "/posts/1/comments";

        given()
                .when()
                .get(POSTS_URL)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void testGetCommentsByPostId() {
        final String POSTS_URL = API_HOME + "/comments?postId=1";

        given()
                .when()
                    .get(POSTS_URL)
                .then()
                    .statusCode(200)
                    .log().all();
    }

    @Test
    public void testPatchPosts() {
        final String PATCH_URL = API_HOME + "/posts/1";
        final String body = "{\n" +
                "\"title\": \"foo\"\n" +
                "}";

        given()
                .header("Content-Type", "application/json; charset=UTF-8")
                    .body(body)
                .when()
                    .patch(PATCH_URL)
                .then()
                    .statusCode(200)
                    .body("title", equalTo("foo"))
                .log().all();
    }
}
