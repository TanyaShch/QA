package Lesson2_8;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostRawText {

    private static final String BASE_URL = "https://postman-echo.com";

    @Test
    public void testPostRawTextRequest() {

        String requestBody = "This is expected to be sent back as part of response body.";

        Response response = given()
                .contentType("text/plain")
                .body(requestBody)
                .when()
                .post(BASE_URL + "/post");

        assertEquals(200, response.getStatusCode());
        String responseBody = response.getBody().asString();
        System.out.println("Response Body" + responseBody);

        response.then().body("data", equalTo(requestBody));
    }
}