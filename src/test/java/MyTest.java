import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class MyTest {

    private static String payload = "{\"isbn\":\"11111\",\"title\":\"automation\",\"author\":{\"firstname\":\"oana\",\"lastname\":\"rusu\"}}";
    private static String emptyPayload = "{}";
    private static String incorrectPayload = "{\"description\":\"wrong\",\"title\":\"this is not correct\"}";

    @Test
    public void test_verifyPostRequestCorrectPayload() {
        RestAssured.baseURI = "https://glacial-chamber-83122.herokuapp.com";
        given()
                .contentType(ContentType.JSON)
                .body(payload)
                .post("/api/books")
                .then()
                .statusCode(200);
    }

    @Test
    public void test_verifyPostRequestIncorrectPayload() {
        RestAssured.baseURI = "https://glacial-chamber-83122.herokuapp.com";
        given()
                .contentType(ContentType.JSON)
                .body(incorrectPayload)
                .post("/api/books")
                .then()
                .statusCode(200);
    }

    @Test
    public void test_verifyPostRequestEmptyPayload() {
        RestAssured.baseURI = "https://glacial-chamber-83122.herokuapp.com";
        given()
                .contentType(ContentType.JSON)
                .body(emptyPayload)
                .post("/api/books")
                .then()
                .statusCode(200);
    }

    @Test
    public void test_verifyPostRequestWrongContentType() {
        RestAssured.baseURI = "https://glacial-chamber-83122.herokuapp.com";
        given()
                .contentType(ContentType.TEXT)
                .body(payload)
                .post("/api/books")
                .then()
                .statusCode(200);
    }

    @Test
    public void test_verifyPostRequestIncorrectEndpoint() {
        RestAssured.baseURI = "https://glacial-chamber-83122.herokuapp.com";
        given()
                .contentType(ContentType.JSON)
                .body(payload)
                .post("/api/book")
                .then()
                .statusCode(404);
    }
}