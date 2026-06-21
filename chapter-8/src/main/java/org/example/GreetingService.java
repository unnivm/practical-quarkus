package org.example;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/greeting")
@RegisterRestClient(configKey = "greeting-api")
public interface GreetingService {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    String hello();

    @GET
    @Path("/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    String greet(@PathParam("name") String name);
}
