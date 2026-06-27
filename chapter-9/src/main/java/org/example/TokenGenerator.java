package org.example;

import io.smallrye.jwt.build.Jwt;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.util.Set;

@Path("/auth")
public class TokenGenerator {

    @GET
    @Path("/token")
    public Response generateToken() {
        String token = Jwt.issuer("https://example.com/issuer")
                .upn("testuser")
                .groups(Set.of("user", "admin"))
                .audience("my-api")
                .expiresIn(3600) // 1 hour
                .sign();

        return Response.ok(token).build();
    }

}
