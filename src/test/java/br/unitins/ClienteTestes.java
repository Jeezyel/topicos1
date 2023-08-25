package br.unitins;
import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;
import br.unitins.service.ClienteService;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
public class ClienteTestes {

  @Inject
  ClienteService service;


  @Test
  public void getAllTeste(){

    given().when().get("/cliente/getAll").then().statusCode(200);

  }

  @Test
  public void CountTeste(){

    given().when().get("/cliente/count").then().statusCode(200);

  }

  

    

    
}
