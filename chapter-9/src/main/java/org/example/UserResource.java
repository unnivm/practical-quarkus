
package org.example;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import jakarta.validation.Valid;
import java.util.Map;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;
import org.eclipse.microprofile.config.inject.ConfigProperty;


@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    private static final Logger LOG = Logger.getLogger(UserResource.class);

    @ConfigProperty(name = "app.max-users-per-page", defaultValue = "50")
    int maxUsersPerPage;

    @Inject
    @RestClient
    GreetingService greetingService;

    @GET
    @Path("/greeting")
    public Response getGreeting() {
        try {
            String greeting = greetingService.hello();
            return Response.ok(greeting).build();
        } catch (Exception e) {
            LOG.error("Failed to call greeting service", e);
            return Response.status(Response.Status.SERVICE_UNAVAILABLE)
                    .entity(Map.of("error", "Greeting service unavailable"))
                    .build();
        }
    }

    @GET
    @Path("/greeting/{name}")
    public String getPersonalizedGreeting(@PathParam("name") String name) {
        return greetingService.greet(name);
    }


    @GET
    @RolesAllowed({"user", "admin"})
    public List<User> listAll() {
        LOG.infof("Fetching up to %d users", maxUsersPerPage);
        return User.listAll();
    }

    @POST
    @Transactional
    @RolesAllowed({"admin"})
    public Response create(@Valid User user) {
        user.persist();
        return Response.ok(user).status(201).build();
    }

    @GET
    @Path("/{id}")
    public Response getOne(@PathParam("id") Long id) {
        LOG.debugf("Looking for user with ID: %d", id);
        User user = User.findById(id);
            if (user == null) {
                return Response.status(Response.Status.NOT_FOUND)
                .entity(Map.of("message", "User with id " + id + " not found"))
                .build();
            }

        return Response.ok(user).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public User update(@PathParam("id") Long id, @Valid User user) {
        User existing = User.findById(id);
        existing.name = user.name;
        existing.email = user.email;
        existing.age = user.age;
        existing.persist();
        return existing;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        User.deleteById(id);
        return Response.noContent().build();
    }
}

