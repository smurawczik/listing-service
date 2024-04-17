package org.listing.Fruit;

import java.util.List;
import java.util.UUID;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/fruits")
public class FruitResource {

  @Inject
  FruitService fruitService;

  @GET
  public List<Fruit> list() {
    System.out.println("Listing fruits");
    return fruitService.list();
  }

  @POST()
  public List<Fruit> add(Fruit fruit) {
    System.out.println("Adding fruit: " + fruit.getName() + " - " + fruit.getId());
    if (fruit.getId() == null) {
      String uuid = UUID.randomUUID().toString();
      System.out.println("Setting id " + uuid);
      fruit.setId(uuid);
    }
    fruitService.add(fruit);
    return list();
  }
}