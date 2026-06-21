package org.example;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
//import static org.hamcrest.CoreMatchers.hasKey;
import static org.hamcrest.Matchers.hasKey;

@QuarkusTest
class ValidationExceptionMapperTest {

    @Test
    void testValidationErrorsReturnJsonWithFieldDetails() {
        Map<String, Object> invalidUser = Map.of(
                "name", "",
                "email", "bad-email",
                "age", -1
        );

        given()
                .contentType(ContentType.JSON)
                .body(invalidUser)
                .when()
                .post("/users")
                .then()
                .statusCode(400)
                .body("$", hasKey("errors"))
                .body("errors", hasKey("name"))
                .body("errors", hasKey("email"))
                .body("errors", hasKey("age"));
    }
}