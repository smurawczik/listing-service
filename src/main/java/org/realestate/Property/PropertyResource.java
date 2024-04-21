package org.realestate.Property;

import static jakarta.ws.rs.core.Response.Status.CREATED;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jboss.logging.Logger;
import org.realestate.PropertyType.PropertyType;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.CompositeException;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Path("/properties")
@ApplicationScoped
@Consumes(MediaType.APPLICATION_JSON)
public class PropertyResource {

  private static final Logger LOGGER = Logger.getLogger(PropertyResource.class.getName());

  @GET
  public Uni<List<Property>> getAllProperties() {
    return Property.findAll().page(0, 20).list();
  }

  @POST
  public Uni<Response> addProperty(Property property) {
    return Panache.withTransaction(property::persist)
        .replaceWith(Response.ok(property).status(CREATED)::build);
  }

  @GET
  @Path("/{id}")
  public Uni<Property> getPropertyById(@PathParam("id") String id) {
    return Property.findById(Long.valueOf(id));
  }

  @GET
  @Path("/search")
  public Uni<List<Property>> searchProperties(
      @QueryParam("type") String type,
      @QueryParam("minPrice") Double minPrice,
      @QueryParam("maxPrice") Double maxPrice,
      @QueryParam("bedrooms") Integer bedrooms,
      @QueryParam("bathrooms") Integer bathrooms) {
    StringBuilder queryBuilder = new StringBuilder("SELECT p FROM Property p WHERE 1=1");

    Map<String, Object> params = new HashMap<>();

    if (type != null && !type.isEmpty()) {
      queryBuilder.append(" AND p.type = :type");
      params.put("type", PropertyType.valueOf(type.toUpperCase()));
    }
    if (minPrice != null) {
      queryBuilder.append(" AND p.price >= :minPrice");
      params.put("minPrice", minPrice);
    }
    if (maxPrice != null) {
      queryBuilder.append(" AND p.price <= :maxPrice");
      params.put("maxPrice", maxPrice);
    }
    if (bedrooms != null) {
      queryBuilder.append(" AND p.bedrooms = :bedrooms");
      params.put("bedrooms", bedrooms);
    }
    if (bathrooms != null) {
      queryBuilder.append(" AND p.bathrooms = :bathrooms");
      params.put("bathrooms", bathrooms);
    }

    if (params.isEmpty()) {
      return Uni.createFrom().item(Collections.emptyList());
    }

    return Property.find(queryBuilder.toString(), params).list();
  }

  @Provider
  public static class ErrorMapper implements ExceptionMapper<Exception> {

    @Inject
    ObjectMapper objectMapper;

    @Override
    public Response toResponse(Exception exception) {
      LOGGER.error("Failed to handle request", exception);

      Throwable throwable = exception;

      int code = 500;
      if (throwable instanceof WebApplicationException) {
        code = ((WebApplicationException) exception).getResponse().getStatus();
      }

      // This is a Mutiny exception and it happens, for example, when we try to insert
      // a new
      // fruit but the name is already in the database
      if (throwable instanceof CompositeException) {
        throwable = ((CompositeException) throwable).getCause();
      }

      ObjectNode exceptionJson = objectMapper.createObjectNode();
      exceptionJson.put("exceptionType", throwable.getClass().getName());
      exceptionJson.put("code", code);

      if (exception.getMessage() != null) {
        exceptionJson.put("error", throwable.getMessage());
      }

      return Response.status(code)
          .entity(exceptionJson)
          .build();
    }

  }
}
