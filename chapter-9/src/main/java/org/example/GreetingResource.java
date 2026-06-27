package org.example;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/greeting")
@Produces(MediaType.TEXT_PLAIN)
public class GreetingResource {

    @GET
    public String hello() {
        return "Hello Greeting Service!";
    }

    @GET
    @Path("/{name}")
    public String greet(String name) {
        return "Hello, " + name + "!";
    }

}
