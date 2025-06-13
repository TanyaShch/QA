package Lesson2_8;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Put {

    private static final String BASE_URL = "https://postman-echo.com";

    @Test
    public void testPutRequest() {

        String requestBody = "This is expected to be sent back as part of response body.";

        Response response = given()
                .contentType("text/plain")
                .header("cookie", "sails.sid=s%3A53CAVPNfc6GKRfIgd27dktEuK21aMV-f.nlpebZ%2BCKQKiBBxXy4AJPm4WBEdEEIrnjLn7Pajaflc")
                .body(requestBody)
                .when()
                .put(BASE_URL + "/put")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        System.out.println("Status Code: " + statusCode);
        assert statusCode == 200;

        String responseBody = response.getBody().asString();
        assert responseBody.contains(requestBody);
    }
}