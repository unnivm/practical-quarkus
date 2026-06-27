package org.example;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class UserTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testValidUser() {
        User user = new User();
        user.name = "Alice";
        user.email = "alice@example.com";
        user.age = 30;

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertTrue(violations.isEmpty(), "Valid user should have no violations");
    }

    @Test
    void testInvalidEmailIsInvalid() {
        User user = new User();
        user.name = "Alice";
        user.email = "not-an-email";
        user.age = 30;

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertFalse(violations.isEmpty());
        assertEquals("Email must be valid", violations.iterator().next().getMessage());
    }

    @Test
    void testNegativeAgeIsInvalid() {
        User user = new User();
        user.name = "Alice";
        user.email = "alice@example.com";
        user.age = -5;

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertFalse(violations.isEmpty());
        assertEquals("Age cannot be negative", violations.iterator().next().getMessage());
    }

    @Test
    void testAgeTooHighIsInvalid() {
        User user = new User();
        user.name = "Alice";
        user.email = "alice@example.com";
        user.age = 200;

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertFalse(violations.isEmpty());
        assertEquals("Age must be less than 150", violations.iterator().next().getMessage());
    }

}
