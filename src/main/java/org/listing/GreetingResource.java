package org.listing;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus REST";
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String helloPost() {
        System.out.println("Hello from Quarkus REST");
        return "Hello from Quarkus REST";
    }
}
