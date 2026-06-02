package org.example;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.*;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserResourceTest {

    private static Long createdUserId;

    @Test
    @Order(1)
    void testCreateUser() {
        Map<String, Object> user = Map.of(
                "name", "Test User",
                "email", "test@example.com",
                "age", 25
        );

        // Extract as Integer first, then convert to Long
        Integer id = given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .body("id", notNullValue())
                .body("name", is("Test User"))
                .body("email", is("test@example.com"))
                .body("age", is(25))
                .extract()
                .path("id");

        createdUserId = id.longValue();
    }

    @Test
    @Order(2)
    void testGetAllUsers() {
        given()
                .when()
                .get("/users")
                .then()
                .statusCode(200);
    }

    @Test
    @Order(3)
    void testGetUserById() {
        given()
                .when()
                .get("/users/{id}", createdUserId)
                .then()
                .statusCode(200)
                .body("id", is(createdUserId.intValue()))
                .body("name", is("Test User"))
                .body("email", is("test@example.com"))
                .body("age", is(25));
    }

    @Test
    @Order(4)
    void testGetUserNotFound() {
        given()
                .when()
                .get("/users/99999")
                .then()
                .statusCode(404)
                .body("message", is("User with id 99999 not found"));
    }

    @Test
    @Order(5)
    void testUpdateUser() {
        Map<String, Object> updatedUser = Map.of(
                "name", "Updated User",
                "email", "updated@example.com",
                "age", 30
        );

        given()
                .contentType(ContentType.JSON)
                .body(updatedUser)
                .when()
                .put("/users/{id}", createdUserId)
                .then()
                .statusCode(200)
                .body("name", is("Updated User"))
                .body("email", is("updated@example.com"))
                .body("age", is(30));
    }

    @Test
    @Order(6)
    void testCreateUserWithInvalidData() {
        Map<String, Object> invalidUser = Map.of(
                "name", "",
                "email", "invalid",
                "age", -10
        );

        given()
                .contentType(ContentType.JSON)
                .body(invalidUser)
                .when()
                .post("/users")
                .then()
                .statusCode(400);
    }

    @Test
    @Order(7)
    void testDeleteUser() {
        given()
                .when()
                .delete("/users/{id}", createdUserId)
                .then()
                .statusCode(204);
    }

    @Test
    @Order(8)
    void testGetDeletedUserReturns404() {
        given()
                .when()
                .get("/users/{id}", createdUserId)
                .then()
                .statusCode(404);
    }
}