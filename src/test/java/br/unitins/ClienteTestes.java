package br.unitins;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import br.unitins.dto.ClienteDTO;
import br.unitins.dto.EnderecoDTO;
import br.unitins.dto.TelefoneDTO;
import br.unitins.service.ClienteService;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
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

  @Test
  public void insertTest(){
   
  }

    

    
}
