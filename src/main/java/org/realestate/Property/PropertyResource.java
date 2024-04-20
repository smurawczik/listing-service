package org.realestate.Property;

import java.util.List;

import org.bson.types.ObjectId;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/properties")
@Consumes(MediaType.APPLICATION_JSON)
public class PropertyResource {

  @Inject
  PropertyRepository propertyRepository;

  @GET
  public List<Property> getAllProperties() {
    return propertyRepository.listAll();
  }

  @POST
  @Transactional
  public Response addProperty(Property property) {
    propertyRepository.persist(property);
    return Response.status(Response.Status.CREATED).build();
  }

  @GET
  @Path("/{id}")
  public Property getPropertyById(@PathParam("id") String id) {
    return propertyRepository.findById(new ObjectId(id));
  }
}
