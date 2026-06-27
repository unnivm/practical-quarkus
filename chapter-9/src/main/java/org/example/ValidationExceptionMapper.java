package org.example;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.HashMap;
import java.util.Map;

@Provider
public class ValidationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException exception) {
        Map<String, String> errors = new HashMap<>();
        
        for (ConstraintViolation<?> violation : exception.getConstraintViolations()) {
            String propertyPath = violation.getPropertyPath().toString();
            // Extract the field name from paths like "create.user.name" or "user.name"
            String fieldName = propertyPath.contains(".") 
                ? propertyPath.substring(propertyPath.lastIndexOf(".") + 1) 
                : propertyPath;
            errors.put(fieldName, violation.getMessage());
        }
        
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(Map.of("status", 400, "errors", errors))
                .build();
    }
}
